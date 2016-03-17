package model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the assoc_filiere_bloc database table.
 */
@Entity
@Table(name = "assoc_filiere_bloc")
@NamedQuery(name = "AssocFiliereBloc.findAll", query = "SELECT a FROM AssocFiliereBloc a")
public class AssocFiliereBloc implements Serializable {
    private static final long serialVersionUID = 1L;

    //TODO : verifier EnbeddedId sur cette object
    //Supression? => pas de contrainte d'unicité entre les filiere et bloc?
    //	@EmbeddedId
//	private AssocFiliereBlocPK id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assoc_filiere_bloc_id")
    private Integer assocFiliereBlocId;

    //bi-directional many-to-one association to Bloc
    @ManyToOne
    @JoinColumn(name = "assoc_filiere_bloc_fk_bloc_id")
    private Bloc bloc;

    //bi-directional many-to-one association to Filiere
    @ManyToOne
    @JoinColumn(name = "assoc_filiere_bloc_fk_filiere_id")
    private Filiere filiere;

    public AssocFiliereBloc() {
    }

//	public AssocFiliereBlocPK getId() {
//		return this.id;
//	}

//	public void setId(AssocFiliereBlocPK id) {
//		this.id = id;
//	}

    public Integer getAssocFiliereBlocId() {
        return this.assocFiliereBlocId;
    }

    public void setAssocFiliereBlocId(Integer assocFiliereBlocId) {
        this.assocFiliereBlocId = assocFiliereBlocId;
    }

    public Bloc getBloc() {
        return this.bloc;
    }

    public void setBloc(Bloc bloc) {
        this.bloc = bloc;
    }

    public Filiere getFiliere() {
        return this.filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

}