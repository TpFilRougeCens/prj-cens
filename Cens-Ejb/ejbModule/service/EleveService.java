package service;

import model.Eleve;
import model.Groupe;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
            if (listeEleves != null) {
                for (Eleve p : listeEleves) {
                    jsonArray.put(convertToJson(p));
                }
                jsonObject.put("eleves", jsonArray);
            } else {
                jsonObject.put("eleves", "null");
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
        Eleve eleve = findOne(eleveId);
        JSONObject jsonObject = new JSONObject();

        if (eleve != null) {
            jsonObject.put("eleve", convertToJson(eleve));
        } else {
            jsonObject.put("eleve", "null");
        }
        return jsonObject;

    }

    /**
     * DELETE METHODE WITH NATIVE JPA METHODE
     *
     * @param eleveId : Id de eleve
     */
    public boolean delete(Integer eleveId) {
        try {
            Eleve result = entityManager.find(Eleve.class, eleveId);
            if (result != null) {
                // OK FONCTIONNE
                while (result.getBilans().isEmpty() == false) {
                    result.removeBilan(result.getBilans().get(0));
                }
                entityManager.createNamedQuery("Eleve.deleteEtudier").setParameter("idd", eleveId).executeUpdate();
                entityManager.createNamedQuery("Eleve.deleteEvaluer").setParameter("idd", eleveId).executeUpdate();
                entityManager.createNamedQuery("Eleve.deleteBilan").setParameter("idd", eleveId).executeUpdate();

                entityManager.remove(result);
            }
            return true;
        } catch (Exception e) {
            System.err.print(e);
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
            System.err.print(e);
            e.printStackTrace();
            return false;
        }

    }

    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param eleve : Object de type JSON eleve
     */
    public boolean JSON_insert(JSONObject eleve) {
        try {
            entityManager.persist(convertToObject(eleve));
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

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param eleve : Object de type Eleve (de la classe)
     */
    public boolean JSON_update(JSONObject eleve) {
        try {
            entityManager.merge(convertToObject(eleve));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * PERMET DE CONVERTIR UN OBJECT JAVA EN OBJECT JSON
     *
     * @param p de type Eleve
     * @return JSONObject
     */
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

    /**
     * CONVERTIR UN OBJ JSON EN OBJ JAVA
     * <p>
     * Attention l'ID du groupe est OBLIGATOIRE
     *
     * @param eleve
     * @return un Eleve
     */
    private Eleve convertToObject(JSONObject eleve) {
        Eleve result = new Eleve();
        Groupe groupe;

        result.setPersonneLogin(eleve.getString("login"));
        result.setPersonnePassword(eleve.getString("password"));
        result.setPersonneNom(eleve.getString("nom"));
        result.setPersonnePrenom(eleve.getString("prenom"));

        //****** Traitement des champs pouvant être NULL *****
        // Si le champs existe dans l'object JSON

        if (eleve.has("id") && !eleve.isNull("id")) {
            result.setPersonneId(eleve.getInt("id"));
        }

        if (eleve.has("dateNaissance") && !eleve.isNull("dateNaissance")) {
            DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
            String dateAsString = eleve.getString("dateNaissance");
            Date date = null;
            try {
                date = sourceFormat.parse(dateAsString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            result.setPersonneDateNaissance(date);
        }
        if (eleve.has("adresse") && !eleve.isNull("adresse")) {
            result.setPersonneAdresse(eleve.getString("adresse"));
        }
        if (eleve.has("cp") && !eleve.isNull("cp")) {
            result.setPersonneCp(eleve.getString("cp"));
        }
        if (eleve.has("ville") && !eleve.isNull("ville")) {
            result.setPersonneVille(eleve.getString("ville"));
        }
        if (eleve.has("emailParent") && !eleve.isNull("emailParent")) {
            result.setEleveEmailParent(eleve.getString("emailParent"));
        }

        // Consulter entityManger pour retrouver le groupe dans UP
        try {
            groupe = entityManager.find(Groupe.class, eleve.getInt("groupeId"));
            result.setGroupe(groupe);
        } catch (Exception e) {
            e.printStackTrace();
            // Si le groupe est introuvable on stop la methode = ERREUR fatal
            return null;
        }

        return result;
    }
}
