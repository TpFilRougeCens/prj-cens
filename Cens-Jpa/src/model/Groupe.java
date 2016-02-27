package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the groupe database table.
 */
@Entity
@NamedQuery(name = "Groupe.findAll", query = "SELECT g FROM Groupe g")
public class Groupe implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "groupe_id")
    private Integer groupeId;

    @Column(name = "groupe_libelle")
    private String groupeLibelle;

    //bi-directional many-to-one association to AssocEmployeGroupe
    @OneToMany(mappedBy = "groupe", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<AssocEmployeGroupe> assocEmployeGroupes;

    //bi-directional many-to-one association to Droit
    @OneToMany(mappedBy = "groupe", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Droit> droits;

    public Groupe() {
    }

    public Integer getGroupeId() {
        return this.groupeId;
    }

    private void setGroupeId(Integer groupeId) {
        this.groupeId = groupeId;
    }

    public String getGroupeLibelle() {
        return this.groupeLibelle;
    }

    public void setGroupeLibelle(String groupeLibelle) {
        this.groupeLibelle = groupeLibelle;
    }

    public List<AssocEmployeGroupe> getAssocEmployeGroupes() {
        return this.assocEmployeGroupes;
    }

    public void setAssocEmployeGroupes(List<AssocEmployeGroupe> assocEmployeGroupes) {
        this.assocEmployeGroupes = assocEmployeGroupes;
    }

    public AssocEmployeGroupe addAssocEmployeGroupe(AssocEmployeGroupe assocEmployeGroupe) {
        getAssocEmployeGroupes().add(assocEmployeGroupe);
        assocEmployeGroupe.setGroupe(this);

        return assocEmployeGroupe;
    }

    public AssocEmployeGroupe removeAssocEmployeGroupe(AssocEmployeGroupe assocEmployeGroupe) {
        getAssocEmployeGroupes().remove(assocEmployeGroupe);
        assocEmployeGroupe.setGroupe(null);

        return assocEmployeGroupe;
    }

    public List<Droit> getDroits() {
        return this.droits;
    }

    public void setDroits(List<Droit> droits) {
        this.droits = droits;
    }

    public Droit addDroit(Droit droit) {
        getDroits().add(droit);
        droit.setGroupe(this);

        return droit;
    }

    public Droit removeDroit(Droit droit) {
        getDroits().remove(droit);
        droit.setGroupe(null);

        return droit;
    }

}