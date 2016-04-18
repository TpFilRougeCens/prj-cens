package rest;

import model.ComCap;
import model.Eleve;
import model.Note;
import org.json.JSONException;
import service.ComCapService;
import service.EleveService;
import service.NoteService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by steven on 08/04/16.
 */

@Path("/statComp")
public class StatCompMatiere {

    private final String JSON_SUCCES = "{\"msg\":\"Succès. L'opération à bien été réalisée!\"}";
    private final String JSON_FAIL_SERVER = "{\"msg\":\"Echec. Le serveur ne peut pas traiter la demande. Contacter l'administrateur!\"}";
    private final String JSON_FAIL_CLIENT = "{\"msg\":\"Echec. Le format des données n'est pas utilisable!\"}";

    @EJB
    EleveService eleveService;

    @EJB
    ComCapService comCapService;

    @EJB
    NoteService noteService;


    @GET
    @Produces("application/json;charset=utf-8")
    @Path("{idEleve}")
    public Response RecupStatEleve(@PathParam("idEleve") Integer idEleve)throws JSONException{
        try{
            Eleve eleve = eleveService.findOne(idEleve);
            comCapService.findComCapByEleveId(idEleve);
            noteService.findNoteByEleve(eleve);
        }catch(Exception e){
            e.printStackTrace();
        }

        return Response.status(200).entity(JSON_SUCCES).build();
    }


}
