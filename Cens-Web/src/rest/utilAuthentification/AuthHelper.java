package rest.utilAuthentification;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import net.oauth.jsontoken.JsonToken;
import net.oauth.jsontoken.JsonTokenParser;
import net.oauth.jsontoken.crypto.HmacSHA256Signer;
import net.oauth.jsontoken.crypto.HmacSHA256Verifier;
import net.oauth.jsontoken.crypto.SignatureAlgorithm;
import net.oauth.jsontoken.crypto.Verifier;
import net.oauth.jsontoken.discovery.VerifierProvider;
import net.oauth.jsontoken.discovery.VerifierProviders;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.security.InvalidKeyException;
import java.security.SignatureException;
import java.util.Calendar;
import java.util.List;

/**
 * Created by steven.cdi12 on 01/04/2016.
 */
public class AuthHelper {
    private static final String AUDIENCE = "NotReallyImportant";

    private static final String ISSUER = "GroupeDuMilieu";

    private static final String SIGNING_KEY = "LongAndHardToGuessValueWithSpecialCharacters@^($%*$%";

    /**
     * Creates a json web token which is a digitally signed token that contains a payload (e.g. userId to identify
     * the user). The signing key is secret. That ensures that the token is authentic and has not been modified.
     * Using a jwt eliminates the need to store authentication session information in a database.
     *
     * @param userId
     * @param durationDays
     * @return
     */
    public static String createJsonWebToken(Integer userId, String userLogin, String nomUtilisateur, String prenomUtilisateur, String role, Long durationDays) {
        //Récuperer l'heure de création du token
        Calendar cal = Calendar.getInstance();
        HmacSHA256Signer signer;
        try {
            signer = new HmacSHA256Signer(ISSUER, null, SIGNING_KEY.getBytes());
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }

        //Configurer le jason Web Token
        JsonToken token = new net.oauth.jsontoken.JsonToken(signer);
        token.setAudience(AUDIENCE);
        token.setIssuedAt(new org.joda.time.Instant(cal.getTimeInMillis()));
        token.setExpiration(new org.joda.time.Instant(cal.getTimeInMillis() + 1000L * 60L * 60L * 24L * durationDays));

        JsonObject request = new JsonObject();
        request.addProperty("userId", userId);
        request.addProperty("userLogin",userLogin);
        request.addProperty("userNom", nomUtilisateur);
        request.addProperty("userPrenom", prenomUtilisateur);
        request.addProperty("userRole", role);

        JsonObject payload = token.getPayloadAsJsonObject();
        payload.add("info", request);

        try {
            return token.serializeAndSign();
        } catch (SignatureException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Verifies a json web token's validity and extracts the user id and other information from it.
     *
     * @param token
     * @return
     * @throws SignatureException
     * @throws InvalidKeyException
     */
    public static TokenInfo verifyToken(String token) {
        try {
            final Verifier hmacVerifier = new HmacSHA256Verifier(SIGNING_KEY.getBytes());

            VerifierProvider hmacLocator = new VerifierProvider() {

                @Override
                public List<Verifier> findVerifier(String id, String key) {

                    return Lists.newArrayList(hmacVerifier);
                }
            };
            VerifierProviders locators = new VerifierProviders();
            locators.setVerifierProvider(SignatureAlgorithm.HS256, hmacLocator);
            net.oauth.jsontoken.Checker checker = new net.oauth.jsontoken.Checker() {

                @Override
                public void check(JsonObject payload) throws SignatureException {
                    // don't throw - allow anything
                }

            };
            //Ignore Audience does not mean that the Signature is ignored
            JsonTokenParser parser = new JsonTokenParser(locators,checker);
            JsonToken jt;
            try {
                jt = parser.verifyAndDeserialize(token);
            } catch (SignatureException e) {
                throw new RuntimeException(e);
            }
            JsonObject payload = jt.getPayloadAsJsonObject();
            TokenInfo t = new TokenInfo();
            String issuer = payload.getAsJsonPrimitive("iss").getAsString();
            String userIdString = payload.getAsJsonObject("info").getAsJsonPrimitive("userId").getAsString();
            String userNom = payload.getAsJsonObject("info").getAsJsonPrimitive("userNom").getAsString();
            String userLogin = payload.getAsJsonObject("info").getAsJsonPrimitive("userLogin").getAsString();
            if (issuer.equals(ISSUER) && !StringUtils.isBlank(userIdString)) {
                t.setUserId(new Integer(userIdString));
                t.setUserLogin(userLogin);
                t.setIssued(new DateTime(payload.getAsJsonPrimitive("iat").getAsLong()));
                t.setExpires(new DateTime(payload.getAsJsonPrimitive("exp").getAsLong()));
                t.setUserNom(new String(userNom));
                System.out.println("valeur du nom de la personne émitrice du token "+t.getUserLogin());
                return t;
            } else {
                return null;
            }
        } catch (InvalidKeyException e1) {
            throw new RuntimeException(e1);
        }
    }
}
