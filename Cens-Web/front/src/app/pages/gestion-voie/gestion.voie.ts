import {Component} from 'angular2/core';
import {RestVoie} from '../../service/rest.voie';
import {AppState} from '../../app.service';
import {Router} from 'angular2/router';
import {LoadingImage} from '../../components/loading-image/loading.image';
import {MODAL_DIRECTIVES, ModalComponent} from 'ng2-bs3-modal/ng2-bs3-modal';
import {ViewChild} from 'angular2/core';
import {EditableComponent} from '../../components/editable-component';
import {FormBuilder} from 'angular2/common';
import {ControlGroup} from 'angular2/common';
import {Validators} from 'angular2/common';

@Component({
    selector: 'gestion-voie',
    directives: [LoadingImage, MODAL_DIRECTIVES, EditableComponent],
    providers: [RestVoie],
    template: require('./gestion-voie.html')
})
export class GestionVoie {
    voies = [];
    classes;
    textAllClass = '0'; // classe.id = 0 means all classes
    model = {'filtre': '', 'classe': this.textAllClass};
    submitted = false;
    error: boolean;

    // modal delete
    @ViewChild('modalDelete')
    modalDelete: ModalComponent;

    voieIdToDelete: number;

    // modal add
    @ViewChild('modalAdd')
    modalAdd: ModalComponent;
    form: ControlGroup;


    // TODO: Remove this when we're done
    // pas utilisé
    get diagnostic() {
        return JSON.stringify(this.model);
    }

    constructor(fb: FormBuilder, private restVoieService: RestVoie, public appState: AppState, public router: Router) {
        this.form = fb.group({
            voie: ['', Validators.required]
        });
    }

    ngOnInit() {
        console.log('hello `gestion voie` component');

        this.classes = [{'id': 0, 'niveau': 'Toutes les classes', 'filiere': '', 'libelle': ''},
            ...this.appState.get('classesEnseignant')];

        this.refreshVoie();
    }

    openModalDelete(voieId: number) {
        this.voieIdToDelete = voieId;
        this.modalDelete.open();
    }

    saveVoie(event, voie) {

        console.log(event);
        voie.libelle = event;
        this.restVoieService.update(voie)
            .subscribe(
                (restVoie: any) => {
                    console.log('response');
                    console.log(restVoie);
                },
                (err) => {
                }
            );
    }

    deleteVoie() {
        console.log('delete: ' + this.voieIdToDelete);
        this.restVoieService.delete(this.voieIdToDelete)
            .subscribe(
            (msg: any) => {
                console.log('msg: ' + msg);
                this.refreshVoie();
            },
            (err) => {
                console.log('erreur: ' + err);
                this.error = true;
            }
        );

        this.modalDelete.close();
    }

    onSubmit(value: any) {

        console.log(value);
        this.modalAdd.dismiss();
        this.restVoieService.add(value.voie)
            .subscribe(
                (msg: any) => {
                    console.log('msg: ' + msg);
                    console.log('msg json: ' + msg.json());
                    this.refreshVoie();

                },
                (err) => {
                    console.log('erreur: ' + err);
                    this.error = true;
                }
            );



    }


    refreshVoie() {
        this.restVoieService.getVoie()
            .subscribe(
            (restVoie: any) => {
                console.log(restVoie.json());
                this.voies = restVoie.json().voies;
            },
            (err) => {
            }
            );

    }




}
