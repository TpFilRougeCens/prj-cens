package dto;

import java.io.Serializable;

/**
 * Created by Gawel on 15/03/2016.
 */
public class EleveDTO extends PersonneDTO implements Serializable {

    private static final long serialVersionUID = 6102676432743062711L;
    private String eleveEmailParent;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getEleveEmailParent() {
        return eleveEmailParent;
    }

    public void setEleveEmailParent(String eleveEmailParent) {
        this.eleveEmailParent = eleveEmailParent;
    }
}
