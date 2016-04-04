package rest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import service.NoteService;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;


/**
 * SERVICE REST ELEVES
 * <p>
 * Voir les méthodes pour le design pattern des URI
 */
@Path("/note")
public class NotesRest {

    @PersistenceContext(unitName = "Cens-Jpa")
    EntityManager entityManager;

    @EJB
    NoteService noteService;

    private static final String JSON_SUCCES = "{\"msg\":\"Succès. L'opération à bien été réalisée!\"}";
    private static final String JSON_FAIL_SERVER = "{\"msg\":\"Echec. Le serveur ne peut pas traiter la demande. Contacter l'administrateur!\"}";
    private static final String JSON_FAIL_CLIENT = "{\"msg\":\"Echec. Le format des données n'est pas utilisable!\"}";
    // ########################## WEB SERVICE /eleve ########################################

    /**
     * GET retourne toutes les notes
     * <p>
     * URI : /rest/note/
     *
     * @return code HTTP + JsonArray
     * @throws JSONException
     */
    @GET
    @Produces("application/json;charset=utf-8")
    public Response findAllNotes() throws JSONException {
        JSONObject jsonObject = noteService.JSON_findAll();
        return Response.status(200).entity(jsonObject.toString()).build();
    }


    /**
     * Get : retourne une note unique
     * <p>
     * URI : /rest/note/{idNote}
     *
     * @param idNote
     * @return code HTTP + JsonArray
     * @throws JSONException
     */
    @Path("{idNote}")
    @GET
    @Produces("application/json;charset=utf-8")
    public Response findEleveById(@PathParam("idNote") Integer idNote) throws JSONException {
        JSONObject jsonObject = noteService.JSON_findOne(idNote);
        // on retourne un Object JasonArray afin de garantir une réponse cohérente dans le WebService global
        return Response.status(200).entity(jsonObject.toString()).build();
    }


    /**
     * GET retourne les notes actives ou non
     * <p>
     * URI : /rest/note/{boolean}
     *
     * @param active_desactive de type boolean
     * @return code HTTP + JsonArray
     * @throws JSONException
     */
    @Path("{active_desactive}")
    @GET
    @Produces("application/json;charset=utf-8")
    public Response findAllNotesActDesac(@PathParam("active_desactive") String active_desactive) throws JSONException {
        JSONObject jsonObject = noteService.JSON_findAll();
        JSONArray jsonArray = jsonObject.getJSONArray("notes");
        JSONArray jsonResults = new JSONArray();
        JSONObject jsonResult = new JSONObject();

        boolean param = false;

        // Si active_desactive = true on souhaites les éléments activé TRUE
        if (active_desactive.equals("true")) {
            param = true;
        } else {
            param = false;
        }

        try {
            // Boucle pour trouver les éléments à garder
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject item = jsonArray.getJSONObject(i);
                if (item.get("active").equals(param)) {
                    jsonResults.put(item);
                }
            }

            jsonResult.put("notes", jsonResults);
        } catch (Exception e) {
            jsonResult.put("notes", "null");
        }

        return Response.status(200).entity(jsonResult.toString()).build();
    }


    /**
     * GET : Active ou desactive une note
     * <p>
     * URI : /rest/note/{idNote}/{boolean}
     *
     * @param idNote
     * @return code HTTP + [message]
     * @throws JSONException
     */
    @Path("{idNote}/{active}")
    @GET
    @Produces("application/json;charset=utf-8")
    public Response active_desactive(@PathParam("idNote") Integer idNote, @PathParam("active") String active) throws JSONException {
        try {
            boolean param = true;
            if (active.equals("true")) {
                param = true;
            } else {
                param = false;
            }
            boolean result = noteService.active_desactive(idNote, param);
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
     * PUT : modifier/maj une note en base
     * <p>
     * URI : /rest/note/
     * <p>
     * ID obligatoire dans le JSON
     * <p>
     * Exemple : {"note":{"abvr":"DEC","valeur":0,"libelle":"Compétence désactivée","couleur":"#ff1000","active":false,"id":7}}
     *
     * @param jsonEntity
     * @return code HTTP + [message]
     * @throws JSONException
     */
    @PUT
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public Response putNote(String jsonEntity) throws JSONException {
        JSONObject jsonObj;
        JSONObject jsonNote;

        try {
            jsonObj = new JSONObject(jsonEntity);
            jsonNote = jsonObj.getJSONObject("note");
        } catch (Exception e) {
            return Response.status(400).entity(JSON_FAIL_CLIENT).build();
        }

        boolean result = noteService.JSON_update(jsonNote);

        if (!result) {
            return Response.status(500).entity(JSON_FAIL_SERVER).build();
        }

        return Response.status(200).entity(JSON_SUCCES).build();
    }

    /**
     * POST : ajouter une note en base
     * <p>
     * URI : /rest/note/
     * <p>
     * ID ne sert à rien
     * <p>
     * Exemple : {"note":{"abvr":"TES","valeur":0,"libelle":"Depuis java","couleur":"#cecece","active":false}}
     *
     * @param jsonEntity
     * @return code HTTP + [message]
     * @throws JSONException
     */
    @POST
    @Produces("application/json;charset=utf-8")
    @Consumes("application/json;charset=utf-8")
    public Response postNote(String jsonEntity) throws JSONException {
        JSONObject jsonObj;
        JSONObject jsonNote;

        try {
            jsonObj = new JSONObject(jsonEntity);
            jsonNote = jsonObj.getJSONObject("note");
        } catch (Exception e) {
            return Response.status(400).entity(JSON_FAIL_CLIENT).build();
        }

        boolean result = noteService.JSON_insert(jsonNote);

        if (!result) {
            return Response.status(500).entity(JSON_FAIL_SERVER).build();
        }

        return Response.status(200).entity(JSON_SUCCES).build();
    }


}