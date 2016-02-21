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

    // pour un type JTA pas de factory mais injection de dépendances
    @PersistenceContext(unitName = "Cens-Jpa")
    EntityManager entityManager;

    public List<Niveau> findAll() {
        @SuppressWarnings("unchecked")
        List<Niveau> retour = entityManager.createNamedQuery("Niveau.findAll").getResultList();
        return retour;
    }


    public void delete(Niveau userr) {
        Niveau retour = entityManager.find(Niveau.class, userr.getIdniveau());
        entityManager.remove(retour);
        System.out.println("ID Supprimé = " + userr.getIdniveau());
    }

    public void insert(Niveau userr) {
        entityManager.persist(userr);
        // if (userr.getLibelle() != null) {
        // //entityManager.persist(userr.getLibelle());
        // System.out.println("ajout de l'enfant depuis user id="+userr.getLibelle().getIdniveau());
        // }

        System.out.println("ID inséré = " + userr.getIdniveau());
    }

    public void update(Niveau userr) {

        entityManager.merge(userr);
        if (userr.getLibelle() != null) {
            entityManager.merge(userr.getLibelle());
            System.out.println("MAJ de enfant depuis User id=" + userr.getIdniveau());
        }

        // //Foonctionne :
        // Niveau retour = entityManager.find(Niveau.class, userr.getIdniveau());
        // retour.setNom(userr.getNom());
        // retour.setPrenom(userr.getPrenom());
        // retour.setMail(userr.getMail());
        // retour.setMdp(userr.getMdp());
        System.out.println("ID Update = " + userr.getIdniveau());
    }
}