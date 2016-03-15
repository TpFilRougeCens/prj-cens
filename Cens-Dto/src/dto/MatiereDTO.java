package dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Gawel on 15/03/2016.
 */
public class MatiereDTO implements Serializable {

    private static final long serialVersionUID = -969379489433690141L;
    private Integer matiereId;
    private String matiereLibelle;
    private List<AssocEnseignerDTO> assocEnseigners;
    private List<AssocMatiereComCapDTO> assocMatiereComCaps;
    private BlocDTO bloc;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getMatiereId() {
        return matiereId;
    }

    public void setMatiereId(Integer matiereId) {
        this.matiereId = matiereId;
    }

    public String getMatiereLibelle() {
        return matiereLibelle;
    }

    public void setMatiereLibelle(String matiereLibelle) {
        this.matiereLibelle = matiereLibelle;
    }

    public List<AssocEnseignerDTO> getAssocEnseigners() {
        return assocEnseigners;
    }

    public void setAssocEnseigners(List<AssocEnseignerDTO> assocEnseigners) {
        this.assocEnseigners = assocEnseigners;
    }

    public List<AssocMatiereComCapDTO> getAssocMatiereComCaps() {
        return assocMatiereComCaps;
    }

    public void setAssocMatiereComCaps(List<AssocMatiereComCapDTO> assocMatiereComCaps) {
        this.assocMatiereComCaps = assocMatiereComCaps;
    }

    public BlocDTO getBloc() {
        return bloc;
    }

    public void setBloc(BlocDTO bloc) {
        this.bloc = bloc;
    }
}
