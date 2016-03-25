package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * The primary key class for the assoc_com_cap database table.
 * 
 */
@Embeddable
public class AssocComCapPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="assoc_com_cap_fk_com_id", insertable=false, updatable=false)
	private Integer assocComCapFkComId;

	@Column(name="assoc_com_cap_fk_cap_id", insertable=false, updatable=false)
	private Integer assocComCapFkCapId;

	public AssocComCapPK() {
	}
	public Integer getAssocComCapFkComId() {
		return this.assocComCapFkComId;
	}
	public void setAssocComCapFkComId(Integer assocComCapFkComId) {
		this.assocComCapFkComId = assocComCapFkComId;
	}
	public Integer getAssocComCapFkCapId() {
		return this.assocComCapFkCapId;
	}
	public void setAssocComCapFkCapId(Integer assocComCapFkCapId) {
		this.assocComCapFkCapId = assocComCapFkCapId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AssocComCapPK)) {
			return false;
		}
		AssocComCapPK castOther = (AssocComCapPK)other;
		return 
			this.assocComCapFkComId.equals(castOther.assocComCapFkComId)
			&& this.assocComCapFkCapId.equals(castOther.assocComCapFkCapId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.assocComCapFkComId.hashCode();
		hash = hash * prime + this.assocComCapFkCapId.hashCode();
		
		return hash;
	}
}