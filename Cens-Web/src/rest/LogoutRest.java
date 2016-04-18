package rest;

import org.json.JSONException;
import rest.utilAuthentification.RoleUtilisateur;
import rest.utilAuthentification.Secured;
import service.TokenService;

import javax.ejb.EJB;
import javax.ws.rs.*;

/**
 * Created by steven.cdi12 on 24/03/2016.
 */

@Path("/logout")
@Secured({RoleUtilisateur.ELEVE,RoleUtilisateur.ADMIN,RoleUtilisateur.COORDINATEUR,RoleUtilisateur.ENSEIGNANT,RoleUtilisateur.MANAGER})
public class LogoutRest {

    @EJB
    TokenService tokenService;

    @POST
    @Produces
    @Consumes("application/x-www-form-urlencoded")
    public String logout(@FormParam("x-security-token") String token) throws JSONException {
        try{
            deleteToken(token);
            return "token supprimé";
        }catch (Exception e){
            return "token pas supprimé";
        }

    }

    private void deleteToken(String token) {
        tokenService.delete(token);
    }
}
