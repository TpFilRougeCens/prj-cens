package dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Gawel on 15/03/2016.
 */
public class AssocEvaluerDTO implements Serializable {

    private static final long serialVersionUID = 2924994134097419383L;
    private Integer assocEvaluerId;
    private Date assocEvaluerDateEvaluation;
    private ComCapDTO comCap;
    private EleveDTO eleve;
    private EmployeDTO employe;
    private NoteDTO note1; //autoevaluation
    private NoteDTO note2; //evaluation

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getAssocEvaluerId() {
        return assocEvaluerId;
    }

    public void setAssocEvaluerId(Integer assocEvaluerId) {
        this.assocEvaluerId = assocEvaluerId;
    }

    public Date getAssocEvaluerDateEvaluation() {
        return assocEvaluerDateEvaluation;
    }

    public void setAssocEvaluerDateEvaluation(Date assocEvaluerDateEvaluation) {
        this.assocEvaluerDateEvaluation = assocEvaluerDateEvaluation;
    }

    public ComCapDTO getComCap() {
        return comCap;
    }

    public void setComCap(ComCapDTO comCap) {
        this.comCap = comCap;
    }

    public EleveDTO getEleve() {
        return eleve;
    }

    public void setEleve(EleveDTO eleve) {
        this.eleve = eleve;
    }

    public EmployeDTO getEmploye() {
        return employe;
    }

    public void setEmploye(EmployeDTO employe) {
        this.employe = employe;
    }

    /**
     * Auto-évaluation de l'élève
     *
     * @return Auto-évaluation de l'élève
     */
    public NoteDTO getNote1() {
        return note1;
    }

    /**
     * Auto-évaluation de l'élève
     *
     * @param note1 : Auto-évaluation
     */
    public void setNote1(NoteDTO note1) {
        this.note1 = note1;
    }

    /**
     * Evaluation de l'enseignant sur l'élève
     *
     * @return Evaluation de l'enseignant
     */
    public NoteDTO getNote2() {
        return note2;
    }

    /**
     * Evaluation de l'enseignant sur l'élève
     *
     * @param note2 Evaluation de l'enseignant
     */
    public void setNote2(NoteDTO note2) {
        this.note2 = note2;
    }
}
