package service;

import model.Employe;
import model.Groupe;
import org.json.JSONObject;
import service.util.EncryptPassword;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Session Bean implementation class EmployeService
 */
@Stateless
@LocalBean
public class EmployeService {

    @PersistenceContext(unitName = "Cens-Jpa")
    EntityManager entityManager;

    /**
     * FIND ALL ELEMENTS METHODE WITH PARAMETER QUERY findAll
     *
     * @see Employe
     */
    @SuppressWarnings("unchecked")
    public List<Employe> findAll() {
        return entityManager.createNamedQuery("Employe.findAll").getResultList();
    }

    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param employeId : Id du employe recherché
     * @return Employe
     */

    public Employe findOne(Integer employeId) {
        try {
            return entityManager.find(Employe.class, employeId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * RETOURNE UN ELEVE SI CELLE CI EST CONNUE
     *
     * @param login : login utilisateur qui demande une connexion
     */
    public Employe findOne(String login) {
        try {
            System.out.println("valeur de eleve dans service ");
            Employe employe = (Employe) entityManager
                    .createNamedQuery("Employe.findByLogin")
                    .setParameter("loginn", login)
                    .getSingleResult();
            System.out.println("valeur de Employe dans service " + employe);
            return employe;

        } catch (NoResultException e) {
            System.out.println("Employe : FindOne : Pas de resultat");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * RETOURNE UN ELEVE SI CELLE CI EST CONNUE
     *
     * @param login    : login utilisateur qui demande une connexion
     * @param password : mot de passe tentative
     */
    public Employe findOne(String login, String password) {
        try {
            System.out.println("valeur de employe dans service ");
            Employe employe = (Employe) entityManager
                    .createNamedQuery("Employe.findByNameAndPassWord")
                    .setParameter("loginn", login)
                    .setParameter("passwordd", password)
                    .getSingleResult();
            System.out.println("valeur de employe dans service " + employe);
            return employe;

        } catch (NoResultException e) {
            System.out.println("employe : FindOne : Pas de resultat");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * DELETE METHODE WITH NATIVE JPA METHODE
     *
     * @param employeId : Object de type Employe (de la classe)
     */
    public boolean delete(Integer employeId) {
        try {
            Employe result = entityManager.find(Employe.class, employeId);
            entityManager.remove(result);
            //System.out.println("ID Supprimé = " + employe.getEmployeId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param employe : Object de type Employe (de la classe)
     */
    public boolean insert(Employe employe) {
        try {
            String passNoCrypt = employe.getPersonnePassword();
            String passYesCrypt = new EncryptPassword().encrypt(passNoCrypt);
            employe.setPersonnePassword(passYesCrypt);
            entityManager.persist(employe);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param employe : Object de type Employe
     */
    public boolean update(Employe employe) {
        try {
            Employe employeJPA = entityManager.find(Employe.class, employe.getPersonneId());
            if (!employe.getPersonnePassword().equals(employeJPA.getPersonnePassword())) {
                String passEncryt = new EncryptPassword().encrypt(employe.getPersonnePassword());
                employe.setPersonnePassword(passEncryt);
            }
            entityManager.merge(employe);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param employeId : Id du eleve recherché
     */
    public JSONObject JSON_findOne(Integer employeId) {
        Employe employe = findOne(employeId);
        JSONObject jsonObject = new JSONObject();

        if (employe != null) {
            jsonObject.put("user", convertToJson(employe)); //TODO ici ???
        } else {
            jsonObject.put("user", "null");
        }
        return jsonObject;

    }

    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param employe : Object de type JSON Employe
     */
    public boolean JSON_insert(JSONObject employe) {
        try {
            if (employe.has("id") && !employe.isNull("id")) {
                employe.remove("id");
            }
            return insert(convertToObject(employe));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param employe : Object de type JSON Employe
     */
    public boolean JSON_update(JSONObject employe) {
        try {
            return update(convertToObject(employe));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * PERMET DE CONVERTIR UN OBJECT JAVA EN OBJECT JSON
     *
     * @param p de type Employe
     * @return JSONObject
     */
    private JSONObject convertToJson(Employe p) {
        JSONObject detailsJson = new JSONObject();
        JSONObject groupeJson = new JSONObject();

        detailsJson.put("id", p.getPersonneId());
        detailsJson.put("login", p.getPersonneLogin());
        detailsJson.put("password", p.getPersonnePassword());
        detailsJson.put("nom", p.getPersonneNom());
        detailsJson.put("prenom", p.getPersonnePrenom());
        detailsJson.put("dateNaissance", p.getPersonneDateNaissance());
        detailsJson.put("adresse", p.getPersonneAdresse());
        detailsJson.put("cp", p.getPersonneCp());
        detailsJson.put("ville", p.getPersonneVille());

        groupeJson.put("id", p.getGroupe().getGroupeId());
        groupeJson.put("libelle", p.getGroupe().getGroupeLibelle());
        groupeJson.put("access", p.getGroupe().getGroupeNiveauAcces());
        detailsJson.put("groupe", groupeJson); // Json in Json

        // Impl Assoc not yet
        return detailsJson;
    }

    /**
     * CONVERTIR UN OBJ JSON EN OBJ JAVA
     * <p>
     * Attention l'ID du groupe est OBLIGATOIRE
     *
     * @param employe
     * @return un Eleve
     */
    private Employe convertToObject(JSONObject employe) {
        Employe result = new Employe();
        Groupe groupe;

        if (employe.has("id") && !employe.isNull("id")) {
            result.setPersonneId(employe.getInt("id"));
        }

        result.setPersonneLogin(employe.getString("login"));
        result.setPersonnePassword(employe.getString("password"));
        result.setPersonneNom(employe.getString("nom"));
        result.setPersonnePrenom(employe.getString("prenom"));

        if (employe.has("dateNaissance") && !employe.isNull("dateNaissance")) {
            DateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.FRENCH);
            String dateAsString = employe.getString("dateNaissance");
            Date date = null;
            try {
                date = sourceFormat.parse(dateAsString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            result.setPersonneDateNaissance(date);
        }
        if (employe.has("adresse") && !employe.isNull("adresse")) {
            result.setPersonneAdresse(employe.getString("adresse"));
        }
        if (employe.has("cp") && !employe.isNull("cp")) {
            result.setPersonneCp(employe.getString("cp"));
        }
        if (employe.has("ville") && !employe.isNull("ville")) {
            result.setPersonneVille(employe.getString("ville"));
        }

        // Consulter entityManger pour retrouver le groupe dans UP
        try {
            groupe = entityManager.find(Groupe.class, employe.getInt("groupeId"));
            result.setGroupe(groupe);
        } catch (Exception e) {
            e.printStackTrace();
            // Si le groupe est introuvable on stop la methode = ERREUR fatal
            return null;
        }

        return result;
    }
}
