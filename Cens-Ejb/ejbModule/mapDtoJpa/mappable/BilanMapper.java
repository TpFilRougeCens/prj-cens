package mapDtoJpa.mappable;

import dto.BilanDTO;
import mapDtoJpa.mapper.Mapper;
import model.Bilan;

import javax.inject.Inject;

/**
 * Created by Gawel on 15/03/2016.
 */
public class BilanMapper extends Mapper<BilanDTO, Bilan> {

    @Inject
    private EleveMapper eleveMapper;

    @Override
    public BilanDTO mapFromEntity(Bilan bilan, String... instance) {
        if (bilan == null) {
            return null;
        }
        BilanDTO result = new BilanDTO();
        result.setBilanId(bilan.getBilanId());
        result.setEleve(eleveMapper.mapFromEntity(bilan.getEleve()));
        result.setBilanLibelle(bilan.getBilanLibelle());
        result.setBilanCommentaire(bilan.getBilanCommentaire());
        result.setBilanDateDebut(bilan.getBilanDateDebut());
        result.setBilanDateFin(bilan.getBilanDateFin());
        return result;
    }

    @Override
    public Bilan mapToEntity(BilanDTO bilanDTO, String... instance) {
        if (bilanDTO == null) {
            return null;
        }
        Bilan result = new Bilan();
        result.setBilanId(bilanDTO.getBilanId());
        result.setEleve(eleveMapper.mapToEntity(bilanDTO.getEleve()));
        result.setBilanLibelle(bilanDTO.getBilanLibelle());
        result.setBilanCommentaire(bilanDTO.getBilanCommentaire());
        result.setBilanDateDebut(bilanDTO.getBilanDateDebut());
        result.setBilanDateFin(bilanDTO.getBilanDateFin());
        return result;
    }

}
