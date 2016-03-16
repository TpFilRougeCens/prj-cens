package mapDtoJpa.mappable;

import dto.AssocFiliereBlocDTO;
import dto.BlocDTO;
import dto.MatiereDTO;
import mapDtoJpa.mapper.Mapper;
import model.AssocFiliereBloc;
import model.Bloc;
import model.Matiere;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Gawel on 16/03/2016.
 */
public class BlocMapper extends Mapper<BlocDTO, Bloc> {

    @Inject
    AssocFiliereBlocMapper assocFiliereBloc;

    @Inject
    MatiereMapper matiereMapper;

    @Override
    public BlocDTO mapFromEntity(Bloc bloc) {
        if (bloc == null) {
            return null;
        }

        Collection<MatiereDTO> matieresDuBloc = matiereMapper.mapFromEntity(bloc.getMatieres());
        Collection<AssocFiliereBlocDTO> filliereDuBloc = assocFiliereBloc.mapFromEntity(bloc.getAssocFiliereBlocs());

        BlocDTO result = new BlocDTO();
        result.setBlocId(bloc.getBlocId());
        result.setBlocLibelle(bloc.getBlocLibelle());
        result.setAssocFiliereBlocs(CollectionToListAssocDTO(filliereDuBloc));
        result.setMatieres(CollectionToListMatiereDTO(matieresDuBloc));
        return result;
    }

    @Override
    public Bloc mapToEntity(BlocDTO blocDTO) {
        if (blocDTO == null) {
            return null;
        }

        Collection<Matiere> matieresDuBloc = matiereMapper.mapToEntity(blocDTO.getMatieres());
        Collection<AssocFiliereBloc> filliereDuBloc = assocFiliereBloc.mapToEntity(blocDTO.getAssocFiliereBlocs());

        Bloc result = new Bloc();
        result.setBlocId(blocDTO.getBlocId());
        result.setBlocLibelle(blocDTO.getBlocLibelle());
        result.setAssocFiliereBlocs(CollectionToListAssocENTITY(filliereDuBloc));
        result.setMatieres(CollectionToListMatiereENTITY(matieresDuBloc));
        return result;
    }

    // TODO Verifier ça... result.setMatiere attend une List le Mapper renvoi une Collection
    // TODO REFACTOR
    // ******************* CONVERTION DES TYPES ********************************************
    // Attention pas de surcharge : limite du compilateur... et oui...
    private List<MatiereDTO> CollectionToListMatiereDTO(Collection<MatiereDTO> matieresDuBloc) {
        List<MatiereDTO> listMatieres;
        if (matieresDuBloc instanceof List) {
            listMatieres = (List<MatiereDTO>) matieresDuBloc;
        } else {
            listMatieres = new ArrayList<MatiereDTO>(matieresDuBloc);
        }
        return listMatieres;
    }

    private List<Matiere> CollectionToListMatiereENTITY(Collection<Matiere> matieresDuBloc) {
        List<Matiere> listMatieres;
        if (matieresDuBloc instanceof List) {
            listMatieres = (List<Matiere>) matieresDuBloc;
        } else {
            listMatieres = new ArrayList<Matiere>(matieresDuBloc);
        }
        return listMatieres;
    }

    private List<AssocFiliereBlocDTO> CollectionToListAssocDTO(Collection<AssocFiliereBlocDTO> assocFiliereBlocsDuBloc) {
        List<AssocFiliereBlocDTO> listAssocFiliereBlocs;
        if (assocFiliereBlocsDuBloc instanceof List) {
            listAssocFiliereBlocs = (List<AssocFiliereBlocDTO>) assocFiliereBlocsDuBloc;
        } else {
            listAssocFiliereBlocs = new ArrayList<AssocFiliereBlocDTO>(assocFiliereBlocsDuBloc);
        }
        return listAssocFiliereBlocs;
    }

    private List<AssocFiliereBloc> CollectionToListAssocENTITY(Collection<AssocFiliereBloc> assocFiliereBlocsDuBloc) {
        List<AssocFiliereBloc> listAssocFiliereBlocs;
        if (assocFiliereBlocsDuBloc instanceof List) {
            listAssocFiliereBlocs = (List<AssocFiliereBloc>) assocFiliereBlocsDuBloc;
        } else {
            listAssocFiliereBlocs = new ArrayList<AssocFiliereBloc>(assocFiliereBlocsDuBloc);
        }
        return listAssocFiliereBlocs;
    }
}
