package mapDtoJpa.mappable;

import dto.MatiereDTO;
import mapDtoJpa.mapper.Mapper;
import model.Matiere;

import javax.inject.Inject;

/**
 * Created by Gawel on 16/03/2016.
 */
public class MatiereMapper extends Mapper<MatiereDTO, Matiere> {

    @Inject
    private BlocMapper blocMapper;

    @Inject
    private AssocEnseignerMapper assocEnseignerMapper;

    @Inject
    private AssocMatiereComCapMapper assocMatiereComCapMapper;


    @Override
    public MatiereDTO mapFromEntity(Matiere matiere) {
        if (matiere == null) {
            return null;
        }

        MatiereDTO result = new MatiereDTO();
        result.setMatiereId(matiere.getMatiereId());
        result.setBloc(blocMapper.mapFromEntity(matiere.getBloc()));
        result.setMatiereLibelle(matiere.getMatiereLibelle());
        result.setAssocEnseigners(assocEnseignerMapper.mapFromEntity(matiere.getAssocEnseigners()));
        result.setAssocMatiereComCaps(assocMatiereComCapMapper.mapFromEntity(matiere.getAssocMatiereComCaps()));
        return result;
    }

    @Override
    public Matiere mapToEntity(MatiereDTO matiereDTO) {
        if (matiereDTO == null) {
            return null;
        }

        Matiere result = new Matiere();
        result.setMatiereId(matiereDTO.getMatiereId());
        result.setBloc(blocMapper.mapToEntity(matiereDTO.getBloc()));
        result.setMatiereLibelle(matiereDTO.getMatiereLibelle());
        result.setAssocEnseigners(assocEnseignerMapper.mapToEntity(matiereDTO.getAssocEnseigners()));
        result.setAssocMatiereComCaps(assocMatiereComCapMapper.mapToEntity(matiereDTO.getAssocMatiereComCaps()));
        return result;
    }
}
