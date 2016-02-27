package service;

import model.Bilan;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Session Bean implementation class BilanService
 */
@Stateless
@LocalBean
public class BilanService {

    @PersistenceContext(unitName = "Cens-Jpa")
    EntityManager entityManager;

    /**
     * FIND ALL ELEMENTS METHODE WITH PARAMETER QUERY findAll
     *
     * @see Bilan
     */
    @SuppressWarnings("unchecked")
    public List<Bilan> findAll() {
        return entityManager.createNamedQuery("Bilan.findAll").getResultList();
    }

    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param bilanId : Id du bilan recherché
     */
    public Bilan findOne(Integer bilanId) {
        try {
            return entityManager.find(Bilan.class, bilanId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * DELETE METHODE WITH NATIVE JPA METHODE
     *
     * @param bilan : Object de type Bilan (de la classe)
     */
    public boolean delete(Bilan bilan) {
        try {
            Bilan result = entityManager.find(Bilan.class, bilan.getBilanId());
            entityManager.remove(result);
            //System.out.println("ID Supprimé = " + bilan.getBilanId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param bilan : Object de type Bilan (de la classe)
     */
    public boolean insert(Bilan bilan) {
        try {
            entityManager.persist(bilan);
            //System.out.println("ID inséré = " + bilan.getBilanId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param bilan : Object de type Bilan (de la classe)
     */
    public boolean update(Bilan bilan) {
        try {
            entityManager.merge(bilan);
            //System.out.println("ID Update = " + bilan.getBilanId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
