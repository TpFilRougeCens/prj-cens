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
@Path("/eleve")
public class ElevesRest {

    // ##############################################################
    // Web service sur la logique données axes élèves
    // ##############################################################


    @EJB
    EleveService eleveService;

    @EJB
    VoieService voieService;

    @EJB
    FiliereService filiereService;

    @EJB
    ClassroomService classeService;

    @EJB
    ComCapService competenceService;

    private static final String JSON_SUCCES = "{\"msg\":\"Succès. L'opération à bien été réalisée!\"}";
    private static final String JSON_FAIL_SERVER = "{\"msg\":\"Echec. Le serveur ne peut pas traiter la demande. Contacter l'administrateur!\"}";
    private static final String JSON_FAIL_CLIENT = "{\"msg\":\"Echec. Le format des données n'est pas utilisable!\"}";
    // ########################## WEB SERVICE /eleve ########################################

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
        try {
            boolean result = eleveService.delete(idEleve);
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
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public Response putEleve(String jsonEntity) throws JSONException {
        JSONObject jsonObj;
        JSONObject jsonEleve;

        try {
            jsonObj = new JSONObject(jsonEntity);
            jsonEleve = jsonObj.getJSONObject("eleve");
        } catch (Exception e) {
            return Response.status(400).entity(JSON_FAIL_CLIENT).build();
        }

        boolean result = eleveService.JSON_update(jsonEleve);

        if (!result) {
            return Response.status(500).entity(JSON_FAIL_SERVER).build();
        }

        return Response.status(200).entity(JSON_SUCCES).build();
    }

    /**
     * POST : ajouter un élève en base
     * <p>
     * URI : http://localhost:8080/Cens-Web-1.0.0-SNAPSHOT/rest/eleve/
     * <p>
     * Exemple : {"eleve":{"password": "P@ssword","ville": "NANTES1","adresse": "1 rue dupont","groupeId":1,"login": "Eleve1DepuisJson2","nom": "nom1Json","prenom": "prenom1","cp": "44000"}}
     *
     * @param jsonEntity
     * @return code HTTP + [message]
     * @throws JSONException
     */
    @POST
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public Response postEleve(String jsonEntity) throws JSONException {
        JSONObject jsonObj;
        JSONObject jsonEleve;

        try {
            jsonObj = new JSONObject(jsonEntity);
            jsonEleve = jsonObj.getJSONObject("eleve");
        } catch (Exception e) {
            return Response.status(400).entity(JSON_FAIL_CLIENT).build();
        }

        boolean result = eleveService.JSON_insert(jsonEleve);

        if (!result) {
            return Response.status(500).entity(JSON_FAIL_SERVER).build();
        }

        return Response.status(200).entity(JSON_SUCCES).build();
    }


    // ########################## WEB SERVICE /eleve/{idEleve}/lpc #################################
    // ########################## Construit le LPC de l'élève      #################################

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
    public Response getLpcEleveById(@PathParam("idEleve") Integer idEleve) throws JSONException {
        JSONObject jsonObject = eleveService.JSON_findHierarchiePedagogique(idEleve, null, null);
        return Response.status(200).entity(jsonObject.toString()).build();
    }

    // ########################## WEB SERVICE /eleve/lps/evaluation #################################
    // ########################## Traite les évaluation de l'élève  #################################

    /**
     * AJOUTER UNE NOUVELLE EVALUATION AU LPC DE L'ELEVE
     * <p>
     * Exemple de post : {"evaluation":{"enseignant": 1,"eleve": 7,"capacite":49,"evalEnseignant": 2,"evalEleve": 3,"date": "31/01/1989","commentaire": "youpiiii un commentaire"}}
     * <p>
     * L'évaluation et l'auto-évaluation peuvent ne sont pas obligatoirement stipulé
     * Si non stipuler : la Note Id = 1 = Non noté
     * <p>
     * Aucun Id à stipuler sur un nouvel ajout
     *
     * @param jsonEntity
     * @return json
     * @throws JSONException
     */
    @Path("lpc/evaluation")
    @POST
    @Consumes("application/json;charset=utf-8")
    @Produces("application/json;charset=utf-8")
    public Response postEvaluationEleveById(String jsonEntity) throws JSONException {
        JSONObject jsonObj;
        JSONObject jsonEval;

        try {
            jsonObj = new JSONObject(jsonEntity);
            jsonEval = jsonObj.getJSONObject("evaluation");
        } catch (Exception e) {
            return Response.status(400).entity(JSON_FAIL_CLIENT).build();
        }
        boolean result = eleveService.JSON_insertEval(jsonEval);

        if (!result) {
            return Response.status(500).entity(JSON_FAIL_SERVER).build();
        }

        return Response.status(200).entity(JSON_SUCCES).build();
    }

    /**
     * MODIFIER UNE NOUVELLE EVALUATION AU LPC DE L'ELEVE
     * <p>
     * Exemple de PUT : {"evaluation":{"id":1,"enseignant": 2,"eleve": 7,"capacite":49,"evalEnseignant": 2,"evalEleve": 3,"date": "31/01/1989","commentaire": "youpiiii un commentaire"}}
     * <p>
     * L'évaluation et l'auto-évaluation peuvent ne sont pas obligatoirement stipulé
     * Si non stipuler : la Note Id = 1 = Non noté
     * <p>
     * Warning : Id à stipuler sur un update
     *
     * @param jsonEntity
     * @return json
     * @throws JSONException
     */
    @Path("lpc/evaluation")
    @PUT
    @Consumes("application/json;charset=utf-8")
    @Produces("application/json;charset=utf-8")
    public Response putEvaluationEleveById(String jsonEntity) throws JSONException {
        JSONObject jsonObj;
        JSONObject jsonEval;

        try {
            jsonObj = new JSONObject(jsonEntity);
            jsonEval = jsonObj.getJSONObject("evaluation");
        } catch (Exception e) {
            return Response.status(400).entity(JSON_FAIL_CLIENT).build();
        }
        boolean result = eleveService.JSON_updateEval(jsonEval);

        if (!result) {
            return Response.status(500).entity(JSON_FAIL_SERVER).build();
        }

        return Response.status(200).entity(JSON_SUCCES).build();
    }


    /**
     * SUPPRIMER UNE EVALUATION DU LPC DE L'ELEVE
     *
     * @param idEvaluation
     * @return json
     * @throws JSONException
     */
    @Path("lpc/evaluation/{idEvaluation}")
    @DELETE
    @Produces("application/json;charset=utf-8")
    public Response deleteEvaluationEleveById(@PathParam("idEvaluation") Integer idEvaluation) throws JSONException {
        try {
            boolean result = eleveService.deleteEvaluation(idEvaluation);
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


    // ########################## WEB SERVICE /eleve/lps/bilans #################################
    // ########################## Traite les bilans de l'élève  #################################

    /**
     * Retourne les bilans de l'élèves
     * <p>
     * Classe, bilans
     *
     * @param idEleve
     * @return json
     * @throws JSONException
     */
    @Path("{idEleve}/lpc/bilan")
    @GET
    @Produces("application/json;charset=utf-8")
    public Response getBilan(@PathParam("idEleve") Integer idEleve) throws JSONException {
        JSONObject jsonObject = eleveService.JSON_findBilan(idEleve);
        return Response.status(200).entity(jsonObject.toString()).build();
    }


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

    /**
     * Renvoi les classes (+élève) d'un enseignant
     *
     * @param idEnseignant
     * @return
     * @throws JSONException
     */
    @Path("classe/enseignant/{idEnseignant}")
    @GET
    @Produces("application/json;charset=utf-8")
    public Response findClasseByEnseignantId(@PathParam("idEnseignant") Integer idEnseignant) throws JSONException {
        JSONObject jsonObject = classeService.JSON_findByEnseignantId(idEnseignant);
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