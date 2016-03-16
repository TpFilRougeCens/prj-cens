package mapDtoJpa.mappable;

import dto.FiliereDTO;
import dto.VoieDTO;
import mapDtoJpa.mapper.Mapper;
import model.Filiere;
import model.Voie;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Gawel on 16/03/2016.
 */
public class VoieMapper extends Mapper<VoieDTO, Voie> {

    @Inject
    FiliereMapper filiereMapper;

    @Override
    public VoieDTO mapFromEntity(Voie voie) {
        if (voie == null) {
            return null;
        }

        Collection<FiliereDTO> filieresDeLaVoie = filiereMapper.mapFromEntity(voie.getFilieres());

        VoieDTO result = new VoieDTO();
        result.setVoieId(voie.getVoieId());
        result.setVoieLibelle(voie.getVoieLibelle());
        result.setFilieres(CollectionToListFiliereDTO(filieresDeLaVoie));
        return result;
    }

    @Override
    public Voie mapToEntity(VoieDTO voieDTO) {
        if (voieDTO == null) {
            return null;
        }

        Collection<Filiere> filieresDeLaVoie = filiereMapper.mapToEntity(voieDTO.getFilieres());

        Voie result = new Voie();
        result.setVoieId(voieDTO.getVoieId());
        result.setVoieLibelle(voieDTO.getVoieLibelle());
        result.setFilieres(CollectionToListFiliereENTITY(filieresDeLaVoie));
        return result;

    }

    // ******************* CONVERTION DES TYPES ********************************************
    // Attention pas de surcharge : limite du compilateur... et oui...
    private List<FiliereDTO> CollectionToListFiliereDTO(Collection<FiliereDTO> filieresDuBloc) {
        List<FiliereDTO> listFilieres;
        if (filieresDuBloc instanceof List) {
            listFilieres = (List<FiliereDTO>) filieresDuBloc;
        } else {
            listFilieres = new ArrayList<FiliereDTO>(filieresDuBloc);
        }
        return listFilieres;
    }

    private List<Filiere> CollectionToListFiliereENTITY(Collection<Filiere> filieresDuBloc) {
        List<Filiere> listFilieres;
        if (filieresDuBloc instanceof List) {
            listFilieres = (List<Filiere>) filieresDuBloc;
        } else {
            listFilieres = new ArrayList<Filiere>(filieresDuBloc);
        }
        return listFilieres;
    }
}
