package model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the assoc_com_cap database table.
 */
@Entity
@Table(name = "assoc_com_cap")
@NamedQuery(name = "AssocComCap.findAll", query = "SELECT a FROM AssocComCap a")
public class AssocComCap implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private AssocComCapPK id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assoc_com_cap_id")
    private Integer assocComCapId;

    //bi-directional many-to-one association to ComCap
    @ManyToOne
    @JoinColumn(name = "assoc_com_cap_fk_cap_id")
    private ComCap comCap1;

    //bi-directional many-to-one association to ComCap
    @ManyToOne
    @JoinColumn(name = "assoc_com_cap_fk_com_id")
    private ComCap comCap2;

    public AssocComCap() {
    }

    public AssocComCapPK getId() {
        return this.id;
    }

    public void setId(AssocComCapPK id) {
        this.id = id;
    }

    public Integer getAssocComCapId() {
        return this.assocComCapId;
    }

    public void setAssocComCapId(Integer assocComCapId) {
        this.assocComCapId = assocComCapId;
    }

    public ComCap getComCap1() {
        return this.comCap1;
    }

    public void setComCap1(ComCap comCap1) {
        this.comCap1 = comCap1;
    }

    public ComCap getComCap2() {
        return this.comCap2;
    }

    public void setComCap2(ComCap comCap2) {
        this.comCap2 = comCap2;
    }

}