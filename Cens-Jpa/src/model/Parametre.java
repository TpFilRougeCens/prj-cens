package model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the parametre database table.
 */
@Entity
@NamedQuery(name = "Parametre.findAll", query = "SELECT p FROM Parametre p")
public class Parametre implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parametre_parametre_id")
    private Integer parametreParametreId;

    @Column(name = "parametre_libelle")
    private String parametreLibelle;

    @Column(name = "parametre_valeur")
    private String parametreValeur;

    public Parametre() {
    }

    public Integer getParametreParametreId() {
        return this.parametreParametreId;
    }

    private void setParametreParametreId(Integer parametreParametreId) {
        this.parametreParametreId = parametreParametreId;
    }

    public String getParametreLibelle() {
        return this.parametreLibelle;
    }

    public void setParametreLibelle(String parametreLibelle) {
        this.parametreLibelle = parametreLibelle;
    }

    public String getParametreValeur() {
        return this.parametreValeur;
    }

    public void setParametreValeur(String parametreValeur) {
        this.parametreValeur = parametreValeur;
    }

}