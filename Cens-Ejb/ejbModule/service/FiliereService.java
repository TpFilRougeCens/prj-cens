package service;

import model.Filiere;
import model.Voie;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Session Bean implementation class FiliereService
 */
@Stateless
@LocalBean
public class FiliereService {

    @PersistenceContext(unitName = "Cens-Jpa")
    EntityManager entityManager;

    /**
     * FIND ALL ELEMENTS METHODE WITH PARAMETER QUERY findAll
     *
     * @see Filiere
     */
    @SuppressWarnings("unchecked")
    public List<Filiere> findAll() {
        return entityManager.createNamedQuery("Filiere.findAll").getResultList();
    }

    @SuppressWarnings("unchecked")
    public JSONObject JSON_findAll() {
        try {
            List<Filiere> listeFiliere = entityManager.createNamedQuery("Filiere.findAll").getResultList();
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            if (listeFiliere != null) {
                for (Filiere p : listeFiliere) {
                    jsonArray.put(convertToJson(p));
                }
                jsonObject.put("filiere", jsonArray);
            } else {
                jsonObject.put("filiere", "null");
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
     * @param filiereId : Id du filiere recherché
     */
    public Filiere findOne(Integer filiereId) {
        try {
            return entityManager.find(Filiere.class, filiereId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param filiereId : Id du eleve recherché
     */
    public JSONObject JSON_findOne(Integer filiereId) {
        Filiere filiere = findOne(filiereId);
        JSONObject jsonObject = new JSONObject();

        if (filiere != null) {
            jsonObject.put("filiere", convertToJson(filiere));
        } else {
            jsonObject.put("filiere", "null");
        }
        return jsonObject;

    }

    /**
     * DELETE METHODE WITH NATIVE JPA METHODE
     *
     * @param filiere : Object de type Filiere (de la classe)
     */
    public boolean delete(Filiere filiere) {
        try {
            Filiere result = entityManager.find(Filiere.class, filiere.getFiliereId());
            entityManager.remove(result);
            //System.out.println("ID Supprimé = " + filiere.getFiliereId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param filiere : Object de type Filiere (de la classe)
     */
    public boolean insert(Filiere filiere) {
        try {
            entityManager.persist(filiere);
            //System.out.println("ID inséré = " + filiere.getFiliereId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param filiere : Object de type Filiere (de la classe)
     */
    public boolean update(Filiere filiere) {
        try {
            entityManager.merge(filiere);
            //System.out.println("ID Update = " + filiere.getFiliereId());
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
    private JSONObject convertToJson(Filiere p) {
        JSONObject detailsJson = new JSONObject();
        JSONObject voieJson = new JSONObject();
        JSONObject classeJson = new JSONObject();
        detailsJson.put("id", p.getFiliereId());
        detailsJson.put("libelle", p.getFiliereLibelle());

        voieJson.put("id", p.getVoie().getVoieId());
        voieJson.put("libelle", p.getVoie().getVoieLibelle());
        detailsJson.put("voie", voieJson);

        return detailsJson;
    }

    /**
     * CONVERTIR UN OBJ JSON EN OBJ JAVA
     * <p>
     * Attention l'ID du groupe est OBLIGATOIRE
     *
     * @param p
     * @return Filiere
     */
    private Filiere convertToObject(JSONObject p) {
        Filiere result = new Filiere();
        Voie voie;

        if (p.has("id") && !p.isNull("id")) {
            result.setFiliereId(p.getInt("id"));
        }
        if (p.has("filliere") && !p.isNull("filliere")) {
            result.setFiliereLibelle(p.getString("libelle"));
        }

        // Consulter entityManger pour retrouver la voie
        try {
            voie = entityManager.find(Voie.class, p.getInt("voieId"));
            result.setVoie(voie);
        } catch (Exception e) {
            e.printStackTrace();
            // Si le groupe est introuvable on stop la methode = ERREUR fatal
            return null;
        }

        return result;
    }
}
