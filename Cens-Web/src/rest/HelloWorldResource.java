package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes({MediaType.APPLICATION_JSON})
public class HelloWorldResource {

    @GET
    public String getHtml() {
        return "{\"message\": \"hello\"}";
    }
}
