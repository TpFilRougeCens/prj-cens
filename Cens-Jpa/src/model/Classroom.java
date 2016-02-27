package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the classroom database table.
 * 
 */
@Entity
@NamedQuery(name="Classroom.findAll", query="SELECT c FROM Classroom c")
public class Classroom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="classroom_id")
	private Integer classroomId;

	@Column(name="classroom_libelle")
	private String classroomLibelle;

	//bi-directional many-to-one association to AssocEnseigner
	@OneToMany(mappedBy="classroom")
	private List<AssocEnseigner> assocEnseigners;

	//bi-directional many-to-one association to AssocEtudier
	@OneToMany(mappedBy="classroom")
	private List<AssocEtudier> assocEtudiers;

	//bi-directional many-to-one association to Employe
	@ManyToOne
	@JoinColumn(name="classroom_fk_personne_manager_id")
	private Employe employe;

	//bi-directional many-to-one association to Filiere
	@ManyToOne
	@JoinColumn(name="classroom_fk_filiere_id")
	private Filiere filiere;

	//bi-directional many-to-one association to Niveau
	@ManyToOne
	@JoinColumn(name="classroom_fk_niveau_id")
	private Niveau niveau;

	public Classroom() {
	}

	public Integer getClassroomId() {
		return this.classroomId;
	}

	public void setClassroomId(Integer classroomId) {
		this.classroomId = classroomId;
	}

	public String getClassroomLibelle() {
		return this.classroomLibelle;
	}

	public void setClassroomLibelle(String classroomLibelle) {
		this.classroomLibelle = classroomLibelle;
	}

	public List<AssocEnseigner> getAssocEnseigners() {
		return this.assocEnseigners;
	}

	public void setAssocEnseigners(List<AssocEnseigner> assocEnseigners) {
		this.assocEnseigners = assocEnseigners;
	}

	public AssocEnseigner addAssocEnseigner(AssocEnseigner assocEnseigner) {
		getAssocEnseigners().add(assocEnseigner);
		assocEnseigner.setClassroom(this);

		return assocEnseigner;
	}

	public AssocEnseigner removeAssocEnseigner(AssocEnseigner assocEnseigner) {
		getAssocEnseigners().remove(assocEnseigner);
		assocEnseigner.setClassroom(null);

		return assocEnseigner;
	}

	public List<AssocEtudier> getAssocEtudiers() {
		return this.assocEtudiers;
	}

	public void setAssocEtudiers(List<AssocEtudier> assocEtudiers) {
		this.assocEtudiers = assocEtudiers;
	}

	public AssocEtudier addAssocEtudier(AssocEtudier assocEtudier) {
		getAssocEtudiers().add(assocEtudier);
		assocEtudier.setClassroom(this);

		return assocEtudier;
	}

	public AssocEtudier removeAssocEtudier(AssocEtudier assocEtudier) {
		getAssocEtudiers().remove(assocEtudier);
		assocEtudier.setClassroom(null);

		return assocEtudier;
	}

	public Employe getEmploye() {
		return this.employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Filiere getFiliere() {
		return this.filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public Niveau getNiveau() {
		return this.niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

}