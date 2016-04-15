package tests;


import mapDtoJpa.mappable.FiliereMapper;
import mapDtoJpa.mappable.VoieMapper;
import service.*;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/TestPersonne")
public class TestPersonne extends HttpServlet {
    private static final long serialVersionUID = 1L;

   /* @EJB
    PersonneService personneService;
    @EJB
    EmployeService employeService;
    @EJB
    EleveService eleveService;
    @EJB
    GroupeService groupeService;

    @Inject
    private VoieMapper voieMapper;
    @EJB
    VoieService voieService;
    @Inject
    private FiliereMapper filiereMapper;
    @EJB
    FiliereService filiereService;*/

    public TestPersonne() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //eleveService.delete(8);
        //TEST VOIE VERS FILIERE
//        List<Voie> voieJ = voieService.findAll();
//        List<VoieDTO> voieD = voieMapper.mapFromEntity(voieJ);
//
//        for (VoieDTO eleme : voieD) {
//            System.out.println("voie liebl :" + eleme.getVoieLibelle());
//            for (FiliereDTO elem2 : eleme.getFilieres()) {
//                System.out.println("filiere de la voie  : " + elem2.getFiliereLibelle());
//            }
//        }
//
//        System.out.println("==========================================");
//
//        //TEST FILIERE VERS VOIE
//        List<Filiere> filJ = filiereService.findAll();
//        List<FiliereDTO> filD = filiereMapper.mapFromEntity(filJ);
//
//        for (FiliereDTO elm1 : filD) {
//            System.out.println("Filiere libel : " + elm1.getFiliereLibelle());
//            System.out.println("voie de la filliere : du type voie " + elm1.getVoie());
//        }
//

        // Liste des personnes
//        List<Personne> desPersonnes = eleveService.findAll();
//        for (Personne hop : desPersonnes) {
//            System.out.println(hop.getPersonneId());
//        }


        // Trouver une personne avec son login et pass
//        Personne az = new Eleve();
//        az = personneService.findOne(2);
//        System.out.println(az.getPersonneLogin());

//        Groupe groupe = groupeService.findOne(3);

//        System.out.println("depuis test" + az.getPersonneNom());
//        eleve = (Eleve) az;
//        eleve.setEleveEmailParent("parentEmail2");
//        eleve.setGroupe(groupe);
//        eleve.setPersonneNom("elev2Java");
//        eleveService.insert(eleve);

        // Trouver le groupe d'un utilisateur
//        Groupe groupe = new Groupe();
//        groupe = az.getGroupe();
//        System.out.println(groupe.getGroupeLibelle());

        request.getRequestDispatcher("/WEB-INF/tags/exemple.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
