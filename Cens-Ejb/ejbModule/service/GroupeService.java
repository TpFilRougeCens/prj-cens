package service;

import model.Groupe;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Session Bean implementation class GroupeService
 */
@Stateless
@LocalBean
public class GroupeService {

    @PersistenceContext(unitName = "Cens-Jpa")
    EntityManager entityManager;

    /**
     * FIND ALL ELEMENTS METHODE WITH PARAMETER QUERY findAll
     *
     * @see Groupe
     */
    @SuppressWarnings("unchecked")
    public List<Groupe> findAll() {
        return entityManager.createNamedQuery("Groupe.findAll").getResultList();
    }

    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param groupeId : Id du groupe recherché
     */
    public Groupe findOne(Integer groupeId) {
        try {
            return entityManager.find(Groupe.class, groupeId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * DELETE METHODE WITH NATIVE JPA METHODE
     *
     * @param groupe : Object de type Groupe (de la classe)
     */
    public boolean delete(Groupe groupe) {
        try {
            Groupe result = entityManager.find(Groupe.class, groupe.getGroupeId());
            entityManager.remove(result);
            //System.out.println("ID Supprimé = " + groupe.getGroupeId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param groupe : Object de type Groupe (de la classe)
     */
    public boolean insert(Groupe groupe) {
        try {
            entityManager.persist(groupe);
            //System.out.println("ID inséré = " + groupe.getGroupeId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param groupe : Object de type Groupe (de la classe)
     */
    public boolean update(Groupe groupe) {
        try {
            entityManager.merge(groupe);
            //System.out.println("ID Update = " + groupe.getGroupeId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
