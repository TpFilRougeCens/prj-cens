package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * The primary key class for the assoc_enseigner database table.
 */
@Embeddable
public class AssocEnseignerPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name = "assoc_enseigner_fk_personne_id", insertable = false, updatable = false)
    private Integer assocEnseignerFkPersonneId;

    @Column(name = "assoc_enseigner_fk_classroom_id", insertable = false, updatable = false)
    private Integer assocEnseignerFkClassroomId;

    @Column(name = "assoc_enseigner_fk_matiere_id", insertable = false, updatable = false)
    private Integer assocEnseignerFkMatiereId;

    @Column(name = "assoc_enseigner_fk_promo_enseignement_id", insertable = false, updatable = false)
    private Integer assocEnseignerFkPromoEnseignementId;

    public AssocEnseignerPK() {
    }

    public Integer getAssocEnseignerFkPersonneId() {
        return this.assocEnseignerFkPersonneId;
    }

    public void setAssocEnseignerFkPersonneId(Integer assocEnseignerFkPersonneId) {
        this.assocEnseignerFkPersonneId = assocEnseignerFkPersonneId;
    }

    public Integer getAssocEnseignerFkClassroomId() {
        return this.assocEnseignerFkClassroomId;
    }

    public void setAssocEnseignerFkClassroomId(Integer assocEnseignerFkClassroomId) {
        this.assocEnseignerFkClassroomId = assocEnseignerFkClassroomId;
    }

    public Integer getAssocEnseignerFkMatiereId() {
        return this.assocEnseignerFkMatiereId;
    }

    public void setAssocEnseignerFkMatiereId(Integer assocEnseignerFkMatiereId) {
        this.assocEnseignerFkMatiereId = assocEnseignerFkMatiereId;
    }

    public Integer getAssocEnseignerFkPromoEnseignementId() {
        return this.assocEnseignerFkPromoEnseignementId;
    }

    public void setAssocEnseignerFkPromoEnseignementId(Integer assocEnseignerFkPromoEnseignementId) {
        this.assocEnseignerFkPromoEnseignementId = assocEnseignerFkPromoEnseignementId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AssocEnseignerPK)) {
            return false;
        }
        AssocEnseignerPK castOther = (AssocEnseignerPK) other;
        return
                this.assocEnseignerFkPersonneId.equals(castOther.assocEnseignerFkPersonneId)
                        && this.assocEnseignerFkClassroomId.equals(castOther.assocEnseignerFkClassroomId)
                        && this.assocEnseignerFkMatiereId.equals(castOther.assocEnseignerFkMatiereId)
                        && this.assocEnseignerFkPromoEnseignementId.equals(castOther.assocEnseignerFkPromoEnseignementId);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.assocEnseignerFkPersonneId.hashCode();
        hash = hash * prime + this.assocEnseignerFkClassroomId.hashCode();
        hash = hash * prime + this.assocEnseignerFkMatiereId.hashCode();
        hash = hash * prime + this.assocEnseignerFkPromoEnseignementId.hashCode();

        return hash;
    }
}