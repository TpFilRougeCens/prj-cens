package service;

import model.Eleve;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Session Bean implementation class EleveService
 */
@Stateless
@LocalBean
//public class EleveService extends EleveService {
public class EleveService {

    @PersistenceContext(unitName = "Cens-Jpa")
    EntityManager entityManager;

    /**
     * FIND ALL ELEMENTS METHODE WITH PARAMETER QUERY findAll
     *
     * @see Eleve
     */
    @SuppressWarnings("unchecked")
    public List<Eleve> findAll() {
        try {
            return entityManager.createNamedQuery("Eleve.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * FIND ALL ELEMENTS METHODE WITH PARAMETER QUERY findAll
     *
     * @see Eleve
     */
    @SuppressWarnings("unchecked")
    public JSONObject JSON_findAll() {
        try {
            List<Eleve> listeEleves = entityManager.createNamedQuery("Eleve.findAll").getResultList();
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();

            for (Eleve p : listeEleves) {
                jsonArray.put(convertToJson(p));
            }
            jsonObject.put("eleves", jsonArray);

            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param eleveId : Id du eleve recherché
     */
    public Eleve findOne(Integer eleveId) {
        try {
            return entityManager.find(Eleve.class, eleveId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param eleveId : Id du eleve recherché
     */
    public JSONObject JSON_findOne(Integer eleveId) {
        try {
            Eleve eleve = findOne(eleveId);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("eleve", convertToJson(eleve));
            return jsonObject;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * DELETE METHODE WITH NATIVE JPA METHODE
     *
     * @param eleveId : Id de eleve
     */
    public boolean delete(Integer eleveId) {
        try {
            Eleve result = entityManager.find(Eleve.class, eleveId);
            System.out.println("suppression de " + result.getEleveId() + " " + result.getEleveLogin());

            /*for (AssocEtudier elem : result.getAssocEtudiers()) {
                System.out.println(elem.getAssocEtudierId());
                entityManager.remove(elem);
            }

            for (AssocEvaluer elem : result.getAssocEvaluers()) {
                System.out.println(elem.getAssocEvaluerId());
                entityManager.remove(elem);
            }*/

            /*for (AssocEtudier elem : result.getAssocEtudiers()) {
                result.removeAssocEtudier(elem);
            }*/
            /*for (AssocEvaluer elem : result.getAssocEvaluers()) {
                result.removeAssocEvaluer(elem);
            }*/
            entityManager.createNamedQuery("Eleve.deleteBilan").setParameter("idd", eleveId).executeUpdate();
            entityManager.createNamedQuery("Eleve.deleteEval").setParameter("idd", eleveId).executeUpdate();
            entityManager.createNamedQuery("Eleve.deleteEtud").setParameter("idd", eleveId).executeUpdate();
            entityManager.createNamedQuery("Eleve.deleteEleve").setParameter("idd", eleveId).executeUpdate();


//            entityManager.remove(result);
//            entityManager.flush();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param eleve : Object de type Eleve (de la classe)
     */
    public boolean insert(Eleve eleve) {
        try {
            entityManager.persist(eleve);
            //System.out.println("ID inséré = " + eleve.getEleveId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param eleve : Object de type Eleve (de la classe)
     */
    public boolean update(Eleve eleve) {
        try {
            entityManager.merge(eleve);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    //METHODE PRIVATE
    private JSONObject convertToJson(Eleve p) {
        JSONObject detailsJson = new JSONObject();
        detailsJson.put("id", p.getEleveId());
        detailsJson.put("login", p.getEleveLogin());
        detailsJson.put("password", p.getElevePassword());
        detailsJson.put("nom", p.getEleveNom());
        detailsJson.put("prenom", p.getElevePrenom());
        detailsJson.put("dateNaissance", p.getEleveDateNaissance());
        detailsJson.put("adresse", p.getEleveAdresse());
        detailsJson.put("cp", p.getEleveCp());
        detailsJson.put("ville", p.getEleveVille());
        detailsJson.put("emailParent", p.getEleveEmailParent());
        detailsJson.put("groupeId", p.getGroupe().getGroupeId());
        detailsJson.put("groupeLibelle", p.getGroupe().getGroupeLibelle());
        detailsJson.put("groupeAccess", p.getGroupe().getGroupeNiveauAcces());
        return detailsJson;
    }
}
