package service;

import model.Filiere;

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

}
