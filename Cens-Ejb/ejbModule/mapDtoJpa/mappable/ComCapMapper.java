package mapDtoJpa.mappable;

import dto.ComCapDTO;
import mapDtoJpa.mapper.Mapper;
import model.ComCap;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Arrays;

/**
 * Created by gael.cdi12 : 17/03/2016.
 */
public class ComCapMapper extends Mapper<ComCapDTO, ComCap> {

    @Inject
    Provider<AssocComCapMapper> assocComCapMapper;


    @Override
    public ComCapDTO mapFromEntity(ComCap comCap, String... instance) {
        if (comCap == null) {
            return null;
        }
        ComCapDTO result = new ComCapDTO();
        result.setComCapId(comCap.getComCapId());
        result.setComCapLibelle(comCap.getComCapLibelle());
        //on passe le nom de la classe instance pour éviter une boucle infini entre Voie et Filière
        if (Arrays.binarySearch(instance, "AssocComCapMapper") < 0) {
            result.setAssocComCaps1(assocComCapMapper.get().mapFromEntity(comCap.getAssocComCaps1())); //parent = compétence
            result.setAssocComCaps2(assocComCapMapper.get().mapFromEntity(comCap.getAssocComCaps2())); //enfant = capacité
        }
        return result;
    }

    @Override
    public ComCap mapToEntity(ComCapDTO comCapDTO, String... instance) {
        if (comCapDTO == null) {
            return null;
        }
        ComCap result = new ComCap();
        result.setComCapId(comCapDTO.getComCapId());
        result.setComCapLibelle(comCapDTO.getComCapLibelle());
        //on passe le nom de la classe instance pour éviter une boucle infini entre Voie et Filière
        if (Arrays.binarySearch(instance, "AssocComCapMapper") < 0) {
            result.setAssocComCaps1(assocComCapMapper.get().mapToEntity(comCapDTO.getAssocComCaps1())); //parent = compétence
            result.setAssocComCaps2(assocComCapMapper.get().mapToEntity(comCapDTO.getAssocComCaps2())); //enfant = capacité
        }
        return result;
    }
}
