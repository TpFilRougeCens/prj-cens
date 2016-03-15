package dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Gawel on 15/03/2016.
 */
public class BilanDTO implements Serializable {
    private static final long serialVersionUID = -3056935239706682023L;

    private Integer bilanId;
    private String bilanCommentaire;
    private Date bilanDateDebut;
    private Date bilanDateFin;
    private String bilanLibelle;
    private EleveDTO eleve;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getBilanId() {
        return bilanId;
    }

    public void setBilanId(Integer bilanId) {
        this.bilanId = bilanId;
    }

    public String getBilanCommentaire() {
        return bilanCommentaire;
    }

    public void setBilanCommentaire(String bilanCommentaire) {
        this.bilanCommentaire = bilanCommentaire;
    }

    public Date getBilanDateDebut() {
        return bilanDateDebut;
    }

    public void setBilanDateDebut(Date bilanDateDebut) {
        this.bilanDateDebut = bilanDateDebut;
    }

    public Date getBilanDateFin() {
        return bilanDateFin;
    }

    public void setBilanDateFin(Date bilanDateFin) {
        this.bilanDateFin = bilanDateFin;
    }

    public String getBilanLibelle() {
        return bilanLibelle;
    }

    public void setBilanLibelle(String bilanLibelle) {
        this.bilanLibelle = bilanLibelle;
    }

    public EleveDTO getEleve() {
        return eleve;
    }

    public void setEleve(EleveDTO eleve) {
        this.eleve = eleve;
    }
}
