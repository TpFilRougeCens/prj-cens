package controleur;

import bean.Utilisateur;
import model.FormulaireConnexion;

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
@WebServlet("/ConnesionServlet")
public class ConnesionServlet extends HttpServlet {
    public static final String ATT_UTILISATEUR         = "utilisateur";
    public static final String ATT_FORM                = "form";
    public static final String SESSION_UTILISATEUR = "sessionUtilisateur";
    public static final String VUE              = "/login.jsp";
    public static final String VUE_ENSEIGNANT = "/EnseignantServlet";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page de connexion */

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        System.out.println("test connexion servlet");
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
            session.setAttribute( SESSION_UTILISATEUR, utilisateur );
            this.getServletContext().getRequestDispatcher( VUE_ENSEIGNANT).forward( request, response );
        } else {
            session.setAttribute( SESSION_UTILISATEUR, null );
        }

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_UTILISATEUR, utilisateur );

        this.getServletContext().getRequestDispatcher( VUE).forward( request, response );
    }
}
