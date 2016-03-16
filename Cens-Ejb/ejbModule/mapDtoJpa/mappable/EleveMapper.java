package mapDtoJpa.mappable;

import dto.EleveDTO;
import mapDtoJpa.mapper.Mapper;
import model.Eleve;

/**
 * Created by gael.cdi12 on 16/03/2016.
 */
public class EleveMapper extends Mapper<EleveDTO, Eleve> {
    //    @Inject
//    private EleveMapper eleveMapper;

    @Override
    public EleveDTO mapFromEntity(Eleve eleve) {
        return null;
    }

    @Override
    public Eleve mapToEntity(EleveDTO eleveDTO) {
        return null;
    }

}
