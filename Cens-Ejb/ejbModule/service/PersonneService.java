package service;

import model.Personne;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Session Bean implementation class PersonneService
 */
@Stateless
@LocalBean
public class PersonneService {
    @EJB
    DroitService droitService;

    @PersistenceContext(unitName = "Cens-Jpa")
    EntityManager entityManager;

    /**
     * FIND ALL ELEMENTS METHODE WITH PARAMETER QUERY findAll
     *
     * @see Personne
     */
    @SuppressWarnings("unchecked")
    public List<Personne> findAll() {
        return entityManager.createNamedQuery("Personne.findAll").getResultList();
    }

    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param personneId : Id du personne recherché
     */
    public Personne findOne(Integer personneId) {
        try {
            System.out.println("passage dans la couche service personne avec id");
            return entityManager.find(Personne.class, personneId);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * RETOURNE UNE PERSONNE SI CELLE CI EST CONNUE
     *
     * @param login    : login utilisateur qui demande une connexion
     * @param password : mot de passe tentative
     */
    public Personne findOne(String login, String password) {
        try {
            System.out.println("valeur de personne dans service ");
            Personne personne = (Personne) entityManager
                    .createNamedQuery("Personne.findByNameAndPassWord")
                    .setParameter("loginn", login)
                    .setParameter("passwordd", password)
                    .getSingleResult();
            System.out.println("valeur de personne dans service " + personne);
            return personne;

        } catch (NoResultException e) {
            System.out.println("Personne : FindOne : Pas de resultat");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public Personne findOne(String login) {
        try {
            Personne personne = (Personne) entityManager
                    .createNamedQuery("Personne.findByLogin")
                    .setParameter("loginn", login)
                    .getSingleResult();
            System.out.println("valeur de personne dans service " + personne);
            return personne;

        } catch (NoResultException e) {
            System.out.println("Personne : FindOne : Pas de resultat");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * DELETE METHODE WITH NATIVE JPA METHODE
     *
     * @param personneId : Type Integer ID de la personne
     */
    public boolean delete(Integer personneId) {
        try {
            Personne result = entityManager.find(Personne.class, personneId);
            entityManager.remove(result);
            //System.out.println("ID Supprimé = " + personne.getPersonneId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param personne : Object de type Personne (de la classe)
     */
    public boolean insert(Personne personne) {
        try {
            entityManager.persist(personne);
            return true;
        } catch (Exception d) {
            d.printStackTrace();
            return false;
        }

    }

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param personne : Object de type Personne
     */
    public boolean update(Personne personne) {
        try {
            entityManager.merge(personne);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /*public List<Droit> droitsPersonne(Personne personne) {
        try {
            return entityManager.find(Personne.class, personne.getPersonneId()).getGroupe().getDroits();
        } catch (NoResultException e) {
            System.out.println("Personne : droitsUtilisateur : Pas de resultat");
            return null;
        } catch (NullPointerException e) {
            System.out.println("Personne : droitsUtilisateur : Null pointer");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/

    public boolean authPersonneLecture(Personne personne, String pathModule) {
        try {

            // Recupération de tous les droits du groupe User
            Integer niveauAccessUser = entityManager.find(Personne.class, personne.getPersonneId()).getGroupe().getGroupeNiveauAcces();
            Integer niveauAccessLectureModule = droitService.findNiveauLecture(pathModule);

            // Vérification du droits de lecture
            if (niveauAccessUser >= niveauAccessLectureModule) {
                return true;
            } else {
                return false;
            }

        } catch (NoResultException e) {
            System.out.println("PersonneService : authPersonneLecture : Pas de resultat");
            return false;
        } catch (NullPointerException e) {
            System.out.println("PersonneService : authPersonneLecture : Null pointer");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean authPersonneEcriture(Personne personne, String pathModule) {
        try {
            // Recupération de tous les droits du groupe User
            Integer niveauAccessUser = entityManager.find(Personne.class, personne.getPersonneId()).getGroupe().getGroupeNiveauAcces();
            Integer niveauAccessEcritureModule = droitService.findNiveauEcriture(pathModule);

            // Vérification du droits de lecture
            if (niveauAccessUser >= niveauAccessEcritureModule) {
                return true;
            } else {
                return false;
            }

        } catch (NoResultException e) {
            System.out.println("PersonneService : authPersonneLecture : Pas de resultat");
            return false;
        } catch (NullPointerException e) {
            System.out.println("PersonneService : authPersonneLecture : Null pointer");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public static Personne encryptPassword(Personne personne) {
        String password = personne.getPersonnePassword();
        String key = "todo"; //MAX LENGHT 16CHARS // TODO Variable global à l'application a faire au lancement serveur
        try {
            byte[] keyData = key.getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] hasil = cipher.doFinal(password.getBytes());
            personne.setPersonnePassword(new BASE64Encoder().encode(hasil));
            return personne;
        } catch (Exception e) {
            return null;
        }
//        return new BASE64Encoder().encode(hasil); //retourne le password encrypté
    }

    // NE JAMAIS DECRYPTER
//    private static String decrypt(String password) throws Exception {
//        String key = "todo";
//        byte[] keyData = key.getBytes();
//        SecretKeySpec secretKeySpec = new SecretKeySpec(keyData, "Blowfish");
//        Cipher cipher = Cipher.getInstance("Blowfish");
//        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
//        byte[] hasil = cipher.doFinal(new BASE64Decoder().decodeBuffer(password));
//        return new String(hasil);
//    }

}
