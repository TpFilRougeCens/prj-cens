package dto;

import java.io.Serializable;

/**
 * Created by Gawel on 15/03/2016.
 */
public class AssocFiliereBlocDTO implements Serializable {

    private static final long serialVersionUID = -4415311745338361906L;
    private Integer assocFiliereBlocId;
    private BlocDTO bloc;
    private FiliereDTO filiere;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getAssocFiliereBlocId() {
        return assocFiliereBlocId;
    }

    public void setAssocFiliereBlocId(Integer assocFiliereBlocId) {
        this.assocFiliereBlocId = assocFiliereBlocId;
    }

    public BlocDTO getBloc() {
        return bloc;
    }

    public void setBloc(BlocDTO bloc) {
        this.bloc = bloc;
    }

    public FiliereDTO getFiliere() {
        return filiere;
    }

    public void setFiliere(FiliereDTO filiere) {
        this.filiere = filiere;
    }
}
