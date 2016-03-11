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
    @Column(name = "parametre_id")
    private Integer parametreId;

    @Column(name = "parametre_libelle")
    private String parametreLibelle;

    @Column(name = "parametre_valeur")
    private String parametreValeur;

    public Parametre() {
    }

    public Integer getParametreId() {
        return this.parametreId;
    }

    private void setParametreId(Integer parametreId) {
        this.parametreId = parametreId;
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