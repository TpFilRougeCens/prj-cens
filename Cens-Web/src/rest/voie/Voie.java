package rest;

import org.json.JSONException;
import org.json.JSONObject;
import service.*;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;


/**
 * SERVICE REST ELEVES
 * <p>
 * Voir les méthodes pour le design pattern des URI
 */
@Path("/voie")
public class Voie {

    // ##############################################################
    // Web service sur la logique données axes élèves
    // ##############################################################


    @EJB
    VoieService voieService;


    private static final String JSON_SUCCES = "{\"msg\":\"Succès. L'opération à bien été réalisée!\"}";
    private static final String JSON_FAIL_SERVER = "{\"msg\":\"Echec. Le serveur ne peut pas traiter la demande. Contacter l'administrateur!\"}";
    private static final String JSON_FAIL_CLIENT = "{\"msg\":\"Echec. Le format des données n'est pas utilisable!\"}";


    // ########################## WEB SERVICE /voie #################################


    @GET
    @Produces("application/json;charset=utf-8")
    public Response findAllVoie() throws JSONException {
        JSONObject jsonObject = voieService.JSON_findAll();
        return Response.status(200).entity(jsonObject.toString()).build();
    }


    @Path("{idVoie}")
    @GET
    @Produces("application/json;charset=utf-8")
    public Response findVoieById(@PathParam("idVoie") Integer idVoie) throws JSONException {
        JSONObject jsonObject = voieService.JSON_findOne(idVoie);
        return Response.status(200).entity(jsonObject.toString()).build();
    }



    /**
     * AJOUTER UNE NOUVELLE EVALUATION AU LPC DE L'ELEVE
     * <p>
     * Exemple de post : {"voie":{"libelle": "Pro"}}
     * <p>
     * Aucun Id à stipuler sur un nouvel ajout
     *
     * @param jsonEntity
     * @return json
     * @throws JSONException
     */
    @POST
    @Consumes("application/json;charset=utf-8")
    @Produces("application/json;charset=utf-8")
    public Response postVoie(String jsonEntity) throws JSONException {
        JSONObject jsonObj;
        JSONObject jsonEval;

        try {
            jsonObj = new JSONObject(jsonEntity);
            jsonEval = jsonObj.getJSONObject("voie");
        } catch (Exception e) {
            return Response.status(400).entity(JSON_FAIL_CLIENT).build();
        }
        boolean result = voieService.JSON_insert(jsonEval);

        if (!result) {
            return Response.status(500).entity(JSON_FAIL_SERVER).build();
        }

        return Response.status(200).entity(JSON_SUCCES).build();
    }

    /**
     * AJOUTER UNE NOUVELLE EVALUATION AU LPC DE L'ELEVE
     * <p>
     * Exemple de post : {"voie":{"id": "4", "libelle": "Apprentissage"}}
     * <p>
     * Aucun Id à stipuler sur un nouvel ajout
     *
     * @param jsonEntity
     * @return json
     * @throws JSONException
     */
    @PUT
    @Consumes("application/json;charset=utf-8")
    @Produces("application/json;charset=utf-8")
    public Response putVoie(String jsonEntity) throws JSONException {
        JSONObject jsonObj;
        JSONObject jsonVoie;

        try {
            jsonObj = new JSONObject(jsonEntity);
            jsonVoie = jsonObj.getJSONObject("voie");
        } catch (Exception e) {
            return Response.status(400).entity(JSON_FAIL_CLIENT).build();
        }
        boolean result = voieService.JSON_update(jsonVoie);

        if (!result) {
            return Response.status(500).entity(JSON_FAIL_SERVER).build();
        }

        return Response.status(200).entity(JSON_SUCCES).build();
    }



    /**
     * DELETE : Supprime un élève en base
     * <p>
     * URI : http://localhost:8080/Cens-Web-1.0.0-SNAPSHOT/rest/voie/4
     *
     * @param idVoie
     * @return code HTTP + [message]
     * @throws JSONException
     */
    @Path("{idVoie}")
    @DELETE
    public Response deleteEleveById(@PathParam("idVoie") Integer idVoie) throws JSONException {
        try {
            boolean result = voieService.delete(idVoie);
            if (result) {
                return Response.status(200).entity(JSON_SUCCES).build();
            } else {
                return Response.status(400).entity(JSON_FAIL_CLIENT).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity(JSON_FAIL_SERVER).build();
        }
    }



}