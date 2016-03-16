package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the filiere database table.
 */
@Entity
@NamedQuery(name = "Filiere.findAll", query = "SELECT f FROM Filiere f")
public class Filiere implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "filiere_id")
    private Integer filiereId;

    @Column(name = "filiere_libelle")
    private String filiereLibelle;

    //bi-directional many-to-one association to AssocFiliereBloc
    @OneToMany(mappedBy = "filiere", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<AssocFiliereBloc> assocFiliereBlocs;

    //bi-directional many-to-one association to Classroom
    @OneToMany(mappedBy = "filiere", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Classroom> classrooms;

    //bi-directional many-to-one association to Voie
    @ManyToOne
    @JoinColumn(name = "filiere_fk_voie_id")
    private Voie voie;

    public Filiere() {
    }

    public Integer getFiliereId() {
        return this.filiereId;
    }

    public void setFiliereId(Integer filiereId) {
        this.filiereId = filiereId;
    }

    public String getFiliereLibelle() {
        return this.filiereLibelle;
    }

    public void setFiliereLibelle(String filiereLibelle) {
        this.filiereLibelle = filiereLibelle;
    }

    public List<AssocFiliereBloc> getAssocFiliereBlocs() {
        return this.assocFiliereBlocs;
    }

    public void setAssocFiliereBlocs(List<AssocFiliereBloc> assocFiliereBlocs) {
        this.assocFiliereBlocs = assocFiliereBlocs;
    }

    public AssocFiliereBloc addAssocFiliereBloc(AssocFiliereBloc assocFiliereBloc) {
        getAssocFiliereBlocs().add(assocFiliereBloc);
        assocFiliereBloc.setFiliere(this);

        return assocFiliereBloc;
    }

    public AssocFiliereBloc removeAssocFiliereBloc(AssocFiliereBloc assocFiliereBloc) {
        getAssocFiliereBlocs().remove(assocFiliereBloc);
        assocFiliereBloc.setFiliere(null);

        return assocFiliereBloc;
    }

    public List<Classroom> getClassrooms() {
        return this.classrooms;
    }

    public void setClassrooms(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    public Classroom addClassroom(Classroom classroom) {
        getClassrooms().add(classroom);
        classroom.setFiliere(this);

        return classroom;
    }

    public Classroom removeClassroom(Classroom classroom) {
        getClassrooms().remove(classroom);
        classroom.setFiliere(null);

        return classroom;
    }

    public Voie getVoie() {
        return this.voie;
    }

    public void setVoie(Voie voie) {
        this.voie = voie;
    }

}