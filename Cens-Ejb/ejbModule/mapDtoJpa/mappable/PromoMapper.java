package mapDtoJpa.mappable;

import dto.PromoDTO;
import mapDtoJpa.mapper.Mapper;
import model.Promo;

import javax.inject.Inject;

/**
 * Created by gael.cdi12 : 17/03/2016.
 */
public class PromoMapper extends Mapper<PromoDTO, Promo> {

    @Inject
    private AssocEnseignerMapper assocEnseignerMapper;

    @Inject
    private AssocEtudierMapper assocEtudierMapper;

    @Override
    public PromoDTO mapFromEntity(Promo promo) {
        if (promo == null) {
            return null;
        }
        PromoDTO result = new PromoDTO();
        result.setPromoId(promo.getPromoId());
        result.setPromoLibelle(promo.getPromoLibelle());
        result.setAssocEnseigners(assocEnseignerMapper.mapFromEntity(promo.getAssocEnseigners()));
        result.setAssocEtudiers(assocEtudierMapper.mapFromEntity(promo.getAssocEtudiers()));
        return result;
    }

    @Override
    public Promo mapToEntity(PromoDTO promoDTO) {
        if (promoDTO == null) {
            return null;
        }
        Promo result = new Promo();
        result.setPromoId(promoDTO.getPromoId());
        result.setPromoLibelle(promoDTO.getPromoLibelle());
        result.setAssocEnseigners(assocEnseignerMapper.mapToEntity(promoDTO.getAssocEnseigners()));
        result.setAssocEtudiers(assocEtudierMapper.mapToEntity(promoDTO.getAssocEtudiers()));
        return result;
    }
}
