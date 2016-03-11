package tests;


import model.Personne;
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

    public TestPersonne() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Liste des personnes
        List<Personne> desPersonnes = personneService.findAll();
        for (Personne hop : desPersonnes) {
            System.out.println(hop.getPersonneId());
        }

        // Trouver une personne avec son login et pass
        Personne az = new Personne();
        az = personneService.findOne("login22", "pass1");

//        if (az != null) {
//            System.out.println("ok");
//        } else {
//            System.out.println("non");
//        }

        // Trouver
        personneService.fonctionUtilisateur(az);


        request.getRequestDispatcher("/WEB-INF/tags/exemple.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
