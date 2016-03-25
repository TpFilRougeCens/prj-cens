package rest.utilAuthentification;

import model.Personne;
import service.PersonneService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;

/**
 * Created by steven.cdi12 on 25/03/2016.
 */
@RequestScoped
public class AuthentifierUserProducer {

    @EJB
    PersonneService personneService;

    @Produces
    @RequestScoped
    @AuthenticateUser
    private Personne authentifierUser;

    public void handleAuthentificationEvent(@Observes @AuthenticateUser String login){
        this.authentifierUser = findUser(login);
        System.out.println("valeur authentifierUser "+authentifierUser);
    }

    private Personne findUser(String login){

        return personneService.findOne(login);
    }
}
