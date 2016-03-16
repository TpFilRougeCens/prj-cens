package mapDtoJpa.mappable;

import dto.GroupeDTO;
import dto.PersonneDTO;
import mapDtoJpa.mapper.Mapper;
import model.Groupe;
import model.Personne;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Gawel on 16/03/2016.
 */
public class GroupeMapper extends Mapper<GroupeDTO, Groupe> {

    @Inject
    PersonneMapper personneMapper;

    @Override
    public GroupeDTO mapFromEntity(Groupe groupe) {
        if (groupe == null) {
            return null;
        }

        //Convertion du type COLLECTION vers LIST<PersonneDTO>
        Collection<PersonneDTO> personnesDuGroupe = personneMapper.mapFromEntity(groupe.getPersonnes());

        GroupeDTO result = new GroupeDTO();
        result.setGroupeId(groupe.getGroupeId());
        result.setGroupeLibelle(groupe.getGroupeLibelle());
        result.setGroupeNiveauAcces(groupe.getGroupeNiveauAcces());
        result.setPersonnes(CollectionToListDTO(personnesDuGroupe));
        return result;
    }


    @Override
    public Groupe mapToEntity(GroupeDTO groupeDTO) {
        if (groupeDTO == null) {
            return null;
        }

        //CAST du type Collection vers List
        Collection<Personne> personnesDuGroupe = personneMapper.mapToEntity(groupeDTO.getPersonnes());

        Groupe result = new Groupe();
        result.setGroupeId(groupeDTO.getGroupeId());
        result.setGroupeLibelle(groupeDTO.getGroupeLibelle());
        result.setGroupeNiveauAcces(groupeDTO.getGroupeNiveauAcces());
        result.setPersonnes(CollectionToListENTITY(personnesDuGroupe));
        return result;
    }


    // TODO Verifier ça... result.setPersonne attend une List le Mapper renvoi une Collection
    // ******************* CONVERTION DES TYPES ********************************************
    // Attention pas de surcharge : limite du compilateur... et oui...
    private List<PersonneDTO> CollectionToListDTO(Collection<PersonneDTO> personnesDuGroupe) {
        List<PersonneDTO> listPersonnes;
        if (personnesDuGroupe instanceof List) {
            listPersonnes = (List<PersonneDTO>) personnesDuGroupe;
        } else {
            listPersonnes = new ArrayList<PersonneDTO>(personnesDuGroupe);
        }
        return listPersonnes;
    }

    private List<Personne> CollectionToListENTITY(Collection<Personne> personnesDuGroupe) {
        List<Personne> listPersonnes;
        if (personnesDuGroupe instanceof List) {
            listPersonnes = (List<Personne>) personnesDuGroupe;
        } else {
            listPersonnes = new ArrayList<Personne>(personnesDuGroupe);
        }
        return listPersonnes;
    }


}
