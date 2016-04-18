package rest;

import model.Bloc;
import model.ComCap;
import org.json.JSONArray;
import org.json.JSONObject;
import service.BlocService;
import service.ComCapService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by steven on 16/04/16.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/comcap")
public class ComCapRest {
    @EJB
    ComCapService comCapService;

    @Path("/")
    @GET
    @Produces("application/json")
    public Response findAll() {
        List<ComCap> listeComCap = comCapService.findAll();

        JSONArray comCapsJson = new JSONArray();
        for (ComCap comCap:listeComCap){
            JSONObject comCapJson = new JSONObject();
            comCapJson.put("id",comCap.getComCapId());
            comCapJson.put("libelle",comCap.getComCapLibelle());

            comCapsJson.put(comCapJson);
        }

        return Response.status(200).entity(comCapsJson.toString()).build();
    }

    @Path("/{idComCap}")
    @GET
    @Produces("application/json")
    public Response findOne(@PathParam("idComCap") int idBloc){
        ComCap comCap = comCapService.findOne(idBloc);
        JSONObject comCapJson = new JSONObject();
        comCapJson.put("id",comCap.getComCapId());
        comCapJson.put("libelle",comCap.getComCapLibelle());

        return Response.status(200).entity(comCapJson.toString()).build();
    }

    @Path("/insert")
    @PUT
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public Response insertBilan(@FormParam("comCapLibelle") String comCapLibelle){
        ComCap comCap =new ComCap();
        comCap.setComCapLibelle(comCapLibelle);

        comCapService.insert(comCap);

        return  Response.status(200).build();
    }

    @Path("/delete/{idComCap}")
    @DELETE
    @Produces("application/json")
    public Response deleteBilan(@PathParam("idComCap")int idComCap){
        ComCap comCap =new ComCap();
        comCap.setComCapId(idComCap);
        comCapService.delete(comCap);
        return Response.status(200).build();
    }
}
