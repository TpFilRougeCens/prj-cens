package service;

import model.Token;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by steven.cdi12 on 24/03/2016.
 */
@Stateless
@LocalBean
public class TokenService {
    @PersistenceContext(unitName = "Cens-Jpa")
    EntityManager entityManager;

    public Token findOne(String token) {
        Token tokenBase = (Token) entityManager
                .createNamedQuery("Token.findByToken")
                .setParameter("token", token)
                .getSingleResult();
        return tokenBase;
    }

    public boolean insert(Token token) {
        try {
            entityManager.persist(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String tokenString) {
        try {
            Token token = (Token) entityManager
                    .createNamedQuery("Token.findByToken")
                    .setParameter("token", tokenString)
                    .getSingleResult();
            entityManager.remove(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
