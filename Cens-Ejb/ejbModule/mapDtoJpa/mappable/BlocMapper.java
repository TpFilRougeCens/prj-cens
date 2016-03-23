package mapDtoJpa.mappable;

import dto.BlocDTO;
import mapDtoJpa.mapper.Mapper;
import model.Bloc;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Arrays;

/**
 * Created by Gawel on 16/03/2016.
 */
public class BlocMapper extends Mapper<BlocDTO, Bloc> {

    @Inject
    private Provider<AssocFiliereBlocMapper> assocFiliereBlocMapper;

    @Inject
    private Provider<MatiereMapper> matiereMapper;

    @Override
    public BlocDTO mapFromEntity(Bloc bloc, String... instance) {
        if (bloc == null) {
            return null;
        }

        BlocDTO result = new BlocDTO();
        result.setBlocId(bloc.getBlocId());
        result.setBlocLibelle(bloc.getBlocLibelle());

        if (Arrays.binarySearch(instance, "AssocFiliereBlocMapper") < 0) {
            result.setAssocFiliereBlocs(assocFiliereBlocMapper.get().mapFromEntity(bloc.getAssocFiliereBlocs(), this.getClass().getSimpleName()));
        }
        if (Arrays.binarySearch(instance, "MatiereMapper") < 0) {
            result.setMatieres(matiereMapper.get().mapFromEntity(bloc.getMatieres(), this.getClass().getSimpleName()));
        }
        return result;
    }

    @Override
    public Bloc mapToEntity(BlocDTO blocDTO, String... instance) {
        if (blocDTO == null) {
            return null;
        }

        Bloc result = new Bloc();
        result.setBlocId(blocDTO.getBlocId());
        result.setBlocLibelle(blocDTO.getBlocLibelle());

        if (Arrays.binarySearch(instance, "AssocFiliereBlocMapper") < 0) {
            result.setAssocFiliereBlocs(assocFiliereBlocMapper.get().mapToEntity(blocDTO.getAssocFiliereBlocs(), this.getClass().getSimpleName()));
        }
        if (Arrays.binarySearch(instance, "MatiereMapper") < 0) {
            result.setMatieres(matiereMapper.get().mapToEntity(blocDTO.getMatieres(), this.getClass().getSimpleName()));
        }
        return result;
    }

}
