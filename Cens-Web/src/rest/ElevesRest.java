package rest;

import org.json.JSONException;
import org.json.JSONObject;
import service.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;


/**
 * SERVICE REST ELEVES
 * <p>
 * Voir les méthodes pour le design pattern des URI
 */
@Path("/eleve")
public class ElevesRest {

    // ##############################################################
    // Web service sur la logique données axes élèves
    // ##############################################################


    @Inject
    EleveService eleveService;

    @Inject
    VoieService voieService;

    @Inject
    FiliereService filiereService;

    @Inject
    ClassroomService classeService;

    @Inject
    ComCapService competenceService;

    // ########################## WEB SERVICE SUR ELEVE ########################################

    /**
     * GET retourne tous les élèves en base
     * <p>
     * URI : http://localhost:8080/Cens-Web-1.0.0-SNAPSHOT/rest/eleve/
     *
     * @return code HTTP + JsonArray
     * @throws JSONException
     */
    @GET
    @Produces("application/json")
    public Response findAllEleve() throws JSONException {
        JSONObject jsonObject = eleveService.JSON_findAll();
        return Response.status(200).entity(jsonObject.toString()).build();
    }

    /**
     * Get retourne un élève unique
     * <p>
     * URI : http://localhost:8080/Cens-Web-1.0.0-SNAPSHOT/rest/eleve/2
     *
     * @param idEleve
     * @return code HTTP + JsonArray
     * @throws JSONException
     */
    @Path("{idEleve}")
    @GET
    @Produces("application/json;charset=utf-8")
    public Response findEleveById(@PathParam("idEleve") Integer idEleve) throws JSONException {
        JSONObject jsonObject = eleveService.JSON_findOne(idEleve);
        // on retourne un Object JasonArray afin de garantir une réponse cohérente dans le WebService global
        return Response.status(200).entity(jsonObject.toString()).build();
    }

    /**
     * DELETE : Supprime un élève en base
     * <p>
     * URI : http://localhost:8080/Cens-Web-1.0.0-SNAPSHOT/rest/eleve/5
     *
     * @param idEleve
     * @return code HTTP + [message]
     * @throws JSONException
     */
    @Path("{idEleve}")
    @DELETE
    public Response deleteEleveById(@PathParam("idEleve") Integer idEleve) throws JSONException {
        boolean result = eleveService.delete(idEleve);
        return Response.status(200).entity("" + result).build();
    }

    /**
     * PUT : modifier/maj un élève en base
     * <p>
     * URI : http://localhost:8080/Cens-Web-1.0.0-SNAPSHOT/rest/eleve/
     * <p>
     * Exemple : {"eleve":{"password": "P@ssword","ville": "NANTES1","adresse": "1 rue dupont","id": 1,"groupeId":1,"login": "Eleve1DepuisJson2","nom": "nom1","prenom": "prenom1","cp": "44000"}}
     *
     * @param jsonEntity
     * @return code HTTP + [message]
     * @throws JSONException
     */
    @PUT
    @Consumes("application/json;charset=utf-8")
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
     * <p>
     * URI : http://localhost:8080/Cens-Web-1.0.0-SNAPSHOT/rest/eleve/
     * <p>
     * Exemple : {"eleve":{"password": "P@ssword","ville": "NANTES1","adresse": "1 rue dupont",groupeId":1,"login": "Eleve1DepuisJson2","nom": "nom1","prenom": "prenom1","cp": "44000"}}
     *
     * @param jsonEntity
     * @return code HTTP + [message]
     * @throws JSONException
     */
    @POST
    @Consumes("application/json;charset=utf-8")
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


    // ########################## WEB SERVICE /eleve/{idEleve}/lpc #################################

    /**
     * Retourne la hierarchie de l'élève jusqu'a ça liste de ses evaluations
     * <p>
     * Classe, blocs, matiere, competences, capacité, evaluations
     *
     * @param idEleve
     * @return json
     * @throws JSONException
     */
    @Path("{idEleve}/lpc")
    @GET
    @Produces("application/json;charset=utf-8")
    public Response findCapaciteById(@PathParam("idEleve") Integer idEleve) throws JSONException {
        JSONObject jsonObject = eleveService.JSON_findHierarchiePedagogique(idEleve);
        return Response.status(200).entity(jsonObject.toString()).build();
    }


    // !!!!!!!!!! NE SERT A RIEN ET PAS LOGIQUE ICI !!!!!!!!!!

    // ########################## WEB SERVICE /eleve/classe #################################

    @Path("classe")
    @GET
    @Produces("application/json;charset=utf-8")
    public Response findAllClasse() throws JSONException {
        JSONObject jsonObject = classeService.JSON_findAll();
        return Response.status(200).entity(jsonObject.toString()).build();
    }

    @Path("classe/{idClasse}")
    @GET
    @Produces("application/json;charset=utf-8")
    public Response findClasseById(@PathParam("idClasse") Integer idClasse) throws JSONException {
        JSONObject jsonObject = classeService.JSON_findOne(idClasse);
        return Response.status(200).entity(jsonObject.toString()).build();
    }


    // ########################## WEB SERVICE /eleve/voie #################################

    @Path("voie")
    @GET
    @Produces("application/json;charset=utf-8")
    public Response findAllVoie() throws JSONException {
        JSONObject jsonObject = voieService.JSON_findAll();
        return Response.status(200).entity(jsonObject.toString()).build();
    }


    @Path("voie/{idVoie}")
    @GET
    @Produces("application/json;charset=utf-8")
    public Response findVoieById(@PathParam("idVoie") Integer idVoie) throws JSONException {
        JSONObject jsonObject = voieService.JSON_findOne(idVoie);
        return Response.status(200).entity(jsonObject.toString()).build();
    }


    // ########################## WEB SERVICE /eleve/filiere #######################

    /**
     * GET : retourne toutes les fillières en base
     *
     * @return json
     * @throws JSONException
     */
    @Path("filiere")
    @GET
    @Produces("application/json;charset=utf-8")
    public Response findAllFiliere() throws JSONException {
        JSONObject jsonObject = filiereService.JSON_findAll();
        return Response.status(200).entity(jsonObject.toString()).build();
    }

    /**
     * GET : retourne une filiere selon Id
     *
     * @return json
     * @throws JSONException
     */
    @Path("filiere/{idFiliere}")
    @GET
    @Produces("application/json;charset=utf-8")
    public Response findById(@PathParam("idFiliere") Integer idFiliere) throws JSONException {
        JSONObject jsonObject = filiereService.JSON_findOne(idFiliere);
        return Response.status(200).entity(jsonObject.toString()).build();
    }

}