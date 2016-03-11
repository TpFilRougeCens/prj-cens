package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the bilan database table.
 */
@Entity
@NamedQuery(name = "Bilan.findAll", query = "SELECT b FROM Bilan b")
public class Bilan implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bilan_id")
    private Integer bilanId;

    @Column(name = "bilan_commentaire")
    private String bilanCommentaire;

    @Temporal(TemporalType.DATE)
    @Column(name = "bilan_date_debut")
    private Date bilanDateDebut;

    @Temporal(TemporalType.DATE)
    @Column(name = "bilan_date_fin")
    private Date bilanDateFin;

    @Column(name = "bilan_libelle")
    private String bilanLibelle;

    //bi-directional many-to-one association to Eleve
    @ManyToOne
    @JoinColumn(name = "bilan_fk_personne_id")
    private Eleve eleve;

    public Bilan() {
    }

    public Integer getBilanId() {
        return this.bilanId;
    }

    public void setBilanId(Integer bilanId) {
        this.bilanId = bilanId;
    }

    public String getBilanCommentaire() {
        return this.bilanCommentaire;
    }

    public void setBilanCommentaire(String bilanCommentaire) {
        this.bilanCommentaire = bilanCommentaire;
    }

    public Date getBilanDateDebut() {
        return this.bilanDateDebut;
    }

    public void setBilanDateDebut(Date bilanDateDebut) {
        this.bilanDateDebut = bilanDateDebut;
    }

    public Date getBilanDateFin() {
        return this.bilanDateFin;
    }

    public void setBilanDateFin(Date bilanDateFin) {
        this.bilanDateFin = bilanDateFin;
    }

    public String getBilanLibelle() {
        return this.bilanLibelle;
    }

    public void setBilanLibelle(String bilanLibelle) {
        this.bilanLibelle = bilanLibelle;
    }

    public Eleve getEleve() {
        return this.eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

}