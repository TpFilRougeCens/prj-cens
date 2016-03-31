import {Component} from "angular2/core";
import {RestEleve} from "../../service/rest.eleve";
import {AppState} from "../../app.service";
import {Router} from "angular2/router";
import {LoadingImage} from "../../components/loading-image/loading.image";

/*
 * We're loading this component asynchronously
 * We are using some magic with es6-promise-loader that will  wrap the module with a Promise
 * see https://github.com/gdi2290/es6-promise-loader for more info
 */

console.log('`About` component loaded asynchronously');

@Component({
    selector: 'liste-eleve',
    directives: [LoadingImage],
    providers: [RestEleve],
    template: require('./liste-eleve.html')
    /*template: `
     <h2>Liste des élèves</h2>
     <div class="form-group">
     <label for="classe">Classe</label>
     <select class="form-control"
     [(ngModel)]="model.classe" >
     <option *ngFor="#classe of classes" [value]="classe">{{classe}}</option>
     </select>
     <div class="form-group">
     <label for="filtre">Filtre</label>
     <input type="text" class="form-control"
     [(ngModel)]="model.filtre" >
     </div>
     </div>

     <table *ngIf="elevesVisible.length != 0" class="table table-hover">
     <tr>
     <td>Nom</td>
     <td>Prénom</td>
     <td>Classe</td>
     <td>Voie</td>
     <td>Filière</td>
     </tr>
     <tr *ngFor="#eleve of elevesVisible" (click)="onEleveSelect(eleve.id)">
     <template [ngIf]="
     (eleve.nom.indexOf(model.filtre) > -1 || eleve.prenom.indexOf(model.filtre) > -1 )&&
     ( eleve.classe + ' ' + eleve.voie + ' ' + eleve.filiere + ' ' + eleve.libelle == model.classe
     || model.classe == textAllClass )
     ">
     <td>{{eleve.nom}}</td>
     <td>{{eleve.prenom}}</td>
     <td>{{eleve.classe + " " + eleve.libelle}}</td>
     <td>{{eleve.voie}}</td>
     <td>{{eleve.filiere}}</td>
     </template>
     </tr>
     </table>

     <div *ngIf="elevesVisible.length == 0">
     <loading-image></loading-image>
     </div>
     `*/
})
export class ListEleve {
    eleves = [];
    elevesVisible = [];
    classes;
    textAllClass = 'Toutes les classes';
    model = {'filtre': '', 'classe': this.textAllClass};
    submitted = false;

    onSubmit() {
        this.submitted = true;
    }

    // TODO: Remove this when we're done
    get diagnostic() {
        return JSON.stringify(this.model);
    }

    constructor(private restEleveService:RestEleve, public appState:AppState, public router:Router) {
    }

    ngOnInit() {
        console.log('hello `Liste eleve` component');
        // static data that is bundled
        var mockData = require('assets/mock-data/mock-data.json');
        console.log(this.appState.get('classes'));

        this.classes = ['Toutes les classes', ...this.appState.get('classes')];
        this.restEleveService.getEleve()
            .subscribe(
                (restEleve:any) => {
                    console.log(restEleve.json());
                    restEleve.json().classes.forEach((classe) => {
                        console.log(classe.voie.libelle);
                        classe.eleves.forEach((eleve) => {
                            this.eleves.push(Object.assign({}, {'voie': classe.voie.libelle}, {'filiere': classe.filiere.libelle}, {'classe': classe.niveau.libelle}, {'libelle': classe.libelle}, eleve));
                            this.elevesVisible.push(Object.assign({}, {'voie': classe.voie.libelle}, {'filiere': classe.filiere.libelle}, {'classe': classe.niveau.libelle}, {'libelle': classe.libelle}, eleve));
                        });
                    });

                    console.log("eleves", this.eleves);

                },
                (err) => {
                }
            );
        // if you're working with mock data you can also use http.get('assets/mock-data/mock-data.json')
        //this.asyncDataWithWebpack();
    }

    onEleveSelect(id:number) {
        //console.log(id);
        this.appState.set('idLpc', id);
        this.router.navigate(['../Lpc']);
    }


}
