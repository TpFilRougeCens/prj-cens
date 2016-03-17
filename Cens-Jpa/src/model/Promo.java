package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the promo database table.
 */
@Entity
@NamedQuery(name = "Promo.findAll", query = "SELECT p FROM Promo p")
public class Promo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promo_id")
    private Integer promoId;

    @Column(name = "promo_libelle")
    private String promoLibelle;

    //bi-directional many-to-one association to AssocEnseigner
    @OneToMany(mappedBy = "promo")
    private List<AssocEnseigner> assocEnseigners;

    //bi-directional many-to-one association to AssocEtudier
    @OneToMany(mappedBy = "promo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<AssocEtudier> assocEtudiers;

    public Promo() {
    }

    public Integer getPromoId() {
        return this.promoId;
    }

    public void setPromoId(Integer promoId) {
        this.promoId = promoId;
    }

    public String getPromoLibelle() {
        return this.promoLibelle;
    }

    public void setPromoLibelle(String promoLibelle) {
        this.promoLibelle = promoLibelle;
    }

    public List<AssocEnseigner> getAssocEnseigners() {
        return this.assocEnseigners;
    }

    public void setAssocEnseigners(List<AssocEnseigner> assocEnseigners) {
        this.assocEnseigners = assocEnseigners;
    }

    public AssocEnseigner addAssocEnseigner(AssocEnseigner assocEnseigner) {
        getAssocEnseigners().add(assocEnseigner);
        assocEnseigner.setPromo(this);

        return assocEnseigner;
    }

    public AssocEnseigner removeAssocEnseigner(AssocEnseigner assocEnseigner) {
        getAssocEnseigners().remove(assocEnseigner);
        assocEnseigner.setPromo(null);

        return assocEnseigner;
    }

    public List<AssocEtudier> getAssocEtudiers() {
        return this.assocEtudiers;
    }

    public void setAssocEtudiers(List<AssocEtudier> assocEtudiers) {
        this.assocEtudiers = assocEtudiers;
    }

    public AssocEtudier addAssocEtudier(AssocEtudier assocEtudier) {
        getAssocEtudiers().add(assocEtudier);
        assocEtudier.setPromo(this);

        return assocEtudier;
    }

    public AssocEtudier removeAssocEtudier(AssocEtudier assocEtudier) {
        getAssocEtudiers().remove(assocEtudier);
        assocEtudier.setPromo(null);

        return assocEtudier;
    }

}