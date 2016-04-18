package rest;

import model.Bloc;
import org.json.JSONArray;
import org.json.JSONObject;
import service.BlocService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by steven on 16/04/16.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/bloc")
public class BlocRest {
    @EJB
    BlocService blocService;

    @Path("/")
    @GET
    @Produces("application/json")
    public Response findAll() {
        List<Bloc> listeBloc = blocService.findAll();

        JSONArray blocsJson = new JSONArray();
        for (Bloc bloc:listeBloc){
            JSONObject bilanJson = new JSONObject();
            bilanJson.put("id",bloc.getBlocId());
            bilanJson.put("libelle",bloc.getBlocLibelle());

            blocsJson.put(bilanJson);
        }

        return Response.status(200).entity(blocsJson.toString()).build();
    }

    @Path("/{idBloc}")
    @GET
    @Produces("application/json")
    public Response findOne(@PathParam("idBloc") int idBloc){
        Bloc bloc = blocService.findOne(idBloc);
        JSONObject blocJson = new JSONObject();
        blocJson.put("id",bloc.getBlocId());
        blocJson.put("libelle",bloc.getBlocLibelle());

        return Response.status(200).entity(blocJson.toString()).build();
    }

    @Path("/insert")
    @PUT
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public Response insertBloc(@FormParam("blocLibelle") String blocLibelle){
        Bloc bloc = new Bloc();
        bloc.setBlocLibelle(blocLibelle);

        blocService.insert(bloc);

        return  Response.status(200).build();
    }

    @Path("/delete/{idBloc}")
    @DELETE
    @Produces("application/json")
    public Response deleteBloc(@PathParam("idBloc")int idBloc){
        Bloc bloc = new Bloc();
        bloc.setBlocId(idBloc);
        blocService.delete(bloc);
        return Response.status(200).build();
    }
}
