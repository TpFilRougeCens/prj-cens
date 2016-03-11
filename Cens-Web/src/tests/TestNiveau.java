package tests;


import model.Classroom;
import model.Niveau;
import service.NiveauService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class TestNiveau whith JPA IntelliJ
 */
@WebServlet("/TestNiveau")
public class TestNiveau extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    NiveauService niveauService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestNiveau() {
        super();
        // TODO Auto-generated constructor stub

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Test d'un insert
        Niveau niveau = new Niveau();
        niveau.setNiveauLibelle("JavaTest");
        niveauService.insert(niveau);

        // Test FIND MASTER + SLAVE
        List<Niveau> desNiveaux = niveauService.findAll();
        for (Niveau hop : desNiveaux) {
            System.out.println("Niveau : " + hop.getNiveauLibelle());
            List<Classroom> classes = hop.getClassrooms();

            for (Classroom hip : classes) {
                System.out.println("     Classe : " + hip.getClassroomLibelle());
            }

        }

        // Test UPDATE
//        Niveau finNiv = niveauService.findOne(1);
//        finNiv.setNiveauLibelle("Depuis JPA JAVA test");
//        niveauService.update(finNiv);
//
//        // Test DELETE
//        List<Niveau> allNiv = niveauService.findAll();
//        Niveau az = allNiv.get(allNiv.size() - 1);
//        System.out.println(az.getNiveauId());
//        niveauService.delete(az);


        request.getRequestDispatcher("/WEB-INF/tags/exemple.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

}
