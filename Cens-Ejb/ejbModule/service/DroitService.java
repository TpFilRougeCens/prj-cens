package service;

import model.Droit;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Session Bean implementation class DroitService
 */
@Stateless
@LocalBean
public class DroitService {

    @PersistenceContext(unitName = "Cens-Jpa")
    EntityManager entityManager;

    /**
     * FIND ALL ELEMENTS METHODE WITH PARAMETER QUERY findAll
     *
     * @see Droit
     */
    @SuppressWarnings("unchecked")
    public List<Droit> findAll() {
        return entityManager.createNamedQuery("Droit.findAll").getResultList();
    }

    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param droitId : Id du droit recherché
     */
    public Droit findOne(Integer droitId) {
        try {
            return entityManager.find(Droit.class, droitId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * DELETE METHODE WITH NATIVE JPA METHODE
     *
     * @param droit : Object de type Droit (de la classe)
     */
    public boolean delete(Droit droit) {
        try {
            Droit result = entityManager.find(Droit.class, droit.getDroitId());
            entityManager.remove(result);
            //System.out.println("ID Supprimé = " + droit.getDroitId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param droit : Object de type Droit (de la classe)
     */
    public boolean insert(Droit droit) {
        try {
            entityManager.persist(droit);
            //System.out.println("ID inséré = " + droit.getDroitId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param droit : Object de type Droit (de la classe)
     */
    public boolean update(Droit droit) {
        try {
            entityManager.merge(droit);
            //System.out.println("ID Update = " + droit.getDroitId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
