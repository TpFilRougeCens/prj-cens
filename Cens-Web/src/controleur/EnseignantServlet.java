package controleur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Steven on 24/02/2016.
 */

@WebServlet("/enseignant")
public class EnseignantServlet extends HttpServlet {
    private static final String ACCES_ENSEIGNANT = "/WEB-INF/jsp/PageEnseignant.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("test servlet enseignant");
        request.getRequestDispatcher(ACCES_ENSEIGNANT).forward(request,response);
    }
}
