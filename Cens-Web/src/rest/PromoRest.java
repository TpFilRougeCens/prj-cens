package rest;

import model.Groupe;
import model.Promo;
import org.json.JSONArray;
import org.json.JSONObject;
import service.GroupeService;
import service.PromoService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by steven on 16/04/16.
 */
@Path("/promo")
public class PromoRest {
    @EJB
    PromoService promoService;

    @Path("/")
    @GET
    @Produces("application/json")
    public Response findAll() {
        List<Promo> listepromo = promoService.findAll();

        JSONArray promosJson = new JSONArray();
        for (Promo promo:listepromo){
            JSONObject promoJson = new JSONObject();
            promoJson.put("id",promo.getPromoId());
            promoJson.put("libelle",promo.getPromoLibelle());

            promosJson.put(promoJson);
        }

        return Response.status(200).entity(promosJson.toString()).build();
    }

    @Path("/{idPromo}")
    @GET
    @Produces("application/json")
    public Response findOne(@PathParam("idPromo") int idPromo){
        Promo promo= promoService.findOne(idPromo);
        JSONObject promoJson = new JSONObject();
        promoJson.put("id",promo.getPromoId());
        promoJson.put("libelle",promo.getPromoLibelle());

        return Response.status(200).entity(promoJson.toString()).build();
    }

    @Path("/insert")
    @PUT
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public Response insertPromo(@FormParam("promoLibelle") String promoLibelle){
        Promo promo = new Promo();
        promo.setPromoLibelle(promoLibelle);
        promoService.insert(promo);

        return  Response.status(200).build();
    }

    @Path("/delete/{idpromo}")
    @DELETE
    @Produces("application/json")
    public Response deleteGroupe(@PathParam("idpromo")int idPromo){
        Promo promo = new Promo();
        promo.setPromoId(idPromo);
        promoService.delete(promo);
        return Response.status(200).build();
    }
}
