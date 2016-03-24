package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the eleve database table.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Eleve.findAll", query = "SELECT e FROM Eleve e"),
        @NamedQuery(name = "Eleve.deleteBilan", query = "DELETE FROM Bilan b WHERE b.eleve.eleveId = :idd"),
        @NamedQuery(name = "Eleve.deleteEval", query = "DELETE FROM AssocEvaluer a WHERE a.eleve.eleveId = :idd"),
        @NamedQuery(name = "Eleve.deleteEleve", query = "DELETE FROM Eleve e WHERE e.eleveId = :idd"),
        @NamedQuery(name = "Eleve.deleteEtud", query = "DELETE FROM AssocEtudier a WHERE a.eleve.eleveId = :idd")
})
//public class Eleve extends Personne implements Serializable {
public class Eleve implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personne_id")
    private Integer eleveId;

    @Column(name = "eleve_email_parent")
    private String eleveEmailParent;


    @Column(name = "personne_adresse")
    private String eleveAdresse;

    @Column(name = "personne_cp")
    private String eleveCp;

    @Temporal(TemporalType.DATE)
    @Column(name = "personne_date_naissance")
    private Date eleveDateNaissance;

    @Column(name = "personne_login")
    private String eleveLogin;

    @Column(name = "personne_password")
    private String elevePassword;

    @Column(name = "personne_nom")
    private String eleveNom;

    @Column(name = "personne_prenom")
    private String elevePrenom;

    @Column(name = "personne_ville")
    private String eleveVille;

    //bi-directional many-to-one association to AssocEtudier
    @OneToMany
    private List<AssocEtudier> assocEtudiers;

    //bi-directional many-to-one association to AssocEvaluer
    @OneToMany
    private List<AssocEvaluer> assocEvaluers;

    //bi-directional many-to-one association to Bilan
    //todo cascade
    @OneToMany
    private List<Bilan> bilans;

    //bi-directional many-to-one association to Groupe
    @ManyToOne
    @JoinColumn(name = "personne_fk_groupe_id")
    private Groupe groupe;

    public Eleve() {
    }

    public Integer getEleveId() {
        return this.eleveId;
    }

    public void setEleveId(Integer eleveId) {
        this.eleveId = eleveId;
    }

    public String getEleveEmailParent() {
        return this.eleveEmailParent;
    }

    public void setEleveEmailParent(String eleveEmailParent) {
        this.eleveEmailParent = eleveEmailParent;
    }

    public String getEleveAdresse() {
        return this.eleveAdresse;
    }

    public void setEleveAdresse(String eleveAdresse) {
        this.eleveAdresse = eleveAdresse;
    }

    public String getEleveCp() {
        return this.eleveCp;
    }

    public void setEleveCp(String eleveCp) {
        this.eleveCp = eleveCp;
    }

    public Date getEleveDateNaissance() {
        return this.eleveDateNaissance;
    }

    public void setEleveDateNaissance(Date eleveDateNaissance) {
        this.eleveDateNaissance = eleveDateNaissance;
    }

    public String getEleveLogin() {
        return this.eleveLogin;
    }

    public void setEleveLogin(String eleveLogin) {
        this.eleveLogin = eleveLogin;
    }

    public String getElevePassword() {
        return this.elevePassword;
    }

    public void setElevePassword(String elevePassword) {
        this.elevePassword = elevePassword;
    }

    public String getEleveNom() {
        return this.eleveNom;
    }

    public void setEleveNom(String eleveNom) {
        this.eleveNom = eleveNom;
    }

    public String getElevePrenom() {
        return this.elevePrenom;
    }

    public void setElevePrenom(String elevePrenom) {
        this.elevePrenom = elevePrenom;
    }

    public String getEleveVille() {
        return this.eleveVille;
    }

    public void setEleveVille(String eleveVille) {
        this.eleveVille = eleveVille;
    }

    public List<AssocEtudier> getAssocEtudiers() {
        return this.assocEtudiers;
    }

    public void setAssocEtudiers(List<AssocEtudier> assocEtudiers) {
        this.assocEtudiers = assocEtudiers;
    }

    public AssocEtudier addAssocEtudier(AssocEtudier assocEtudier) {
        getAssocEtudiers().add(assocEtudier);
        assocEtudier.setEleve(this);

        return assocEtudier;
    }

    public AssocEtudier removeAssocEtudier(AssocEtudier assocEtudier) {
        getAssocEtudiers().remove(assocEtudier);
        assocEtudier.setEleve(null);

        return assocEtudier;
    }

    public List<AssocEvaluer> getAssocEvaluers() {
        return this.assocEvaluers;
    }

    public void setAssocEvaluers(List<AssocEvaluer> assocEvaluers) {
        this.assocEvaluers = assocEvaluers;
    }

    public AssocEvaluer addAssocEvaluer(AssocEvaluer assocEvaluer) {
        getAssocEvaluers().add(assocEvaluer);
        assocEvaluer.setEleve(this);

        return assocEvaluer;
    }

    public AssocEvaluer removeAssocEvaluer(AssocEvaluer assocEvaluer) {
        getAssocEvaluers().remove(assocEvaluer);
        assocEvaluer.setEleve(null);

        return assocEvaluer;
    }

    public List<Bilan> getBilans() {
        return this.bilans;
    }

    public void setBilans(List<Bilan> bilans) {
        this.bilans = bilans;
    }

    public Bilan addBilan(Bilan bilan) {
        getBilans().add(bilan);
        bilan.setEleve(this);

        return bilan;
    }

    public Bilan removeBilan(Bilan bilan) {
        getBilans().remove(bilan);
        bilan.setEleve(null);

        return bilan;
    }

    public Groupe getGroupe() {
        return this.groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

}