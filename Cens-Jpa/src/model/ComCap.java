package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the com_cap database table.
 */
@Entity
@Table(name = "com_cap")
@NamedQuery(name = "ComCap.findAll", query = "SELECT c FROM ComCap c")
public class ComCap implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "com_cap_id")
    private Integer comCapId;

    @Column(name = "com_cap_libelle")
    private String comCapLibelle;

    //bi-directional many-to-one association to AssocComCap
    //Liste les Compétences de la Capacité (liste PARENT)
    @OneToMany(mappedBy = "comCap1")
    private List<AssocComCap> assocComCaps1;

    //bi-directional many-to-one association to AssocComCap
    // Liste les capacités de la compétence (Liste ENFANT)
    @OneToMany(mappedBy = "comCap2")
    private List<AssocComCap> assocComCaps2;

    //bi-directional many-to-one association to AssocEvaluer
    @OneToMany(mappedBy = "comCap")
    private List<AssocEvaluer> assocEvaluers;

    //bi-directional many-to-one association to AssocMatiereComCap
    @OneToMany(mappedBy = "comCap")
    private List<AssocMatiereComCap> assocMatiereComCaps;

    public ComCap() {
    }

    public Integer getComCapId() {
        return this.comCapId;
    }

    public void setComCapId(Integer comCapId) {
        this.comCapId = comCapId;
    }

    public String getComCapLibelle() {
        return this.comCapLibelle;
    }

    public void setComCapLibelle(String comCapLibelle) {
        this.comCapLibelle = comCapLibelle;
    }

    /**
     * Liste les Compétences de la Capacité (liste des PARENTS)
     *
     * @return Retourne les Compétences de la capacité si je suis une capacité
     */
    public List<AssocComCap> getAssocComCaps1() {
        return this.assocComCaps1;
    }

    /**
     * Ajoute des Compétences à la Capacité (liste des PARENTS)
     * <p>
     * Je suis donc une capacité transversale si SET d'une List
     *
     * @param assocComCaps1
     */
    public void setAssocComCaps1(List<AssocComCap> assocComCaps1) {
        this.assocComCaps1 = assocComCaps1;
    }

    public AssocComCap addAssocComCaps1(AssocComCap assocComCaps1) {
        getAssocComCaps1().add(assocComCaps1);
        assocComCaps1.setComCap1(this);

        return assocComCaps1;
    }

    public AssocComCap removeAssocComCaps1(AssocComCap assocComCaps1) {
        getAssocComCaps1().remove(assocComCaps1);
        assocComCaps1.setComCap1(null);

        return assocComCaps1;
    }

    /**
     * Liste les capacités de la compétence (LISTE DES ENFANTS)
     *
     * @return retourne les capacités de la compétence
     */
    public List<AssocComCap> getAssocComCaps2() {
        return this.assocComCaps2;
    }

    /**
     * Ajoute des capacités à la compétence (liste des PARENTS)
     *
     * @param assocComCaps2
     */
    public void setAssocComCaps2(List<AssocComCap> assocComCaps2) {
        this.assocComCaps2 = assocComCaps2;
    }

    public AssocComCap addAssocComCaps2(AssocComCap assocComCaps2) {
        getAssocComCaps2().add(assocComCaps2);
        assocComCaps2.setComCap2(this);

        return assocComCaps2;
    }

    public AssocComCap removeAssocComCaps2(AssocComCap assocComCaps2) {
        getAssocComCaps2().remove(assocComCaps2);
        assocComCaps2.setComCap2(null);

        return assocComCaps2;
    }

    public List<AssocEvaluer> getAssocEvaluers() {
        return this.assocEvaluers;
    }

    public void setAssocEvaluers(List<AssocEvaluer> assocEvaluers) {
        this.assocEvaluers = assocEvaluers;
    }

    public AssocEvaluer addAssocEvaluer(AssocEvaluer assocEvaluer) {
        getAssocEvaluers().add(assocEvaluer);
        assocEvaluer.setComCap(this);

        return assocEvaluer;
    }

    public AssocEvaluer removeAssocEvaluer(AssocEvaluer assocEvaluer) {
        getAssocEvaluers().remove(assocEvaluer);
        assocEvaluer.setComCap(null);

        return assocEvaluer;
    }

    public List<AssocMatiereComCap> getAssocMatiereComCaps() {
        return this.assocMatiereComCaps;
    }

    public void setAssocMatiereComCaps(List<AssocMatiereComCap> assocMatiereComCaps) {
        this.assocMatiereComCaps = assocMatiereComCaps;
    }

    public AssocMatiereComCap addAssocMatiereComCap(AssocMatiereComCap assocMatiereComCap) {
        getAssocMatiereComCaps().add(assocMatiereComCap);
        assocMatiereComCap.setComCap(this);

        return assocMatiereComCap;
    }

    public AssocMatiereComCap removeAssocMatiereComCap(AssocMatiereComCap assocMatiereComCap) {
        getAssocMatiereComCaps().remove(assocMatiereComCap);
        assocMatiereComCap.setComCap(null);

        return assocMatiereComCap;
    }

}