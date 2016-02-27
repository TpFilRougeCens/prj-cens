package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bloc database table.
 * 
 */
@Entity
@NamedQuery(name="Bloc.findAll", query="SELECT b FROM Bloc b")
public class Bloc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bloc_id")
	private Integer blocId;

	@Column(name="bloc_libelle")
	private String blocLibelle;

	//bi-directional many-to-one association to AssocFiliereBloc
	@OneToMany(mappedBy="bloc")
	private List<AssocFiliereBloc> assocFiliereBlocs;

	//bi-directional many-to-one association to Matiere
	@OneToMany(mappedBy="bloc")
	private List<Matiere> matieres;

	public Bloc() {
	}

	public Integer getBlocId() {
		return this.blocId;
	}

	public void setBlocId(Integer blocId) {
		this.blocId = blocId;
	}

	public String getBlocLibelle() {
		return this.blocLibelle;
	}

	public void setBlocLibelle(String blocLibelle) {
		this.blocLibelle = blocLibelle;
	}

	public List<AssocFiliereBloc> getAssocFiliereBlocs() {
		return this.assocFiliereBlocs;
	}

	public void setAssocFiliereBlocs(List<AssocFiliereBloc> assocFiliereBlocs) {
		this.assocFiliereBlocs = assocFiliereBlocs;
	}

	public AssocFiliereBloc addAssocFiliereBloc(AssocFiliereBloc assocFiliereBloc) {
		getAssocFiliereBlocs().add(assocFiliereBloc);
		assocFiliereBloc.setBloc(this);

		return assocFiliereBloc;
	}

	public AssocFiliereBloc removeAssocFiliereBloc(AssocFiliereBloc assocFiliereBloc) {
		getAssocFiliereBlocs().remove(assocFiliereBloc);
		assocFiliereBloc.setBloc(null);

		return assocFiliereBloc;
	}

	public List<Matiere> getMatieres() {
		return this.matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	public Matiere addMatiere(Matiere matiere) {
		getMatieres().add(matiere);
		matiere.setBloc(this);

		return matiere;
	}

	public Matiere removeMatiere(Matiere matiere) {
		getMatieres().remove(matiere);
		matiere.setBloc(null);

		return matiere;
	}

}