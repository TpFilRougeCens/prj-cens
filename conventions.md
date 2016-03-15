# CONVENTIONS DE NOMMAGE
===================================

## Conventions de la Base de données
----------------------------------------------
* Les tables : 
    * Les tables simple : 'nomdelatable' | exemple : 'bilan'
    * Les tables d'association : 'Assoc_nomdelatable' | exemple : 'assoc_etudier'
* Les attributs :
    * les attributs simple :'nomdelatable_nomduchamps'
    * les attributs ID : 'nomdelatable_nomduchamps_id'
    * Les attributs FK : 'nomdelatable_fknomduchamps'
    
## Conventions de développement
----------------------------------------------
*  Les Entity JPA : type 'model' | nommmage : xxx.java | exemple : 'Bilan.java'
*  Les DTO : type 'dto' | nommmage : xxxDTO.java | exemple : 'BilanDTO.java'
*  Les Maps JPA->DTO & DTO->JPA : nommmage : xxxMapper.java | exemple : 'BilanMapper.java'
*  Les classe de service : nommmage : xxxService.java | exemple : 'BilanService.java'



