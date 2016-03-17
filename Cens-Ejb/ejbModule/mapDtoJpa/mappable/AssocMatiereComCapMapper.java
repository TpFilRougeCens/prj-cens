package mapDtoJpa.mappable;

import dto.AssocMatiereComCapDTO;
import mapDtoJpa.mapper.Mapper;
import model.AssocMatiereComCap;

import javax.inject.Inject;

/**
 * Created by gael.cdi12 : 17/03/2016.
 */
public class AssocMatiereComCapMapper extends Mapper<AssocMatiereComCapDTO, AssocMatiereComCap> {

    //TODO SUPER IMPORTANT : TOUTE LES MAPS PK A FAIRE + GESTION DTO

    @Inject
    MatiereMapper matiereMapper;

    @Inject
    ComCapMapper comCapMapper;

    @Override
    public AssocMatiereComCapDTO mapFromEntity(AssocMatiereComCap assocMatiereComCap) {
        if (assocMatiereComCap == null) {
            return null;
        }
        AssocMatiereComCapDTO result = new AssocMatiereComCapDTO();
        result.setAssocMatiereComCapId(assocMatiereComCap.getAssocMatiereComCapId());
        result.setMatiere(matiereMapper.mapFromEntity(assocMatiereComCap.getMatiere()));
        result.setComCap(comCapMapper.mapFromEntity(assocMatiereComCap.getComCap())); //compétence
        return result;
    }

    @Override
    public AssocMatiereComCap mapToEntity(AssocMatiereComCapDTO assocMatiereComCapDTO) {
        if (assocMatiereComCapDTO == null) {
            return null;
        }
        AssocMatiereComCap result = new AssocMatiereComCap();
        result.setAssocMatiereComCapId(assocMatiereComCapDTO.getAssocMatiereComCapId());
        result.setMatiere(matiereMapper.mapToEntity(assocMatiereComCapDTO.getMatiere()));
        result.setComCap(comCapMapper.mapToEntity(assocMatiereComCapDTO.getComCap())); //compétence
        return result;
    }
}
