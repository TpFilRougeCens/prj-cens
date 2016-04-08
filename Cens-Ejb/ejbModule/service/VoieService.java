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
 * Session Bean implementation class VoieService
 */
@Stateless
@LocalBean
public class VoieService {

    @PersistenceContext(unitName = "Cens-Jpa")
    EntityManager entityManager;

    /**
     * FIND ALL ELEMENTS METHODE WITH PARAMETER QUERY findAll
     *
     * @see Voie
     */
    @SuppressWarnings("unchecked")
    public List<Voie> findAll() {
        return entityManager.createNamedQuery("Voie.findAll").getResultList();
    }

    @SuppressWarnings("unchecked")
    public JSONObject JSON_findAll() {
        try {
            List<Voie> listeVoie = entityManager.createNamedQuery("Voie.findAll").getResultList();
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            if (listeVoie != null) {
                for (Voie p : listeVoie) {
                    jsonArray.put(convertToJson(p));
                }
                jsonObject.put("voies", jsonArray);
            } else {
                jsonObject.put("voies", "null");
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
     * @param voieId : Id du eleve recherché
     */
    public JSONObject JSON_findOne(Integer voieId) {
        Voie voie = findOne(voieId);
        JSONObject jsonObject = new JSONObject();

        if (voie != null) {
            jsonObject.put("voie", convertToJson(voie));
        } else {
            jsonObject.put("voie", "null");
        }
        return jsonObject;

    }

    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param voieId : Id du voie recherché
     */
    public Voie findOne(Integer voieId) {
        try {
            return entityManager.find(Voie.class, voieId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * DELETE METHODE WITH NATIVE JPA METHODE
     *
     * @param voieId : identifiant de voie
     */
    public boolean delete(Integer voieId) {
        try {
            Voie result = entityManager.find(Voie.class, voieId);
            entityManager.remove(result);
            //System.out.println("ID Supprimé = " + voie.getVoieId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param voie : Object de type Voie (de la classe)
     */
    public boolean insert(Voie voie) {
        try {
            entityManager.persist(voie);
            //System.out.println("ID inséré = " + voie.getVoieId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param voie : Object de type Voie (de la classe)
     */
    public boolean update(Voie voie) {
        try {
            entityManager.merge(voie);
            //System.out.println("ID Update = " + voie.getVoieId());
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
    private JSONObject convertToJson(Voie p) {
        JSONObject detailsJson = new JSONObject();
        JSONObject filieresJson = new JSONObject();
        detailsJson.put("id", p.getVoieId());
        detailsJson.put("libelle", p.getVoieLibelle());
        return detailsJson;
    }

    /**
     * CONVERTIR UN OBJ JSON EN OBJ JAVA
     *
     * @param p
     * @return Voie
     */
    private Voie convertToObject(JSONObject p) {
        Voie result = new Voie();
        Filiere filiere;

        if (p.has("id") && !p.isNull("id")) {
            result.setVoieId(p.getInt("id"));
        }
        if (p.has("libelle") && !p.isNull("libelle")) {
            result.setVoieLibelle(p.getString("libelle"));
        }
        return result;
    }


    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param voie : Object de type JSON eleve
     */
    public boolean JSON_insert(JSONObject voie) {
        try {
            if (voie.has("id") && !voie.isNull("id")) {
                voie.remove("id");
            }
            return insert(convertToObject(voie));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param voie : Object de type Eleve (de la classe)
     */
    public boolean JSON_update(JSONObject voie) {
        try {
            return update(convertToObject(voie));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
