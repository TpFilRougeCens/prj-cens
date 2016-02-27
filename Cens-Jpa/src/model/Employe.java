package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the employe database table.
 * 
 */
@Entity
@NamedQuery(name="Employe.findAll", query="SELECT e FROM Employe e")
public class Employe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="personne_id")
	private Integer personneId;

	@Column(name="personne_adresse")
	private String personneAdresse;

	@Column(name="personne_cp")
	private String personneCp;

	@Temporal(TemporalType.DATE)
	@Column(name="personne_date_naissance")
	private Date personneDateNaissance;

	@Column(name="personne_nom")
	private String personneNom;

	@Column(name="personne_prenom")
	private String personnePrenom;

	@Column(name="personne_ville")
	private String personneVille;

	//bi-directional many-to-one association to AssocEmployeGroupe
	@OneToMany(mappedBy="employe")
	private List<AssocEmployeGroupe> assocEmployeGroupes;

	//bi-directional many-to-one association to AssocEnseigner
	@OneToMany(mappedBy="employe")
	private List<AssocEnseigner> assocEnseigners;

	//bi-directional many-to-one association to AssocEvaluer
	@OneToMany(mappedBy="employe")
	private List<AssocEvaluer> assocEvaluers;

	//bi-directional many-to-one association to Classroom
	@OneToMany(mappedBy="employe")
	private List<Classroom> classrooms;

	public Employe() {
	}

	public Integer getPersonneId() {
		return this.personneId;
	}

	public void setPersonneId(Integer personneId) {
		this.personneId = personneId;
	}

	public String getPersonneAdresse() {
		return this.personneAdresse;
	}

	public void setPersonneAdresse(String personneAdresse) {
		this.personneAdresse = personneAdresse;
	}

	public String getPersonneCp() {
		return this.personneCp;
	}

	public void setPersonneCp(String personneCp) {
		this.personneCp = personneCp;
	}

	public Date getPersonneDateNaissance() {
		return this.personneDateNaissance;
	}

	public void setPersonneDateNaissance(Date personneDateNaissance) {
		this.personneDateNaissance = personneDateNaissance;
	}

	public String getPersonneNom() {
		return this.personneNom;
	}

	public void setPersonneNom(String personneNom) {
		this.personneNom = personneNom;
	}

	public String getPersonnePrenom() {
		return this.personnePrenom;
	}

	public void setPersonnePrenom(String personnePrenom) {
		this.personnePrenom = personnePrenom;
	}

	public String getPersonneVille() {
		return this.personneVille;
	}

	public void setPersonneVille(String personneVille) {
		this.personneVille = personneVille;
	}

	public List<AssocEmployeGroupe> getAssocEmployeGroupes() {
		return this.assocEmployeGroupes;
	}

	public void setAssocEmployeGroupes(List<AssocEmployeGroupe> assocEmployeGroupes) {
		this.assocEmployeGroupes = assocEmployeGroupes;
	}

	public AssocEmployeGroupe addAssocEmployeGroupe(AssocEmployeGroupe assocEmployeGroupe) {
		getAssocEmployeGroupes().add(assocEmployeGroupe);
		assocEmployeGroupe.setEmploye(this);

		return assocEmployeGroupe;
	}

	public AssocEmployeGroupe removeAssocEmployeGroupe(AssocEmployeGroupe assocEmployeGroupe) {
		getAssocEmployeGroupes().remove(assocEmployeGroupe);
		assocEmployeGroupe.setEmploye(null);

		return assocEmployeGroupe;
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

}