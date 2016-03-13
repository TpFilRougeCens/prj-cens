package model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the droit database table.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Droit.findAll", query = "SELECT d FROM Droit d"),
        @NamedQuery(name = "Droit.findByUnite", query = "SELECT d FROM Droit d WHERE d.droitUnite = :pathh")
})
public class Droit implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "droit_id")
    private Integer droitId;

    @Column(name = "droit_unite")
    private String droitUnite;

    @Column(name = "droit_lecture")
    private Integer droitLecture;

    @Column(name = "droit_ecriture")
    private Integer droitEcriture;


    //bi-directional many-to-one association to Groupe
    @ManyToOne
    @JoinColumn(name = "droit_fk_groupe_id")
    private Groupe groupe;

    public Droit() {
    }

    public Integer getDroitId() {
        return this.droitId;
    }

    public void setDroitId(Integer droitId) {
        this.droitId = droitId;
    }

    public Integer getDroitLecture() {
        return this.droitLecture;
    }

    public void setDroitLecture(Integer droitLecture) {
        this.droitLecture = droitLecture;
    }

    public Integer getDroitEcriture() {
        return this.droitEcriture;
    }

    public void setDroitEcriture(Integer droitEcriture) {
        this.droitEcriture = droitEcriture;
    }

    public String getDroitUnite() {
        return this.droitUnite;
    }

    public void setDroitUnite(String droitUnite) {
        this.droitUnite = droitUnite;
    }

    public Groupe getGroupe() {
        return this.groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

}