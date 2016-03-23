package mapDtoJpa.mappable;

import dto.NiveauDTO;
import mapDtoJpa.mapper.Mapper;
import model.Niveau;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Arrays;

/**
 * Created by gael.cdi12 : 17/03/2016.
 */
public class NiveauMapper extends Mapper<NiveauDTO, Niveau> {

    @Inject
    private Provider<ClassroomMapper> classroomMapper;

    @Override
    public NiveauDTO mapFromEntity(Niveau niveau, String... instance) {
        if (niveau == null) {
            return null;
        }
        NiveauDTO result = new NiveauDTO();
        result.setNiveauId(niveau.getNiveauId());
        result.setNiveauLibelle(niveau.getNiveauLibelle());
        if (Arrays.binarySearch(instance, "ClassroomMapper") < 0) {
            result.setClassrooms(classroomMapper.get().mapFromEntity(niveau.getClassrooms()));
        }
        return result;
    }

    @Override
    public Niveau mapToEntity(NiveauDTO niveauDTO, String... instance) {
        if (niveauDTO == null) {
            return null;
        }
        Niveau result = new Niveau();
        result.setNiveauId(niveauDTO.getNiveauId());
        result.setNiveauLibelle(niveauDTO.getNiveauLibelle());
        if (Arrays.binarySearch(instance, "ClassroomMapper") < 0) {
            result.setClassrooms(classroomMapper.get().mapToEntity(niveauDTO.getClassrooms()));
        }
        return result;
    }
}
