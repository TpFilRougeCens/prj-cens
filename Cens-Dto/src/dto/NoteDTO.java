package dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Gawel on 15/03/2016.
 */
public class NoteDTO implements Serializable {

    private static final long serialVersionUID = 453722191890987191L;
    private Integer noteId;
    private String noteAbvr;
    private String noteCouleur;
    private String noteLibelle;
    private Integer noteValeur;
    private boolean noteActive;
    private List<AssocEvaluerDTO> assocEvaluers1;
    private List<AssocEvaluerDTO> assocEvaluers2;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getNoteAbvr() {
        return noteAbvr;
    }

    public void setNoteAbvr(String noteAbvr) {
        this.noteAbvr = noteAbvr;
    }

    public String getNoteCouleur() {
        return noteCouleur;
    }

    public void setNoteCouleur(String noteCouleur) {
        this.noteCouleur = noteCouleur;
    }

    public String getNoteLibelle() {
        return noteLibelle;
    }

    public void setNoteLibelle(String noteLibelle) {
        this.noteLibelle = noteLibelle;
    }

    public Integer getNoteValeur() {
        return noteValeur;
    }

    public void setNoteValeur(Integer noteValeur) {
        this.noteValeur = noteValeur;
    }

    public boolean getNoteActive() {
        return noteActive;
    }

    public void setNoteActive(boolean noteActive) {
        this.noteActive = noteActive;
    }

    public List<AssocEvaluerDTO> getAssocEvaluers1() {
        return assocEvaluers1;
    }

    public void setAssocEvaluers1(List<AssocEvaluerDTO> assocEvaluers1) {
        this.assocEvaluers1 = assocEvaluers1;
    }

    public List<AssocEvaluerDTO> getAssocEvaluers2() {
        return assocEvaluers2;
    }

    public void setAssocEvaluers2(List<AssocEvaluerDTO> assocEvaluers2) {
        this.assocEvaluers2 = assocEvaluers2;
    }
}
