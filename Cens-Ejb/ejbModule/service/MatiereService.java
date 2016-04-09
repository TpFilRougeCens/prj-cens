package service;

import model.Eleve;
import model.Matiere;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Session Bean implementation class MatiereService
 */
@Stateless
@LocalBean
public class MatiereService {

    @PersistenceContext(unitName = "Cens-Jpa")
    EntityManager entityManager;

    /**
     * FIND ALL ELEMENTS METHODE WITH PARAMETER QUERY findAll
     *
     * @see Matiere
     */
    @SuppressWarnings("unchecked")
    public List<Matiere> findAll() {
        return entityManager.createNamedQuery("Matiere.findAll").getResultList();
    }

    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param matiereId : Id du matiere recherché
     */
    public Matiere findOne(Integer matiereId) {
        try {
            return entityManager.find(Matiere.class, matiereId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * DELETE METHODE WITH NATIVE JPA METHODE
     *
     * @param matiere : Object de type Matiere (de la classe)
     */
    public boolean delete(Matiere matiere) {
        try {
            Matiere result = entityManager.find(Matiere.class, matiere.getMatiereId());
            entityManager.remove(result);
            //System.out.println("ID Supprimé = " + matiere.getMatiereId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param matiere : Object de type Matiere (de la classe)
     */
    public boolean insert(Matiere matiere) {
        try {
            entityManager.persist(matiere);
            //System.out.println("ID inséré = " + matiere.getMatiereId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param matiere : Object de type Matiere (de la classe)
     */
    public boolean update(Matiere matiere) {
        try {
            entityManager.merge(matiere);
            //System.out.println("ID Update = " + matiere.getMatiereId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
