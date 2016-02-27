package model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the assoc_etudier database table.
 */
@Entity
@Table(name = "assoc_etudier")
@NamedQuery(name = "AssocEtudier.findAll", query = "SELECT a FROM AssocEtudier a")
public class AssocEtudier implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private AssocEtudierPK id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assoc_etudier_id")
    private Integer assocEtudierId;

    //bi-directional many-to-one association to Classroom
    @ManyToOne
    @JoinColumn(name = "assoc_etudier_fk_classroom_id")
    private Classroom classroom;

    //bi-directional many-to-one association to Eleve
    @ManyToOne
    @JoinColumn(name = "assoc_etudier_fk_personne_id")
    private Eleve eleve;

    //bi-directional many-to-one association to Promo
    @ManyToOne
    @JoinColumn(name = "assoc_etudier_fk_promo_etudiant_id")
    private Promo promo;

    public AssocEtudier() {
    }

    public AssocEtudierPK getId() {
        return this.id;
    }

    public void setId(AssocEtudierPK id) {
        this.id = id;
    }

    public Integer getAssocEtudierId() {
        return this.assocEtudierId;
    }

    public void setAssocEtudierId(Integer assocEtudierId) {
        this.assocEtudierId = assocEtudierId;
    }

    public Classroom getClassroom() {
        return this.classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Eleve getEleve() {
        return this.eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public Promo getPromo() {
        return this.promo;
    }

    public void setPromo(Promo promo) {
        this.promo = promo;
    }

}