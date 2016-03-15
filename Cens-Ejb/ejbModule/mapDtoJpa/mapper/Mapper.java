package mapDtoJpa.mapper;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Mapper<Dto, Model> {
    public abstract Dto mapFromModel(Model model);

    public abstract Model mapToModel(Dto model);

    public Collection<Dto> mapFromModel(Collection<Model> entities) {
        if (entities == null) {
            return new ArrayList<Dto>();
        }
        Collection<Dto> result = new ArrayList<Dto>();
        for (Model model : entities) {
            result.add(mapFromModel(model));
        }
        return result;
    }

    public Collection<Model> mapToModel(Collection<Dto> entities) {
        if (entities == null) {
            return new ArrayList<Model>();
        }
        Collection<Model> result = new ArrayList<Model>();
        for (Dto model : entities) {
            result.add(mapToModel(model));
        }
        return result;
    }
}
