package dto;

import java.io.Serializable;

/**
 * Created by Gawel on 15/03/2016.
 */
public class AssocComCapDTO implements Serializable {

    private static final long serialVersionUID = -2519200385983250496L;
    private ComCapDTO comCap1;
    private ComCapDTO comCap2;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public ComCapDTO getComCap1() {
        return comCap1;
    }

    public void setComCap1(ComCapDTO comCap1) {
        this.comCap1 = comCap1;
    }

    public ComCapDTO getComCap2() {
        return comCap2;
    }

    public void setComCap2(ComCapDTO comCap2) {
        this.comCap2 = comCap2;
    }
}
