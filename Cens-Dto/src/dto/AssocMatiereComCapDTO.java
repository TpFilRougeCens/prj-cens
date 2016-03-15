package dto;

import java.io.Serializable;

/**
 * Created by Gawel on 15/03/2016.
 */
public class AssocMatiereComCapDTO implements Serializable {

    private static final long serialVersionUID = 3815096967328204258L;
    private Integer assocMatiereComCapId;
    private ComCapDTO comCap;
    private MatiereDTO matiere;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getAssocMatiereComCapId() {
        return assocMatiereComCapId;
    }

    public void setAssocMatiereComCapId(Integer assocMatiereComCapId) {
        this.assocMatiereComCapId = assocMatiereComCapId;
    }

    public ComCapDTO getComCap() {
        return comCap;
    }

    public void setComCap(ComCapDTO comCap) {
        this.comCap = comCap;
    }

    public MatiereDTO getMatiere() {
        return matiere;
    }

    public void setMatiere(MatiereDTO matiere) {
        this.matiere = matiere;
    }
}
