package model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the niveau database table JPA With IntelliJ.
 */
@Entity
@NamedQuery(name = "Niveau.findAll", query = "SELECT n FROM Niveau n")
public class Niveau implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idniveau;

    private String libelle;

    public Niveau() {
    }

    public Integer getIdniveau() {
        return this.idniveau;
    }

    public void setIdniveau(Integer idniveau) {
        this.idniveau = idniveau;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}