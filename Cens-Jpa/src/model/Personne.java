package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the personne database table.
 */
@Entity
@NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p")
public class Personne implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personne_id")
    private Integer personneId;

    @Column(name = "personne_adresse")
    private String personneAdresse;

    @Column(name = "personne_cp")
    private String personneCp;

    @Temporal(TemporalType.DATE)
    @Column(name = "personne_date_naissance")
    private Date personneDateNaissance;

    @Column(name = "personne_nom")
    private String personneNom;

    @Column(name = "personne_prenom")
    private String personnePrenom;

    @Column(name = "personne_ville")
    private String personneVille;

    public Personne() {
    }

    public Integer getPersonneId() {
        return this.personneId;
    }

    private void setPersonneId(Integer personneId) {
        this.personneId = personneId;
    }

    public String getPersonneAdresse() {
        return this.personneAdresse;
    }

    public void setPersonneAdresse(String personneAdresse) {
        this.personneAdresse = personneAdresse;
    }

    public String getPersonneCp() {
        return this.personneCp;
    }

    public void setPersonneCp(String personneCp) {
        this.personneCp = personneCp;
    }

    public Date getPersonneDateNaissance() {
        return this.personneDateNaissance;
    }

    public void setPersonneDateNaissance(Date personneDateNaissance) {
        this.personneDateNaissance = personneDateNaissance;
    }

    public String getPersonneNom() {
        return this.personneNom;
    }

    public void setPersonneNom(String personneNom) {
        this.personneNom = personneNom;
    }

    public String getPersonnePrenom() {
        return this.personnePrenom;
    }

    public void setPersonnePrenom(String personnePrenom) {
        this.personnePrenom = personnePrenom;
    }

    public String getPersonneVille() {
        return this.personneVille;
    }

    public void setPersonneVille(String personneVille) {
        this.personneVille = personneVille;
    }

}