package tests;


import service.NiveauService;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class TestNiveau whith JPA IntelliJ
 */
@WebServlet("/TestNiveau")
public class TestNiveau extends HttpServlet {
    private static final long serialVersionUID = 1L;

//    @Inject
//    NiveauService niveauService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestNiveau() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Test d'un insert = ok
//        Niveau niveau = new Niveau();
//        niveau.setNiveauLibelle("JavaTest");
//        niveauService.insert(niveau);

        // Test FIND MASTER + SLAVE
//        List<Niveau> desNiveaux = niveauService.findAll();
//        for (Niveau hop : desNiveaux) {
//            System.out.println("Niveau : " + hop.getNiveauLibelle());
//
//
//        }

        // Test UPDATE = ok
//        Niveau finNiv = niveauService.findOne(1);
//        finNiv.setNiveauLibelle("Depuis JPA JAVA test");
//        niveauService.update(finNiv);
//
//        // Test DELETE = ok
//        List<Niveau> allNiv = niveauService.findAll();
//        for (Niveau elem : allNiv) {
//            System.out.println(elem.getNiveauId() + " " + elem.getNiveauLibelle());
//        }
//        Niveau az = allNiv.get(allNiv.size() - 1);
//        System.out.println("id sup : " + az.getNiveauId());
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
