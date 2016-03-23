package controleur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by steven.cdi12 on 21/03/2016.
 */
@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {

    private static final String VUE_ADMIN= "/WEB-INF/jsp/PageAdmin.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(VUE_ADMIN).forward(request,response);
    }
}
