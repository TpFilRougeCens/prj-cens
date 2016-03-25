package mapDtoJpa.mappable;

import dto.EleveDTO;
import mapDtoJpa.mapper.Mapper;
import model.Eleve;

import javax.inject.Inject;

/**
 * Created by gael.cdi12 : 16/03/2016.
 */
public class EleveMapper extends Mapper<EleveDTO, Eleve> {
    @Inject
    private GroupeMapper groupeMapper;

    @Override
    public EleveDTO mapFromEntity(Eleve eleve, String... instance) {
        if (eleve == null) {
            return null;
        }

        EleveDTO result = new EleveDTO();
        result.setPersonneId(eleve.getPersonneId());
        result.setPersonneLogin(eleve.getPersonneLogin());
        result.setPersonnePassword(eleve.getPersonnePassword());
        result.setPersonneNom(eleve.getPersonneNom());
        result.setPersonnePrenom(eleve.getPersonnePrenom());
        result.setPersonneDateNaissance(eleve.getPersonneDateNaissance());
        result.setPersonneAdresse(eleve.getPersonneAdresse());
        result.setPersonneCp(eleve.getPersonneCp());
        result.setPersonneVille(eleve.getPersonneVille());
        result.setEleveEmailParent(eleve.getEleveEmailParent());
        result.setGroupe(groupeMapper.mapFromEntity(eleve.getGroupe()));
        return result;
    }

    @Override
    public Eleve mapToEntity(EleveDTO eleveDTO, String... instance) {
        if (eleveDTO == null) {
            return null;
        }
        Eleve result = new Eleve();
        result.setPersonneId(eleveDTO.getPersonneId());
        result.setPersonneLogin(eleveDTO.getPersonneLogin());
        result.setPersonnePassword(eleveDTO.getPersonnePassword());
        result.setPersonneNom(eleveDTO.getPersonneNom());
        result.setPersonnePrenom(eleveDTO.getPersonnePrenom());
        result.setPersonneDateNaissance(eleveDTO.getPersonneDateNaissance());
        result.setPersonneAdresse(eleveDTO.getPersonneAdresse());
        result.setPersonneCp(eleveDTO.getPersonneCp());
        result.setPersonneVille(eleveDTO.getPersonneVille());
        result.setGroupe(groupeMapper.mapToEntity(eleveDTO.getGroupe()));
        result.setEleveEmailParent(eleveDTO.getEleveEmailParent());
        return result;
    }

}
