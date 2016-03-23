package filtre;

import bean.Utilisateur;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Steven on 24/02/2016.
 */
@WebFilter(urlPatterns = "/desactivé/")
public class AccesFiltre implements javax.servlet.Filter {
    private static final String SESSION_UTILISATEUR = "sessionUtilisateur";
    private static final String ACCES_LOGIN = "/Connexion";

    private Utilisateur recentUser;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("passage dnas le filtre!!");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse reponse = (HttpServletResponse) resp;
        HttpSession session = request.getSession();

        String chemin = request.getRequestURI().substring(request.getContextPath().length());
        System.out.println("le chemin dans le filtre "+chemin);
        if (chemin.startsWith("/css")) {
            chain.doFilter(request, reponse);
            return;
        }
        if(chemin.startsWith("/js")){
            chain.doFilter(request, reponse);
            return;
        }
        if(chemin.startsWith("/fonts")){
            chain.doFilter(request,reponse);
            return;
        }

        Utilisateur user = (Utilisateur) session.getAttribute("sessionUtilisateur");

        if (user!=null && recentUser != null) {
            System.out.println("passage filtre page demande");
            request.getRequestDispatcher(chemin).forward(request,reponse);
            //String pageDemande = (String) request.getSession().getAttribute("pageFiltre");
        }
        //System.out.println("utilisateur session dans le filte " + SESSION_UTILISATEUR);


        if (session.getAttribute(SESSION_UTILISATEUR) == null && recentUser==null) {
            System.out.println("pas d'utilisaeur en session");
            request.getRequestDispatcher(ACCES_LOGIN).forward(request, reponse);
        } else if (user != null && recentUser == null) {
            recentUser = user;
            String fonc = user.getFonction();
            request.getSession().setAttribute("pageFiltre", fonc);
            chain.doFilter(request, reponse);
            System.out.println("user dans le filtre " + user);

        }
        System.out.println("valeur user "+user+" valeur recentUser "+recentUser);

    }


    @Override
    public void destroy() {

    }
}

