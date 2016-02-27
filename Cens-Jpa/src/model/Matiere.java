package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the matiere database table.
 */
@Entity
@NamedQuery(name = "Matiere.findAll", query = "SELECT m FROM Matiere m")
public class Matiere implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matiere_id")
    private Integer matiereId;

    @Column(name = "matiere_libelle")
    private String matiereLibelle;

    //bi-directional many-to-one association to AssocEnseigner
    @OneToMany(mappedBy = "matiere", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<AssocEnseigner> assocEnseigners;

    //bi-directional many-to-one association to AssocMatiereComCap
    @OneToMany(mappedBy = "matiere", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<AssocMatiereComCap> assocMatiereComCaps;

    //bi-directional many-to-one association to Bloc
    @ManyToOne
    @JoinColumn(name = "matiere_fk_bloc_id")
    private Bloc bloc;

    public Matiere() {
    }

    public Integer getMatiereId() {
        return this.matiereId;
    }

    private void setMatiereId(Integer matiereId) {
        this.matiereId = matiereId;
    }

    public String getMatiereLibelle() {
        return this.matiereLibelle;
    }

    public void setMatiereLibelle(String matiereLibelle) {
        this.matiereLibelle = matiereLibelle;
    }

    public List<AssocEnseigner> getAssocEnseigners() {
        return this.assocEnseigners;
    }

    public void setAssocEnseigners(List<AssocEnseigner> assocEnseigners) {
        this.assocEnseigners = assocEnseigners;
    }

    public AssocEnseigner addAssocEnseigner(AssocEnseigner assocEnseigner) {
        getAssocEnseigners().add(assocEnseigner);
        assocEnseigner.setMatiere(this);

        return assocEnseigner;
    }

    public AssocEnseigner removeAssocEnseigner(AssocEnseigner assocEnseigner) {
        getAssocEnseigners().remove(assocEnseigner);
        assocEnseigner.setMatiere(null);

        return assocEnseigner;
    }

    public List<AssocMatiereComCap> getAssocMatiereComCaps() {
        return this.assocMatiereComCaps;
    }

    public void setAssocMatiereComCaps(List<AssocMatiereComCap> assocMatiereComCaps) {
        this.assocMatiereComCaps = assocMatiereComCaps;
    }

    public AssocMatiereComCap addAssocMatiereComCap(AssocMatiereComCap assocMatiereComCap) {
        getAssocMatiereComCaps().add(assocMatiereComCap);
        assocMatiereComCap.setMatiere(this);

        return assocMatiereComCap;
    }

    public AssocMatiereComCap removeAssocMatiereComCap(AssocMatiereComCap assocMatiereComCap) {
        getAssocMatiereComCaps().remove(assocMatiereComCap);
        assocMatiereComCap.setMatiere(null);

        return assocMatiereComCap;
    }

    public Bloc getBloc() {
        return this.bloc;
    }

    public void setBloc(Bloc bloc) {
        this.bloc = bloc;
    }

}