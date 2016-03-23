package controleur;

import bean.Utilisateur;
import filtre.AccesFiltre;
import modelweb.FormulaireConnexion;

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
@WebServlet("/Connexion")
public class ConnexionServlet extends HttpServlet {
    private static final String ATT_UTILISATEUR         = "utilisateur";
    private static final String ATT_FORM                = "form";
    private static final String SESSION_UTILISATEUR     = "sessionUtilisateur";
    private static final String VUE                     = "/login.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        FormulaireConnexion form = new FormulaireConnexion();

        /* Traitement de la requête et récupération du bean en résultant */
        Utilisateur utilisateur = form.connecterUtilisateur( request );

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
        if ( form.getErreurs().isEmpty() ) {
            utilisateur.setFonction("coordinateur");
            session.setAttribute( SESSION_UTILISATEUR, utilisateur );
            String function = utilisateur.getFonction();
           switch (function){
               case "enseignant":
                   response.sendRedirect("/Cens/Enseignant");
                   break;
               case "manager":
                   response.sendRedirect("/Cens/manager");
                   break;
               case "coordinateur":
                   response.sendRedirect("/Cens/Coordinateur");
                   break;
               case "admin":
                   response.sendRedirect("/Cens/Admin");
                   break;
               case "eleve":
                   response.sendRedirect("/Cens/Eleve");
                   break;
               default:
                   response.sendRedirect("/Cens/Connexion");
                   break;
           }
        } else {
            request.setAttribute( ATT_FORM, form );
            request.setAttribute( ATT_UTILISATEUR, utilisateur );
            System.out.println("réinitialisation session utilisateur");
            session.setAttribute( SESSION_UTILISATEUR, null );
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }
    }
}
