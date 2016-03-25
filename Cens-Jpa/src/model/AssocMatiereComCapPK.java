package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * The primary key class for the assoc_matiere_com_cap database table.
 * 
 */
@Embeddable
public class AssocMatiereComCapPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="assoc_matiere_com_cap_fk_matiere_id", insertable=false, updatable=false)
	private Integer assocMatiereComCapFkMatiereId;

	@Column(name="assoc_matiere_com_cap_fk_competence_id", insertable=false, updatable=false)
	private Integer assocMatiereComCapFkCompetenceId;

	public AssocMatiereComCapPK() {
	}
	public Integer getAssocMatiereComCapFkMatiereId() {
		return this.assocMatiereComCapFkMatiereId;
	}
	public void setAssocMatiereComCapFkMatiereId(Integer assocMatiereComCapFkMatiereId) {
		this.assocMatiereComCapFkMatiereId = assocMatiereComCapFkMatiereId;
	}
	public Integer getAssocMatiereComCapFkCompetenceId() {
		return this.assocMatiereComCapFkCompetenceId;
	}
	public void setAssocMatiereComCapFkCompetenceId(Integer assocMatiereComCapFkCompetenceId) {
		this.assocMatiereComCapFkCompetenceId = assocMatiereComCapFkCompetenceId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AssocMatiereComCapPK)) {
			return false;
		}
		AssocMatiereComCapPK castOther = (AssocMatiereComCapPK)other;
		return 
			this.assocMatiereComCapFkMatiereId.equals(castOther.assocMatiereComCapFkMatiereId)
			&& this.assocMatiereComCapFkCompetenceId.equals(castOther.assocMatiereComCapFkCompetenceId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.assocMatiereComCapFkMatiereId.hashCode();
		hash = hash * prime + this.assocMatiereComCapFkCompetenceId.hashCode();
		
		return hash;
	}
}