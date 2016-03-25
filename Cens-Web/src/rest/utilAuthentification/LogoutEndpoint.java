package rest.utilAuthentification;

import model.Personne;
import org.json.JSONException;
import service.TokenService;

import javax.ejb.EJB;
import javax.ws.rs.*;

/**
 * Created by steven.cdi12 on 24/03/2016.
 */

@Path("/logout")
public class LogoutEndpoint {

    private Personne persBase;

    @EJB
    TokenService tokenService;

    @POST
    @Produces
    @Consumes("application/x-www-form-urlencoded")
    public String logout(@FormParam("x-security-token") String token) throws JSONException {
        try{
            deleteToken(token);
            return "petit penis";
        }catch (Exception e){
            return "token pas supprimé";
        }

    }

    private void deleteToken(String token) {
        tokenService.delete(token);
    }
}
