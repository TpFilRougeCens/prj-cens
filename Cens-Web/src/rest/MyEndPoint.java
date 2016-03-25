package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by steven.cdi12 on 24/03/2016.
 */
@Path("/")
public class MyEndPoint {
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response myUnsecuredMethod(@PathParam("id") Long id) {
        // This method is not annotated with @Secured
        // The authentication filter won't be executed before invoking this method
        //TODO
        return null;
    }

    @DELETE
    @Secured
    @Path("{id}")
    @Produces("application/json")
    public Response mySecuredMethod(@PathParam("id") Long id) {
        // This method is annotated with @Secured
        // The authentication filter will be executed before invoking this method
        // The HTTP request must be performed with a valid token
        //TODO
        return null;
    }
}
