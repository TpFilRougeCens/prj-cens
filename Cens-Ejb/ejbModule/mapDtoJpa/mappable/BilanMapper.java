package mapDtoJpa.mappable;

import dto.BilanDTO;
import mapDtoJpa.mapper.Mapper;
import model.Bilan;

import javax.inject.Inject;

/**
 * Created by Gawel on 15/03/2016.
 */
public class BilanMapper extends Mapper<BilanDTO, Bilan> {

    // TODO : IMPLEMENTATION DE ELEVE MAPPER (COCHE GAEL ???)
    @Inject
    private EleveMapper eleveMapper;

    @Override
    public BilanDTO mapFromModel(Bilan bilan) {
        BilanDTO result = new BilanDTO();
        result.setBilanId(bilan.getBilanId());
        result.setBilanCommentaire(bilan.getBilanCommentaire());
        result.setBilanDateDebut(bilan.getBilanDateDebut());
        result.setBilanDateFin(bilan.getBilanDateFin());
        result.setBilanLibelle(bilan.getBilanLibelle());
        result.setEleve(eleveMapper.mapFromEntity(bilan.getEleve()));

        return null;
    }

    @Override
    public Bilan mapToModel(BilanDTO model) {
        return null;
    }


/*
    @Override
    public PageDTO mapFromEntity(Page page) {
        PageDTO retour = new PageDTO();
        retour.setHtml(page.getHtml());
        retour.setUrl(page.getUrl());
        retour.setId(page.getId());
        return retour;
    }

    @Override
    public Page mapToEntity(PageDTO pagePB) {
        Page retour = new Page();
        if (pagePB.getId() != null) {
            retour.setId(pagePB.getId());
        }
        retour.setUrl(pagePB.getUrl());
        retour.setHtml(pagePB.getHtml());
        return retour;
    }
*/

}
