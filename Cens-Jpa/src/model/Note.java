package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the note database table.
 */
@Entity
@NamedQuery(name = "Note.findAll", query = "SELECT n FROM Note n")
public class Note implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private Integer noteId;

    @Column(name = "note_abvr")
    private String noteAbvr;

    @Column(name = "note_couleur")
    private String noteCouleur;

    @Column(name = "note_libelle")
    private String noteLibelle;

    @Column(name = "note_valeur")
    private Integer noteValeur;

    //bi-directional many-to-one association to AssocEvaluer
    @OneToMany(mappedBy = "note1", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<AssocEvaluer> assocEvaluers1;

    //bi-directional many-to-one association to AssocEvaluer
    @OneToMany(mappedBy = "note2", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<AssocEvaluer> assocEvaluers2;

    public Note() {
    }

    public Integer getNoteId() {
        return this.noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getNoteAbvr() {
        return this.noteAbvr;
    }

    public void setNoteAbvr(String noteAbvr) {
        this.noteAbvr = noteAbvr;
    }

    public String getNoteCouleur() {
        return this.noteCouleur;
    }

    public void setNoteCouleur(String noteCouleur) {
        this.noteCouleur = noteCouleur;
    }

    public String getNoteLibelle() {
        return this.noteLibelle;
    }

    public void setNoteLibelle(String noteLibelle) {
        this.noteLibelle = noteLibelle;
    }

    public Integer getNoteValeur() {
        return this.noteValeur;
    }

    public void setNoteValeur(Integer noteValeur) {
        this.noteValeur = noteValeur;
    }

    public List<AssocEvaluer> getAssocEvaluers1() {
        return this.assocEvaluers1;
    }

    public void setAssocEvaluers1(List<AssocEvaluer> assocEvaluers1) {
        this.assocEvaluers1 = assocEvaluers1;
    }

    public AssocEvaluer addAssocEvaluers1(AssocEvaluer assocEvaluers1) {
        getAssocEvaluers1().add(assocEvaluers1);
        assocEvaluers1.setNote1(this);

        return assocEvaluers1;
    }

    public AssocEvaluer removeAssocEvaluers1(AssocEvaluer assocEvaluers1) {
        getAssocEvaluers1().remove(assocEvaluers1);
        assocEvaluers1.setNote1(null);

        return assocEvaluers1;
    }

    public List<AssocEvaluer> getAssocEvaluers2() {
        return this.assocEvaluers2;
    }

    public void setAssocEvaluers2(List<AssocEvaluer> assocEvaluers2) {
        this.assocEvaluers2 = assocEvaluers2;
    }

    public AssocEvaluer addAssocEvaluers2(AssocEvaluer assocEvaluers2) {
        getAssocEvaluers2().add(assocEvaluers2);
        assocEvaluers2.setNote2(this);

        return assocEvaluers2;
    }

    public AssocEvaluer removeAssocEvaluers2(AssocEvaluer assocEvaluers2) {
        getAssocEvaluers2().remove(assocEvaluers2);
        assocEvaluers2.setNote2(null);

        return assocEvaluers2;
    }

}