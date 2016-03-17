package dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Gawel on 15/03/2016.
 */
public class ComCapDTO implements Serializable {

    private static final long serialVersionUID = -6790798471405782950L;
    private Integer comCapId;
    private String comCapLibelle;
    private List<AssocComCapDTO> assocComCaps1; //liste les parents : compétences
    private List<AssocComCapDTO> assocComCaps2; //liste les enfants : capacités
    private List<AssocEvaluerDTO> assocEvaluers;
    private List<AssocMatiereComCapDTO> assocMatiereComCaps;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getComCapId() {
        return comCapId;
    }

    public void setComCapId(Integer comCapId) {
        this.comCapId = comCapId;
    }

    public String getComCapLibelle() {
        return comCapLibelle;
    }

    public void setComCapLibelle(String comCapLibelle) {
        this.comCapLibelle = comCapLibelle;
    }

    /**
     * Liste les parents : compétences
     * <p>
     * SI je suis une compétences == null SINON je suis une capacité != null
     *
     * @return
     */
    public List<AssocComCapDTO> getAssocComCaps1() {
        return assocComCaps1;
    }

    /**
     * Ajouter un parent (Compétence)
     * <p>
     * Si ajout d'un parent : je deviens une capacité
     *
     * @param assocComCaps1 : Compétence (parent)
     */
    public void setAssocComCaps1(List<AssocComCapDTO> assocComCaps1) {
        this.assocComCaps1 = assocComCaps1;
    }

    /**
     * Liste les enfants : capacités
     * <p>
     * SI je suis une capacités == null SINON je suis une compétence != null
     *
     * @return
     */
    public List<AssocComCapDTO> getAssocComCaps2() {
        return assocComCaps2;
    }

    /**
     * Ajouter un enfant (Capacité)
     * <p>
     * Si ajout d'un enfant : je deviens une compétence
     *
     * @param assocComCaps2 : Capacité (enfant)
     */
    public void setAssocComCaps2(List<AssocComCapDTO> assocComCaps2) {
        this.assocComCaps2 = assocComCaps2;
    }

    public List<AssocEvaluerDTO> getAssocEvaluers() {
        return assocEvaluers;
    }

    public void setAssocEvaluers(List<AssocEvaluerDTO> assocEvaluers) {
        this.assocEvaluers = assocEvaluers;
    }

    public List<AssocMatiereComCapDTO> getAssocMatiereComCaps() {
        return assocMatiereComCaps;
    }

    public void setAssocMatiereComCaps(List<AssocMatiereComCapDTO> assocMatiereComCaps) {
        this.assocMatiereComCaps = assocMatiereComCaps;
    }
}
