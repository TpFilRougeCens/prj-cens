package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the voie database table.
 */
@Entity
@NamedQuery(name = "Voie.findAll", query = "SELECT v FROM Voie v")
public class Voie implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voie_id")
    private Integer voieId;

    @Column(name = "voie_libelle")
    private String voieLibelle;

    //bi-directional many-to-one association to Filiere
    @OneToMany(mappedBy = "voie", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Filiere> filieres;

    public Voie() {
    }

    public Integer getVoieId() {
        return this.voieId;
    }

    public void setVoieId(Integer voieId) {
        this.voieId = voieId;
    }

    public String getVoieLibelle() {
        return this.voieLibelle;
    }

    public void setVoieLibelle(String voieLibelle) {
        this.voieLibelle = voieLibelle;
    }

    public List<Filiere> getFilieres() {
        return this.filieres;
    }

    public void setFilieres(List<Filiere> filieres) {
        this.filieres = filieres;
    }

    public Filiere addFiliere(Filiere filiere) {
        getFilieres().add(filiere);
        filiere.setVoie(this);

        return filiere;
    }

    public Filiere removeFiliere(Filiere filiere) {
        getFilieres().remove(filiere);
        filiere.setVoie(null);

        return filiere;
    }

}