package mapDtoJpa.mappable;

import dto.ComCapDTO;
import mapDtoJpa.mapper.Mapper;
import model.ComCap;

/**
 * Created by gael.cdi12 : 17/03/2016.
 */
public class ComCapMapper extends Mapper<ComCapDTO, ComCap> {

//    @Inject
//    AssocComCapMapper assocComCapMapper;
//
//    @Inject
//    AssocEvaluerMapper assocEvaluerMapper;
//
//    @Inject
//    AssocMatiereComCapMapper assocMatiereComCapMapper;

    @Override
    public ComCapDTO mapFromEntity(ComCap comCap) {
        if (comCap == null) {
            return null;
        }
        ComCapDTO result = new ComCapDTO();
        result.setComCapId(comCap.getComCapId());
        result.setComCapLibelle(comCap.getComCapLibelle());
//        result.setAssocComCaps1(assocComCapMapper.mapFromEntity(comCap.getAssocComCaps1())); //parent = compétence
//        result.setAssocComCaps2(assocComCapMapper.mapFromEntity(comCap.getAssocComCaps2())); //enfant = capacité
//        result.setAssocEvaluers(assocEvaluerMapper.mapFromEntity(comCap.getAssocEvaluers()));
//        result.setAssocMatiereComCaps(assocMatiereComCapMapper.mapFromEntity(comCap.getAssocMatiereComCaps()));
        return result;
    }

    @Override
    public ComCap mapToEntity(ComCapDTO comCapDTO) {
        if (comCapDTO == null) {
            return null;
        }
        ComCap result = new ComCap();
        result.setComCapId(comCapDTO.getComCapId());
        result.setComCapLibelle(comCapDTO.getComCapLibelle());
//        result.setAssocComCaps1(assocComCapMapper.mapToEntity(comCapDTO.getAssocComCaps1())); //parent = compétence
//        result.setAssocComCaps2(assocComCapMapper.mapToEntity(comCapDTO.getAssocComCaps2())); //enfant = capacité
//        result.setAssocEvaluers(assocEvaluerMapper.mapToEntity(comCapDTO.getAssocEvaluers()));
//        result.setAssocMatiereComCaps(assocMatiereComCapMapper.mapToEntity(comCapDTO.getAssocMatiereComCaps()));
        return result;
    }
}
