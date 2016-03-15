package dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Gawel on 15/03/2016.
 */
public class PersonneDTO implements Serializable {

    private static final long serialVersionUID = -885974244025187408L;
    private Integer personneId;
    private String personneAdresse;
    private String personneCp;
    private Date personneDateNaissance;
    private String personneLogin;
    private String personnePassword;
    private String personneNom;
    private String personnePrenom;
    private String personneVille;
    private GroupeDTO groupe;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPersonneId() {
        return personneId;
    }

    public void setPersonneId(Integer personneId) {
        this.personneId = personneId;
    }

    public String getPersonneAdresse() {
        return personneAdresse;
    }

    public void setPersonneAdresse(String personneAdresse) {
        this.personneAdresse = personneAdresse;
    }

    public String getPersonneCp() {
        return personneCp;
    }

    public void setPersonneCp(String personneCp) {
        this.personneCp = personneCp;
    }

    public Date getPersonneDateNaissance() {
        return personneDateNaissance;
    }

    public void setPersonneDateNaissance(Date personneDateNaissance) {
        this.personneDateNaissance = personneDateNaissance;
    }

    public String getPersonneLogin() {
        return personneLogin;
    }

    public void setPersonneLogin(String personneLogin) {
        this.personneLogin = personneLogin;
    }

    public String getPersonnePassword() {
        return personnePassword;
    }

    public void setPersonnePassword(String personnePassword) {
        this.personnePassword = personnePassword;
    }

    public String getPersonneNom() {
        return personneNom;
    }

    public void setPersonneNom(String personneNom) {
        this.personneNom = personneNom;
    }

    public String getPersonnePrenom() {
        return personnePrenom;
    }

    public void setPersonnePrenom(String personnePrenom) {
        this.personnePrenom = personnePrenom;
    }

    public String getPersonneVille() {
        return personneVille;
    }

    public void setPersonneVille(String personneVille) {
        this.personneVille = personneVille;
    }

    public GroupeDTO getGroupe() {
        return groupe;
    }

    public void setGroupe(GroupeDTO groupe) {
        this.groupe = groupe;
    }
}
