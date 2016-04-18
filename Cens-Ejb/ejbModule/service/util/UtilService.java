package service.util;

import model.AssocEtudier;
import model.ComCap;
import model.Eleve;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by steven on 09/04/16.
 */
public class UtilService {

    public JSONObject convertEleveToJson(Eleve p) {
        JSONObject eleveJson = new JSONObject();

        eleveJson.put("id", p.getPersonneId());
        eleveJson.put("login", p.getPersonneLogin());
        eleveJson.put("password", p.getPersonnePassword());
        eleveJson.put("nom", p.getPersonneNom());
        eleveJson.put("prenom", p.getPersonnePrenom());
        eleveJson.put("dateNaissance", p.getPersonneDateNaissance());
        eleveJson.put("adresse", p.getPersonneAdresse());
        eleveJson.put("cp", p.getPersonneCp());
        eleveJson.put("ville", p.getPersonneVille());
        eleveJson.put("emailParent", p.getEleveEmailParent());

        return eleveJson;
    }

    public JSONObject convertComCapToJson(ComCap c){
        JSONObject comCapJson = new JSONObject();

        comCapJson.put("id",c.getComCapId());

        return comCapJson;
    }
}
