package dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Gawel on 15/03/2016.
 */
public class VoieDTO implements Serializable {

    private static final long serialVersionUID = -7486735451559398304L;
    private Integer voieId;
    private String voieLibelle;
    private List<FiliereDTO> filieres;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getVoieId() {
        return voieId;
    }

    public void setVoieId(Integer voieId) {
        this.voieId = voieId;
    }

    public String getVoieLibelle() {
        return voieLibelle;
    }

    public void setVoieLibelle(String voieLibelle) {
        this.voieLibelle = voieLibelle;
    }

    public List<FiliereDTO> getFilieres() {
        return filieres;
    }

    public void setFilieres(List<FiliereDTO> filieres) {
        this.filieres = filieres;
    }
}
