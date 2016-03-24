package service;

import model.Eleve;
import model.Personne;
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
public class EleveService extends PersonneService {

    @PersistenceContext(unitName = "Cens-Jpa")
    EntityManager entityManager;

    /**
     * FIND ALL ELEMENTS METHODE WITH PARAMETER QUERY findAll
     *
     * @see Eleve
     */
    @SuppressWarnings("unchecked")
    public List<Personne> findAll() {
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
     * @param eleve : Object de type Eleve (de la classe)
     */
    public boolean delete(Eleve eleve) {
        try {
            Eleve result = entityManager.find(Eleve.class, eleve.getPersonneId());
            entityManager.remove(result);
            //System.out.println("ID Supprimé = " + eleve.getEleveId());
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
        detailsJson.put("id", p.getPersonneId());
        detailsJson.put("login", p.getPersonneLogin());
        detailsJson.put("password", p.getPersonnePassword());
        detailsJson.put("nom", p.getPersonneNom());
        detailsJson.put("prenom", p.getPersonnePrenom());
        detailsJson.put("dateNaissance", p.getPersonneDateNaissance());
        detailsJson.put("adresse", p.getPersonneAdresse());
        detailsJson.put("cp", p.getPersonneCp());
        detailsJson.put("ville", p.getPersonneVille());
        detailsJson.put("emailParent", p.getEleveEmailParent());
        detailsJson.put("groupeId", p.getGroupe().getGroupeId());
        detailsJson.put("groupeLibelle", p.getGroupe().getGroupeLibelle());
        detailsJson.put("groupeAccess", p.getGroupe().getGroupeNiveauAcces());
        return detailsJson;
    }
}
