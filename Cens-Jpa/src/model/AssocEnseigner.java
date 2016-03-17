package model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the assoc_enseigner database table.
 */
@Entity
@Table(name = "assoc_enseigner")
@NamedQuery(name = "AssocEnseigner.findAll", query = "SELECT a FROM AssocEnseigner a")
public class AssocEnseigner implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private AssocEnseignerPK id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assoc_enseigner_id")
    private Integer assocEnseignerId;

    //bi-directional many-to-one association to Classroom
    @ManyToOne()
    @JoinColumn(name = "assoc_enseigner_fk_classroom_id")
    private Classroom classroom;

    //bi-directional many-to-one association to Employe
    @ManyToOne
    @JoinColumn(name = "assoc_enseigner_fk_personne_id")
    private Employe employe;

    //bi-directional many-to-one association to Matiere
    @ManyToOne
    @JoinColumn(name = "assoc_enseigner_fk_matiere_id")
    private Matiere matiere;

    //bi-directional many-to-one association to Promo
    @ManyToOne
    @JoinColumn(name = "assoc_enseigner_fk_promo_enseignement_id")
    private Promo promo;

    public AssocEnseigner() {
    }

    public AssocEnseignerPK getId() {
        return this.id;
    }

    public void setId(AssocEnseignerPK id) {
        this.id = id;
    }

    public Integer getAssocEnseignerId() {
        return this.assocEnseignerId;
    }

    public void setAssocEnseignerId(Integer assocEnseignerId) {
        this.assocEnseignerId = assocEnseignerId;
    }

    public Classroom getClassroom() {
        return this.classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Employe getEmploye() {
        return this.employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Matiere getMatiere() {
        return this.matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Promo getPromo() {
        return this.promo;
    }

    public void setPromo(Promo promo) {
        this.promo = promo;
    }

}