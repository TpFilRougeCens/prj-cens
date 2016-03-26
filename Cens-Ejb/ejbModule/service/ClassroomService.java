package service;

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Session Bean implementation class ClassroomService
 */
@Stateless
@LocalBean
public class ClassroomService {

    @PersistenceContext(unitName = "Cens-Jpa")
    EntityManager entityManager;

    /**
     * FIND ALL ELEMENTS METHODE WITH PARAMETER QUERY findAll
     *
     * @see Classroom
     */
    @SuppressWarnings("unchecked")
    public List<Classroom> findAll() {
        return entityManager.createNamedQuery("Classroom.findAll").getResultList();
    }

    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param classroomId : Id du classroom recherché
     */
    public Classroom findOne(Integer classroomId) {
        try {
            return entityManager.find(Classroom.class, classroomId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @SuppressWarnings("unchecked")
    public JSONObject JSON_findAll() {
        try {
            List<Classroom> listeClasse = entityManager.createNamedQuery("Classroom.findAll").getResultList();
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            if (listeClasse != null) {
                for (Classroom p : listeClasse) {
                    jsonArray.put(convertToJson(p));
                }
                jsonObject.put("classes", jsonArray);
            } else {
                jsonObject.put("classes", "null");
            }
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param classroomId : Id du classe recherché
     */
    public JSONObject JSON_findOne(Integer classroomId) {
        Classroom classroom = findOne(classroomId);
        JSONObject jsonObject = new JSONObject();

        if (classroom != null) {
            jsonObject.put("classe", convertToJson(classroom));
        } else {
            jsonObject.put("classe", "null");
        }
        return jsonObject;

    }

    /**
     * DELETE METHODE WITH NATIVE JPA METHODE
     *
     * @param classroom : Object de type Classroom (de la classe)
     */
    public boolean delete(Classroom classroom) {
        try {
            Classroom result = entityManager.find(Classroom.class, classroom.getClassroomId());
            entityManager.remove(result);
            //System.out.println("ID Supprimé = " + classroom.getClassroomId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param classroom : Object de type Classroom (de la classe)
     */
    public boolean insert(Classroom classroom) {
        try {
            entityManager.persist(classroom);
            //System.out.println("ID inséré = " + classroom.getClassroomId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param classroom : Object de type Classroom (de la classe)
     */
    public boolean update(Classroom classroom) {
        try {
            entityManager.merge(classroom);
            //System.out.println("ID Update = " + classroom.getClassroomId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * PERMET DE CONVERTIR UN OBJECT JAVA EN OBJECT JSON
     *
     * @param p
     * @return JSONObject
     */
    private JSONObject convertToJson(Classroom p) {
        JSONObject detailsJson = new JSONObject();
        JSONObject managerJson = new JSONObject();
        JSONObject niveauJson = new JSONObject();
        JSONObject filiereJson = new JSONObject();
        JSONObject voieJson = new JSONObject();
        JSONArray elevesJson = new JSONArray();
        JSONObject eleveJson = new JSONObject();


        detailsJson.put("id", p.getClassroomId());
        detailsJson.put("libelle", p.getClassroomLibelle());

        managerJson.put("id", p.getEmploye().getPersonneId());
        managerJson.put("nom", p.getEmploye().getPersonneNom());
        managerJson.put("prenom", p.getEmploye().getPersonnePrenom());
        detailsJson.put("manager", managerJson);

        niveauJson.put("id", p.getNiveau().getNiveauId());
        niveauJson.put("libelle", p.getNiveau().getNiveauLibelle());
        detailsJson.put("niveau", niveauJson);

        filiereJson.put("id", p.getFiliere().getFiliereId());
        filiereJson.put("libelle", p.getFiliere().getFiliereLibelle());
        detailsJson.put("filiere", filiereJson);

        voieJson.put("id", p.getFiliere().getVoie().getVoieId());
        voieJson.put("libelle", p.getFiliere().getVoie().getVoieLibelle());
        detailsJson.put("voie", voieJson);

        for (AssocEtudier elem : p.getAssocEtudiers()) {
            eleveJson.put("id", elem.getEleve().getPersonneId());
            eleveJson.put("nom", elem.getEleve().getPersonneNom());
            eleveJson.put("prenom", elem.getEleve().getPersonnePrenom());
            eleveJson.put("dateNaissance", elem.getEleve().getPersonneDateNaissance());
            elevesJson.put(eleveJson);
        }
        detailsJson.put("eleves", elevesJson);

        return detailsJson;
    }

    /**
     * CONVERTIR UN OBJ JSON EN OBJ JAVA
     *
     * @param p
     * @return Classroom
     */
    private Classroom convertToObject(JSONObject p) {
        Classroom result = new Classroom();
        Filiere filiere = new Filiere();
        Niveau niveau = new Niveau();
        Employe manager = new Employe();

        if (p.has("id") && !p.isNull("id")) {
            result.setClassroomId(p.getInt("id"));
        }
        if (p.has("libelle") && !p.isNull("libelle")) {
            result.setClassroomLibelle(p.getString("libelle"));
        }

        try {
            filiere = entityManager.find(Filiere.class, new JSONObject(p.get("filiere")).getInt("id"));
            result.setFiliere(filiere);
            niveau = entityManager.find(Niveau.class, new JSONObject(p.get("niveau")).getInt("id"));
            result.setNiveau(niveau);
            manager = entityManager.find(Employe.class, new JSONObject(p.get("manager")).getInt("id"));
            result.setEmploye(manager);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }
}
