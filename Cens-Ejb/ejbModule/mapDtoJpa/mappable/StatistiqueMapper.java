package mapDtoJpa.mappable;

import dto.StatistiqueDTO;
import mapDtoJpa.mapper.Mapper;
import model.Statistique;

/**
 * Created by gael.cdi12 : 17/03/2016.
 */
public class StatistiqueMapper extends Mapper<StatistiqueDTO, Statistique> {
    @Override
    public StatistiqueDTO mapFromEntity(Statistique statistique) {
        if (statistique == null) {
            return null;
        }
        StatistiqueDTO result = new StatistiqueDTO();
        result.setStatistiqueId(statistique.getStatistiqueId());
        result.setStatistiqueLibelle(statistique.getStatistiqueLibelle());
        result.setStatistiqueValeur(statistique.getStatistiqueValeur());
        result.setStatistiqueDateStat(statistique.getStatistiqueDateStat());
        return result;
    }

    @Override
    public Statistique mapToEntity(StatistiqueDTO statistiqueDTO) {
        if (statistiqueDTO == null) {
            return null;
        }
        Statistique result = new Statistique();
        result.setStatistiqueId(statistiqueDTO.getStatistiqueId());
        result.setStatistiqueLibelle(statistiqueDTO.getStatistiqueLibelle());
        result.setStatistiqueValeur(statistiqueDTO.getStatistiqueValeur());
        result.setStatistiqueDateStat(statistiqueDTO.getStatistiqueDateStat());
        return result;
    }
}
