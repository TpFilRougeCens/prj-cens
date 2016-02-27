package model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the assoc_matiere_com_cap database table.
 */
@Entity
@Table(name = "assoc_matiere_com_cap")
@NamedQuery(name = "AssocMatiereComCap.findAll", query = "SELECT a FROM AssocMatiereComCap a")
public class AssocMatiereComCap implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private AssocMatiereComCapPK id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assoc_matiere_com_cap_id")
    private Integer assocMatiereComCapId;

    //bi-directional many-to-one association to ComCap
    @ManyToOne
    @JoinColumn(name = "assoc_matiere_com_cap_fk_competence_id")
    private ComCap comCap;

    //bi-directional many-to-one association to Matiere
    @ManyToOne
    @JoinColumn(name = "assoc_matiere_com_cap_fk_matiere_id")
    private Matiere matiere;

    public AssocMatiereComCap() {
    }

    public AssocMatiereComCapPK getId() {
        return this.id;
    }

    public void setId(AssocMatiereComCapPK id) {
        this.id = id;
    }

    public Integer getAssocMatiereComCapId() {
        return this.assocMatiereComCapId;
    }

    public void setAssocMatiereComCapId(Integer assocMatiereComCapId) {
        this.assocMatiereComCapId = assocMatiereComCapId;
    }

    public ComCap getComCap() {
        return this.comCap;
    }

    public void setComCap(ComCap comCap) {
        this.comCap = comCap;
    }

    public Matiere getMatiere() {
        return this.matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

}