package dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Gawel on 15/03/2016.
 */
public class NiveauDTO implements Serializable {

    private static final long serialVersionUID = 5119931601293333167L;
    private Integer niveauId;
    private String niveauLibelle;
    private List<ClassroomDTO> classrooms;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getNiveauId() {
        return niveauId;
    }

    public void setNiveauId(Integer niveauId) {
        this.niveauId = niveauId;
    }

    public String getNiveauLibelle() {
        return niveauLibelle;
    }

    public void setNiveauLibelle(String niveauLibelle) {
        this.niveauLibelle = niveauLibelle;
    }

    public List<ClassroomDTO> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(List<ClassroomDTO> classrooms) {
        this.classrooms = classrooms;
    }
}
