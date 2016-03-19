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
//    public FiliereDTO mapFromEntity(Filiere filiere, String... instance) {
        if (filiere == null) {
            return null;
        }

        FiliereDTO result = new FiliereDTO();
        result.setFiliereId(filiere.getFiliereId());
//        result.setAssocFiliereBlocs(assocFiliereBlocMapper.mapFromEntity(filiere.getAssocFiliereBlocs()));
//        result.setClassrooms(classroomMapper.mapFromEntity(filiere.getClassrooms()));
        result.setFiliereLibelle(filiere.getFiliereLibelle());

        // On vérifie si l'instance VoieMapper est l'appellant pour éviter une boucle infinie
//        if (Arrays.binarySearch(instance, "VoieMapper") < 0) {
        result.setVoie(voieMapper.mapFromEntity(filiere.getVoie()));
//        }
        return result;
    }

    @Override
    public Filiere mapToEntity(FiliereDTO filiereDTO) {
//    public Filiere mapToEntity(FiliereDTO filiereDTO, String... instance) {
        if (filiereDTO == null) {
            return null;
        }

        Filiere result = new Filiere();
        result.setFiliereId(filiereDTO.getFiliereId());
//        result.setAssocFiliereBlocs(assocFiliereBlocMapper.mapToEntity(filiereDTO.getAssocFiliereBlocs()));
//        result.setClassrooms(classroomMapper.mapToEntity(filiereDTO.getClassrooms()));
        result.setFiliereLibelle(filiereDTO.getFiliereLibelle());
//        if (Arrays.binarySearch(instance, "VoieMapper") < 0) {
        result.setVoie(voieMapper.mapToEntity(filiereDTO.getVoie()));
//        }
        return result;
    }

}
