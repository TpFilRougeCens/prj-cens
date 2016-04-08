import {Component} from "angular2/core";
import {RestClasse} from "../../service/rest.classe";
import {AppState} from "../../app.service";
import {Router} from "angular2/router";
import {LoadingImage} from "../../components/loading-image/loading.image";

@Component({
    selector: 'gestion-classe',
    directives: [LoadingImage],
    providers: [RestClasse],
    template: require('./gestion-classe.html')
})
export class GestionClasse {
    classes = [];
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

    constructor(private restClasseService: RestClasse, public appState: AppState, public router: Router) {

    }

    ngOnInit() {
        console.log('hello `gestion voie` component');

        this.restClasseService.getClasse()
            .subscribe(
                (restClasse:any) => {
                    console.log(restClasse.json());
                    this.classes = restClasse.json().classes;
                },
                (err) => {
                }
            );
    }



}
