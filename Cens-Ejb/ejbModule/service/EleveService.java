package service;

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Session Bean implementation class EleveService
 */
@Stateless
@LocalBean
//public class EleveService extends EleveService {
public class EleveService {

    @PersistenceContext(unitName = "Cens-Jpa")
    EntityManager entityManager;

    /**
     * FIND ALL ELEMENTS METHODE WITH PARAMETER QUERY findAll
     *
     * @see Eleve
     */
    @SuppressWarnings("unchecked")
    public List<Eleve> findAll() {
        try {
            return entityManager.createNamedQuery("Eleve.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * FIND ALL ELEMENTS METHODE WITH PARAMETER QUERY findAll
     *
     * @see Eleve
     */
    @SuppressWarnings("unchecked")
    public JSONObject JSON_findAll() {
        try {
            List<Eleve> listeEleves = entityManager.createNamedQuery("Eleve.findAll").getResultList();
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            if (listeEleves != null) {
                for (Eleve p : listeEleves) {
                    jsonArray.put(convertToJson(p));
                }
                jsonObject.put("eleves", jsonArray);
            } else {
                jsonObject.put("eleves", "null");
            }

            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param eleveId : Id du eleve recherché
     */
    public Eleve findOne(Integer eleveId) {
        try {
            return entityManager.find(Eleve.class, eleveId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * FIND ONE ELEMENT METHODE WITH NATIVE JPA METHODE
     *
     * @param eleveId : Id du eleve recherché
     */
    public JSONObject JSON_findOne(Integer eleveId) {
        Eleve eleve = findOne(eleveId);
        JSONObject jsonObject = new JSONObject();

        if (eleve != null) {
            jsonObject.put("eleve", convertToJson(eleve));
        } else {
            jsonObject.put("eleve", "null");
        }
        return jsonObject;

    }

    /**
     * DELETE METHODE WITH NATIVE JPA METHODE
     *
     * @param eleveId : Id de eleve
     */
    public boolean delete(Integer eleveId) {
        try {
            Eleve result = entityManager.find(Eleve.class, eleveId);
            if (result != null) {
                // OK FONCTIONNE
                while (result.getBilans().isEmpty() == false) {
                    result.removeBilan(result.getBilans().get(0));
                }
                entityManager.createNamedQuery("Eleve.deleteEtudier").setParameter("idd", eleveId).executeUpdate();
                entityManager.createNamedQuery("Eleve.deleteEvaluer").setParameter("idd", eleveId).executeUpdate();
                entityManager.createNamedQuery("Eleve.deleteBilan").setParameter("idd", eleveId).executeUpdate();

                entityManager.remove(result);
            }
            return true;
        } catch (Exception e) {
            System.err.print(e);
            e.printStackTrace();
            return false;
        }
    }

    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param eleve : Object de type Eleve (de la classe)
     */
    public boolean insert(Eleve eleve) {
        try {
            entityManager.persist(eleve);
            //System.out.println("ID inséré = " + eleve.getEleveId());
            return true;
        } catch (Exception e) {
            System.err.print(e);
            e.printStackTrace();
            return false;
        }

    }

    /**
     * INSERT METHODE WITH NATIVE JPA METHODE
     *
     * @param eleve : Object de type JSON eleve
     */
    public boolean JSON_insert(JSONObject eleve) {
        try {
            if (eleve.has("id") && !eleve.isNull("id")) {
                eleve.remove("id");
            }

            entityManager.persist(convertToObject(eleve));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param eleve : Object de type Eleve (de la classe)
     */
    public boolean update(Eleve eleve) {
        try {
            entityManager.merge(eleve);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * UPDATE METHODE WITH NATIVE JPA METHODE
     *
     * @param eleve : Object de type Eleve (de la classe)
     */
    public boolean JSON_update(JSONObject eleve) {
        try {
            entityManager.merge(convertToObject(eleve));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public void findHierarchiePedagogique(Integer eleveId) {
        Eleve eleve = entityManager.find(Eleve.class, eleveId);
        for (Classroom elem1 : findClassrooms(eleve)) {
            System.out.println("classe : " + elem1.getClassroomLibelle());
            for (Bloc elem2 : findBlocs(elem1)) {
                System.out.println("     Bloc de la classe " + elem2.getBlocLibelle());
                for (Matiere elem3 : findMatiere(elem2)) {
                    System.out.println("        matiere  :" + elem3.getMatiereLibelle());
                    for (ComCap elem4 : findCompetences(elem3)) {
                        System.out.println("           competence " + elem4.getComCapLibelle());
                        for (ComCap elem5 : findCapacitees(elem4)) {
                            System.out.println("                Capacite " + elem5.getComCapLibelle());
                        }
                    }
                }
            }
        }
    }

    public JSONObject JSON_findHierarchiePedagogique(Integer eleveId) {
        Eleve eleve = entityManager.find(Eleve.class, eleveId);
        JSONObject resultJson = new JSONObject();

        JSONArray classeListJson = new JSONArray();

        for (Classroom classroom : findClassrooms(eleve)) {
            System.out.println("classe : " + classroom.getClassroomLibelle());

            JSONObject classeEntityJson = new JSONObject();
            classeEntityJson.put("id", classroom.getClassroomId());
            classeEntityJson.put("libelle", classroom.getClassroomLibelle());
            classeEntityJson.put("filiere", classroom.getFiliere().getFiliereLibelle());
            classeEntityJson.put("niveau", classroom.getNiveau().getNiveauLibelle());
            classeEntityJson.put("manager", classroom.getEmploye().getPersonneNom() + "" + classroom.getEmploye().getPersonnePrenom());

            JSONArray blocListJson = new JSONArray();

            for (Bloc bloc : findBlocs(classroom)) {
                System.out.println("     Bloc de la classe " + bloc.getBlocLibelle());

                JSONObject blocEntityJson = new JSONObject();
                blocEntityJson.put("id", bloc.getBlocId());
                blocEntityJson.put("libelle", bloc.getBlocLibelle());

                JSONArray matiereListJson = new JSONArray();
                for (Matiere matiere : findMatiere(bloc)) {
                    System.out.println("        matiere  :" + matiere.getMatiereLibelle());

                    JSONObject matiereEntityJson = new JSONObject();
                    matiereEntityJson.put("id", matiere.getMatiereId());
                    matiereEntityJson.put("libelle", matiere.getMatiereLibelle());

                    // Remplissage des competences par matieres
                    JSONArray competenceListJson = new JSONArray();
                    for (ComCap competence : findCompetences(matiere)) {
                        System.out.println("           competence " + competence.getComCapLibelle());

                        JSONObject competenceEntityJson = new JSONObject();
                        competenceEntityJson.put("id", competence.getComCapId());
                        competenceEntityJson.put("libelle", competence.getComCapLibelle());

                        // Remplissage des capacitées pour chaque competences
                        JSONArray capaciteListJson = new JSONArray();
                        for (ComCap capacite : findCapacitees(competence)) {
                            System.out.println("                Capacite " + capacite.getComCapLibelle());

                            JSONObject capaciteEntityJson = new JSONObject();
                            capaciteEntityJson.put("id", capacite.getComCapId());
                            capaciteEntityJson.put("libelle", capacite.getComCapLibelle());
                            capaciteListJson.put(capaciteEntityJson);
                        }
                        competenceEntityJson.put("capacite", capaciteListJson);
                        competenceListJson.put(competenceEntityJson);
                    }
                    matiereEntityJson.put("competence", competenceListJson);
                    matiereListJson.put(matiereEntityJson);
                }
                blocEntityJson.put("matiere", matiereListJson);
                blocListJson.put(blocEntityJson);
                System.out.println(blocListJson);
            }
            System.out.println(blocListJson);
            classeEntityJson.put("bloc", blocListJson);
            classeListJson.put(classeEntityJson);
        }
        return resultJson.put("classe", classeListJson);
    }

    public List<Classroom> findClassrooms(Eleve eleve) {
        List<Classroom> classrooms = new ArrayList<>();
        // Boucle sur les classrooms
        for (AssocEtudier classroom : eleve.getAssocEtudiers()) {
            // => Affiche les classe de l'étudiant
//            System.out.println("Eleve classe : " + classroom.getClassroom().getClassroomLibelle());
            classrooms.add(classroom.getClassroom());
        }
        return classrooms;
    }

    public List<Bloc> findBlocs(Classroom classroom) {
        List<Bloc> blocs = new ArrayList<>();
        // Boucle sur Bloc de chaque années étudiées
        for (AssocFiliereBloc bloc : classroom.getFiliere().getAssocFiliereBlocs()) {
            // => Affiche les blocs
//            System.out.println("   Bloc de la classe " + bloc.getBloc().getBlocLibelle());
            blocs.add(bloc.getBloc());
        }
        return blocs;
    }

    public List<Matiere> findMatiere(Bloc bloc) {
        List<Matiere> matieres = new ArrayList<>();
        //Boucle sur matière des blocs
        for (Matiere matiere : bloc.getMatieres()) {
            // => Affiche les matieres
//            System.out.println("       matieres du bloc : " + matiere.getMatiereId() + " " + matiere.getMatiereLibelle());
            matieres.add(matiere);
        }
        return matieres;
    }

    public List<ComCap> findCompetences(Matiere matiere) {
        List<ComCap> competences = new ArrayList<>();
        //boucle d'association Matière vers compétences
        for (AssocMatiereComCap competence : matiere.getAssocMatiereComCaps()) {
            // => Affiche les compétences
//            System.out.println("             Competence " + competence.getComCap().getComCapId() + " " + competence.getComCap().getComCapLibelle());
            competences.add(competence.getComCap());
        }
        return competences;

    }

    public List<ComCap> findCapacitees(ComCap competence) {
        List<ComCap> capacitees = new ArrayList<>();
        // Boucle sur les capacités de la compétence
        for (AssocComCap capacite : competence.getAssocComCaps2()) {
            // => Affiche les capacités
//            System.out.println("                  ComCap1 : " + capacite.getComCap1().getComCapLibelle());
            capacitees.add(capacite.getComCap1());
        }
        return capacitees;
    }


    public void BouclesDeLaMortOk(Integer eleveId) {
        Eleve eleve = entityManager.find(Eleve.class, eleveId);
//
//        for (AssocEtudier elem : eleve.getAssocEtudiers()) {
//            // => Affiche les classe de l'étudiant
//            System.out.println("Eleve classe : " + elem.getClassroom().getClassroomLibelle());
//            // Boucle sur Bloc de chaque années étudiées
//            for (AssocFiliereBloc bloc : elem.getClassroom().getFiliere().getAssocFiliereBlocs()) {
//                // => Affiche les blocs
//                System.out.println("   Bloc de la classe " + bloc.getBloc().getBlocLibelle());
//                //Boucle sur matière des blocs
//                for (Matiere matiere : bloc.getBloc().getMatieres()) {
//                    // => Affiche les matieres
//                    System.out.println("       matieres du bloc : " + matiere.getMatiereId() + " " + matiere.getMatiereLibelle());
//                    //boucle d'association Matière vers compétences
//                    for (AssocMatiereComCap elem2 : matiere.getAssocMatiereComCaps()) {
//                        // => Affiche les compétences
//                        System.out.println("             Competence " + elem2.getComCap().getComCapId() + " " + elem2.getComCap().getComCapLibelle());
//
//                        // Boucle sur les capacités de la compétence
//                        for (AssocComCap elem3 : elem2.getComCap().getAssocComCaps2()) {
//                            // => Affiche les capacités
//                            System.out.println("                  ComCap1 : " + elem3.getComCap1().getComCapLibelle());
////                            System.out.println("                  ComCap2 : " + elem3.getComCap2().getComCapLibelle()); //Raffiche la compétence liée
//                        }
//                    }
//                }
//            }
//
//        }

    }

    /**
     * PERMET DE CONVERTIR UN OBJECT JAVA EN OBJECT JSON
     *
     * @param p de type Eleve
     * @return JSONObject
     */
    private JSONObject convertToJson(Eleve p) {
        JSONObject detailsJson = new JSONObject();
        JSONObject groupeJson = new JSONObject();
        JSONArray classesJson = new JSONArray();


        detailsJson.put("id", p.getPersonneId());
        detailsJson.put("login", p.getPersonneLogin());
        detailsJson.put("password", p.getPersonnePassword());
        detailsJson.put("nom", p.getPersonneNom());
        detailsJson.put("prenom", p.getPersonnePrenom());
        detailsJson.put("dateNaissance", p.getPersonneDateNaissance());
        detailsJson.put("adresse", p.getPersonneAdresse());
        detailsJson.put("cp", p.getPersonneCp());
        detailsJson.put("ville", p.getPersonneVille());
        detailsJson.put("emailParent", p.getEleveEmailParent());

        groupeJson.put("id", p.getGroupe().getGroupeId());
        groupeJson.put("libelle", p.getGroupe().getGroupeLibelle());
        groupeJson.put("access", p.getGroupe().getGroupeNiveauAcces());
        detailsJson.put("groupe", groupeJson); // Json in Json

        // Boucle sur les classes de l'élève : 2sd 1er Term...
        for (AssocEtudier elem : p.getAssocEtudiers()) {
            JSONObject classeJson = new JSONObject();
            classeJson.put("id", elem.getClassroom().getClassroomId());
            classeJson.put("libelle", elem.getClassroom().getClassroomLibelle());
            classeJson.put("niveau", elem.getClassroom().getNiveau().getNiveauLibelle());
            classeJson.put("filiere", elem.getClassroom().getFiliere().getFiliereLibelle());
            classeJson.put("manager", elem.getClassroom().getEmploye().getPersonneNom());
            classesJson.put(classeJson);
        }
        detailsJson.put("classes", classesJson);
        return detailsJson;
    }

    /**
     * CONVERTIR UN OBJ JSON EN OBJ JAVA
     * <p>
     * Attention l'ID du groupe est OBLIGATOIRE
     *
     * @param eleve
     * @return un Eleve
     */
    private Eleve convertToObject(JSONObject eleve) {
        Eleve result = new Eleve();
        Groupe groupe;

        result.setPersonneLogin(eleve.getString("login"));
        result.setPersonnePassword(eleve.getString("password"));
        result.setPersonneNom(eleve.getString("nom"));
        result.setPersonnePrenom(eleve.getString("prenom"));

        //****** Traitement des champs pouvant être NULL *****
        // Si le champs existe dans l'object JSON

        if (eleve.has("id") && !eleve.isNull("id")) {
            result.setPersonneId(eleve.getInt("id"));
        }

        if (eleve.has("dateNaissance") && !eleve.isNull("dateNaissance")) {
            DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
            String dateAsString = eleve.getString("dateNaissance");
            Date date = null;
            try {
                date = sourceFormat.parse(dateAsString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            result.setPersonneDateNaissance(date);
        }
        if (eleve.has("adresse") && !eleve.isNull("adresse")) {
            result.setPersonneAdresse(eleve.getString("adresse"));
        }
        if (eleve.has("cp") && !eleve.isNull("cp")) {
            result.setPersonneCp(eleve.getString("cp"));
        }
        if (eleve.has("ville") && !eleve.isNull("ville")) {
            result.setPersonneVille(eleve.getString("ville"));
        }
        if (eleve.has("emailParent") && !eleve.isNull("emailParent")) {
            result.setEleveEmailParent(eleve.getString("emailParent"));
        }

        // Consulter entityManger pour retrouver le groupe dans UP
        try {
            groupe = entityManager.find(Groupe.class, eleve.getInt("groupeId"));
            result.setGroupe(groupe);
        } catch (Exception e) {
            e.printStackTrace();
            // Si le groupe est introuvable on stop la methode = ERREUR fatal
            return null;
        }

        return result;
    }
}
