package service;

import model.Employe;
import model.Personne;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

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
    public List<Personne> findAll() {
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
     * @param login    : login utilisateur qui demande une connexion
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
            entityManager.persist(employe);
            //System.out.println("ID inséré = " + employe.getEmployeId());
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
            entityManager.merge(employe);
            //System.out.println("ID Update = " + employe.getEmployeId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
