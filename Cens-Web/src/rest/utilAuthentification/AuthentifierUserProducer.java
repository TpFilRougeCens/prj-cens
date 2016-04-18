package rest.utilAuthentification;

import dto.PersonneDTO;
import mapDtoJpa.mappable.EleveMapper;
import mapDtoJpa.mappable.EmployeMapper;
import model.Eleve;
import model.Employe;
import service.EleveService;
import service.EmployeService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 * Created by steven.cdi12 on 25/03/2016.
 */
@SuppressWarnings("CdiInjectionPointsInspection")
@RequestScoped
public class AuthentifierUserProducer {

    @EJB
    EmployeService employeService;
    @EJB
    EleveService eleveService;

    @Inject
    EmployeMapper empMapper;
    @Inject
    EleveMapper eleMapper;

    private Employe empBase;
    private Eleve eleBase;

    @Produces
    @RequestScoped
    @AuthentifierUser
    private PersonneDTO authentifierUser;


    public void authentificationEvent(@Observes @AuthentifierUser String login) {

            this.authentifierUser = findUser(login);
            System.out.println("valeur authentifierUseremp " + authentifierUser);

    }

    private PersonneDTO findUser(String login) {
        empBase = employeService.findOne(login);
        eleBase = eleveService.findOne(login);
        PersonneDTO persDto = new PersonneDTO();
        if(empBase!=null) {
            persDto = empMapper.mapFromEntity(empBase);
        }else if(eleBase!=null){

            persDto = eleMapper.mapFromEntity(eleBase);
        }
        System.out.println("personneDto");
        return persDto;
    }
}
