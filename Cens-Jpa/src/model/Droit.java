package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the droit database table.
 * 
 */
@Entity
@NamedQuery(name="Droit.findAll", query="SELECT d FROM Droit d")
public class Droit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="droit_id")
	private Integer droitId;

	@Column(name="droit_droit")
	private String droitDroit;

	@Column(name="droit_unite")
	private String droitUnite;

	//bi-directional many-to-one association to Groupe
	@ManyToOne
	@JoinColumn(name="droit_fk_groupe_id")
	private Groupe groupe;

	public Droit() {
	}

	public Integer getDroitId() {
		return this.droitId;
	}

	public void setDroitId(Integer droitId) {
		this.droitId = droitId;
	}

	public String getDroitDroit() {
		return this.droitDroit;
	}

	public void setDroitDroit(String droitDroit) {
		this.droitDroit = droitDroit;
	}

	public String getDroitUnite() {
		return this.droitUnite;
	}

	public void setDroitUnite(String droitUnite) {
		this.droitUnite = droitUnite;
	}

	public Groupe getGroupe() {
		return this.groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

}