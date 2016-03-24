package filtre;

import model.Personne;

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
public class AccesFiltre implements javax.servlet.Filter {
    private static final String SESSION_UTILISATEUR = "sessionUtilisateur";
    private static final String ACCES_LOGIN = "/Connexion";

    private Personne recentUser;

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
        if(chemin.startsWith("/img")){
            chain.doFilter(request,reponse);
            return;
        }

        Personne user = (Personne) session.getAttribute("sessionUtilisateur");

        if (user!=null && recentUser != null) {System.out.println("passage filtre page demande");
            String fonc = ( ((Personne) session.getAttribute("sessionUtilisateur")).getGroupe().getGroupeLibelle());
            String cheminRedir = "/"+fonc.toLowerCase();
            System.out.println("fonction avancé "+cheminRedir);
            switch (fonc.toLowerCase()){
                case "manager":
                    request.getRequestDispatcher(cheminRedir).forward(request,reponse);
                    break;
                case "coordinateur":
                    request.getRequestDispatcher(cheminRedir).forward(request,reponse);
                    break;
                case "eleve":
                    request.getRequestDispatcher(cheminRedir).forward(request,reponse);
                    break;
                case "enseignant":
                    request.getRequestDispatcher(cheminRedir).forward(request,reponse);
                    break;
                case "admin":
                    request.getRequestDispatcher(cheminRedir).forward(request,reponse);
                    break;
                default:
                    reponse.sendRedirect("/Cens-Web-1.0.0-SNAPSHOT/connexion");
                    break;
            }
        }


        if (session.getAttribute(SESSION_UTILISATEUR) == null && recentUser==null) {
            System.out.println("pas d'utilisaeur en session");
            request.getRequestDispatcher(ACCES_LOGIN).forward(request, reponse);
        } else if (user != null && recentUser == null) {
            recentUser = user;
            String fonc = user.getGroupe().getGroupeLibelle();
            request.getSession().setAttribute("pageFiltre", fonc);
            chain.doFilter(request, reponse);
        }
        System.out.println("valeur user "+user+" valeur recentUser "+recentUser);
    }


    @Override
    public void destroy() {

    }
}

