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
@WebFilter(urlPatterns = "/*")
public class AccesFiltre implements javax.servlet.Filter{
    public static final String SESSION_UTILISATEUR = "sessionUtilisateur";
    public static final String ACCES_LOGIN = "/Connexion";
    public static final String ACCES_ENSEIGNANT = "/Enseignant";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("passage dans le filtre");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse reponse = (HttpServletResponse) resp;
        HttpSession session = request.getSession();

        /* Non-filtrage des ressources statiques*/
        String chemin = request.getRequestURI().substring( request.getContextPath().length() );
        if ( chemin.startsWith( "/css" ) ) {
            chain.doFilter( request, reponse );
            return;
        }


        System.out.println("utilisateur session dans le filte "+SESSION_UTILISATEUR);
        if(session.getAttribute(SESSION_UTILISATEUR)==null){
            System.out.println("pas d'utilisaeur en session");
            request.getRequestDispatcher(ACCES_LOGIN).forward(request,reponse);
        }else{
            request.getRequestDispatcher(ACCES_ENSEIGNANT).forward(request,reponse);
        }
    }

    @Override
    public void destroy() {

    }
}

