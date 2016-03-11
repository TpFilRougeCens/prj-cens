package service;

import model.Statistique;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Session Bean implementation class StatistiqueService
 */
@Stateless
@LocalBean
public class StatistiqueService {

    @PersistenceContext(unitName = "Cens-Jpa")
    EntityManager entityManager;

    /**
     * FIND ALL ELEMENTS METHODE WITH PARAMETER QUERY findAll
     *
     * @see Statistique
     */
    @SuppressWarnings("unchecked")
    public List<Statistique> findAll() {
        return entityManager.createNamedQuery("Statistique.findAll").getResultList();
    }

    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param statistiqueId : Id du statistique recherché
     */
    public Statistique findOne(Integer statistiqueId) {
        try {
            return entityManager.find(Statistique.class, statistiqueId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * DELETE METHODE WITH NATIVE JPA METHODE
     *
     * @param statistique : Object de type Statistique (de la classe)
     */
    public boolean delete(Statistique statistique) {
        try {
            Statistique result = entityManager.find(Statistique.class, statistique.getstatistiqueId());
            entityManager.remove(result);
            //System.out.println("ID Supprimé = " + statistique.getStatistiqueId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param statistique : Object de type Statistique (de la classe)
     */
    public boolean insert(Statistique statistique) {
        try {
            entityManager.persist(statistique);
            //System.out.println("ID inséré = " + statistique.getStatistiqueId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param statistique : Object de type Statistique (de la classe)
     */
    public boolean update(Statistique statistique) {
        try {
            entityManager.merge(statistique);
            //System.out.println("ID Update = " + statistique.getStatistiqueId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
