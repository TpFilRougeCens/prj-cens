package mapDtoJpa.mappable;

import dto.GroupeDTO;
import mapDtoJpa.mapper.Mapper;
import model.Groupe;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Arrays;

/**
 * Created by Gawel on 16/03/2016.
 */
public class GroupeMapper extends Mapper<GroupeDTO, Groupe> {

    @Inject
    private Provider<PersonneMapper> personneMapper;

    @Override
    public GroupeDTO mapFromEntity(Groupe groupe, String... instance) {
        if (groupe == null) {
            return null;
        }

        GroupeDTO result = new GroupeDTO();
        result.setGroupeId(groupe.getGroupeId());
        result.setGroupeLibelle(groupe.getGroupeLibelle());
        result.setGroupeNiveauAcces(groupe.getGroupeNiveauAcces());

        if (Arrays.binarySearch(instance, "PersonneMapper") < 0 && Arrays.binarySearch(instance, "EmployeMapper") < 0 && Arrays.binarySearch(instance, "EleveMapper") < 0) {
            result.setPersonnes(personneMapper.get().mapFromEntity(groupe.getPersonnes(), this.getClass().getSimpleName()));
        }
        return result;
    }


    @Override
    public Groupe mapToEntity(GroupeDTO groupeDTO, String... instance) {
        if (groupeDTO == null) {
            return null;
        }

        Groupe result = new Groupe();
        result.setGroupeId(groupeDTO.getGroupeId());
        result.setGroupeLibelle(groupeDTO.getGroupeLibelle());
        result.setGroupeNiveauAcces(groupeDTO.getGroupeNiveauAcces());

        if (Arrays.binarySearch(instance, "PersonneMapper") < 0 && Arrays.binarySearch(instance, "EmployeMapper") < 0 && Arrays.binarySearch(instance, "EleveMapper") < 0) {
            result.setPersonnes(personneMapper.get().mapToEntity(groupeDTO.getPersonnes(), this.getClass().getSimpleName()));
        }
        return result;
    }

}
