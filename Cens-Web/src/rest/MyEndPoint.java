package rest;

import dto.PersonneDTO;
import rest.utilAuthentification.AuthentifierUser;
import rest.utilAuthentification.RoleUtilisateur;
import rest.utilAuthentification.Secured;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by steven.cdi12 on 24/03/2016.
 */
@Path("/endPoint")
public class MyEndPoint {


    @Inject
    @AuthentifierUser
    PersonneDTO authentifierUser;

    @POST
    @Path("/methodeNonSecurise")
    @Produces("application/json")
    public Response myUnsecuredMethod() {
        // This method is not annotated with @Secured
        // The authentication filter won't be executed before invoking this method
        //TODO
        System.out.println("passage dans la methode non securise");
        return null;
    }

    @POST
    @Path("/methodeSecurise")
    @Secured(RoleUtilisateur.ELEVE)
    @Produces("application/json")
    public Response myUnsecuredMethod2()  {
        // This method is not annotated with @Secured
        // The authentication filter won't be executed before invoking this method
        System.out.println("passage dans la méthode sécurisé");
        return null;
    }

    @DELETE
    @Secured({RoleUtilisateur.ELEVE})
    @Path("{id}")
    @Produces("application/json")
    public Response mySecuredMethod(@PathParam("id") Long id) {
        // This method is annotated with @Secured
        // The authentication filter will be executed before invoking this method
        // The HTTP request must be performed with a valid token
        System.out.println("passage methode securisée");
        return null;
    }
}
