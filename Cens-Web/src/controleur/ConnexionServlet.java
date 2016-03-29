package controleur;

import model.Personne;
import service.*;

import javax.ejb.EJB;
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

    private static final String SESSION_UTILISATEUR = "sessionUtilisateur";
    private static final String VUE = "/login.jsp";


    @EJB
    PersonneService personneService;
    @EJB
    GroupeService groupeService;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        String nom = null, mdp = null;

        if (request.getParameter("nom") != null) {
            nom = request.getParameter("nom");
        }
        if (request.getParameter("motdepasse") != null) {
            mdp = request.getParameter("motdepasse");
        }

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        Personne persBase = personneService.findOne(nom, mdp);
        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
        if (persBase!=null) {
            session.setAttribute(SESSION_UTILISATEUR, persBase);
            String function = persBase.getGroupe().getGroupeLibelle();
            System.out.println("function dans servlet "+function.toLowerCase());
            switch (function.toLowerCase()) {
                case "enseignant":
                    response.sendRedirect("/Cens-Web-1.0.0-SNAPSHOT/enseignant");
                    break;
                case "manager":
                    response.sendRedirect("/Cens-Web-1.0.0-SNAPSHOT/manager");
                    break;
                case "coordinateur":
                    response.sendRedirect("/Cens-Web-1.0.0-SNAPSHOT/coordinateur");
                    break;
                case "admin":
                    response.sendRedirect("/Cens-Web-1.0.0-SNAPSHOT/admin");
                    break;
                case "eleve":
                    response.sendRedirect("/Cens-Web-1.0.0-SNAPSHOT/eleve");
                    break;
                default:
                    response.sendRedirect("/Cens-Web-1.0.0-SNAPSHOT/connexion");
                    break;
            }
        } else {
            //request.setAttribute(ATT_FORM, form);
            //request.setAttribute(ATT_UTILISATEUR, utilisateur);
            System.out.println("réinitialisation session utilisateur");
            session.setAttribute(SESSION_UTILISATEUR, null);
            this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
        }
    }
}
