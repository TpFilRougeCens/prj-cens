package service;

import model.Parametre;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Session Bean implementation class ParametreService
 */
@Stateless
@LocalBean
public class ParametreService {

    @PersistenceContext(unitName = "Cens-Jpa")
    EntityManager entityManager;

    /**
     * FIND ALL ELEMENTS METHODE WITH PARAMETER QUERY findAll
     *
     * @see Parametre
     */
    @SuppressWarnings("unchecked")
    public List<Parametre> findAll() {
        return entityManager.createNamedQuery("Parametre.findAll").getResultList();
    }

    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param parametreId : Id du parametre recherché
     */
    public Parametre findOne(Integer parametreId) {
        try {
            return entityManager.find(Parametre.class, parametreId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * DELETE METHODE WITH NATIVE JPA METHODE
     *
     * @param parametre : Object de type Parametre (de la classe)
     */
    public boolean delete(Parametre parametre) {
        try {
            Parametre result = entityManager.find(Parametre.class, parametre.getParametreId());
            entityManager.remove(result);
            //System.out.println("ID Supprimé = " + parametre.getParametreId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param parametre : Object de type Parametre (de la classe)
     */
    public boolean insert(Parametre parametre) {
        try {
            entityManager.persist(parametre);
            //System.out.println("ID inséré = " + parametre.getParametreId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param parametre : Object de type Parametre (de la classe)
     */
    public boolean update(Parametre parametre) {
        try {
            entityManager.merge(parametre);
            //System.out.println("ID Update = " + parametre.getParametreId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
