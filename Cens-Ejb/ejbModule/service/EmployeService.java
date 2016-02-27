package service;

import model.Employe;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Session Bean implementation class EmployeService
 */
@Stateless
@LocalBean
public class EmployeService {

    @PersistenceContext(unitName = "Cens-Jpa")
    EntityManager entityManager;

    /**
     * FIND ALL ELEMENTS METHODE WITH PARAMETER QUERY findAll
     *
     * @see Employe
     */
    @SuppressWarnings("unchecked")
    public List<Employe> findAll() {
        return entityManager.createNamedQuery("Employe.findAll").getResultList();
    }

    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param employeId : Id du employe recherché
     */
    public Employe findOne(Integer employeId) {
        try {
            return entityManager.find(Employe.class, employeId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * DELETE METHODE WITH NATIVE JPA METHODE
     *
     * @param employe : Object de type Employe (de la classe)
     */
    public boolean delete(Employe employe) {
        try {
            Employe result = entityManager.find(Employe.class, employe.getEmployeId());
            entityManager.remove(result);
            //System.out.println("ID Supprimé = " + employe.getEmployeId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param employe : Object de type Employe (de la classe)
     */
    public boolean insert(Employe employe) {
        try {
            entityManager.persist(employe);
            //System.out.println("ID inséré = " + employe.getEmployeId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param employe : Object de type Employe (de la classe)
     */
    public boolean update(Employe employe) {
        try {
            entityManager.merge(employe);
            //System.out.println("ID Update = " + employe.getEmployeId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
