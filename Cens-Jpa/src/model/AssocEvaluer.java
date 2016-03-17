package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the assoc_evaluer database table.
 */
@Entity
@Table(name = "assoc_evaluer")
@NamedQuery(name = "AssocEvaluer.findAll", query = "SELECT a FROM AssocEvaluer a")
public class AssocEvaluer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assoc_evaluer_id")
    private Integer assocEvaluerId;

    @Temporal(TemporalType.DATE)
    @Column(name = "assoc_evaluer_date_evaluation")
    private Date assocEvaluerDateEvaluation;

    //bi-directional many-to-one association to ComCap
    @ManyToOne
    @JoinColumn(name = "assoc_evaluer_fk_com_cap_id")
    private ComCap comCap;

    //bi-directional many-to-one association to Eleve
    @ManyToOne
    @JoinColumn(name = "assoc_evaluer_fk_personne_ele_id")
    private Eleve eleve;

    //bi-directional many-to-one association to Employe
    @ManyToOne
    @JoinColumn(name = "assoc_evaluer_fk_personne_emp_id")
    private Employe employe;

    //bi-directional many-to-one association to Note
    // Auto-évaluation de l'élève
    @ManyToOne
    @JoinColumn(name = "assoc_evaluer_fk_note_emp_id")
    private Note note1;

    //bi-directional many-to-one association to Note
    // Evaluation de l'enseignant
    @ManyToOne
    @JoinColumn(name = "assoc_evaluer_fk_note_ele_id")
    private Note note2;

    public AssocEvaluer() {
    }

    public Integer getAssocEvaluerId() {
        return this.assocEvaluerId;
    }

    public void setAssocEvaluerId(Integer assocEvaluerId) {
        this.assocEvaluerId = assocEvaluerId;
    }

    public Date getAssocEvaluerDateEvaluation() {
        return this.assocEvaluerDateEvaluation;
    }

    public void setAssocEvaluerDateEvaluation(Date assocEvaluerDateEvaluation) {
        this.assocEvaluerDateEvaluation = assocEvaluerDateEvaluation;
    }

    public ComCap getComCap() {
        return this.comCap;
    }

    public void setComCap(ComCap comCap) {
        this.comCap = comCap;
    }

    public Eleve getEleve() {
        return this.eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public Employe getEmploye() {
        return this.employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    /**
     * Auto-évaluation de l'élève
     *
     * @return auto-evaluation
     */
    public Note getNote1() {
        return this.note1;
    }

    /**
     * Auto-évaluation de l'élève
     *
     * @param note1 : Auto-evaluation de l'élève
     */
    public void setNote1(Note note1) {
        this.note1 = note1;
    }

    /**
     * Evaluation de l'enseignant sur l'élève
     *
     * @return evaluation de l'enseignant
     */
    public Note getNote2() {
        return this.note2;
    }

    /**
     * Evaluation de l'enseignant sur l'élève
     *
     * @param note2 : evaluation de l'enseignant
     */
    public void setNote2(Note note2) {
        this.note2 = note2;
    }

}