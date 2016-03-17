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
    @Column(name = "statistique_id")
    private Integer statistiqueId;

    @Column(name = "statistique_date_stat")
    private Timestamp statistiqueDateStat;

    @Column(name = "statistique_libelle")
    private String statistiqueLibelle;

    @Column(name = "statistique_valeur")
    private String statistiqueValeur;

    public Statistique() {
    }

    public Integer getStatistiqueId() {
        return this.statistiqueId;
    }

    public void setStatistiqueId(Integer statistiqueId) {
        this.statistiqueId = statistiqueId;
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