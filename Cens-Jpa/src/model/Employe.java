package model;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import java.io.Serializable;


/**
 * The persistent class for the employe database table.
 */
@Entity
@NamedQuery(name = "Employe.findAll", query = "SELECT e FROM Employe e")
public class Employe extends Personne implements Serializable {
    private static final long serialVersionUID = 1L;
/*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personne_id")
    private Integer employeId;

    @Column(name = "personne_adresse")
    private String employeAdresse;

    @Column(name = "personne_cp")
    private String employeCp;

    @Temporal(TemporalType.DATE)
    @Column(name = "personne_date_naissance")
    private Date employeDateNaissance;

    @Column(name = "personne_login")
    private String employeLogin;

    @Column(name = "personne_nom")
    private String employeNom;

    @Column(name = "personne_prenom")
    private String employePrenom;

    @Column(name = "personne_ville")
    private String employeVille;

    //bi-directional many-to-one association to Groupe
    @ManyToOne
    @JoinColumn(name = "personne_fk_groupe_id")
    private Groupe groupe;

    //bi-directional many-to-one association to AssocEnseigner
    @OneToMany(mappedBy = "employe")
    private List<AssocEnseigner> assocEnseigners;

    //bi-directional many-to-one association to AssocEvaluer
    @OneToMany(mappedBy = "employe")
    private List<AssocEvaluer> assocEvaluers;

    //bi-directional many-to-one association to Classroom
    @OneToMany(mappedBy = "employe")
    private List<Classroom> classrooms;

    public Employe() {
    }

    public Integer getEmployeId() {
        return this.employeId;
    }

    public void setEmployeId(Integer employeId) {
        this.employeId = employeId;
    }

    public String getEmployeAdresse() {
        return this.employeAdresse;
    }

    public void setEmployeAdresse(String employeAdresse) {
        this.employeAdresse = employeAdresse;
    }

    public String getEmployeCp() {
        return this.employeCp;
    }

    public void setEmployeCp(String employeCp) {
        this.employeCp = employeCp;
    }

    public Date getEmployeDateNaissance() {
        return this.employeDateNaissance;
    }

    public void setEmployeDateNaissance(Date employeDateNaissance) {
        this.employeDateNaissance = employeDateNaissance;
    }

    public String getEmployeLogin() {
        return this.employeLogin;
    }

    public void setEmployeLogin(String employeLogin) {
        this.employeLogin = employeLogin;
    }

    public String getEmployeNom() {
        return this.employeNom;
    }

    public void setEmployeNom(String employeNom) {
        this.employeNom = employeNom;
    }

    public String getEmployePrenom() {
        return this.employePrenom;
    }

    public void setEmployePrenom(String employePrenom) {
        this.employePrenom = employePrenom;
    }

    public String getEmployeVille() {
        return this.employeVille;
    }

    public void setEmployeVille(String employeVille) {
        this.employeVille = employeVille;
    }

    public Groupe getGroupe() {
        return this.groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public List<AssocEnseigner> getAssocEnseigners() {
        return this.assocEnseigners;
    }

    public void setAssocEnseigners(List<AssocEnseigner> assocEnseigners) {
        this.assocEnseigners = assocEnseigners;
    }

    public AssocEnseigner addAssocEnseigner(AssocEnseigner assocEnseigner) {
        getAssocEnseigners().add(assocEnseigner);
        assocEnseigner.setEmploye(this);

        return assocEnseigner;
    }

    public AssocEnseigner removeAssocEnseigner(AssocEnseigner assocEnseigner) {
        getAssocEnseigners().remove(assocEnseigner);
        assocEnseigner.setEmploye(null);

        return assocEnseigner;
    }

    public List<AssocEvaluer> getAssocEvaluers() {
        return this.assocEvaluers;
    }

    public void setAssocEvaluers(List<AssocEvaluer> assocEvaluers) {
        this.assocEvaluers = assocEvaluers;
    }

    public AssocEvaluer addAssocEvaluer(AssocEvaluer assocEvaluer) {
        getAssocEvaluers().add(assocEvaluer);
        assocEvaluer.setEmploye(this);

        return assocEvaluer;
    }

    public AssocEvaluer removeAssocEvaluer(AssocEvaluer assocEvaluer) {
        getAssocEvaluers().remove(assocEvaluer);
        assocEvaluer.setEmploye(null);

        return assocEvaluer;
    }

    public List<Classroom> getClassrooms() {
        return this.classrooms;
    }

    public void setClassrooms(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    public Classroom addClassroom(Classroom classroom) {
        getClassrooms().add(classroom);
        classroom.setEmploye(this);

        return classroom;
    }

    public Classroom removeClassroom(Classroom classroom) {
        getClassrooms().remove(classroom);
        classroom.setEmploye(null);

        return classroom;
    }
*/

}