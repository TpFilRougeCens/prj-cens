package dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Gawel on 15/03/2016.
 */
public class GroupeDTO implements Serializable {

    private static final long serialVersionUID = 8468022916775104876L;
    private Integer groupeId;
    private String groupeLibelle;
    private Integer groupeNiveauAcces;
    private List<PersonneDTO> personnes;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getGroupeId() {
        return groupeId;
    }

    public void setGroupeId(Integer groupeId) {
        this.groupeId = groupeId;
    }

    public String getGroupeLibelle() {
        return groupeLibelle;
    }

    public void setGroupeLibelle(String groupeLibelle) {
        this.groupeLibelle = groupeLibelle;
    }

    public Integer getGroupeNiveauAcces() {
        return groupeNiveauAcces;
    }

    public void setGroupeNiveauAcces(Integer groupeNiveauAcces) {
        this.groupeNiveauAcces = groupeNiveauAcces;
    }

    public List<PersonneDTO> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(List<PersonneDTO> personnes) {
        this.personnes = personnes;
    }
}
