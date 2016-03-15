package dto;

import java.io.Serializable;

/**
 * Created by Gawel on 15/03/2016.
 */
public class ParametreDTO implements Serializable {

    private static final long serialVersionUID = 4502199952199336796L;
    private Integer parametreId;
    private String parametreLibelle;
    private String parametreValeur;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getParametreId() {
        return parametreId;
    }

    public void setParametreId(Integer parametreId) {
        this.parametreId = parametreId;
    }

    public String getParametreLibelle() {
        return parametreLibelle;
    }

    public void setParametreLibelle(String parametreLibelle) {
        this.parametreLibelle = parametreLibelle;
    }

    public String getParametreValeur() {
        return parametreValeur;
    }

    public void setParametreValeur(String parametreValeur) {
        this.parametreValeur = parametreValeur;
    }
}
