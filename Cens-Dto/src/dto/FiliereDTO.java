package dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Gawel on 15/03/2016.
 */
public class FiliereDTO implements Serializable {

    private static final long serialVersionUID = -6139772100469795998L;
    private Integer filiereId;
    private String filiereLibelle;
    private List<AssocFiliereBlocDTO> assocFiliereBlocs;
    private List<ClassroomDTO> classrooms;
    private VoieDTO voie;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getFiliereId() {
        return filiereId;
    }

    public void setFiliereId(Integer filiereId) {
        this.filiereId = filiereId;
    }

    public String getFiliereLibelle() {
        return filiereLibelle;
    }

    public void setFiliereLibelle(String filiereLibelle) {
        this.filiereLibelle = filiereLibelle;
    }

    public List<AssocFiliereBlocDTO> getAssocFiliereBlocs() {
        return assocFiliereBlocs;
    }

    public void setAssocFiliereBlocs(List<AssocFiliereBlocDTO> assocFiliereBlocs) {
        this.assocFiliereBlocs = assocFiliereBlocs;
    }

    public List<ClassroomDTO> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(List<ClassroomDTO> classrooms) {
        this.classrooms = classrooms;
    }

    public VoieDTO getVoie() {
        return voie;
    }

    public void setVoie(VoieDTO voie) {
        this.voie = voie;
    }
}
