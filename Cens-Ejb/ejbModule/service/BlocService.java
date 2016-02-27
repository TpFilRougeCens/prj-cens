package service;

import model.Bloc;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Session Bean implementation class BlocService
 */
@Stateless
@LocalBean
public class BlocService {

    @PersistenceContext(unitName = "Cens-Jpa")
    EntityManager entityManager;

    /**
     * FIND ALL ELEMENTS METHODE WITH PARAMETER QUERY findAll
     *
     * @see Bloc
     */
    @SuppressWarnings("unchecked")
    public List<Bloc> findAll() {
        return entityManager.createNamedQuery("Bloc.findAll").getResultList();
    }

    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param blocId : Id du bloc recherché
     */
    public Bloc findOne(Integer blocId) {
        try {
            return entityManager.find(Bloc.class, blocId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * DELETE METHODE WITH NATIVE JPA METHODE
     *
     * @param bloc : Object de type Bloc (de la classe)
     */
    public boolean delete(Bloc bloc) {
        try {
            Bloc result = entityManager.find(Bloc.class, bloc.getBlocId());
            entityManager.remove(result);
            //System.out.println("ID Supprimé = " + bloc.getBlocId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param bloc : Object de type Bloc (de la classe)
     */
    public boolean insert(Bloc bloc) {
        try {
            entityManager.persist(bloc);
            //System.out.println("ID inséré = " + bloc.getBlocId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param bloc : Object de type Bloc (de la classe)
     */
    public boolean update(Bloc bloc) {
        try {
            entityManager.merge(bloc);
            //System.out.println("ID Update = " + bloc.getBlocId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
