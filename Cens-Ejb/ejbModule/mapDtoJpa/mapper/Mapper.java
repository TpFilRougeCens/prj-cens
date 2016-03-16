package mapDtoJpa.mapper;

import java.util.ArrayList;
import java.util.Collection;

/**
 * MAPPER POUR CONVERTIR :<br/>
 * 1 - Entity JPA => DTO<br/>
 * 2 - DTO => Entity JPA<br/>
 *
 * @param <Dto>   : Object de type DTO : exemple 'bilanDTO'
 * @param <Model> : Object de type JPA (Entity) : exemple 'Bilan'
 */
public abstract class Mapper<Dto, Model> {

    /**
     * Methode N°1<br/>
     * Convertir une Entity JPA en DTO
     *
     * @param model Object de type Entity JPA
     * @return return d'un object de type DTO
     */
    public abstract Dto mapFromEntity(Model model);

    /**
     * * Methode N°2<br/>
     * Convertir un DTO en Entity JPA
     *
     * @param dto Object de type DTO
     * @return return d'un object de type Entity JPA
     */
    public abstract Model mapToEntity(Dto dto);

    public Collection<Dto> mapFromEntity(Collection<Model> models) {
        if (models == null) {
            return new ArrayList<Dto>();
        }
        Collection<Dto> result = new ArrayList<Dto>();
        for (Model model : models) {
            result.add(mapFromEntity(model));
        }
        return result;
    }

    public Collection<Model> mapToEntity(Collection<Dto> dtos) {
        if (dtos == null) {
            return new ArrayList<Model>();
        }
        Collection<Model> result = new ArrayList<Model>();
        for (Dto model : dtos) {
            result.add(mapToEntity(model));
        }
        return result;
    }
}
