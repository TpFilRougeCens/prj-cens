package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the niveau database table.
 */
@Entity
@NamedQuery(name = "Niveau.findAll", query = "SELECT n FROM Niveau n")
public class Niveau implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "niveau_id")
    private Integer niveauId;

    @Column(name = "niveau_libelle")
    private String niveauLibelle;

    //bi-directional many-to-one association to Classroom
    @OneToMany(mappedBy = "niveau", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Classroom> classrooms;

    public Niveau() {
    }

    public Integer getNiveauId() {
        return this.niveauId;
    }

    private void setNiveauId(Integer niveauId) {
        this.niveauId = niveauId;
    }

    public String getNiveauLibelle() {
        return this.niveauLibelle;
    }

    public void setNiveauLibelle(String niveauLibelle) {
        this.niveauLibelle = niveauLibelle;
    }

    public List<Classroom> getClassrooms() {
        return this.classrooms;
    }

    public void setClassrooms(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    public Classroom addClassroom(Classroom classroom) {
        getClassrooms().add(classroom);
        classroom.setNiveau(this);

        return classroom;
    }

    public Classroom removeClassroom(Classroom classroom) {
        getClassrooms().remove(classroom);
        classroom.setNiveau(null);

        return classroom;
    }

}