package mapDtoJpa.mappable;

import dto.VoieDTO;
import mapDtoJpa.mapper.Mapper;
import model.Voie;

import javax.inject.Inject;

/**
 * Created by Gawel on 16/03/2016.
 */
public class VoieMapper extends Mapper<VoieDTO, Voie> {

    @Inject
    private FiliereMapper filiereMapper;

    @Override
    public VoieDTO mapFromEntity(Voie voie) {
        if (voie == null) {
            return null;
        }

        VoieDTO result = new VoieDTO();
        result.setVoieId(voie.getVoieId());
        result.setVoieLibelle(voie.getVoieLibelle());
        result.setFilieres(filiereMapper.mapFromEntity(voie.getFilieres()));
        return result;
    }

    @Override
    public Voie mapToEntity(VoieDTO voieDTO) {
        if (voieDTO == null) {
            return null;
        }

        Voie result = new Voie();
        result.setVoieId(voieDTO.getVoieId());
        result.setVoieLibelle(voieDTO.getVoieLibelle());
        result.setFilieres(filiereMapper.mapToEntity(voieDTO.getFilieres()));
        return result;

    }

}
