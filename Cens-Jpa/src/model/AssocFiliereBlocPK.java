package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the assoc_filiere_bloc database table.
 * 
 */
@Embeddable
public class AssocFiliereBlocPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="assoc_filiere_bloc_fk_filiere_id", insertable=false, updatable=false)
	private Integer assocFiliereBlocFkFiliereId;

	@Column(name="assoc_filiere_bloc_fk_bloc_id", insertable=false, updatable=false)
	private Integer assocFiliereBlocFkBlocId;

	public AssocFiliereBlocPK() {
	}
	public Integer getAssocFiliereBlocFkFiliereId() {
		return this.assocFiliereBlocFkFiliereId;
	}
	public void setAssocFiliereBlocFkFiliereId(Integer assocFiliereBlocFkFiliereId) {
		this.assocFiliereBlocFkFiliereId = assocFiliereBlocFkFiliereId;
	}
	public Integer getAssocFiliereBlocFkBlocId() {
		return this.assocFiliereBlocFkBlocId;
	}
	public void setAssocFiliereBlocFkBlocId(Integer assocFiliereBlocFkBlocId) {
		this.assocFiliereBlocFkBlocId = assocFiliereBlocFkBlocId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AssocFiliereBlocPK)) {
			return false;
		}
		AssocFiliereBlocPK castOther = (AssocFiliereBlocPK)other;
		return 
			this.assocFiliereBlocFkFiliereId.equals(castOther.assocFiliereBlocFkFiliereId)
			&& this.assocFiliereBlocFkBlocId.equals(castOther.assocFiliereBlocFkBlocId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.assocFiliereBlocFkFiliereId.hashCode();
		hash = hash * prime + this.assocFiliereBlocFkBlocId.hashCode();
		
		return hash;
	}
}