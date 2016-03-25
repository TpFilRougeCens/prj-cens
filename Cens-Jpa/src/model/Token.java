package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by steven.cdi12 on 24/03/2016.
 */
@Entity
@NamedQuery(name="Token.findByToken", query = "SELECT t FROM Token t WHERE t.token = :token")
public class Token implements Serializable{
    private Integer id;
    private String utilisateur;
    private String token;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "utilisateur")
    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Basic
    @Column(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Token token1 = (Token) o;

        if (id != null ? !id.equals(token1.id) : token1.id != null) return false;
        if (utilisateur != null ? !utilisateur.equals(token1.utilisateur) : token1.utilisateur != null) return false;
        if (token != null ? !token.equals(token1.token) : token1.token != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (utilisateur != null ? utilisateur.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        return result;
    }
}
