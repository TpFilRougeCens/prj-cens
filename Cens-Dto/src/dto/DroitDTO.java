package dto;

import java.io.Serializable;

/**
 * Created by Gawel on 15/03/2016.
 */
public class DroitDTO implements Serializable {

    private static final long serialVersionUID = -2818563274066427250L;
    private Integer droitId;
    private String droitUnite;
    private Integer droitLecture;
    private Integer droitEcriture;
    private GroupeDTO groupe;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getDroitId() {
        return droitId;
    }

    public void setDroitId(Integer droitId) {
        this.droitId = droitId;
    }

    public String getDroitUnite() {
        return droitUnite;
    }

    public void setDroitUnite(String droitUnite) {
        this.droitUnite = droitUnite;
    }

    public Integer getDroitLecture() {
        return droitLecture;
    }

    public void setDroitLecture(Integer droitLecture) {
        this.droitLecture = droitLecture;
    }

    public Integer getDroitEcriture() {
        return droitEcriture;
    }

    public void setDroitEcriture(Integer droitEcriture) {
        this.droitEcriture = droitEcriture;
    }

    public GroupeDTO getGroupe() {
        return groupe;
    }

    public void setGroupe(GroupeDTO groupe) {
        this.groupe = groupe;
    }
}
