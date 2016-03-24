package rest;

import model.Personne;
import model.Token;
import service.GroupeService;
import service.PersonneService;
import service.TokenService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by steven.cdi12 on 24/03/2016.
 */

@Path("/authentification")
public class AuthentificationEndpoint {

    private Personne persBase;

    @EJB
    PersonneService personneService;
    @EJB
    GroupeService groupeService;
    @EJB
    TokenService tokenservice;

    @POST
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public Response authenticateUser(@FormParam("username") String username,
                                     @FormParam("password") String password) {
        System.out.println("entré valeur du login "+username+" valeur du pass "+password);

        try {
            // Authenticate the user using the credentials provided
            authenticate(username, password);
            System.out.println("test before jason");
            // Issue a token for the user
            String token = issueToken(username);

            System.out.println("test before response");
            // Return the token on the response
            return Response.ok(token).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    private void authenticate(String username, String password) throws Exception {
        // Authenticate against a database, LDAP, file or whatever
        // Throw an Exception if the credentials are invalid
        persBase = personneService.findOne(username, password);
        System.out.println("valeur de l'username persbase "+persBase.getPersonneLogin());

    }

    private String issueToken(String username) {
        // Issue a token (can be a random String persisted to a database or a JWT token)
        // The issued token must be associated to a user
        // Return the issued token
        Random random = new SecureRandom();
        String token = new BigInteger(130, random).toString(32);
        Token tokenBuild = new Token();
        tokenBuild.setId(1);
        tokenBuild.setUtilisateur(username);
        tokenBuild.setToken(token);
        tokenservice.insert(tokenBuild);
        return "{\"token\":\""+token+"\"}";
    }
}
