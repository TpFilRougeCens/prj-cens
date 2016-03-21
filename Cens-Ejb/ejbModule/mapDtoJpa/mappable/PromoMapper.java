package mapDtoJpa.mappable;

import dto.PromoDTO;
import mapDtoJpa.mapper.Mapper;
import model.Promo;

/**
 * Created by gael.cdi12 : 17/03/2016.
 */
public class PromoMapper extends Mapper<PromoDTO, Promo> {

    @Override
    public PromoDTO mapFromEntity(Promo promo, String... instance) {
        if (promo == null) {
            return null;
        }
        PromoDTO result = new PromoDTO();
        result.setPromoId(promo.getPromoId());
        result.setPromoLibelle(promo.getPromoLibelle());
        return result;
    }

    @Override
    public Promo mapToEntity(PromoDTO promoDTO, String... instance) {
        if (promoDTO == null) {
            return null;
        }
        Promo result = new Promo();
        result.setPromoId(promoDTO.getPromoId());
        result.setPromoLibelle(promoDTO.getPromoLibelle());
        return result;
    }
}
