package rest.utilAuthentification;

import model.Personne;
import service.PersonneService;

import javax.annotation.Priority;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by steven.cdi12 on 25/03/2016.
 */
@Secured
@Provider
@Priority(Priorities.AUTHORIZATION)
public class AuthorizationFilter implements ContainerRequestFilter {

    @Inject
    @AuthenticateUser
    Personne authenticatedUser;

    @EJB
    PersonneService personneService;

    @Context
    private ResourceInfo resourceInfo;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        Class<?> resourceClass = resourceInfo.getResourceClass();
        List<RoleUtilisateur> classRoles = extractRoles(resourceClass);

        Method resourceMethod = resourceInfo.getResourceMethod();
        List<RoleUtilisateur> methodRoles = extractRoles(resourceMethod);

        try {
            if (methodRoles.isEmpty()) {
                checkPermissions(classRoles);
            } else {
                checkPermissions(methodRoles);
            }
        } catch (Exception e) {
            requestContext.abortWith(
                    Response.status(Response.Status.FORBIDDEN).build());
        }
    }

    private List<RoleUtilisateur> extractRoles(AnnotatedElement annotatedElement) {
        if (annotatedElement == null) {
            return new ArrayList<RoleUtilisateur>();
        } else {
            Secured secured = annotatedElement.getAnnotation(Secured.class);
            if (secured == null) {
                return new ArrayList<RoleUtilisateur>();
            } else {
                RoleUtilisateur[] allowedRoles = secured.value();
                return Arrays.asList(allowedRoles);
            }
        }
    }

    private void checkPermissions(List<RoleUtilisateur> allowedRoles) throws Exception {
        String groupLibelle = authenticatedUser.getGroupe().getGroupeLibelle();
        for (RoleUtilisateur role : allowedRoles) {
            System.out.println("value grouplibelle " + groupLibelle.toUpperCase() + " value role " + role);
            if (!groupLibelle.toUpperCase().equals(role.toString())) {
                System.out.println("pass");
                throw new Exception("le role n'est pas valide");
            }
        }

    }
}
