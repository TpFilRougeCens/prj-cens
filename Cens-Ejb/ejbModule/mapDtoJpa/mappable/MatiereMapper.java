package mapDtoJpa.mappable;

import dto.MatiereDTO;
import mapDtoJpa.mapper.Mapper;
import model.Matiere;

/**
 * Created by Gawel on 16/03/2016.
 */
public class MatiereMapper extends Mapper<MatiereDTO, Matiere> {
    @Override
    public MatiereDTO mapFromEntity(Matiere matiere) {
        return null;
    }

    @Override
    public Matiere mapToEntity(MatiereDTO matiereDTO) {
        return null;
    }
}
