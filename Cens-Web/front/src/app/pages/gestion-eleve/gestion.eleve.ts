import {Component} from 'angular2/core';
import {RestEleve} from '../../service/rest.eleve';
import {AppState} from '../../app.service';
import {Router} from 'angular2/router';
import {LoadingImage} from '../../components/loading-image/loading.image';
import {RestClasse} from '../../service/rest.classe';

@Component({
    selector: 'gestion-eleve',
    directives: [LoadingImage],
    providers: [RestEleve, RestClasse],
    template: require('./gestion-eleve.html')
})
export class GestionEleve {
    eleves = [];
    elevesVisible = [];
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

    constructor(private restClasseService: RestClasse, private restEleveService: RestEleve, public appState: AppState,
                public router: Router) {
    }

    ngOnInit() {
        console.log('hello `Liste eleve` component');
        // static data that is bundled
        var mockData = require('assets/mock-data/mock-data.json');

        this.classes = [{'id': 0, 'niveau': 'Toutes les classes', 'filiere': '', 'libelle': ''},
            ...this.appState.get('classesEnseignant')];
        this.restEleveService.getAllEleve()
            .subscribe(
                (restEleve: any) => {
                    console.log(restEleve.json());
                    restEleve.json().classes.forEach((classe) => {
                        console.log(classe.voie.libelle);
                        classe.eleves.forEach((eleve) => {
                            this.eleves.push(Object.assign({},
                                {'voie': classe.voie.libelle}, {'filiere': classe.filiere.libelle},
                                {'classe': classe.niveau.libelle}, {'libelle': classe.libelle},
                                {'idClasse': classe.id}, eleve));
                            this.elevesVisible.push(Object.assign({}, {'voie': classe.voie.libelle},
                                {'filiere': classe.filiere.libelle}, {'classe': classe.niveau.libelle},
                                {'libelle': classe.libelle}, {'idClasse': classe.id}, eleve));
                        });
                    });

                    console.log('eleves', this.eleves);

                },
                (err) => {
                }
            );
        // if you're working with mock data you can also use http.get('assets/mock-data/mock-data.json')
        //this.asyncDataWithWebpack();
    }

    onEleveSelect(id: number) {
        //console.log(id);
        this.appState.set('idLpc', id);
        this.router.navigate(['../Lpc']);
    }


}
