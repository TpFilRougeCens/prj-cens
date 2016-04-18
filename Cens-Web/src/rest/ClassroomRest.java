package rest;

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;
import service.BlocService;
import service.ClassroomService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by steven on 16/04/16.
 */
@Path("/classe")
public class ClassroomRest {
    @EJB
    ClassroomService classroomService;

    @Path("/")
    @GET
    @Produces("application/json")
    public Response findAll() {
        List<Classroom> listeClasse = classroomService.findAll();

        JSONArray classesJson = new JSONArray();
        for (Classroom classroom : listeClasse) {
            JSONObject classeJson = new JSONObject();
            classeJson.put("id", classroom.getClassroomId());
            classeJson.put("fkFiliere", classroom.getFiliere().getFiliereId());
            classeJson.put("fkNiveau", classroom.getNiveau().getNiveauId());
            classeJson.put("fkManager",classroom.getEmploye().getPersonneId());
            classeJson.put("libelle", classroom.getClassroomLibelle());

            classesJson.put(classeJson);
        }

        return Response.status(200).entity(classesJson.toString()).build();
    }

    @Path("/{idClasse}")
    @GET
    @Produces("application/json")
    public Response findOne(@PathParam("idClasse") int idClasse) {
        Classroom classroom = classroomService.findOne(idClasse);
        JSONObject classeJson = new JSONObject();
        classeJson.put("id", classroom.getClassroomId());
        classeJson.put("fkFiliere", classroom.getFiliere().getFiliereId());
        classeJson.put("fkNiveau", classroom.getNiveau().getNiveauId());
        classeJson.put("fkManager",classroom.getEmploye().getPersonneId());
        classeJson.put("libelle", classroom.getClassroomLibelle());

        return Response.status(200).entity(classeJson.toString()).build();
    }

    @Path("/insert")
    @PUT
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public Response insertClasse(@FormParam("classeLibelle" ) String classeLibelle,
                                 @FormParam("classeFiliereId" ) Integer classeFiliereId,
                                 @FormParam("classeNiveauId") Integer classeNiveauId,
                                 @FormParam("classeManagerId") Integer classeManagerId) {
        Classroom classroom = new Classroom();
        Filiere filiere = new Filiere();
        filiere.setFiliereId(classeFiliereId);
        Niveau niveau = new Niveau();
        niveau.setNiveauId(classeNiveauId);
        Employe manager = new Employe();
        manager.setPersonneId(classeManagerId);

        classroom.setNiveau(niveau);
        classroom.setFiliere(filiere);
        classroom.setEmploye(manager);
        classroom.setClassroomLibelle(classeLibelle);

        classroomService.insert(classroom);

        return Response.status(200).build();
    }

    @Path("/delete/{idClasse}")
    @DELETE
    @Produces("application/json")
    public Response deleteClasse(@PathParam("idClasse") int idClasse) {
        Classroom classroom = new Classroom();
        classroom.setClassroomId(idClasse);
        classroomService.delete(classroom);
        return Response.status(200).build();
    }

}
