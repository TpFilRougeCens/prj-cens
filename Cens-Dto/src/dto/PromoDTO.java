package dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Gawel on 15/03/2016.
 */
public class PromoDTO implements Serializable {


    private static final long serialVersionUID = 2150730680961731111L;
    private Integer promoId;
    private String promoLibelle;
    private List<AssocEnseignerDTO> assocEnseigners;
    private List<AssocEtudierDTO> assocEtudiers;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPromoId() {
        return promoId;
    }

    public void setPromoId(Integer promoId) {
        this.promoId = promoId;
    }

    public String getPromoLibelle() {
        return promoLibelle;
    }

    public void setPromoLibelle(String promoLibelle) {
        this.promoLibelle = promoLibelle;
    }

    public List<AssocEnseignerDTO> getAssocEnseigners() {
        return assocEnseigners;
    }

    public void setAssocEnseigners(List<AssocEnseignerDTO> assocEnseigners) {
        this.assocEnseigners = assocEnseigners;
    }

    public List<AssocEtudierDTO> getAssocEtudiers() {
        return assocEtudiers;
    }

    public void setAssocEtudiers(List<AssocEtudierDTO> assocEtudiers) {
        this.assocEtudiers = assocEtudiers;
    }
}
