package rest.utilAuthentification;

import javax.ws.rs.NameBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by steven.cdi12 on 24/03/2016.
 */
@NameBinding
@Retention(RUNTIME)
@Target({TYPE,METHOD})
public @interface Secured {
    RoleUtilisateur[]value()default {};
}
