package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the personne database table.
 */

@Entity
@Table(name = "personne")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQueries({
        @NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p"),
        @NamedQuery(name = "Personne.findByNameAndPassWord", query = "SELECT p FROM Personne p WHERE p.personneLogin = :loginn AND p.personnePassword = :passwordd"),
        @NamedQuery(name = "Personne.findByLogin", query = "SELECT p FROM Personne p WHERE p.personneLogin = :loginn")
        })
public class Personne implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE) //    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personne_id")
    private Integer personneId;

    @Column(name = "personne_adresse")
    private String personneAdresse;

    @Column(name = "personne_cp")
    private String personneCp;

    @Temporal(TemporalType.DATE)
    @Column(name = "personne_date_naissance")
    private Date personneDateNaissance;

    @Column(name = "personne_login")
    private String personneLogin;

    @Column(name = "personne_password")
    private String personnePassword;

    @Column(name = "personne_nom")
    private String personneNom;

    @Column(name = "personne_prenom")
    private String personnePrenom;

    @Column(name = "personne_ville")
    private String personneVille;

    //bi-directional many-to-one association to Groupe
    @ManyToOne
    @JoinColumn(name = "personne_fk_groupe_id")
    private Groupe groupe;

    public Personne() {
    }

    public Integer getPersonneId() {
        return this.personneId;
    }

    public void setPersonneId(Integer personneId) {
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

    public String getPersonneLogin() {
        return this.personneLogin;
    }

    public void setPersonneLogin(String personneLogin) {
        this.personneLogin = personneLogin;
    }

    public String getPersonnePassword() {
        return this.personnePassword;
    }

    public void setPersonnePassword(String personnePassword) {
        this.personnePassword = personnePassword;
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

    public Groupe getGroupe() {
        return this.groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

}