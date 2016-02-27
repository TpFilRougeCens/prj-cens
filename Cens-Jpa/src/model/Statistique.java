package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * The persistent class for the statistique database table.
 */
@Entity
@NamedQuery(name = "Statistique.findAll", query = "SELECT s FROM Statistique s")
public class Statistique implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statistique_stat_id")
    private Integer statistiqueStatId;

    @Column(name = "statistique_date_stat")
    private Timestamp statistiqueDateStat;

    @Column(name = "statistique_libelle")
    private String statistiqueLibelle;

    @Column(name = "statistique_valeur")
    private String statistiqueValeur;

    public Statistique() {
    }

    public Integer getStatistiqueStatId() {
        return this.statistiqueStatId;
    }

    private void setStatistiqueStatId(Integer statistiqueStatId) {
        this.statistiqueStatId = statistiqueStatId;
    }

    public Timestamp getStatistiqueDateStat() {
        return this.statistiqueDateStat;
    }

    public void setStatistiqueDateStat(Timestamp statistiqueDateStat) {
        this.statistiqueDateStat = statistiqueDateStat;
    }

    public String getStatistiqueLibelle() {
        return this.statistiqueLibelle;
    }

    public void setStatistiqueLibelle(String statistiqueLibelle) {
        this.statistiqueLibelle = statistiqueLibelle;
    }

    public String getStatistiqueValeur() {
        return this.statistiqueValeur;
    }

    public void setStatistiqueValeur(String statistiqueValeur) {
        this.statistiqueValeur = statistiqueValeur;
    }

}