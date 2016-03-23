package rest;

import org.json.JSONException;
import org.json.JSONObject;
import service.EleveService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * SERVICE REST
 * <p>
 * ELEVES
 * <p>
 * DESIGN PATH : /rest/eleves/ideleve/
 */
@Path("/eleves")
public class ElevesRest {

    @Inject
    EleveService eleveService;

    @GET
    @Produces("application/json")
    public Response findAll() throws JSONException {
        JSONObject jsonObject = eleveService.JSON_findAll();
        return Response.status(200).entity(jsonObject.toString()).build();
    }

    @Path("{ideleve}")
    @GET
    @Produces("application/json")
    public Response findEleveById(@PathParam("ideleve") Integer ideleve) throws JSONException {
        JSONObject jsonObject = eleveService.JSON_findOne(ideleve);
        return Response.status(200).entity(jsonObject.toString()).build();
    }

    @Path("{ideleve}")
    @DELETE
    public Response deleteEleveById(@PathParam("ideleve") Integer ideleve) throws JSONException {

        //TODO
        return null;
    }

}