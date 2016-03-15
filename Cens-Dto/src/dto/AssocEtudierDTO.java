package dto;

import java.io.Serializable;

/**
 * Created by Gawel on 15/03/2016.
 */
public class AssocEtudierDTO implements Serializable {

    private static final long serialVersionUID = 3646364692910545450L;
    private Integer assocEtudierId;
    private ClassroomDTO classroom;
    private EleveDTO eleve;
    private PromoDTO promo;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getAssocEtudierId() {
        return assocEtudierId;
    }

    public void setAssocEtudierId(Integer assocEtudierId) {
        this.assocEtudierId = assocEtudierId;
    }

    public ClassroomDTO getClassroom() {
        return classroom;
    }

    public void setClassroom(ClassroomDTO classroom) {
        this.classroom = classroom;
    }

    public EleveDTO getEleve() {
        return eleve;
    }

    public void setEleve(EleveDTO eleve) {
        this.eleve = eleve;
    }

    public PromoDTO getPromo() {
        return promo;
    }

    public void setPromo(PromoDTO promo) {
        this.promo = promo;
    }
}
