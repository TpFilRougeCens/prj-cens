import {Component} from "angular2/core";
import {RestFiliere} from "../../service/rest.filiere";
import {AppState} from "../../app.service";
import {Router} from "angular2/router";
import {LoadingImage} from "../../components/loading-image/loading.image";

@Component({
    selector: 'gestion-filiere',
    directives: [LoadingImage],
    providers: [RestFiliere],
    template: require('./gestion-filiere.html')
})
export class GestionFiliere {
    filieres = [];
    classes;
    textAllClass = '0'; // classe.id = 0 means all classes
    model = {'filtre': '', 'classe': this.textAllClass};
    submitted = false;


    onSubmit() {
        this.submitted = true;
    }

    // TODO: Remove this when we're done
    get diagnostic() {
        return JSON.stringify(this.model);
    }

    constructor(private restFiliereService: RestFiliere, public appState: AppState, public router: Router) {

    }

    ngOnInit() {
        console.log('hello `gestion voie` component');

        this.classes = [{'id':0,'niveau':'Toutes les classes', 'filiere': '', 'libelle':''}, ...this.appState.get('classesEnseignant')];
        this.restFiliereService.getFiliere()
            .subscribe(
                (restFiliere:any) => {
                    console.log(restFiliere.json());
                    this.filieres = restFiliere.json().filiere;
                },
                (err) => {
                }
            );
    }



}
