package mapDtoJpa.mappable;

import dto.AssocEvaluerDTO;
import mapDtoJpa.mapper.Mapper;
import model.AssocEvaluer;

import javax.inject.Inject;

/**
 * Created by gael.cdi12 : 17/03/2016.
 */
public class AssocEvaluerMapper extends Mapper<AssocEvaluerDTO, AssocEvaluer> {

    @Inject
    EleveMapper eleveMapper;

    @Inject
    EmployeMapper employeMapper;

    @Inject
    NoteMapper noteMapper;

    @Inject
    ComCapMapper comCapMapper;

    @Override
    public AssocEvaluerDTO mapFromEntity(AssocEvaluer assocEvaluer, String... instance) {
        if (assocEvaluer == null) {
            return null;
        }
        AssocEvaluerDTO result = new AssocEvaluerDTO();
        result.setAssocEvaluerId(assocEvaluer.getAssocEvaluerId());
        result.setAssocEvaluerDateEvaluation(assocEvaluer.getAssocEvaluerDateEvaluation());
        result.setEleve(eleveMapper.mapFromEntity(assocEvaluer.getEleve()));
        result.setEmploye(employeMapper.mapFromEntity(assocEvaluer.getEmploye()));
        result.setNote1(noteMapper.mapFromEntity(assocEvaluer.getNote1())); //Auto-évaluation de l'élève
        result.setNote2(noteMapper.mapFromEntity(assocEvaluer.getNote2())); //Evaluation de l'enseignant
        result.setComCap(comCapMapper.mapFromEntity(assocEvaluer.getComCap()));
        return result;
    }

    @Override
    public AssocEvaluer mapToEntity(AssocEvaluerDTO assocEvaluerDTO, String... instance) {
        if (assocEvaluerDTO == null) {
            return null;
        }
        AssocEvaluer result = new AssocEvaluer();
        result.setAssocEvaluerId(assocEvaluerDTO.getAssocEvaluerId());
        result.setAssocEvaluerDateEvaluation(assocEvaluerDTO.getAssocEvaluerDateEvaluation());
        result.setEleve(eleveMapper.mapToEntity(assocEvaluerDTO.getEleve()));
        result.setEmploye(employeMapper.mapToEntity(assocEvaluerDTO.getEmploye()));
        result.setNote1(noteMapper.mapToEntity(assocEvaluerDTO.getNote1())); //Auto-évaluation de l'élève
        result.setNote2(noteMapper.mapToEntity(assocEvaluerDTO.getNote2())); //Evaluation de l'enseignant
        result.setComCap(comCapMapper.mapToEntity(assocEvaluerDTO.getComCap()));
        return result;

    }
}
