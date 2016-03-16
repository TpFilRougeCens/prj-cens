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

    @Column(name = "groupe_niveauacces")
    private Integer groupeNiveauAcces;

    //bi-directional many-to-one association to Personne
    @OneToMany(mappedBy = "groupe", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Personne> personnes;


    public Groupe() {
    }

    public Integer getGroupeId() {
        return this.groupeId;
    }

    public void setGroupeId(Integer groupeId) {
        this.groupeId = groupeId;
    }

    public String getGroupeLibelle() {
        return this.groupeLibelle;
    }

    public void setGroupeLibelle(String groupeLibelle) {
        this.groupeLibelle = groupeLibelle;
    }

    public Integer getGroupeNiveauAcces() {
        return this.groupeNiveauAcces;
    }

    public void setGroupeNiveauAcces(Integer groupeNiveauAcces) {
        this.groupeNiveauAcces = groupeNiveauAcces;
    }

    public List<Personne> getPersonnes() {
        return this.personnes;
    }

    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }

    public Personne addPersonne(Personne personne) {
        getPersonnes().add(personne);
        personne.setGroupe(this);

        return personne;
    }

    public Personne removePersonne(Personne personne) {
        getPersonnes().remove(personne);
        personne.setGroupe(null);

        return personne;
    }


}