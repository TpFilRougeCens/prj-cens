package mapDtoJpa.mappable;

import dto.AssocEnseignerDTO;
import mapDtoJpa.mapper.Mapper;
import model.AssocEnseigner;

import javax.inject.Inject;

/**
 * Created by gael.cdi12 : 17/03/2016.
 */
public class AssocEnseignerMapper extends Mapper<AssocEnseignerDTO, AssocEnseigner> {

    @Inject
    private ClassroomMapper classroomMapper;

    @Inject
    private MatiereMapper matiereMapper;

    @Inject
    private PromoMapper promoMapper;

    @Inject
    private EmployeMapper employeMapper;

    @Override
    public AssocEnseignerDTO mapFromEntity(AssocEnseigner assocEnseigner) {
        if (assocEnseigner == null) {
            return null;
        }
        AssocEnseignerDTO result = new AssocEnseignerDTO();
        result.setAssocEnseignerId(assocEnseigner.getAssocEnseignerId());
        result.setClassroom(classroomMapper.mapFromEntity(assocEnseigner.getClassroom()));
        result.setMatiere(matiereMapper.mapFromEntity(assocEnseigner.getMatiere()));
        result.setPromo(promoMapper.mapFromEntity(assocEnseigner.getPromo()));
        result.setEmploye(employeMapper.mapFromEntity(assocEnseigner.getEmploye()));
        return result;
    }

    @Override
    public AssocEnseigner mapToEntity(AssocEnseignerDTO assocEnseignerDTO) {
        if (assocEnseignerDTO == null) {
            return null;
        }
        AssocEnseigner result = new AssocEnseigner();
        result.setAssocEnseignerId(assocEnseignerDTO.getAssocEnseignerId());
        result.setClassroom(classroomMapper.mapToEntity(assocEnseignerDTO.getClassroom()));
        result.setMatiere(matiereMapper.mapToEntity(assocEnseignerDTO.getMatiere()));
        result.setPromo(promoMapper.mapToEntity(assocEnseignerDTO.getPromo()));
        result.setEmploye(employeMapper.mapToEntity(assocEnseignerDTO.getEmploye()));
        return result;

    }
}
