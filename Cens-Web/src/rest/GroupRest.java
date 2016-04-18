package rest;

import model.ComCap;
import model.Groupe;
import org.json.JSONArray;
import org.json.JSONObject;
import service.ComCapService;
import service.GroupeService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.security.acl.Group;
import java.util.List;

/**
 * Created by steven on 16/04/16.
 */
@Path("/groupe")
public class GroupRest {
    @EJB
    GroupeService groupeService;

    @Path("/")
    @GET
    @Produces("application/json")
    public Response findAll() {
        List<Groupe> listegroupe = groupeService.findAll();

        JSONArray groupesJson = new JSONArray();
        for (Groupe groupe:listegroupe){
            JSONObject groupeJson = new JSONObject();
            groupeJson.put("id",groupe.getGroupeId());
            groupeJson.put("libelle",groupe.getGroupeLibelle());
            groupeJson.put("niveauAcces",groupe.getGroupeNiveauAcces());

            groupesJson.put(groupeJson);
        }

        return Response.status(200).entity(groupesJson.toString()).build();
    }

    @Path("/{idGroupe}")
    @GET
    @Produces("application/json")
    public Response findOne(@PathParam("idGroupe") int idGroupe){
        Groupe groupe = groupeService.findOne(idGroupe);
        JSONObject groupeJson = new JSONObject();
        groupeJson.put("id",groupe.getGroupeId());
        groupeJson.put("libelle",groupe.getGroupeLibelle());
        groupeJson.put("niveauAcces",groupe.getGroupeNiveauAcces());

        return Response.status(200).entity(groupeJson.toString()).build();
    }

    @Path("/insert")
    @PUT
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public Response insertGroupe(@FormParam("groupeLibelle") String groupeLibelle,
                                @FormParam("groupeNiveauAcces")Integer groupeNiveauAcces){
        Groupe groupe = new Groupe();
        groupe.setGroupeLibelle(groupeLibelle);
        groupe.setGroupeNiveauAcces(groupeNiveauAcces);

        groupeService.insert(groupe);

        return  Response.status(200).build();
    }

    @Path("/delete/{idgroupe}")
    @DELETE
    @Produces("application/json")
    public Response deleteGroupe(@PathParam("idgroupe")int idGroupe){
        Groupe groupe = new Groupe();
        groupe.setGroupeId(idGroupe);
        groupeService.delete(groupe);
        return Response.status(200).build();
    }

}
