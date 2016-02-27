package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the assoc_employe_groupe database table.
 * 
 */
@Embeddable
public class AssocEmployeGroupePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="assoc_employe_groupe_fk_personne_id", insertable=false, updatable=false)
	private Integer assocEmployeGroupeFkPersonneId;

	@Column(name="assoc_employe_groupe_fk_groupe_id", insertable=false, updatable=false)
	private Integer assocEmployeGroupeFkGroupeId;

	public AssocEmployeGroupePK() {
	}
	public Integer getAssocEmployeGroupeFkPersonneId() {
		return this.assocEmployeGroupeFkPersonneId;
	}
	public void setAssocEmployeGroupeFkPersonneId(Integer assocEmployeGroupeFkPersonneId) {
		this.assocEmployeGroupeFkPersonneId = assocEmployeGroupeFkPersonneId;
	}
	public Integer getAssocEmployeGroupeFkGroupeId() {
		return this.assocEmployeGroupeFkGroupeId;
	}
	public void setAssocEmployeGroupeFkGroupeId(Integer assocEmployeGroupeFkGroupeId) {
		this.assocEmployeGroupeFkGroupeId = assocEmployeGroupeFkGroupeId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AssocEmployeGroupePK)) {
			return false;
		}
		AssocEmployeGroupePK castOther = (AssocEmployeGroupePK)other;
		return 
			this.assocEmployeGroupeFkPersonneId.equals(castOther.assocEmployeGroupeFkPersonneId)
			&& this.assocEmployeGroupeFkGroupeId.equals(castOther.assocEmployeGroupeFkGroupeId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.assocEmployeGroupeFkPersonneId.hashCode();
		hash = hash * prime + this.assocEmployeGroupeFkGroupeId.hashCode();
		
		return hash;
	}
}