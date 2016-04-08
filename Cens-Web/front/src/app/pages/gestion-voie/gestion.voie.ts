import {Component} from "angular2/core";
import {RestVoie} from "../../service/rest.voie";
import {AppState} from "../../app.service";
import {Router} from "angular2/router";
import {LoadingImage} from "../../components/loading-image/loading.image";

@Component({
    selector: 'gestion-voie',
    directives: [LoadingImage],
    providers: [RestVoie],
    template: require('./gestion-voie.html')
})
export class GestionVoie {
    voies = [];
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

    constructor(private restVoieService: RestVoie, public appState: AppState, public router: Router) {
    }

    ngOnInit() {
        console.log('hello `gestion voie` component');

        this.classes = [{'id':0,'niveau':'Toutes les classes', 'filiere': '', 'libelle':''}, ...this.appState.get('classesEnseignant')];
        this.restVoieService.getVoie()
            .subscribe(
                (restVoie:any) => {
                    console.log(restVoie.json());
                    this.voies = restVoie.json().voies;
                },
                (err) => {
                }
            );
    }



}
