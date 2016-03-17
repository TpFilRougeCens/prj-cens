package mapDtoJpa.mappable;

import dto.FiliereDTO;
import mapDtoJpa.mapper.Mapper;
import model.Filiere;

import javax.inject.Inject;

/**
 * Created by Gawel on 16/03/2016.
 */
public class FiliereMapper extends Mapper<FiliereDTO, Filiere> {

//    @Inject
//    private AssocFiliereBlocMapper assocFiliereBlocMapper;
//
//    @Inject
//    private ClassroomMapper classroomMapper;

    @Inject
    private VoieMapper voieMapper;

    @Override
    public FiliereDTO mapFromEntity(Filiere filiere) {
        if (filiere == null) {
            return null;
        }

        FiliereDTO result = new FiliereDTO();
        result.setFiliereId(filiere.getFiliereId());
//        result.setAssocFiliereBlocs(assocFiliereBlocMapper.mapFromEntity(filiere.getAssocFiliereBlocs()));
//        result.setClassrooms(classroomMapper.mapFromEntity(filiere.getClassrooms()));
        result.setFiliereLibelle(filiere.getFiliereLibelle());
        filiere.getVoie();
        result.setVoie(voieMapper.mapFromEntity(filiere.getVoie()));
        return result;
    }

    @Override
    public Filiere mapToEntity(FiliereDTO filiereDTO) {
        if (filiereDTO == null) {
            return null;
        }

        Filiere result = new Filiere();
        result.setFiliereId(filiereDTO.getFiliereId());
//        result.setAssocFiliereBlocs(assocFiliereBlocMapper.mapToEntity(filiereDTO.getAssocFiliereBlocs()));
//        result.setClassrooms(classroomMapper.mapToEntity(filiereDTO.getClassrooms()));
        result.setFiliereLibelle(filiereDTO.getFiliereLibelle());
        result.setVoie(voieMapper.mapToEntity(filiereDTO.getVoie()));
        return result;
    }

}
