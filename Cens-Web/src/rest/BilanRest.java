package rest;
import model.Bilan;
import model.Eleve;
import org.json.JSONArray;
import org.json.JSONObject;
import service.BilanService;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by steven on 16/04/16.
 */
@Path("/bilan")
public class BilanRest {

    @EJB
    BilanService bilanService;

    @Path("/")
    @GET
    @Produces("application/json")
    public Response findAll() {
        List<Bilan> listeBilan = bilanService.findAll();

        JSONArray bilansJson = new JSONArray();
        for (Bilan bilan:listeBilan){
            JSONObject bilanJson = new JSONObject();
            bilanJson.put("id",bilan.getBilanId());
            bilanJson.put("commentaire",bilan.getBilanCommentaire());
            bilanJson.put("date_debut",bilan.getBilanDateDebut());
            bilanJson.put("date_fin", bilan.getBilanDateFin());
            bilanJson.put("libelle",bilan.getBilanLibelle());
            bilanJson.put("eleveNom",bilan.getEleve().getPersonneNom());

            bilansJson.put(bilanJson);
        }

        return Response.status(200).entity(bilansJson.toString()).build();
    }

    @Path("/{idBilan}")
    @GET
    @Produces("application/json")
    public Response findOne(@PathParam("idBilan") int idBilan){
        Bilan bilan = bilanService.findOne(idBilan);
        JSONObject bilanJson = new JSONObject();
        bilanJson.put("id",bilan.getBilanId());
        bilanJson.put("commentaire",bilan.getBilanCommentaire());
        bilanJson.put("date_debut",bilan.getBilanDateDebut());
        bilanJson.put("date_fin", bilan.getBilanDateFin());
        bilanJson.put("libelle",bilan.getBilanLibelle());
        bilanJson.put("eleveNom",bilan.getEleve().getPersonneNom());

        return Response.status(200).entity(bilanJson.toString()).build();
    }

    @Path("/insert")
    @PUT
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public Response insertBilan(@FormParam("bilanCommentaire") String bilanCommentaire,
                                @FormParam("bilan_date_debut") Date bilanDateDebut,
                                @FormParam("bilanDateFin") Date bilanDateFin,
                                @FormParam("bilanLibelle") String bilanLibelle,
                                @FormParam("bilanPersonneId") int bilanPersonneId){
        Bilan bilan = new Bilan();
        Eleve eleve = new Eleve();
        bilan.setBilanCommentaire(bilanCommentaire);
        bilan.setBilanDateDebut(bilanDateDebut);
        bilan.setBilanDateFin(bilanDateFin);
        bilan.setBilanLibelle(bilanLibelle);
        eleve.setPersonneId(bilanPersonneId);
        bilan.setEleve(eleve);

        bilanService.insert(bilan);

        return  Response.status(200).build();
    }

    @Path("/delete/{idBilan}")
    @DELETE
    @Produces("application/json")
    public Response deleteBilan(@PathParam("idBilan")int idBilan){
        Bilan bilan = new Bilan();
        bilan.setBilanId(idBilan);
        bilanService.delete(bilan);
        return Response.status(200).build();
    }


}
