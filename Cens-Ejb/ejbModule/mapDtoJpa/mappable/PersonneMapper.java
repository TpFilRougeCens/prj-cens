package mapDtoJpa.mappable;

import dto.PersonneDTO;
import mapDtoJpa.mapper.Mapper;
import model.Personne;

import javax.inject.Inject;

/**
 * Created by Gawel on 16/03/2016.
 */
public class PersonneMapper extends Mapper<PersonneDTO, Personne> {

    @Inject
    GroupeMapper groupeMapper;

    @Override
    public PersonneDTO mapFromEntity(Personne personne) {
        if (personne == null) {
            return null;
        }
        PersonneDTO result = new PersonneDTO();
        result.setPersonneId(personne.getPersonneId());
        result.setPersonneLogin(personne.getPersonneLogin());
        result.setPersonnePassword(personne.getPersonnePassword());
        result.setPersonneNom(personne.getPersonneNom());
        result.setPersonnePrenom(personne.getPersonnePrenom());
        result.setPersonneDateNaissance(personne.getPersonneDateNaissance());
        result.setPersonneAdresse(personne.getPersonneAdresse());
        result.setPersonneCp(personne.getPersonneCp());
        result.setPersonneVille(personne.getPersonneVille());
        result.setGroupe(groupeMapper.mapFromEntity(personne.getGroupe()));
        return result;
    }

    @Override
    public Personne mapToEntity(PersonneDTO personneDTO) {
        if (personneDTO == null) {
            return null;
        }
        Personne result = new Personne();
        result.setPersonneId(personneDTO.getPersonneId());
        result.setPersonneLogin(personneDTO.getPersonneLogin());
        result.setPersonnePassword(personneDTO.getPersonnePassword());
        result.setPersonneNom(personneDTO.getPersonneNom());
        result.setPersonnePrenom(personneDTO.getPersonnePrenom());
        result.setPersonneDateNaissance(personneDTO.getPersonneDateNaissance());
        result.setPersonneAdresse(personneDTO.getPersonneAdresse());
        result.setPersonneCp(personneDTO.getPersonneCp());
        result.setPersonneVille(personneDTO.getPersonneVille());
        result.setGroupe(groupeMapper.mapToEntity(personneDTO.getGroupe()));
        return result;
    }
}
