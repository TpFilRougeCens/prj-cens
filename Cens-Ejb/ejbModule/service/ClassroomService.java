package service;

import model.Classroom;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Session Bean implementation class ClassroomService
 */
@Stateless
@LocalBean
public class ClassroomService {

    @PersistenceContext(unitName = "Cens-Jpa")
    EntityManager entityManager;

    /**
     * FIND ALL ELEMENTS METHODE WITH PARAMETER QUERY findAll
     *
     * @see Classroom
     */
    @SuppressWarnings("unchecked")
    public List<Classroom> findAll() {
        return entityManager.createNamedQuery("Classroom.findAll").getResultList();
    }

    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param classroomId : Id du classroom recherché
     */
    public Classroom findOne(Integer classroomId) {
        try {
            return entityManager.find(Classroom.class, classroomId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * DELETE METHODE WITH NATIVE JPA METHODE
     *
     * @param classroom : Object de type Classroom (de la classe)
     */
    public boolean delete(Classroom classroom) {
        try {
            Classroom result = entityManager.find(Classroom.class, classroom.getClassroomId());
            entityManager.remove(result);
            //System.out.println("ID Supprimé = " + classroom.getClassroomId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param classroom : Object de type Classroom (de la classe)
     */
    public boolean insert(Classroom classroom) {
        try {
            entityManager.persist(classroom);
            //System.out.println("ID inséré = " + classroom.getClassroomId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param classroom : Object de type Classroom (de la classe)
     */
    public boolean update(Classroom classroom) {
        try {
            entityManager.merge(classroom);
            //System.out.println("ID Update = " + classroom.getClassroomId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
