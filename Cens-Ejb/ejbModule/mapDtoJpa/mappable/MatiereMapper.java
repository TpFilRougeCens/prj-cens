package mapDtoJpa.mappable;

import dto.MatiereDTO;
import mapDtoJpa.mapper.Mapper;
import model.Matiere;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Arrays;

/**
 * Created by Gawel on 16/03/2016.
 */
public class MatiereMapper extends Mapper<MatiereDTO, Matiere> {

    @Inject
    private BlocMapper blocMapper;

    @Inject
    private Provider<AssocEnseignerMapper> assocEnseignerMapper;

    @Inject
    private Provider<AssocMatiereComCapMapper> assocMatiereComCapMapper;


    @Override
    public MatiereDTO mapFromEntity(Matiere matiere, String... instance) {
        if (matiere == null) {
            return null;
        }

        MatiereDTO result = new MatiereDTO();
        result.setMatiereId(matiere.getMatiereId());
        result.setMatiereLibelle(matiere.getMatiereLibelle());
        result.setBloc(blocMapper.mapFromEntity(matiere.getBloc()));
        if (Arrays.binarySearch(instance, "AssocEnseignerMapper") < 0) {
            result.setAssocEnseigners(assocEnseignerMapper.get().mapFromEntity(matiere.getAssocEnseigners()));
        }
        if (Arrays.binarySearch(instance, "AssocMatiereComCapMapper") < 0) {
            result.setAssocMatiereComCaps(assocMatiereComCapMapper.get().mapFromEntity(matiere.getAssocMatiereComCaps()));
        }
        return result;
    }

    @Override
    public Matiere mapToEntity(MatiereDTO matiereDTO, String... instance) {
        if (matiereDTO == null) {
            return null;
        }

        Matiere result = new Matiere();
        result.setMatiereId(matiereDTO.getMatiereId());
        result.setMatiereLibelle(matiereDTO.getMatiereLibelle());
        result.setBloc(blocMapper.mapToEntity(matiereDTO.getBloc()));
        if (Arrays.binarySearch(instance, "AssocEnseignerMapper") < 0) {
            result.setAssocEnseigners(assocEnseignerMapper.get().mapToEntity(matiereDTO.getAssocEnseigners()));
        }
        if (Arrays.binarySearch(instance, "AssocMatiereComCapMapper") < 0) {
            result.setAssocMatiereComCaps(assocMatiereComCapMapper.get().mapToEntity(matiereDTO.getAssocMatiereComCaps()));
        }
        return result;
    }
}
