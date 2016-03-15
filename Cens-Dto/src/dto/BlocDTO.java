package dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Gawel on 15/03/2016.
 */
public class BlocDTO implements Serializable {

    private static final long serialVersionUID = 3708544520107844375L;

    private Integer blocId;
    private String blocLibelle;
    private List<AssocFiliereBlocDTO> assocFiliereBlocs;
    private List<MatiereDTO> matieres;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getBlocId() {
        return blocId;
    }

    public void setBlocId(Integer blocId) {
        this.blocId = blocId;
    }

    public String getBlocLibelle() {
        return blocLibelle;
    }

    public void setBlocLibelle(String blocLibelle) {
        this.blocLibelle = blocLibelle;
    }

    public List<AssocFiliereBlocDTO> getAssocFiliereBlocs() {
        return assocFiliereBlocs;
    }

    public void setAssocFiliereBlocs(List<AssocFiliereBlocDTO> assocFiliereBlocs) {
        this.assocFiliereBlocs = assocFiliereBlocs;
    }

    public List<MatiereDTO> getMatieres() {
        return matieres;
    }

    public void setMatieres(List<MatiereDTO> matieres) {
        this.matieres = matieres;
    }
}
