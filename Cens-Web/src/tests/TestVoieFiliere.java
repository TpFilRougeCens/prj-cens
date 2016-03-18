package tests;


import dto.FiliereDTO;
import dto.VoieDTO;
import mapDtoJpa.mappable.FiliereMapper;
import mapDtoJpa.mappable.VoieMapper;
import model.Filiere;
import model.Voie;
import service.FiliereService;
import service.VoieService;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/TestVoieFiliere")
public class TestVoieFiliere extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private VoieMapper voieMapper;
    @EJB
    VoieService voieService;
    @Inject
    private FiliereMapper filiereMapper;
    @EJB
    FiliereService filiereService;

    public TestVoieFiliere() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // *************** TEST JPA VERS DTO ************************
        //TEST VOIE VERS FILIERE
        System.out.println("================== TEST JPA VERS DTO ========================");
        List<Voie> voieJ = voieService.findAll();
        List<VoieDTO> voieD = voieMapper.mapFromEntity(voieJ);

        for (VoieDTO eleme : voieD) {
            System.out.println("voie liebl :" + eleme.getVoieLibelle());
//            System.out.println(eleme.getFilieres());
            for (FiliereDTO elem2 : eleme.getFilieres()) {
                System.out.println("filiere de la voie  : " + elem2.getFiliereLibelle());
            }
        }

        System.out.println("-----------------------------------------------");

        //TEST FILIERE VERS VOIE
        List<Filiere> filJ = filiereService.findAll();
        List<FiliereDTO> filD = filiereMapper.mapFromEntity(filJ);

        for (FiliereDTO elm1 : filD) {
            System.out.println("Filiere libel : " + elm1.getFiliereLibelle());
            for (FiliereDTO elem : elm1.getVoie().getFilieres()) {
                //Ne sert strictement à rien mais permet de vérifier la cohérence du return
                System.out.println("Filliere de la filliere : du type voie " + elem.getFiliereLibelle());
            }
            System.out.println("voie de la filliere : du type voie " + elm1.getVoie().getVoieLibelle());
        }

        // *************** TEST DTO VERS JPA ************************
        System.out.println("================ TEST DTO VERS JPA ==========================");

        //Sans DTO = ok
        Voie voie2 = voieService.findOne(1);
        voie2.setVoieLibelle("depuisJava");
        voieService.update(voie2);

        // TEST FILIERE SANS DTO = ok
        Filiere filT = filiereService.findOne(1);
        filT.setFiliereLibelle("libel depuis java");
        filiereService.update(filT);

        // TEST FILIERE AVEC DTO = ok
        FiliereDTO filDD = filiereMapper.mapFromEntity(filiereService.findOne(1));
        filDD.setFiliereLibelle("TEST DEPUIS DTO");
        filiereService.update(filiereMapper.mapToEntity(filDD));
        // INSERT FILIERE = ok
        filDD.setFiliereId(null);
        filiereService.insert(filiereMapper.mapToEntity(filDD));

        //AVEC DTO = bug
//        VoieDTO voie1 = voieMapper.mapFromEntity(voieService.findOne(1));
//        voie1.setVoieLibelle("marche pas");
//        voieService.update(voieMapper.mapToEntity(voie1));

        request.getRequestDispatcher("/WEB-INF/tags/exemple.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
