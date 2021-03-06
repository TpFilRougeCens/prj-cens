package service;

import model.Niveau;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Session Bean implementation class NiveauService
 */
@Stateless
@LocalBean
public class NiveauService {

    @PersistenceContext(unitName = "Cens-Jpa")
    EntityManager entityManager;

    /**
     * FIND ALL ELEMENTS METHODE WITH PARAMETER QUERY findAll
     *
     * @see Niveau
     */
    @SuppressWarnings("unchecked")
    public List<Niveau> findAll() {
        return entityManager.createNamedQuery("Niveau.findAll").getResultList();
    }

    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param niveauId : Id du niveau recherché
     */
    public Niveau findOne(Integer niveauId) {
        try {
            return entityManager.find(Niveau.class, niveauId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * DELETE METHODE WITH NATIVE JPA METHODE
     *
     * @param niveau : Object de type Niveau (de la classe)
     */
    public boolean delete(Niveau niveau) {
        try {
            Niveau result = entityManager.find(Niveau.class, niveau.getNiveauId());
            entityManager.remove(result);
            //System.out.println("ID Supprimé = " + niveau.getNiveauId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param niveau : Object de type Niveau (de la classe)
     */
    public boolean insert(Niveau niveau) {
        try {
            entityManager.persist(niveau);
            //System.out.println("ID inséré = " + niveau.getNiveauId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param niveau : Object de type Niveau (de la classe)
     */
    public boolean update(Niveau niveau) {
        try {
            entityManager.merge(niveau);
            //System.out.println("ID Update = " + niveau.getNiveauId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
