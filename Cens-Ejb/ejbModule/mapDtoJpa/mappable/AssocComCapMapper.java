package mapDtoJpa.mappable;

import dto.AssocComCapDTO;
import mapDtoJpa.mapper.Mapper;
import model.AssocComCap;

import javax.inject.Inject;

/**
 * Created by gael.cdi12 : 17/03/2016.
 */
public class AssocComCapMapper extends Mapper<AssocComCapDTO, AssocComCap> {

    @Inject
    ComCapMapper comCapMapper;

    @Override
    public AssocComCapDTO mapFromEntity(AssocComCap assocComCap) {
        if (assocComCap == null) {
            return null;
        }
        AssocComCapDTO result = new AssocComCapDTO();
        result.setAssocComCapId(assocComCap.getAssocComCapId());
        result.setComCap1(comCapMapper.mapFromEntity(assocComCap.getComCap1()));
        result.setComCap2(comCapMapper.mapFromEntity(assocComCap.getComCap2()));
        return result;
    }

    @Override
    public AssocComCap mapToEntity(AssocComCapDTO assocComCapDTO) {
        if (assocComCapDTO == null) {
            return null;
        }
        AssocComCap result = new AssocComCap();
        result.setAssocComCapId(assocComCapDTO.getAssocComCapId());
        result.setComCap1(comCapMapper.mapToEntity(assocComCapDTO.getComCap1()));
        result.setComCap2(comCapMapper.mapToEntity(assocComCapDTO.getComCap2()));
        return result;
    }
}
