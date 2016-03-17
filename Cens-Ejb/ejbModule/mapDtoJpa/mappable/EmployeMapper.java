package mapDtoJpa.mappable;

import dto.EmployeDTO;
import mapDtoJpa.mapper.Mapper;
import model.Employe;

import javax.inject.Inject;

/**
 * Created by gael.cdi12 : 17/03/2016.
 */
public class EmployeMapper extends Mapper<EmployeDTO, Employe> {

    @Inject
    private GroupeMapper groupeMapper;

    @Override
    public EmployeDTO mapFromEntity(Employe employe) {
        if (employe == null) {
            return null;
        }
        EmployeDTO result = new EmployeDTO();
        result.setPersonneId(employe.getPersonneId());
        result.setPersonneLogin(employe.getPersonneLogin());
        result.setPersonnePassword(employe.getPersonnePassword());
        result.setPersonneNom(employe.getPersonneNom());
        result.setPersonnePrenom(employe.getPersonnePrenom());
        result.setPersonneDateNaissance(employe.getPersonneDateNaissance());
        result.setPersonneAdresse(employe.getPersonneAdresse());
        result.setPersonneCp(employe.getPersonneCp());
        result.setPersonneVille(employe.getPersonneVille());
        result.setGroupe(groupeMapper.mapFromEntity(employe.getGroupe()));
        return result;
    }

    @Override
    public Employe mapToEntity(EmployeDTO employeDTO) {
        if (employeDTO == null) {
            return null;
        }
        Employe result = new Employe();
        result.setPersonneId(employeDTO.getPersonneId());
        result.setPersonneLogin(employeDTO.getPersonneLogin());
        result.setPersonnePassword(employeDTO.getPersonnePassword());
        result.setPersonneNom(employeDTO.getPersonneNom());
        result.setPersonnePrenom(employeDTO.getPersonnePrenom());
        result.setPersonneDateNaissance(employeDTO.getPersonneDateNaissance());
        result.setPersonneAdresse(employeDTO.getPersonneAdresse());
        result.setPersonneCp(employeDTO.getPersonneCp());
        result.setPersonneVille(employeDTO.getPersonneVille());
        result.setGroupe(groupeMapper.mapToEntity(employeDTO.getGroupe()));
        return result;
    }
}
