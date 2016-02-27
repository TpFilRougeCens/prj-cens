package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the assoc_etudier database table.
 * 
 */
@Embeddable
public class AssocEtudierPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="assoc_etudier_fk_personne_id", insertable=false, updatable=false)
	private Integer assocEtudierFkPersonneId;

	@Column(name="assoc_etudier_fk_classroom_id", insertable=false, updatable=false)
	private Integer assocEtudierFkClassroomId;

	@Column(name="assoc_etudier_fk_promo_etudiant_id", insertable=false, updatable=false)
	private Integer assocEtudierFkPromoEtudiantId;

	public AssocEtudierPK() {
	}
	public Integer getAssocEtudierFkPersonneId() {
		return this.assocEtudierFkPersonneId;
	}
	public void setAssocEtudierFkPersonneId(Integer assocEtudierFkPersonneId) {
		this.assocEtudierFkPersonneId = assocEtudierFkPersonneId;
	}
	public Integer getAssocEtudierFkClassroomId() {
		return this.assocEtudierFkClassroomId;
	}
	public void setAssocEtudierFkClassroomId(Integer assocEtudierFkClassroomId) {
		this.assocEtudierFkClassroomId = assocEtudierFkClassroomId;
	}
	public Integer getAssocEtudierFkPromoEtudiantId() {
		return this.assocEtudierFkPromoEtudiantId;
	}
	public void setAssocEtudierFkPromoEtudiantId(Integer assocEtudierFkPromoEtudiantId) {
		this.assocEtudierFkPromoEtudiantId = assocEtudierFkPromoEtudiantId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AssocEtudierPK)) {
			return false;
		}
		AssocEtudierPK castOther = (AssocEtudierPK)other;
		return 
			this.assocEtudierFkPersonneId.equals(castOther.assocEtudierFkPersonneId)
			&& this.assocEtudierFkClassroomId.equals(castOther.assocEtudierFkClassroomId)
			&& this.assocEtudierFkPromoEtudiantId.equals(castOther.assocEtudierFkPromoEtudiantId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.assocEtudierFkPersonneId.hashCode();
		hash = hash * prime + this.assocEtudierFkClassroomId.hashCode();
		hash = hash * prime + this.assocEtudierFkPromoEtudiantId.hashCode();
		
		return hash;
	}
}