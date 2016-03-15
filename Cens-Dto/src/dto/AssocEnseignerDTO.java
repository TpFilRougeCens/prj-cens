package dto;

import java.io.Serializable;

/**
 * Created by Gawel on 15/03/2016.
 */
public class AssocEnseignerDTO implements Serializable {

    private static final long serialVersionUID = -4035224786669853941L;
    private Integer assocEnseignerId;
    private ClassroomDTO classroom;
    private EmployeDTO employe;
    private MatiereDTO matiere;
    private PromoDTO promo;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getAssocEnseignerId() {
        return assocEnseignerId;
    }

    public void setAssocEnseignerId(Integer assocEnseignerId) {
        this.assocEnseignerId = assocEnseignerId;
    }

    public ClassroomDTO getClassroom() {
        return classroom;
    }

    public void setClassroom(ClassroomDTO classroom) {
        this.classroom = classroom;
    }

    public EmployeDTO getEmploye() {
        return employe;
    }

    public void setEmploye(EmployeDTO employe) {
        this.employe = employe;
    }

    public MatiereDTO getMatiere() {
        return matiere;
    }

    public void setMatiere(MatiereDTO matiere) {
        this.matiere = matiere;
    }

    public PromoDTO getPromo() {
        return promo;
    }

    public void setPromo(PromoDTO promo) {
        this.promo = promo;
    }
}
