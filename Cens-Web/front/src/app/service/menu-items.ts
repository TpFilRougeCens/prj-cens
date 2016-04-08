import {AppState} from "../app.service";
import {Injectable} from "angular2/core";

var menuItem = {
    // enseignant
    'Enseignant':['ListEleve', 'ListEvaluation'],

// directeur
    'Directeur':['ListEleve', 'ListEvaluation','GestionVoie', 'Gestion'],

    // manager
    'Manager':['ListEleve', 'ListEvaluation'],

    // pedagogie
    'Pedagogie':['ListEleve', 'ListEvaluation'],

    // eleve
    'Eleve':['Lpc']
};

@Injectable()
export class MenuItem {

    constructor(private appState: AppState) {}

    isVisible(route: String): boolean {
        return menuItem[this.appState.get('role')].indexOf(route) != -1;
    }
}
