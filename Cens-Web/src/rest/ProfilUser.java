package rest;

import org.json.JSONException;
import org.json.JSONObject;
import service.EleveService;
import service.EmployeService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("/profil")
public class ProfilUser {

    @EJB
    EleveService eleveService;

    @EJB
    EmployeService employeService;

    private final String JSON_SUCCES = "{\"msg\":\"Succès. L'opération à bien été réalisée!\"}";
    private final String JSON_FAIL_SERVER = "{\"msg\":\"Echec. Le serveur ne peut pas traiter la demande. Contacter l'administrateur!\"}";
    private final String JSON_FAIL_CLIENT = "{\"msg\":\"Echec. Le format des données n'est pas utilisable!\"}";


    /*@Path("/name")
    @GET
    @Produces("application/json;charset=utf-8")
    public String getNameSimple() {
        return "{\"name\": \"John Smith\"}";
    }*/


    @Path("{type}/{idUser}")
    @GET
    @Produces("application/json;charset=utf-8")
    public Response findEleveById(@PathParam("idUser") Integer idUser, @PathParam("type") String type) throws JSONException {
        JSONObject jsonObject = new JSONObject();

        try {
            if (type.equals("eleve")) {
                jsonObject = eleveService.JSON_findOne(idUser);
            } else {
                jsonObject = employeService.JSON_findOne(idUser);
            }

            return Response.status(200).entity(jsonObject.toString()).build();
        } catch (Exception e) {
            return Response.status(500).entity(JSON_FAIL_SERVER).build();
        }
    }

}

