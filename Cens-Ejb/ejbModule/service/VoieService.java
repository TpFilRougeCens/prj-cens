package service;

import model.Voie;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Session Bean implementation class VoieService
 */
@Stateless
@LocalBean
public class VoieService {

    @PersistenceContext(unitName = "Cens-Jpa")
    EntityManager entityManager;

    /**
     * FIND ALL ELEMENTS METHODE WITH PARAMETER QUERY findAll
     *
     * @see Voie
     */
    @SuppressWarnings("unchecked")
    public List<Voie> findAll() {
        return entityManager.createNamedQuery("Voie.findAll").getResultList();
    }

    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param voieId : Id du voie recherché
     */
    public Voie findOne(Integer voieId) {
        try {
            return entityManager.find(Voie.class, voieId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * DELETE METHODE WITH NATIVE JPA METHODE
     *
     * @param voie : Object de type Voie (de la classe)
     */
    public boolean delete(Voie voie) {
        try {
            Voie result = entityManager.find(Voie.class, voie.getVoieId());
            entityManager.remove(result);
            //System.out.println("ID Supprimé = " + voie.getVoieId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param voie : Object de type Voie (de la classe)
     */
    public boolean insert(Voie voie) {
        try {
            entityManager.persist(voie);
            //System.out.println("ID inséré = " + voie.getVoieId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param voie : Object de type Voie (de la classe)
     */
    public boolean update(Voie voie) {
        try {
            entityManager.merge(voie);
            //System.out.println("ID Update = " + voie.getVoieId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
