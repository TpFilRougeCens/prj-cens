package rest.profil;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/profil/name")
@Produces(MediaType.APPLICATION_JSON)
@Consumes({MediaType.APPLICATION_JSON})
public class Name {

    @GET
    public String getHtml() {
        return "{\"name\": \"John Smith\"}";
    }

}
