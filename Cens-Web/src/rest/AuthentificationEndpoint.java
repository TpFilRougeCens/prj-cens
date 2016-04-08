package rest;

import model.Eleve;
import model.Employe;
import rest.utilAuthentification.AuthHelper;
import service.EleveService;
import service.EmployeService;
import service.GroupeService;
import service.TokenService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by steven.cdi12 on 24/03/2016.
 */

@Path("/authentification")
public class AuthentificationEndpoint {

    private Integer id;
    private String nomUtilisateur;
    private String prenomUtilisateur;
    private String role;

    private Employe empBase;
    private Eleve eleBase;

    @EJB
    EmployeService employeService;
    @EJB
    EleveService eleveService;
    @EJB
    GroupeService groupeService;
    @EJB
    TokenService tokenservice;

    @POST
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public Response authenticateUser(@FormParam("username") String username,
                                     @FormParam("password") String password) {
        System.out.println("entré valeur du login "+username+" valeur du pass "+password);

        try {
            // Authenticate the user using the credentials provided
            authenticate(username, password);
            System.out.println("test before jason");
            // Issue a token for the user
            String token = issueToken(username);

            System.out.println("test before response");
            // Return the token on the response
            return Response.ok(token).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    private void authenticate(String username, String password) throws Exception {
        // Authenticate against a database, LDAP, file or whatever
        // Throw an Exception if the credentials are invalid
        empBase = employeService.findOne(username,password);

        eleBase = eleveService.findOne(username,password);
        if (empBase!=null){
            System.out.println("valeur de l'username empBase "+empBase.getPersonneLogin());
            id = empBase.getPersonneId();
            nomUtilisateur = empBase.getPersonneNom();
            prenomUtilisateur=empBase.getPersonnePrenom();
            role=empBase.getGroupe().getGroupeLibelle();
        }else if(eleBase!=null){
            System.out.println("valeur de l'username eleBase "+eleBase.getPersonneLogin());
            id = eleBase.getPersonneId();
            nomUtilisateur = eleBase.getPersonneNom();
            prenomUtilisateur=eleBase.getPersonnePrenom();
            role=eleBase.getGroupe().getGroupeLibelle();
        }else {
            throw new Exception();
        }
    }

    private String issueToken(String username) {
        // Issue a token (can be a random String persisted to a database or a JWT token)
        // The issued token must be associated to a user
        // Return the issued token
        AuthHelper auth = new AuthHelper();
        String tokenBuild=auth.createJsonWebToken(id,nomUtilisateur,prenomUtilisateur,role, (long) 30);
        return tokenBuild;
    }
}
