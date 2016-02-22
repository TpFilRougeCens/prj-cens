package tests;

import model.Niveau;
import service.NiveauService;

import javax.ejb.EJB;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        Niveau niveau = new Niveau();
        niveau.setLibelle("PremièreJavaTest");
        niveauService.insert(niveau);
//        response.getWriter().append("Served at: ").append(request.getContextPath());
        request.getRequestDispatcher("/WEB-INF/tags/exemple.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
