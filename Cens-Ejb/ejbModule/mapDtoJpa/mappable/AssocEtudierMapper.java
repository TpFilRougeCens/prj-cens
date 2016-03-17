package mapDtoJpa.mappable;

import dto.AssocEtudierDTO;
import mapDtoJpa.mapper.Mapper;
import model.AssocEtudier;

import javax.inject.Inject;

/**
 * Created by gael.cdi12 : 17/03/2016.
 */
public class AssocEtudierMapper extends Mapper<AssocEtudierDTO, AssocEtudier> {

    @Inject
    ClassroomMapper classroomMapper;

    @Inject
    PromoMapper promoMapper;

    @Inject
    EleveMapper eleveMapper;

    @Override
    public AssocEtudierDTO mapFromEntity(AssocEtudier assocEtudier) {
        if (assocEtudier == null) {
            return null;
        }
        AssocEtudierDTO result = new AssocEtudierDTO();
        result.setAssocEtudierId(assocEtudier.getAssocEtudierId());
        result.setClassroom(classroomMapper.mapFromEntity(assocEtudier.getClassroom()));
        result.setPromo(promoMapper.mapFromEntity(assocEtudier.getPromo()));
        result.setEleve(eleveMapper.mapFromEntity(assocEtudier.getEleve()));
        return result;
    }

    @Override
    public AssocEtudier mapToEntity(AssocEtudierDTO assocEtudierDTO) {
        if (assocEtudierDTO == null) {
            return null;
        }
        AssocEtudier result = new AssocEtudier();
        result.setAssocEtudierId(assocEtudierDTO.getAssocEtudierId());
        result.setClassroom(classroomMapper.mapToEntity(assocEtudierDTO.getClassroom()));
        result.setPromo(promoMapper.mapToEntity(assocEtudierDTO.getPromo()));
        result.setEleve(eleveMapper.mapToEntity(assocEtudierDTO.getEleve()));
        return result;
    }
}
