package controleur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Steven on 24/02/2016.
 */
@WebServlet("/FiltreServlet")
public class FiltreServlet extends HttpServlet {
    public static final String ACCES_LOGIN = "/login.jsp";
    public static final String ACCES_ENSEIGNANT = "/WEB-INF/jsp/PageEnseignant.jsp";
    public static final String SESSION_UTILISATEUR = "utilisateurSession";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("test");
        if(session.getAttribute(SESSION_UTILISATEUR) == null){
            response.sendRedirect(request.getContextPath() + ACCES_LOGIN );
        }else{
            this.getServletContext().getRequestDispatcher(ACCES_ENSEIGNANT).forward(request,response);
        }
    }
}
