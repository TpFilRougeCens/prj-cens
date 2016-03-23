package service;

import model.Note;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Session Bean implementation class NoteService
 */
@Stateless
@LocalBean
public class NoteService {

    @PersistenceContext(unitName = "Cens-Jpa")
    EntityManager entityManager;

    /**
     * FIND ALL ELEMENTS METHODE WITH PARAMETER QUERY findAll
     *
     * @see Note
     */
    @SuppressWarnings("unchecked")
    public List<Note> findAll() {
        return entityManager.createNamedQuery("Note.findAll").getResultList();
    }

    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param noteId : Id du note recherché
     */
    public Note findOne(Integer noteId) {
        try {
            return entityManager.find(Note.class, noteId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * DELETE METHODE WITH NATIVE JPA METHODE
     * //TODO FAIRE LA METHODE ACTIVE DE NOTE POUR REMPLASSER LA SUPPRESION
     * METHODE INTERDITE UTILISER LA METHODE NOTEACTIVE
     *
     * @param note : Object de type Note (de la classe)
     */
    private boolean delete(Note note) {
        try {
            Note result = entityManager.find(Note.class, note.getNoteId());
            entityManager.remove(result);
            //System.out.println("ID Supprimé = " + note.getNoteId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param note : Object de type Note (de la classe)
     */
    public boolean insert(Note note) {
        try {
            entityManager.persist(note);
            //System.out.println("ID inséré = " + note.getNoteId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param note : Object de type Note (de la classe)
     */
    public boolean update(Note note) {
        try {
            entityManager.merge(note);
            //System.out.println("ID Update = " + note.getNoteId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
