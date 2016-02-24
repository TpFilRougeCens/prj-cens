package filtre;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Steven on 24/02/2016.
 */
@WebFilter(urlPatterns = "/acces/*")
public class AccesFiltre implements javax.servlet.Filter{
    public static final String SESSION_UTILISATEUR = "sessionUtilisateur";
    public static final String ACCES_LOGIN = "/login.jsp";
    public static final String ACCES_ENSEIGNANT = "/WEB-INF/jsp/PageEnseignant.jsp";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("passage dans le filtre");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse reponse = (HttpServletResponse) resp;
        HttpSession session = request.getSession();

        if(session.getAttribute(SESSION_UTILISATEUR)==null){
            reponse.sendRedirect(request.getContextPath() + ACCES_LOGIN );
        }else{
            chain.doFilter(request,reponse);
        }
    }

    @Override
    public void destroy() {

    }
}

