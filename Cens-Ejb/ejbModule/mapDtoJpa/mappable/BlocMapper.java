package mapDtoJpa.mappable;

import dto.BlocDTO;
import mapDtoJpa.mapper.Mapper;
import model.Bloc;

/**
 * Created by Gawel on 16/03/2016.
 */
public class BlocMapper extends Mapper<BlocDTO, Bloc> {

//    @Inject
//    AssocFiliereBlocMapper assocFiliereBloc;
//
//    @Inject
//    MatiereMapper matiereMapper;

    @Override
    public BlocDTO mapFromEntity(Bloc bloc) {
        if (bloc == null) {
            return null;
        }

        BlocDTO result = new BlocDTO();
        result.setBlocId(bloc.getBlocId());
        result.setBlocLibelle(bloc.getBlocLibelle());
//        result.setAssocFiliereBlocs(assocFiliereBloc.mapFromEntity(bloc.getAssocFiliereBlocs()));
//        result.setMatieres(matiereMapper.mapFromEntity(bloc.getMatieres()));
        return result;
    }

    @Override
    public Bloc mapToEntity(BlocDTO blocDTO) {
        if (blocDTO == null) {
            return null;
        }

        Bloc result = new Bloc();
        result.setBlocId(blocDTO.getBlocId());
        result.setBlocLibelle(blocDTO.getBlocLibelle());
//        result.setAssocFiliereBlocs(assocFiliereBloc.mapToEntity(blocDTO.getAssocFiliereBlocs()));
//        result.setMatieres(matiereMapper.mapToEntity(blocDTO.getMatieres()));
        return result;
    }

}
