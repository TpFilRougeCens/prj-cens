package mapDtoJpa.mappable;

import dto.AssocFiliereBlocDTO;
import dto.ClassroomDTO;
import dto.FiliereDTO;
import mapDtoJpa.mapper.Mapper;
import model.AssocFiliereBloc;
import model.Classroom;
import model.Filiere;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Gawel on 16/03/2016.
 */
public class FiliereMapper extends Mapper<FiliereDTO, Filiere> {

    @Inject
    AssocFiliereBlocMapper assocFiliereBlocMapper;

    // TODO GAEL j'en suis la (???)
    @Inject
    ClassroomMapper classroomMapper;

    @Inject
    VoieMapper voieMapper;

    @Override
    public FiliereDTO mapFromEntity(Filiere filiere) {
        if (filiere == null) {
            return null;
        }

        Collection<AssocFiliereBlocDTO> blocsDeFiliere = assocFiliereBlocMapper.mapFromEntity(filiere.getAssocFiliereBlocs());
        Collection<ClassroomDTO> classesDeFiliere = classroomMapper.mapFromEntity(filiere.getClassrooms());

        FiliereDTO result = new FiliereDTO();
        result.setFiliereId(filiere.getFiliereId());
        result.setAssocFiliereBlocs(CollectionToListAssocDTO(blocsDeFiliere));
        result.setClassrooms(CollectionToListClassDTO(classesDeFiliere));
        result.setFiliereLibelle(filiere.getFiliereLibelle());
        result.setVoie(voieMapper.mapFromEntity(filiere.getVoie());
        return result;
    }

    @Override
    public Filiere mapToEntity(FiliereDTO filiereDTO) {
        if (filiereDTO == null) {
            return null;
        }

        Collection<AssocFiliereBloc> blocsDeFiliere = assocFiliereBlocMapper.mapToEntity(filiereDTO.getAssocFiliereBlocs());
        Collection<Classroom> classesDeFiliere = classroomMapper.mapToEntity(filiereDTO.getClassrooms());

        Filiere result = new Filiere();
        result.setFiliereId(filiereDTO.getFiliereId());
        result.setAssocFiliereBlocs(CollectionToListAssocENTITY(blocsDeFiliere));
        result.setClassrooms(CollectionToListClassENTITY(classesDeFiliere));
        result.setFiliereLibelle(filiereDTO.getFiliereLibelle());
        result.setVoie(voieMapper.mapToEntity(filiereDTO.getVoie());
        return result;
    }


    // TODO Verifier ça... result.setMatiere attend une List le Mapper renvoi une Collection
    // TODO REFACTOR
    // ******************* CONVERTION DES TYPES ********************************************
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

    private List<ClassroomDTO> CollectionToListClassDTO(Collection<ClassroomDTO> classroomsDuBloc) {
        List<ClassroomDTO> listClassrooms;
        if (classroomsDuBloc instanceof List) {
            listClassrooms = (List<ClassroomDTO>) classroomsDuBloc;
        } else {
            listClassrooms = new ArrayList<ClassroomDTO>(classroomsDuBloc);
        }
        return listClassrooms;
    }

    private List<Classroom> CollectionToListClassENTITY(Collection<Classroom> classroomsDuBloc) {
        List<Classroom> listClassrooms;
        if (classroomsDuBloc instanceof List) {
            listClassrooms = (List<Classroom>) classroomsDuBloc;
        } else {
            listClassrooms = new ArrayList<Classroom>(classroomsDuBloc);
        }
        return listClassrooms;
    }
}
