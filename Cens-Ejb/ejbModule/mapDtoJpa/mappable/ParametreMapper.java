package mapDtoJpa.mappable;

import dto.ParametreDTO;
import mapDtoJpa.mapper.Mapper;
import model.Parametre;

/**
 * Created by gael.cdi12 : 17/03/2016.
 */
public class ParametreMapper extends Mapper<ParametreDTO, Parametre> {
    @Override
    public ParametreDTO mapFromEntity(Parametre parametre) {
        if (parametre == null) {
            return null;
        }
        ParametreDTO result = new ParametreDTO();
        result.setParametreId(parametre.getParametreId());
        result.setParametreLibelle(parametre.getParametreLibelle());
        result.setParametreValeur(parametre.getParametreValeur());
        return result;
    }

    @Override
    public Parametre mapToEntity(ParametreDTO parametreDTO) {
        if (parametreDTO == null) {
            return null;
        }
        Parametre result = new Parametre();
        result.setParametreId(parametreDTO.getParametreId());
        result.setParametreLibelle(parametreDTO.getParametreLibelle());
        result.setParametreValeur(parametreDTO.getParametreValeur());
        return result;
    }
}
