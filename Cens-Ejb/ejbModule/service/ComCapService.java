package service;

import model.ComCap;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Session Bean implementation class ComCapService
 */
@Stateless
@LocalBean
public class ComCapService {

    @PersistenceContext(unitName = "Cens-Jpa")
    EntityManager entityManager;

    /**
     * FIND ALL ELEMENTS METHODE WITH PARAMETER QUERY findAll
     *
     * @see ComCap
     */
    @SuppressWarnings("unchecked")
    public List<ComCap> findAll() {
        return entityManager.createNamedQuery("ComCap.findAll").getResultList();
    }

    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param comcapId : Id du comcap recherché
     */
    public ComCap findOne(Integer comcapId) {
        try {
            return entityManager.find(ComCap.class, comcapId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * DELETE METHODE WITH NATIVE JPA METHODE
     *
     * @param comcap : Object de type ComCap (de la classe)
     */
    public boolean delete(ComCap comcap) {
        try {
            ComCap result = entityManager.find(ComCap.class, comcap.getComCapId());
            entityManager.remove(result);
            //System.out.println("ID Supprimé = " + comcap.getComCapId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param comcap : Object de type ComCap (de la classe)
     */
    public boolean insert(ComCap comcap) {
        try {
            entityManager.persist(comcap);
            //System.out.println("ID inséré = " + comcap.getComCapId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param comcap : Object de type ComCap (de la classe)
     */
    public boolean update(ComCap comcap) {
        try {
            entityManager.merge(comcap);
            //System.out.println("ID Update = " + comcap.getComCapId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
