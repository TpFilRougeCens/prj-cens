package mapDtoJpa.mappable;

import dto.DroitDTO;
import mapDtoJpa.mapper.Mapper;
import model.Droit;

import javax.inject.Inject;

/**
 * Created by gael.cdi12 : 17/03/2016.
 */
public class DroitMapper extends Mapper<DroitDTO, Droit> {

    @Inject
    GroupeMapper groupeMapper;

    @Override
    public DroitDTO mapFromEntity(Droit droit) {
        if (droit == null) {
            return null;
        }
        DroitDTO result = new DroitDTO();
        result.setDroitId(droit.getDroitId());
        result.setDroitUnite(droit.getDroitUnite());
        result.setDroitLecture(droit.getDroitLecture());
        result.setDroitEcriture(droit.getDroitEcriture());
        result.setGroupe(groupeMapper.mapFromEntity(droit.getGroupe()));
        return result;
    }

    @Override
    public Droit mapToEntity(DroitDTO droitDTO) {
        if (droitDTO == null) {
            return null;
        }
        Droit result = new Droit();
        result.setDroitId(droitDTO.getDroitId());
        result.setDroitUnite(droitDTO.getDroitUnite());
        result.setDroitLecture(droitDTO.getDroitLecture());
        result.setDroitEcriture(droitDTO.getDroitEcriture());
        result.setGroupe(groupeMapper.mapToEntity(droitDTO.getGroupe()));
        return result;
    }
}
