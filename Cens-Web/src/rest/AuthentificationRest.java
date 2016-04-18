package rest;

import model.Eleve;
import model.Employe;
import service.EleveService;
import service.EmployeService;
import service.GroupeService;
import service.TokenService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static rest.utilAuthentification.AuthHelper.createJsonWebToken;

/**
 * Created by steven.cdi12 on 24/03/2016.
 */

@Path("/authentification")
public class AuthentificationRest {

    private Integer id;
    private String nomUtilisateur;
    private String prenomUtilisateur;
    private String role;
    private String login;

    private Employe empBase;
    private Eleve eleBase;

    @EJB
    EmployeService employeService;
    @EJB
    EleveService eleveService;

    @POST
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public Response authenticateUser(@FormParam("username") String username,
                                     @FormParam("password") String password) {
        System.out.println("entré valeur du login "+username+" valeur du pass "+password);

        try {
            // Authentifier l'utilisateur avec les paramétre des champ
            authentifier(username, password);
            System.out.println("test before jason");
            // Mise en place du token pour l'utilisateur
            String token = creerToken(username);

            System.out.println("test before response");
            // Renvoi du token dans la réponse
            return Response.ok(token).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    private void authentifier(String username, String password) throws Exception {
        // Authentification dans la base de donnée de l'utilisateur

        empBase = employeService.findOne(username,password);

        eleBase = eleveService.findOne(username,password);
        if (empBase!=null){
            System.out.println("valeur de l'username empBase "+empBase.getPersonneLogin());
            id = empBase.getPersonneId();
            nomUtilisateur = empBase.getPersonneNom();
            login = eleBase.getPersonneLogin();
            prenomUtilisateur=empBase.getPersonnePrenom();
            role=empBase.getGroupe().getGroupeLibelle();
        }else if(eleBase!=null){
            System.out.println("valeur de l'username eleBase "+eleBase.getPersonneLogin());
            id = eleBase.getPersonneId();
            nomUtilisateur = eleBase.getPersonneNom();
            login = eleBase.getPersonneLogin();
            prenomUtilisateur=eleBase.getPersonnePrenom();
            role=eleBase.getGroupe().getGroupeLibelle();
        }else {
            throw new Exception();
        }
    }

    private String creerToken(String username) {

        //Création du JWT et le retouner
        return createJsonWebToken(id,login,nomUtilisateur,prenomUtilisateur,role, (long) 30);
    }
}
