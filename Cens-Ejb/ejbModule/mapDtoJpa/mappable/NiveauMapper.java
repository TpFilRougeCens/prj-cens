package mapDtoJpa.mappable;

import dto.NiveauDTO;
import mapDtoJpa.mapper.Mapper;
import model.Niveau;

/**
 * Created by gael.cdi12 : 17/03/2016.
 */
public class NiveauMapper extends Mapper<NiveauDTO, Niveau> {

//    @Inject
//    private ClassroomMapper classroomMapper;

    @Override
    public NiveauDTO mapFromEntity(Niveau niveau) {
        if (niveau == null) {
            return null;
        }
        NiveauDTO result = new NiveauDTO();
        result.setNiveauId(niveau.getNiveauId());
        result.setNiveauLibelle(niveau.getNiveauLibelle());
//        result.setClassrooms(classroomMapper.mapFromEntity(niveau.getClassrooms()));
        return result;
    }

    @Override
    public Niveau mapToEntity(NiveauDTO niveauDTO) {
        if (niveauDTO == null) {
            return null;
        }
        Niveau result = new Niveau();
        result.setNiveauId(niveauDTO.getNiveauId());
        result.setNiveauLibelle(niveauDTO.getNiveauLibelle());
//        result.setClassrooms(classroomMapper.mapToEntity(niveauDTO.getClassrooms()));
        return result;
    }
}
