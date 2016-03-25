package rest;

import org.json.JSONException;
import org.json.JSONObject;
import service.EleveService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;


/**
 * SERVICE REST ELEVES
 * <p>
 * <b>DESIGN PATTERN DE URI :</b>
 * <ul>
 * <li><b>GET</b>       /rest/eleve      RETURN JSONArray findAll</li>
 * <li><b>GET</b>       /rest/eleve/{id} RETURN JSONArray findById</li>
 * <li><b>DELETE</b>    /rest/eleve/{id} RETURN boolean</li>
 * <li><b>PUT</b>       /rest/eleve      RETURN boolean</li>
 * <li><b>POST</b>      /rest/eleve      RETURN boolean</li>
 * </ul>
 */
@Path("/eleve")
public class ElevesRest {

    @Inject
    EleveService eleveService;


    /**
     * GET retourne tous les élèves en base
     *
     * @return code HTTP + JsonArray
     * @throws JSONException
     */
    @GET
    @Produces("application/json")
    public Response findAll() throws JSONException {
        JSONObject jsonObject = eleveService.JSON_findAll();
        return Response.status(200).entity(jsonObject.toString()).build();
    }

    /**
     * Get retourne un élève unique
     *
     * @param ideleve
     * @return code HTTP + JsonArray
     * @throws JSONException
     */
    @Path("{ideleve}")
    @GET
    @Produces("application/json")
    public Response findEleveById(@PathParam("ideleve") Integer ideleve) throws JSONException {
        JSONObject jsonObject = eleveService.JSON_findOne(ideleve);
        // on retourne un Object JasonArray afin de garantir une réponse cohérente dans le WebService global
        return Response.status(200).entity(jsonObject.toString()).build();
    }

    /**
     * DELETE : Supprime un élève en base
     *
     * @param ideleve
     * @return code HTTP + [message]
     * @throws JSONException
     */
    @Path("{ideleve}")
    @DELETE
    public Response deleteEleveById(@PathParam("ideleve") Integer ideleve) throws JSONException {
        boolean result = eleveService.delete(ideleve);
        return Response.status(200).entity("" + result).build();
    }

    /**
     * PUT : modifier/maj un élève en base
     *
     * @param jsonEntity
     * @return code HTTP + [message]
     * @throws JSONException
     */
    @PUT
    @Consumes("application/json")
    public Response putEleve(String jsonEntity) throws JSONException {
        JSONObject jsonObj;
        JSONObject jsonEleve;

        try {
            jsonObj = new JSONObject(jsonEntity);
            jsonEleve = jsonObj.getJSONObject("eleve");
        } catch (Exception e) {
            return Response.status(400).entity("Format de données JSON incompatible").build();
        }

        boolean result = eleveService.JSON_update(jsonEleve);

        if (!result) {
            return Response.status(500).entity("Update fail").build();
        }

        return Response.status(200).build();
    }

    /**
     * POST : ajouter un élève en base
     *
     * @param jsonEntity
     * @return code HTTP + [message]
     * @throws JSONException
     */
    @POST
    @Consumes("application/json")
    public Response postEleve(String jsonEntity) throws JSONException {
        JSONObject jsonObj;
        JSONObject jsonEleve;
        try {
            jsonObj = new JSONObject(jsonEntity);
            jsonEleve = jsonObj.getJSONObject("eleve");
        } catch (Exception e) {
            return Response.status(400).entity("Format de données JSON incompatible").build();
        }

        boolean result = eleveService.JSON_insert(jsonEleve);

        if (!result) {
            return Response.status(500).entity("Update fail").build();
        }

        return Response.status(200).build();
    }

}