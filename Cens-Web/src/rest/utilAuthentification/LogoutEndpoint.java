package rest.utilAuthentification;

import model.Personne;
import model.Token;
import org.json.JSONException;
import org.json.JSONObject;
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

@Path("/logout")
public class LogoutEndpoint {

    private Personne persBase;


    @GET
    @Consumes("application/x-www-form-urlencoded")
    public String logout() throws JSONException {

            return "{\"name\": \"John Smith\"}";

    }

    @GET
    public String getHtml() {
        return "{\"name\": \"John Smith\"}";
    }


}
