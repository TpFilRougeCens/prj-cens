package model;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the personne database table.
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQueries({
        @NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p"),
        @NamedQuery(name = "Personne.findByNameAndPassWord", query = "SELECT p FROM Personne p WHERE p.personneLogin = :loginn AND p.personnePassword = :passwordd")
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

    public String getPersonneLogin() {
        return this.personneLogin;
    }

    public void setPersonneLogin(String personneLogin) {
        this.personneLogin = personneLogin;
    }

    public String getPersonnePassword() {
        try {
            return decrypt(this.personnePassword);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void setPersonnePassword(String personnePassword) {

        try {
            this.personnePassword = encrypt(personnePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

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

    private static String encrypt(String password) throws Exception {

        // TODO Variable global à l'application a faire au lancement serveur
        String key = "todo";
        byte[] keyData = key.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] hasil = cipher.doFinal(password.getBytes());
        return new BASE64Encoder().encode(hasil);
    }

    private static String decrypt(String password) throws Exception {
        // TODO Variable global à l'application a faire au lancement serveur
        String key = "todo";
        byte[] keyData = key.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] hasil = cipher.doFinal(new BASE64Decoder().decodeBuffer(password));
        return new String(hasil);
    }
}