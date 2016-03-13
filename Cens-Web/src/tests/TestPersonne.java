package tests;


import model.Eleve;
import model.Groupe;
import model.Personne;
import service.EleveService;
import service.EmployeService;
import service.GroupeService;
import service.PersonneService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/TestPersonne")
public class TestPersonne extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    PersonneService personneService;
    @EJB
    EmployeService employeService;
    @EJB
    EleveService eleveService;
    @EJB
    GroupeService groupeService;


    public TestPersonne() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Liste des personnes
        List<Personne> desPersonnes = eleveService.findAll();
        for (Personne hop : desPersonnes) {
            System.out.println(hop.getPersonneId());
        }


        // Trouver une personne avec son login et pass
//        Personne az = new Eleve();
//        az = personneService.findOne(2);
//        System.out.println(az.getPersonneLogin());

        Groupe groupe = groupeService.findOne(3);

//        System.out.println("depuis test" + az.getPersonneNom());
//        eleve = (Eleve) az;
//        eleve.setEleveEmailParent("parentEmail2");
//        eleve.setGroupe(groupe);
//        eleve.setPersonneNom("elev2Java");
//        eleveService.insert(eleve);

        // Trouver le groupe d'un utilisateur
//        Groupe groupe = new Groupe();
//        groupe = az.getGroupe();
//        System.out.println(groupe.getGroupeLibelle());

        request.getRequestDispatcher("/WEB-INF/tags/exemple.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
