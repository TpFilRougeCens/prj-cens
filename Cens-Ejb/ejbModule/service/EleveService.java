package service;

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;
import service.util.EncryptPassword;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
     * RETOURNE UN ELEVE SI CELLE CI EST CONNUE
     *
     * @param login    : login utilisateur qui demande une connexion
     * @param password : mot de passe tentative
     */
    public Eleve findOne(String login, String password) {
        try {
            System.out.println("valeur de eleve dans service ");
            Eleve eleve = (Eleve) entityManager
                    .createNamedQuery("Eleve.findByNameAndPassWord")
                    .setParameter("loginn", login)
                    .setParameter("passwordd", password)
                    .getSingleResult();
            System.out.println("valeur de eleve dans service " + eleve);
            return eleve;

        } catch (NoResultException e) {
            System.out.println("Eleve : FindOne : Pas de resultat");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * RETOURNE UN ELEVE SI CELLE CI EST CONNUE
     *
     * @param login : login utilisateur qui demande une connexion
     */
    public Eleve findOne(String login) {
        try {
            System.out.println("valeur de eleve dans service ");
            Eleve eleve = (Eleve) entityManager
                    .createNamedQuery("Eleve.findByLogin")
                    .setParameter("loginn", login)
                    .getSingleResult();
            System.out.println("valeur de eleve dans service " + eleve);
            return eleve;

        } catch (NoResultException e) {
            System.out.println("Eleve : FindOne : Pas de resultat");
            return null;
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
     * DELETE METHODE D'UNE EVALUATION WITH NATIVE JPA METHODE
     *
     * @param evaluationId : Id de l'évaluation de l'élève
     */
    public boolean deleteEvaluation(Integer evaluationId) {
        try {
            entityManager.createNamedQuery("Eleve.deleteEvaluerById").setParameter("idd", evaluationId).executeUpdate();
            return true;
        } catch (Exception e) {
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
            String passNoCrypt = eleve.getPersonnePassword();
            String passYesCrypt = new EncryptPassword().encrypt(passNoCrypt);
            eleve.setPersonnePassword(passYesCrypt);
            entityManager.persist(eleve);
            return true;
        } catch (Exception e) {
            System.err.print(e);
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
            Eleve eleveJPA = entityManager.find(Eleve.class, eleve.getPersonneId());
            if (!eleve.getPersonnePassword().equals(eleveJPA.getPersonnePassword())) {
                String passEncryt = new EncryptPassword().encrypt(eleve.getPersonnePassword());
                eleve.setPersonnePassword(passEncryt);
            }
            entityManager.merge(eleve);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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
            List<Eleve> listeEleves = findAll();
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
     * FIND BILAN DE L'ELEVE
     *
     * @param eleveId : Id du eleve recherché
     */
    public JSONObject JSON_findBilan(Integer eleveId) {
        Eleve eleve = findOne(eleveId);
        JSONArray jsonBilans = new JSONArray();
        JSONArray jsonEvals = new JSONArray();
        JSONArray jsonNotes = new JSONArray();
        JSONObject jsonResult = new JSONObject();

        //TODO REVOIR BDD SUR BILAN
        for (Bilan bilan : eleve.getBilans()) {
            JSONObject jsonBilan = new JSONObject();
            jsonBilan.put("id", bilan.getBilanId());
            jsonBilan.put("libelle", bilan.getBilanLibelle());
            jsonBilan.put("dateDebut", bilan.getBilanDateDebut());
            jsonBilan.put("dateFin", bilan.getBilanDateFin());
            jsonBilan.put("commentaire", bilan.getBilanCommentaire());

            JSONObject jsonEval = JSON_findHierarchiePedagogique(eleveId, "date", bilan.getBilanDateDebut().toString(), bilan.getBilanDateFin().toString());
            jsonBilan.put("evaluations", jsonEval);

            jsonBilans.put(jsonBilan);
        }

        jsonResult.put("bilans", jsonBilans);

        //Legende pour les notations
        for (Note note : entityManager.createNamedQuery("Note.findAll", Note.class).getResultList()) {
            JSONObject jsonNote = new JSONObject();
            if (note.getNoteActive() && !note.getNoteAbvr().equals("")) {
                jsonNote.put("abvr", note.getNoteAbvr());
                jsonNote.put("libelle", note.getNoteLibelle());
                jsonNote.put("couleur", note.getNoteCouleur());
                jsonNotes.put(jsonNote);
            }
        }
        jsonResult.put("bilans", jsonBilans);
        jsonResult.put("legende", jsonNotes);
        return jsonResult;

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
            return insert(convertToObject(eleve));
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
            return update(convertToObject(eleve));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * INSERT D'UNE EVALUATION
     * <p>
     * METHODE WITH NATIVE JPA METHODE
     *
     * @param evaluation : Object de type JSON evaluation
     */
    public boolean JSON_insertEval(JSONObject evaluation) {
        try {
            // Supression de l'id pour une méthode POST
            if (evaluation.has("id") && !evaluation.isNull("id")) {
                evaluation.remove("id");
            }
            entityManager.persist(convertToObjectEval(evaluation));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * INSERT D'UNE EVALUATION
     * <p>
     * METHODE WITH NATIVE JPA METHODE
     *
     * @param evaluation : Object de type JSON evaluation
     */
    public boolean JSON_updateEval(JSONObject evaluation) {
        try {
            entityManager.merge(convertToObjectEval(evaluation));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Ne pas utiliser en prod. cette méthode permet le debuguage exclusivement
     *
     * @param eleveId de type Integer
     */
    public void CONSOLE_findHierarchiePedagogique(Integer eleveId) {
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

    /**
     * @param eleveId de type Integer
     * @return un Json avec la hierarchie complète de la classe
     * de l'élève jusqu'aux évaluations
     */
    public JSONObject JSON_findHierarchiePedagogique(Integer eleveId, String... filtre) {
        Eleve eleve = entityManager.find(Eleve.class, eleveId);
        JSONObject resultJson = new JSONObject();

        JSONArray classeListJson = new JSONArray();

        for (Classroom classroom : findClassrooms(eleve)) {
            //System.out.println("classe : " + classroom.getClassroomLibelle());

            JSONObject classeEntityJson = new JSONObject();
            classeEntityJson.put("id", classroom.getClassroomId());
            classeEntityJson.put("libelle", classroom.getClassroomLibelle());
            classeEntityJson.put("filiere", classroom.getFiliere().getFiliereLibelle());
            classeEntityJson.put("niveau", classroom.getNiveau().getNiveauLibelle());
            classeEntityJson.put("manager", classroom.getEmploye().getPersonneNom() + "" + classroom.getEmploye().getPersonnePrenom());

            JSONArray blocListJson = new JSONArray();

            for (Bloc bloc : findBlocs(classroom)) {
                //System.out.println("     Bloc de la classe " + bloc.getBlocLibelle());

                JSONObject blocEntityJson = new JSONObject();
                blocEntityJson.put("id", bloc.getBlocId());
                blocEntityJson.put("libelle", bloc.getBlocLibelle());

                JSONArray matiereListJson = new JSONArray();
                for (Matiere matiere : findMatiere(bloc)) {
                    //System.out.println("        matiere  :" + matiere.getMatiereLibelle());

                    JSONObject matiereEntityJson = new JSONObject();
                    matiereEntityJson.put("id", matiere.getMatiereId());
                    matiereEntityJson.put("libelle", matiere.getMatiereLibelle());

                    // Remplissage des competences par matieres
                    JSONArray competenceListJson = new JSONArray();
                    for (ComCap competence : findCompetences(matiere)) {
                        //System.out.println("           competence " + competence.getComCapLibelle());

                        JSONObject competenceEntityJson = new JSONObject();
                        competenceEntityJson.put("id", competence.getComCapId());
                        competenceEntityJson.put("libelle", competence.getComCapLibelle());

                        // Remplissage des capacitées pour chaque competences
                        JSONArray capaciteListJson = new JSONArray();
                        for (ComCap capacite : findCapacitees(competence)) {
                            //System.out.println("                Capacite " + capacite.getComCapLibelle());

                            JSONObject capaciteEntityJson = new JSONObject();
                            capaciteEntityJson.put("id", capacite.getComCapId());
                            capaciteEntityJson.put("libelle", capacite.getComCapLibelle());

                            // Remplissage des évaluations de la capacite
                            JSONArray evaluationListJson = new JSONArray();
                            for (AssocEvaluer evaluation : findEvaluation(capacite)) {

                                //filtre SI ne contient pas de filtrre date
                                if (filtre[0] != null && filtre[0].equals("date")) {
                                    System.out.println("passe dans le filtrre de date");
                                    DateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.FRENCH);
                                    Date dateEval = evaluation.getAssocEvaluerDateEvaluation();
                                    Date dateDebut;
                                    Date dateFin;
                                    try {
                                        dateDebut = sourceFormat.parse(filtre[1]);
                                        dateFin = sourceFormat.parse(filtre[2]);

                                        if (dateEval.after(dateDebut) && dateEval.before(dateFin)) {
                                            evaluationListJson.put(convertToJsonEval(evaluation));
                                        }

                                    } catch (ParseException e) {
                                        // problème de format dans les dates stockés dans Bilan
                                        System.out.println("Problème sur le format de date en base Vs Java");
                                        e.printStackTrace();
                                        return null;
                                    }

                                } else {
                                    // LPC COMPLET
                                    evaluationListJson.put(convertToJsonEval(evaluation));
                                }
                            }
                            capaciteEntityJson.put("evaluation", evaluationListJson);
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
            }
            classeEntityJson.put("bloc", blocListJson);
            classeListJson.put(classeEntityJson);
        }
        return resultJson.put("classe", classeListJson);
    }


    /**
     * @param eleve de type Eleve
     * @return une liste de classes (2sd, 1er, Term etc...)
     */
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

    /**
     * @param classroom de type Classromm
     * @return une liste des blocs
     */
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

    /**
     * @param bloc de type Bloc
     * @return Une liste de matières
     */
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

    /**
     * @param matiere de type Matiere
     * @return une liste de compétencces
     */
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

    /**
     * @param competence de type ComCap
     * @return liste de Capacitées
     */
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

    /**
     * @param capacite de type ComCap
     * @return liste d'evaluations
     */
    public List<AssocEvaluer> findEvaluation(ComCap capacite) {
        List<AssocEvaluer> evaluations = new ArrayList<>();
        // Boucle sur les evaluations des capacites
        for (AssocEvaluer evaluation : capacite.getAssocEvaluers()) {
            evaluations.add(evaluation);
        }
        return evaluations;
    }

    // MAPPER CONVERTION JSON / OBJ

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
            DateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.FRENCH);
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

    /**
     * CONVERTIR UN OBJ JSON EN OBJ JAVA ASSOCEVALUER
     * <p>
     * Attention des FK_ID sont obligatoire
     *
     * @param eval
     * @return un Eleve
     */
    private AssocEvaluer convertToObjectEval(JSONObject eval) {
        AssocEvaluer result = new AssocEvaluer();
        Employe enseignant;
        Eleve eleve;
        ComCap capacite;
        Note evalEnseignant;
        Note evalEleve;

        if (eval.has("id") && !eval.isNull("id")) {
            result.setAssocEvaluerId(eval.getInt("id"));
        }

        try {
            enseignant = entityManager.find(Employe.class, eval.getInt("enseignant"));
            result.setEmploye(enseignant);
            eleve = entityManager.find(Eleve.class, eval.getInt("eleve"));
            result.setEleve(eleve);
            capacite = entityManager.find(ComCap.class, eval.getInt("capacite"));
            result.setComCap(capacite);

            // Si l'évaluation de l'enseignant est faite on récupère SINON on attribut la Note 1 = Non noté
            if (eval.has("evalEnseignant") && !eval.isNull("evalEnseignant")) {
                evalEnseignant = entityManager.find(Note.class, eval.getInt("evalEnseignant"));
            } else {
                evalEnseignant = entityManager.find(Note.class, 1);
            }
            result.setNote1(evalEnseignant);

            if (eval.has("evalEleve") && !eval.isNull("evalEleve")) {
                evalEleve = entityManager.find(Note.class, eval.getInt("evalEleve"));
            } else {
                evalEleve = entityManager.find(Note.class, 1);
            }
            result.setNote2(evalEleve);

            //Convert to Date format
            DateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.FRENCH);
            String dateAsString = eval.getString("date");
            Date date = null;
            date = sourceFormat.parse(dateAsString);
            result.setAssocEvaluerDateEvaluation(date);
        } catch (Exception e) {
            // Si une ref FK non trouvé on stop tout : fatal error
            e.printStackTrace();
            return null;
        }

        if (eval.has("commentaire") && !eval.isNull("commentaire")) {
            result.setAssocEvaluerCommentaire(eval.getString("commentaire"));
        }

        return result;
    }

    private JSONObject convertToJsonEval(AssocEvaluer evaluation) {
        JSONObject evaluationEntityJson = new JSONObject();
        evaluationEntityJson.put("id", evaluation.getAssocEvaluerId());
        evaluationEntityJson.put("date", evaluation.getAssocEvaluerDateEvaluation());

        // Notation de l'enseignant
        JSONObject evalEnsEntityJson = new JSONObject();
        evalEnsEntityJson.put("abvr", evaluation.getNote1().getNoteAbvr());
        evalEnsEntityJson.put("libelle", evaluation.getNote1().getNoteLibelle());
        evalEnsEntityJson.put("couleur", evaluation.getNote1().getNoteCouleur());
        evalEnsEntityJson.put("value", evaluation.getNote1().getNoteValeur());
        evalEnsEntityJson.put("commentaire", evaluation.getAssocEvaluerCommentaire());
        evaluationEntityJson.put("evalEnseignant", evalEnsEntityJson);

        // Notation de l'éleve = Autoevaluation
        JSONObject autoEvalEnsEntityJson = new JSONObject();
        autoEvalEnsEntityJson.put("abvr", evaluation.getNote2().getNoteAbvr());
        autoEvalEnsEntityJson.put("libelle", evaluation.getNote2().getNoteLibelle());
        autoEvalEnsEntityJson.put("couleur", evaluation.getNote2().getNoteCouleur());
        autoEvalEnsEntityJson.put("value", evaluation.getNote2().getNoteValeur());
        evaluationEntityJson.put("evalEleve", autoEvalEnsEntityJson);

        return evaluationEntityJson;
    }
}
