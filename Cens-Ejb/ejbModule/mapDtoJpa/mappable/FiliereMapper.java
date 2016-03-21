package mapDtoJpa.mappable;

import dto.FiliereDTO;
import mapDtoJpa.mapper.Mapper;
import model.Filiere;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Arrays;

/**
 * Created by Gawel : 16/03/2016.
 */
public class FiliereMapper extends Mapper<FiliereDTO, Filiere> {

    @Inject
    private VoieMapper voieMapper;

    @Inject
    private Provider<ClassroomMapper> classroomMapper;

    @Inject
    private Provider<AssocFiliereBlocMapper> assocFiliereBlocMapper;


    @Override
    public FiliereDTO mapFromEntity(Filiere filiere, String... instance) {
        if (filiere == null) {
            return null;
        }

        FiliereDTO result = new FiliereDTO();
        result.setFiliereId(filiere.getFiliereId());
        result.setFiliereLibelle(filiere.getFiliereLibelle());
        // La boucle infinie est bloquée du coté de la Class Voie
        result.setVoie(voieMapper.mapFromEntity(filiere.getVoie(), this.getClass().getSimpleName()));
        //Blocage de classroom
        if (Arrays.binarySearch(instance, "ClassroomMapper") < 0) {
            result.setClassrooms(classroomMapper.get().mapFromEntity(filiere.getClassrooms(), this.getClass().getSimpleName()));
        }
        // blocage de assocfiliereBlocs
        if (Arrays.binarySearch(instance, "AssocFiliereBlocsMapper") < 0) {
            result.setAssocFiliereBlocs(assocFiliereBlocMapper.get().mapFromEntity(filiere.getAssocFiliereBlocs(), this.getClass().getSimpleName()));
        }
        return result;
    }

    @Override
    public Filiere mapToEntity(FiliereDTO filiereDTO, String... instance) {
        if (filiereDTO == null) {
            return null;
        }

        Filiere result = new Filiere();
        result.setFiliereId(filiereDTO.getFiliereId());
        result.setFiliereLibelle(filiereDTO.getFiliereLibelle());
        // La boucle infinie est bloquée du coté de la Class Voie
        result.setVoie(voieMapper.mapToEntity(filiereDTO.getVoie(), this.getClass().getSimpleName()));
        //Blocage de classroom
        if (Arrays.binarySearch(instance, "ClassroomMapper") < 0) {
            result.setClassrooms(classroomMapper.get().mapToEntity(filiereDTO.getClassrooms(), this.getClass().getSimpleName()));
        }
        // blocage de assocfiliereBlocs
        if (Arrays.binarySearch(instance, "AssocFiliereBlocsMapper") < 0) {
            result.setAssocFiliereBlocs(assocFiliereBlocMapper.get().mapToEntity(filiereDTO.getAssocFiliereBlocs(), this.getClass().getSimpleName()));
        }
        return result;
    }

}
