package mapDtoJpa.mapper;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Mapper<Dto, Model> {

    public abstract Dto mapFromEntity(Model model);

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
