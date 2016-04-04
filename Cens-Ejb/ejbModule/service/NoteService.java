package service;

import model.Note;
import org.json.JSONArray;
import org.json.JSONObject;

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
     *
     * @param note : Object de type Note
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
     * DESACTIVE METHODE WITH NATIVE JPA METHODE
     *
     * @param noteId : Integer Id de la note
     * @param active : boolean pour activer/désactiver
     * @return boolean
     */
    public boolean active_desactive(Integer noteId, boolean active) {
        try {
            Note result = entityManager.find(Note.class, noteId);
            result.setNoteActive(active);
            update(result);
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


    /**
     * FIND ALL ELEMENTS METHODE WITH PARAMETER QUERY findAll
     * <p>
     * Return la liste des toutes les notes possibles sans distinction
     *
     * @see Note
     */
    @SuppressWarnings("unchecked")
    public JSONObject JSON_findAll() {
        try {
            List<Note> listeNotes = findAll();
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();

            if (listeNotes != null) {
                for (Note p : listeNotes) {
                    jsonArray.put(convertToJson(p));
                }
                jsonObject.put("notes", jsonArray);
            } else {
                jsonObject.put("notes", "null");
            }

            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param noteId : Id du eleve recherché
     */
    public JSONObject JSON_findOne(Integer noteId) {
        Note note = findOne(noteId);
        JSONObject jsonObject = new JSONObject();

        if (note != null) {
            jsonObject.put("note", convertToJson(note));
        } else {
            jsonObject.put("note", "null");
        }
        return jsonObject;
    }

    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param note : JSON note
     */
    public boolean JSON_insert(JSONObject note) {
        try {
            if (note.has("id") && !note.isNull("id")) {
                note.remove("id");
            }
            return insert(convertToObject(note));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param note : Object de type JSON note
     */
    public boolean JSON_update(JSONObject note) {
        try {
            return update(convertToObject(note));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // MAPPER CONVERTION JSON / OBJ

    /**
     * PERMET DE CONVERTIR UN OBJECT JAVA EN OBJECT JSON
     *
     * @param p de type Note
     * @return JSONObject
     */
    private JSONObject convertToJson(Note p) {
        JSONObject detailsJson = new JSONObject();
        detailsJson.put("id", p.getNoteId());
        detailsJson.put("abvr", p.getNoteAbvr());
        detailsJson.put("libelle", p.getNoteLibelle());
        detailsJson.put("valeur", p.getNoteValeur());
        detailsJson.put("couleur", p.getNoteCouleur());
        detailsJson.put("active", p.getNoteActive());
        return detailsJson;
    }

    /**
     * CONVERTIR UN OBJ JSON EN OBJ JAVA
     *
     * @param note
     * @return un Note
     */
    private Note convertToObject(JSONObject note) {
        Note result = new Note();

        if (note.has("id") && !note.isNull("id")) {
            result.setNoteId(note.getInt("id"));
        }
        if (note.has("abvr") && !note.isNull("abvr")) {
            result.setNoteAbvr(note.getString("abvr"));
        }
        if (note.has("libelle") && !note.isNull("libelle")) {
            result.setNoteLibelle(note.getString("libelle"));
        }
        if (note.has("valeur") && !note.isNull("valeur")) {
            result.setNoteValeur(note.getInt("valeur"));
        }
        if (note.has("couleur") && !note.isNull("couleur")) {
            result.setNoteCouleur(note.getString("couleur"));
        }
        if (note.has("active") && !note.isNull("active")) {
            result.setNoteActive(note.getBoolean("active"));
        }

        return result;
    }

}
