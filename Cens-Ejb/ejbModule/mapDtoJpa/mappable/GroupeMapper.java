package mapDtoJpa.mappable;

import dto.GroupeDTO;
import mapDtoJpa.mapper.Mapper;
import model.Groupe;

import javax.inject.Inject;

/**
 * Created by Gawel on 16/03/2016.
 */
public class GroupeMapper extends Mapper<GroupeDTO, Groupe> {

    @Inject
    private PersonneMapper personneMapper;

    @Override
    public GroupeDTO mapFromEntity(Groupe groupe) {
        if (groupe == null) {
            return null;
        }

        GroupeDTO result = new GroupeDTO();
        result.setGroupeId(groupe.getGroupeId());
        result.setGroupeLibelle(groupe.getGroupeLibelle());
        result.setGroupeNiveauAcces(groupe.getGroupeNiveauAcces());
        result.setPersonnes(personneMapper.mapFromEntity(groupe.getPersonnes()));
        return result;
    }


    @Override
    public Groupe mapToEntity(GroupeDTO groupeDTO) {
        if (groupeDTO == null) {
            return null;
        }

        Groupe result = new Groupe();
        result.setGroupeId(groupeDTO.getGroupeId());
        result.setGroupeLibelle(groupeDTO.getGroupeLibelle());
        result.setGroupeNiveauAcces(groupeDTO.getGroupeNiveauAcces());
        result.setPersonnes(personneMapper.mapToEntity(groupeDTO.getPersonnes()));
        return result;
    }

}
