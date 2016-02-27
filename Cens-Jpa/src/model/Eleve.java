package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the eleve database table.
 * 
 */
@Entity
@NamedQuery(name="Eleve.findAll", query="SELECT e FROM Eleve e")
public class Eleve implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="personne_id")
	private Integer personneId;

	@Column(name="eleve_email_parent")
	private String eleveEmailParent;

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

	//bi-directional many-to-one association to AssocEtudier
	@OneToMany(mappedBy="eleve")
	private List<AssocEtudier> assocEtudiers;

	//bi-directional many-to-one association to AssocEvaluer
	@OneToMany(mappedBy="eleve")
	private List<AssocEvaluer> assocEvaluers;

	//bi-directional many-to-one association to Bilan
	@OneToMany(mappedBy="eleve")
	private List<Bilan> bilans;

	public Eleve() {
	}

	public Integer getPersonneId() {
		return this.personneId;
	}

	public void setPersonneId(Integer personneId) {
		this.personneId = personneId;
	}

	public String getEleveEmailParent() {
		return this.eleveEmailParent;
	}

	public void setEleveEmailParent(String eleveEmailParent) {
		this.eleveEmailParent = eleveEmailParent;
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

	public List<AssocEtudier> getAssocEtudiers() {
		return this.assocEtudiers;
	}

	public void setAssocEtudiers(List<AssocEtudier> assocEtudiers) {
		this.assocEtudiers = assocEtudiers;
	}

	public AssocEtudier addAssocEtudier(AssocEtudier assocEtudier) {
		getAssocEtudiers().add(assocEtudier);
		assocEtudier.setEleve(this);

		return assocEtudier;
	}

	public AssocEtudier removeAssocEtudier(AssocEtudier assocEtudier) {
		getAssocEtudiers().remove(assocEtudier);
		assocEtudier.setEleve(null);

		return assocEtudier;
	}

	public List<AssocEvaluer> getAssocEvaluers() {
		return this.assocEvaluers;
	}

	public void setAssocEvaluers(List<AssocEvaluer> assocEvaluers) {
		this.assocEvaluers = assocEvaluers;
	}

	public AssocEvaluer addAssocEvaluer(AssocEvaluer assocEvaluer) {
		getAssocEvaluers().add(assocEvaluer);
		assocEvaluer.setEleve(this);

		return assocEvaluer;
	}

	public AssocEvaluer removeAssocEvaluer(AssocEvaluer assocEvaluer) {
		getAssocEvaluers().remove(assocEvaluer);
		assocEvaluer.setEleve(null);

		return assocEvaluer;
	}

	public List<Bilan> getBilans() {
		return this.bilans;
	}

	public void setBilans(List<Bilan> bilans) {
		this.bilans = bilans;
	}

	public Bilan addBilan(Bilan bilan) {
		getBilans().add(bilan);
		bilan.setEleve(this);

		return bilan;
	}

	public Bilan removeBilan(Bilan bilan) {
		getBilans().remove(bilan);
		bilan.setEleve(null);

		return bilan;
	}

}