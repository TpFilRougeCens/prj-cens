package mapDtoJpa.mapper;

import java.util.ArrayList;
import java.util.List;

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
    public abstract Dto mapFromEntity(Model model, String... instance);

    /**
     * * Methode N°2<br/>
     * Convertir un DTO en Entity JPA
     *
     * @param dto Object de type DTO
     * @return return d'un object de type Entity JPA
     */
    public abstract Model mapToEntity(Dto dto, String... instance);

    public List<Dto> mapFromEntity(List<Model> models, String... instance) {
        if (models == null) {
            return new ArrayList<Dto>();
        }
        List<Dto> result = new ArrayList<Dto>();
        for (Model model : models) {
            result.add(mapFromEntity(model, instance));
        }
        return result;
    }

    public List<Model> mapToEntity(List<Dto> dtos, String... instance) {
        if (dtos == null) {
            return new ArrayList<Model>();
        }
        List<Model> result = new ArrayList<Model>();
        for (Dto model : dtos) {
            result.add(mapToEntity(model, instance));
        }
        return result;
    }
}
