package mapDtoJpa.mappable;

import dto.VoieDTO;
import mapDtoJpa.mapper.Mapper;
import model.Voie;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Arrays;

/**
 * Created by Gawel : 16/03/2016.
 */
public class VoieMapper extends Mapper<VoieDTO, Voie> {

    @Inject
    private Provider<FiliereMapper> filiereMapper;

    @Override
    public VoieDTO mapFromEntity(Voie voie, String... instance) {
        if (voie == null) {
            return null;
        }

        VoieDTO result = new VoieDTO();
        result.setVoieId(voie.getVoieId());
        result.setVoieLibelle(voie.getVoieLibelle());
        //on passe le nom de la classe instance pour éviter une boucle infini entre Voie et Filière
        if (Arrays.binarySearch(instance, "FiliereMapper") < 0) {
            result.setFilieres(filiereMapper.get().mapFromEntity(voie.getFilieres(), this.getClass().getSimpleName()));
        }
        return result;
    }

    @Override
    public Voie mapToEntity(VoieDTO voieDTO, String... instance) {
        if (voieDTO == null) {
            return null;
        }

        Voie result = new Voie();
        result.setVoieId(voieDTO.getVoieId());
        result.setVoieLibelle(voieDTO.getVoieLibelle());
        //on passe le nom de la classe instance pour éviter une boucle infini entre Voie et Filière
        if (Arrays.binarySearch(instance, "FiliereMapper") < 0) {
            result.setFilieres(filiereMapper.get().mapToEntity(voieDTO.getFilieres(), this.getClass().getSimpleName()));
        }
        return result;

    }

}
