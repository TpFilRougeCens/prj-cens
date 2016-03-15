package dto;

import java.io.Serializable;

/**
 * Created by Gawel on 15/03/2016.
 */
public class EmployeDTO extends PersonneDTO implements Serializable {

    private static final long serialVersionUID = -3222868642156026384L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
