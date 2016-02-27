package model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the assoc_employe_groupe database table.
 */
@Entity
@Table(name = "assoc_employe_groupe")
@NamedQuery(name = "AssocEmployeGroupe.findAll", query = "SELECT a FROM AssocEmployeGroupe a")
public class AssocEmployeGroupe implements Serializable {
    private static final long serialVersionUID = 1L;

    	@EmbeddedId
	private AssocEmployeGroupePK id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assoc_employe_groupe_id")
    private Integer assocEmployeGroupeId;

    //bi-directional many-to-one association to Employe
    @ManyToOne
    @JoinColumn(name = "assoc_employe_groupe_fk_personne_id")
    private Employe employe;

    //bi-directional many-to-one association to Groupe
    @ManyToOne
    @JoinColumn(name = "assoc_employe_groupe_fk_groupe_id")
    private Groupe groupe;

    public AssocEmployeGroupe() {
    }

    public AssocEmployeGroupePK getId() {
        return this.id;
    }

    public void setId(AssocEmployeGroupePK id) {
        this.id = id;
    }

    public Integer getAssocEmployeGroupeId() {
        return this.assocEmployeGroupeId;
    }

    public void setAssocEmployeGroupeId(Integer assocEmployeGroupeId) {
        this.assocEmployeGroupeId = assocEmployeGroupeId;
    }

    public Employe getEmploye() {
        return this.employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Groupe getGroupe() {
        return this.groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

}