package rest.utilAuthentification;

import model.Token;
import service.TokenService;

import javax.annotation.Priority;
import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

import static rest.utilAuthentification.AuthHelper.verifyToken;

/**
 * Created by steven.cdi12 on 24/03/2016.
 */
@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthentifierFilter implements ContainerRequestFilter {


    @Inject
    @AuthentifierUser
    Event<String> userAuthenticatedEvent;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        // Recupérer le header de la requete sql
        String authorisationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        // Vérifier si l'autentification header est fournis et correctement écrit
        if (authorisationHeader == null || !authorisationHeader.startsWith("Bearer ")) {
            throw new NotAuthorizedException("Authorisation header doit etre renseigner");
        }

        // extraire le token
        String token = authorisationHeader.substring("Bearer".length()).trim();

        try {

            // Valider the token
            validToken(token);

        } catch (Exception e) {
            requestContext.abortWith(
                    Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }

    private void validToken(String tokenString) throws Exception {
        TokenInfo tokenInfo=verifyToken(tokenString);
        //TODO
        userAuthenticatedEvent.fire(tokenInfo.getUserLogin());
    }
}

