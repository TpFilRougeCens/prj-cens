package dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Gawel on 15/03/2016.
 */
public class ClassroomDTO implements Serializable {

    private static final long serialVersionUID = -8800705364639511888L;
    private Integer classroomId;
    private String classroomLibelle;
    private List<AssocEnseignerDTO> assocEnseigners;
    private List<AssocEtudierDTO> assocEtudiers;
    private EmployeDTO employe;
    private FiliereDTO filiere;
    private NiveauDTO niveau;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassroomLibelle() {
        return classroomLibelle;
    }

    public void setClassroomLibelle(String classroomLibelle) {
        this.classroomLibelle = classroomLibelle;
    }

    public List<AssocEnseignerDTO> getAssocEnseigners() {
        return assocEnseigners;
    }

    public void setAssocEnseigners(List<AssocEnseignerDTO> assocEnseigners) {
        this.assocEnseigners = assocEnseigners;
    }

    public List<AssocEtudierDTO> getAssocEtudiers() {
        return assocEtudiers;
    }

    public void setAssocEtudiers(List<AssocEtudierDTO> assocEtudiers) {
        this.assocEtudiers = assocEtudiers;
    }

    public EmployeDTO getEmploye() {
        return employe;
    }

    public void setEmploye(EmployeDTO employe) {
        this.employe = employe;
    }

    public FiliereDTO getFiliere() {
        return filiere;
    }

    public void setFiliere(FiliereDTO filiere) {
        this.filiere = filiere;
    }

    public NiveauDTO getNiveau() {
        return niveau;
    }

    public void setNiveau(NiveauDTO niveau) {
        this.niveau = niveau;
    }
}
