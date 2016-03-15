package dto;

import java.io.Serializable;
import java.security.Timestamp;

/**
 * Created by Gawel on 15/03/2016.
 */
public class StatistiqueDTO implements Serializable {

    private static final long serialVersionUID = -747363276920241124L;
    private Integer statistiqueId;
    private Timestamp statistiqueDateStat; // TODO verifier import : java.security du TimesTamp
    private String statistiqueLibelle;
    private String statistiqueValeur;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getStatistiqueId() {
        return statistiqueId;
    }

    public void setStatistiqueId(Integer statistiqueId) {
        this.statistiqueId = statistiqueId;
    }

    public Timestamp getStatistiqueDateStat() {
        return statistiqueDateStat;
    }

    public void setStatistiqueDateStat(Timestamp statistiqueDateStat) {
        this.statistiqueDateStat = statistiqueDateStat;
    }

    public String getStatistiqueLibelle() {
        return statistiqueLibelle;
    }

    public void setStatistiqueLibelle(String statistiqueLibelle) {
        this.statistiqueLibelle = statistiqueLibelle;
    }

    public String getStatistiqueValeur() {
        return statistiqueValeur;
    }

    public void setStatistiqueValeur(String statistiqueValeur) {
        this.statistiqueValeur = statistiqueValeur;
    }
}
