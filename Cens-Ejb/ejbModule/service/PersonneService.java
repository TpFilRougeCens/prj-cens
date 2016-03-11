package service;

import model.Employe;
import model.Groupe;
import model.Personne;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Session Bean implementation class PersonneService
 */
@Stateless
@LocalBean
public class PersonneService {

    @PersistenceContext(unitName = "Cens-Jpa")
    EntityManager entityManager;

    /**
     * FIND ALL ELEMENTS METHODE WITH PARAMETER QUERY findAll
     *
     * @see Personne
     */
    @SuppressWarnings("unchecked")
    public List<Personne> findAll() {
        return entityManager.createNamedQuery("Personne.findAll").getResultList();
    }

    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param personneId : Id du personne recherché
     */
    public Personne findOne(Integer personneId) {
        try {
            return entityManager.find(Personne.class, personneId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * RETOURNE UNE PERSONNE SI CELLE CI EST CONNUE
     *
     * @param login    : login utilisateur qui demande une connexion
     * @param password : mot de passe tentative
     */
    public Personne findOne(String login, String password) {
        try {
            Personne personne = (Personne) entityManager
                    .createNamedQuery("Personne.findByNameAndPassWord")
                    .setParameter("loginn", login)
                    .setParameter("passwordd", password)
                    .getSingleResult();
            return personne;

        } catch (NoResultException e) {
            System.out.println("Personne : FindOne : Pas de resultat");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    /**
     * DELETE METHODE WITH NATIVE JPA METHODE
     *
     * @param personne : Object de type Personne (de la classe)
     */
    public boolean delete(Personne personne) {
        try {
            Personne result = entityManager.find(Personne.class, personne.getPersonneId());
            entityManager.remove(result);
            //System.out.println("ID Supprimé = " + personne.getPersonneId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param personne : Object de type Personne (de la classe)
     */
    public boolean insert(Personne personne) {
        try {
            entityManager.persist(personne);
            //System.out.println("ID inséré = " + personne.getPersonneId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param personne : Object de type Personne (de la classe)
     */
    public boolean update(Personne personne) {
        try {
            entityManager.merge(personne);
            //System.out.println("ID Update = " + personne.getPersonneId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Groupe fonctionUtilisateur(Personne personne) {

        try {
            Employe result = entityManager.find(Employe.class, personne.getPersonneId());
            // ??? ici en cours
//            result.getAssocEmployeGroupes()
            System.out.println(result.getEmployeLogin());
        } catch (NoResultException e) {
            System.out.println("Personne : fonctionUtilisatteur : Pas de resultat");
        } catch (NullPointerException e) {
            System.out.println("Personne : fonctionUtilisatteur : Null pointer");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
