package mapDtoJpa.mappable;

import dto.AssocFiliereBlocDTO;
import mapDtoJpa.mapper.Mapper;
import model.AssocFiliereBloc;

import javax.inject.Inject;

/**
 * Created by Gawel on 16/03/2016.
 */
public class AssocFiliereBlocMapper extends Mapper<AssocFiliereBlocDTO, AssocFiliereBloc> {

    @Inject
    BlocMapper blocMapper;

    @Inject
    FiliereMapper filiereMapper;

    @Override
    public AssocFiliereBlocDTO mapFromEntity(AssocFiliereBloc assocFiliereBloc) {
        if (assocFiliereBloc == null) {
            return null;
        }
        AssocFiliereBlocDTO result = new AssocFiliereBlocDTO();
        result.setAssocFiliereBlocId(assocFiliereBloc.getAssocFiliereBlocId());
        result.setBloc(blocMapper.mapFromEntity(assocFiliereBloc.getBloc()));
        result.setFiliere(filiereMapper.mapFromEntity(assocFiliereBloc.getFiliere()));
        return result;
    }

    @Override
    public AssocFiliereBloc mapToEntity(AssocFiliereBlocDTO assocFiliereBlocDTO) {
        if (assocFiliereBlocDTO == null) {
            return null;
        }
        AssocFiliereBloc result = new AssocFiliereBloc();
        result.setAssocFiliereBlocId(assocFiliereBlocDTO.getAssocFiliereBlocId());
        result.setBloc(blocMapper.mapToEntity(assocFiliereBlocDTO.getBloc()));
        result.setFiliere(filiereMapper.mapToEntity(assocFiliereBlocDTO.getFiliere()));
        return result;
    }
}
