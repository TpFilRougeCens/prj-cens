package service;

import model.Promo;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Session Bean implementation class PromoService
 */
@Stateless
@LocalBean
public class PromoService {

    @PersistenceContext(unitName = "Cens-Jpa")
    EntityManager entityManager;

    /**
     * FIND ALL ELEMENTS METHODE WITH PARAMETER QUERY findAll
     *
     * @see Promo
     */
    @SuppressWarnings("unchecked")
    public List<Promo> findAll() {
        return entityManager.createNamedQuery("Promo.findAll").getResultList();
    }

    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param promoId : Id du promo recherché
     */
    public Promo findOne(Integer promoId) {
        try {
            return entityManager.find(Promo.class, promoId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * DELETE METHODE WITH NATIVE JPA METHODE
     *
     * @param promo : Object de type Promo (de la classe)
     */
    public boolean delete(Promo promo) {
        try {
            Promo result = entityManager.find(Promo.class, promo.getPromoId());
            entityManager.remove(result);
            //System.out.println("ID Supprimé = " + promo.getPromoId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param promo : Object de type Promo (de la classe)
     */
    public boolean insert(Promo promo) {
        try {
            entityManager.persist(promo);
            //System.out.println("ID inséré = " + promo.getPromoId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param promo : Object de type Promo (de la classe)
     */
    public boolean update(Promo promo) {
        try {
            entityManager.merge(promo);
            //System.out.println("ID Update = " + promo.getPromoId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
