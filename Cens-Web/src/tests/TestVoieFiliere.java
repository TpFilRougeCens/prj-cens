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

//    @Inject
//    private VoieMapper voieMapper;
//    @EJB
//    VoieService voieService;
//    @Inject
//    private FiliereMapper filiereMapper;
//    @EJB
//    FiliereService filiereService;

    public TestVoieFiliere() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //TEST DOZER MAPPER SINGLETON + MapperPerso en XML
        /*Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        Voie sourceObjet = voieService.findOne(2);
        VoieDTO destObject = new VoieDTO();
        mapper.map(sourceObjet, destObject);

        System.out.println("DOZER UNE VOIE " + destObject.getVoieLibelle());

        for (FiliereDTO elmmmmm : destObject.getFilieres()) {
            System.out.println("DOZER VOIE -> Filiere : " + elmmmmm.getFiliereLibelle());
        }

        destObject.setVoieLibelle("Voie2 depuis DOZER");
        mapper.map(destObject, sourceObjet);
        System.out.println("source : " + sourceObjet.getVoieLibelle());
        voieService.update(sourceObjet);*/

        /*List<Voie> sourceObjets = voieService.findAll();
        List<VoieDTO> destObjects = new ArrayList<VoieDTO>();
        mapper.map(sourceObjets, destObjects);

        for (VoieDTO desvoies : destObjects) {
            System.out.println("DOZER list voie : " + desvoies.getVoieLibelle());
            for (FiliereDTO desfilieres : desvoies.getFilieres()) {
                System.out.println("DOZER list : des filieres  : " + desfilieres.getFiliereLibelle());
            }
        }*/

        /*Mapper mapper = new DozerBeanMapper();
        List<Voie> sourceObjet = voieService.findAll();
        List<VoieDTO> destObject = new ArrayList<>();
        mapper.map(sourceObjet, destObject);
*/


        // *************** TEST JPA VERS DTO ************************
        //TEST VOIE VERS FILIERE
//        System.out.println("================== TEST JPA VERS DTO ========================");
//        List<Voie> voieJ = voieService.findAll();
//        List<VoieDTO> voieD = voieMapper.mapFromEntity(voieJ);
//
//        for (VoieDTO eleme : voieD) {
//            System.out.println("voie :" + eleme.getVoieLibelle());
////            System.out.println(eleme.getFilieres());
//            for (FiliereDTO elem2 : eleme.getFilieres()) {
//                System.out.println("filiere de la voie  : " + elem2.getFiliereLibelle());
//            }
//        }
//
//        System.out.println("-----------------------------------------------");
//
//        //TEST FILIERE VERS VOIE
//        List<Filiere> filJ = filiereService.findAll();
//        List<FiliereDTO> filD = filiereMapper.mapFromEntity(filJ);
//
//        for (FiliereDTO elm1 : filD) {
//            System.out.println("Filiere : " + elm1.getFiliereLibelle());
////            for (FiliereDTO elem : elm1.getVoie().getFilieres()) {
////                //Ne sert strictement à rien mais permet de vérifier la cohérence du return
////                System.out.println("Filliere de la filliere : du type voie " + elem.getFiliereLibelle());
////            }
//            System.out.println("voie de la filliere : " + elm1.getVoie().getVoieLibelle());
//        }
//
//        // *************** TEST DTO VERS JPA ************************
//        System.out.println("================ TEST DTO VERS JPA ==========================");
//
//        //Sans DTO = ok
//        Voie voie2 = voieService.findOne(1);
//        voie2.setVoieLibelle("Voie1 depuisJava sans DTO");
//        voieService.update(voie2);
//        System.out.println("MAJ voie sans DTO");
//
//        // TEST FILIERE SANS DTO = ok
//        Filiere filT = filiereService.findOne(1);
//        filT.setFiliereLibelle("Filiere1 depuis java sans DTO");
//        filiereService.update(filT);
//        System.out.println("MAJ filiere sans DTO");
//
//        // TEST FILIERE AVEC DTO = ok
//        FiliereDTO filDD = filiereMapper.mapFromEntity(filiereService.findOne(1));
//        filDD.setFiliereLibelle("Filiere1 depuis java avec DTO");
//        filiereService.update(filiereMapper.mapToEntity(filDD));
//        System.out.println("MAJ filiere avec DTO");
//
//        // INSERT FILIERE = ok
//        //        filDD.setFiliereId(null);
//        //        filiereService.insert(filiereMapper.mapToEntity(filDD));
//
//        //AVEC DTO = bug
//        VoieDTO voie1 = voieMapper.mapFromEntity(voieService.findOne(1));
//        voie1.setVoieLibelle("Voie depuis java avec DTO");
//        Voie voieModel = voieMapper.mapToEntity(voie1);
//        System.out.println("AVANT UPDATE Longueur de la List de filiere dans la voie1 : " + voieModel.getFilieres().size());
//        for (Filiere elemFill : voieModel.getFilieres()) {
//            System.out.println("Boucle sur filiere : " + elemFill.getFiliereId());
//            System.out.println("Boucle sur VoieID de la filiere : " + elemFill.getVoie().getVoieId());
//        }
//        voieService.update(voieModel);
//        System.out.println("APRES UPDATE Longueur de la List de filiere dans la voie1 : " + voie1.getFilieres().size());
//        System.out.println("MAJ voie avec DTO");

        request.getRequestDispatcher("/WEB-INF/tags/exemple.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
