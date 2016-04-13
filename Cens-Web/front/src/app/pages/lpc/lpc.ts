import {Component} from "angular2/core";
import {RestLpc} from "../../service/rest.lpc";
import {AppState} from "../../app.service";
import {LoadingImage} from "../../components/loading-image/loading.image";
import {ConvertDatePipe} from "../../pipes/ConvertDate.pipe";
import {ClickOutsideDirective} from "../../directives/click.outside";
import {EventEmitter} from "angular2/core";
import {ViewChild} from "angular2/core";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {ControlGroup} from "angular2/common";
import {FormBuilder} from "angular2/common";
import {Validators} from "angular2/common";
import {MODAL_DIRECTIVES} from "ng2-bs3-modal/ng2-bs3-modal";
import {RestEleve} from "../../service/rest.eleve";
import {Input} from "angular2/core";
import {Output} from "angular2/core";

console.log('`Liste evaluation` component loaded asynchronously');

@Component({
    selector: 'commentaire-editable',
    inputs: ['eval'],
    outputs: ['nouvelEval'],
    directives: [ClickOutsideDirective],
    template: `
       <div *ngIf="!editable" id={{eval.id}} (click)="edit($event,eval.id)"
             [ngStyle]="{'width':'100%','padding':'10px','margin': '0px','box-sizing': 'border-box',
               '-webkit-box-sizing':'border-box',
               '-moz-box-sizing': 'border-box'}">{{eval.evalEnseignant.commentaire}}</div>
       <input *ngIf="editable"
           id={{eval.id}}
           [ngStyle]="{'width':'100%','padding':'10px','margin': '0px','box-sizing': 'border-box',
               '-webkit-box-sizing':'border-box',
               '-moz-box-sizing': 'border-box'}"
           #comInput
           value="{{eval.evalEnseignant.commentaire}}"
           (clickOutside)="clickOutside($event, comInput.value, eval.id)">

  `,
    pipes: [ConvertDatePipe]
})
class CommentaireEditable {
    editable: boolean = false;
    targetTagName;
    targetId;
    nouvelEval: EventEmitter<any> = new EventEmitter<any>();
    eval;

    constructor(public appState:AppState) {
        this.eval = eval;
    }

    edit(event, id) {
        console.log("Click inside! " +event.target.tagName);
        console.log("event: " ,event);

        console.log("id: " ,id);
        this.editable = true;
        this.targetTagName = event.target.tagName;
        this.targetId = id;

    }

    clickOutside(event, commentaire ) {
        // Des paquerettes dans ton ...
        if (this.targetId != event.target.id) {
            this.eval.evalEnseignant.commentaire = commentaire;
            this.editable = false;
            this.eval.commentaire = commentaire;
            console.log( "Click outside! ", event.target.tagName );
            console.log( "new comment: ", commentaire );
            console.log( "new eval: ", this.eval );
            this.nouvelEval.emit(this.eval);
        }
    }
}


@Component({
    selector: 'bloc-competence',
    directives: [CommentaireEditable, MODAL_DIRECTIVES],
    template: `
  <!--<div class="col-sm-12">-->
      <div class="panel panel-default bloc-competence">
          <div class="panel-heading roll-cursor-pointer" (click)="toggle()">
              <span class="label label-info">Compétence</span> {{comp.libelle}}
          </div>
          <div *ngIf="show">
              <div class="panel-body">
                 <div *ngFor="#cap of comp.capacite">
                    <p>
                        <span class="label label-default">Capacité</span><b> {{cap.libelle}}</b>
                        <button [ngStyle]="{'float': 'right', 'margin-bottom':'10px'}" type="button" class="btn btn-success" (click)="openModalAdd(cap)">Ajouter une évaluation</button>
                    </p>
                    <table class="table table-striped table-bordered table-hover">
                        <tr>
                          <th class="text-center">Date</th>
                          <th class="text-center">Evaluation</th>
                          <th class="text-center">Auto-évaluation</th>
                          <th *ngIf="appState.get('role') == 'Enseignant'" style="width:70%;">Commentaire</th>
                          <th *ngIf="appState.get('role') == 'Enseignant'"></th>

                        </tr>
                        <tr *ngFor="#eval of cap.evaluation">
                          <td class="text-center">{{"FR" | convertToFrDate: eval.date}}</td>
                          <td [style.color]="eval.evalEnseignant.couleur" class="text-center"><b>{{eval.evalEnseignant.abvr}}</b></td>
                          <td [style.color]="eval.evalEleve.couleur" class="text-center"><b>{{eval.evalEleve.abvr}}</b></td>
                          <td *ngIf="appState.get('role') == 'Enseignant'"  [ngStyle]="{'padding':'0px'}"><commentaire-editable [eval]="eval"  (nouvelEval)="saveEval($event, cap)"></commentaire-editable></td>
                          <td *ngIf="appState.get('role') == 'Enseignant'" (click)="openModalDelete(eval.id)"><div class="text-center"><span [ngStyle]="{'color':'red','text-align':'center'}" class="glyphicon glyphicon-remove" aria-hidden="true"></span></div></td>
                        </tr>
                    </table>
                    <hr/>
                 </div>
              </div>
          </div>
      </div>
  <!--</div>-->

        <modal #modalDelete>
            <modal-header [show-close]="true">
                <h4 class="modal-title">Confirmation</h4>
            </modal-header>
            <modal-body>
                Confirmez la suppression de l'évaluation
            </modal-body>
            <modal-footer>
                <button type="button" class="btn btn-default" data-dismiss="modal" (click)="modalDelete.dismiss()">Annuler</button>
                <button type="button" class="btn btn-danger" (click)="deleteEval()">Supprimer</button>
            </modal-footer>
        </modal>

        <modal #modalAdd>
            <modal-header [show-close]="true">
                <h4 class="modal-title">Ajouter une évaluation</h4>
            </modal-header>
                <form role="form" [ngFormModel]="form" (submit)="$event.preventDefault(); onSubmit(form.value)">
                    <fieldset>
                        <modal-body>
                            <div class="form-group">
                               <label>Date de l'évaluation</label>
                               <input class="form-control" placeholder="JJ/MM/AAAA" name="date" autofocus ngControl="date" required>
                            </div>
                            <div class="form-group">
                                <label for="evalEnseignant">Evaluation</label>
                                <select class="form-control"
                                    ngControl="evalEnseignant">
                                  <option *ngFor="#note of notes; #j = index" [value]="j+1" [ngStyle]="{'color':note.couleur}">{{note.abvr}} ({{note.libelle}})</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="evalEleve">Auto-évaluation</label>
                                <select class="form-control"
                                    ngControl="evalEleve">
                                  <option *ngFor="#note of notes; #k = index" [value]="k+1" [ngStyle]="{'color':note.couleur}">{{note.abvr}} ({{note.libelle}})</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="commentaire">Commentaire</label>
                                <input class="form-control" placeholder="Identifiant" name="commentaire" ngControl="commentaire">
                            </div>
                        </modal-body>
                        <modal-footer>
                            <div class="form-group">
                                <button type="submit" class="btn btn-success">Ajouter</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal" (click)="modalAdd.dismiss()">Annuler</button>
                            </div>
                        </modal-footer>
                    </fieldset>
                </form>
        </modal>
  `,
    pipes: [ConvertDatePipe]
})
class BlocCompetence {
    @Input() comp;

    show: boolean = false;

    // TODO récupérer les valeurs depuis la table note, web service à faire
    notes = [
        {'abvr':'', 'libelle':"Non évalué", 'valeur': '',	'couleur':'#00af4c' },
        {'abvr':'A',	'libelle':"Compétence acquise",	'valeur':20,	'couleur':'#00af4c'},
        {'abvr':'PA',	'libelle':"Compétence presque acquise",	'valeur':15,	'couleur':'#007baf'},
        {'abvr':'VA',	'libelle':"Compétence encore fragile, en voie d'acquisition",	'valeur':10,	'couleur':'#ffd600'},
        {'abvr':'EA',	'libelle':"Compétence en cours d'acquisition, débutant",	'valeur':5,	'couleur':'#ff9600'},
        {'abvr':'NA',	'libelle':"Compétence non acquise",	'valeur':0,	'couleur':'#ff0000'},
        {'abvr':'DEC',	'libelle':"Compétence désactivée",	'valeur':0,	'couleur':'#ff1000'}
    ];


    // modal delete

    @ViewChild('modalDelete')
    modalDelete: ModalComponent;

    evalIdToDelete: number;


    // modal add

    @ViewChild('modalAdd')
    modalAdd: ModalComponent;

    form:ControlGroup;
    private cap;

    @Output('refreshEvent')
    refreshEvent: EventEmitter<any> = new EventEmitter<any>();

    constructor(fb:FormBuilder, public appState:AppState, public restLpc:RestLpc) {
        this.form = fb.group({
            date: ['', Validators.required],
            evalEnseignant: ['', Validators.required],
            evalEleve: ['', Validators.required],
            commentaire: ['', Validators.required]
        });
    }

    toggle() {
        console.log("toggle comp");
        this.show = !this.show;
    }

    saveEval(evaluation, cap) {
        console.log("eval to be sent");
        console.log(evaluation);
        var newEval = {
            'id': evaluation.id,
            'enseignant': this.appState.get('id'),
            'eleve': this.appState.get('idLpc') || this.appState.get('id'),
            'capacite': cap.id,
            'evalEnseignant': evaluation.evalEnseignant.value,
            'evalEleve': evaluation.evalEleve.value,
            'date': evaluation.date,
            'commentaire': evaluation.commentaire
        };

        console.log("sending: ", newEval);

        this.restLpc.putEval(newEval)
            .subscribe(
                (response:any) => {
                    console.log(response.json());
                },
                (err) => {
                    console.log("erreur", err);
                }
            );
    }

    openModalDelete(evalId: number) {
        this.evalIdToDelete = evalId;
        this.modalDelete.open();
    }

    deleteEval() {
        this.restLpc.delete(this.evalIdToDelete)
            .subscribe(
                (msg:any) => {
                    console.log('msg: ' , msg);
                    console.log('competence: ');
                    console.log(this.comp);
                    this.comp.capacite.forEach( (cap) => {
                            var position = -1;
                            cap.evaluation.forEach( (evaluation, index) => {
                                if (evaluation.id == this.evalIdToDelete) {
                                    position = index;
                                }
                            })
                            if (position != -1) {
                                cap.evaluation.splice(position,1);
                                position = 1;
                            }
                        })
                    //this.refreshVoie();
                },
                (err) => {
                    console.log("erreur: " + err);
                    //this.error = true;
                }
            );
        this.modalDelete.close();
    }

    openModalAdd(cap) {
        this.cap = cap;
        this.modalAdd.open();
    }

    onSubmit(value: any) {
        value.evalEnseignant == 0 ? value.evalEnseignant = 1 : "";
        value.evalEleve == 0 ? value.evalEleve = 1 : "";
        var newEvalJson = {
            'enseignant': this.appState.get('id'),
            'eleve': this.appState.get('idLpc') || this.appState.get('id'),
            'capacite': this.cap.id,
            'evalEnseignant': +value.evalEnseignant,
            'evalEleve': +value.evalEleve,
            'date': value.date,
            'commentaire': value.commentaire
        };

        console.log(newEvalJson);
        this.restLpc.add(newEvalJson)
            .subscribe(
                (msg:any) => {
                    this.modalAdd.close();
                    var newEval = {
                        'date': value.date,
                        'evalEleve': {
                            'abvr': this.notes[+value.evalEleve].abvr,
                            'libelle': this.notes[+value.evalEleve].libelle,
                            'couleur': this.notes[+value.evalEleve].couleur,
                            'value': this.notes[+value.evalEleve].valeur
                        },
                        "evalEnseignant": {
                            'abvr': this.notes[+value.evalEnseignant].abvr,
                            'libelle': this.notes[+value.evalEnseignant].libelle,
                            'couleur': this.notes[+value.evalEnseignant].couleur
                        },
                        "id": msg.json().idEval
                    };
                    // {'abvr':'', 'libelle':"Non évalué", 'valeur': '',	'couleur':'#00af4c' },
                    this.cap.evaluation.push(newEval);
                    console.log('newEval: ' , newEval);

                    // this.refreshEvent.emit(null);
                },
                (err) => {
                    console.log("erreur: " + err);
                    // this.error = true;
                }
            );
    }


}


@Component({
    selector: 'bloc-matiere',
    inputs: ['matiere'],
    directives: [BlocCompetence],
    template: `
 <div class="panel panel-default ">
    <div class="roll-cursor-pointer panel-heading" (click)="toggle()">
        <b>{{matiere.libelle}}</b>
    </div>
    <div class="panel-body" *ngIf="show">
        <div *ngFor="#comp of matiere.competence">
          <bloc-competence [comp]="comp" (refreshEvent)="refresh()"></bloc-competence>
        </div>
    </div>
 </div>
  `
})
class BlocMatiere {
    matiere;
    show:boolean = true;

    @Output('refreshEvent')
    refreshEvent: EventEmitter<any> = new EventEmitter<any>();


    toggle() {
        console.log("toggle matiere");
        this.show = !this.show;
    }

    refresh(){
        console.log("refresh from BlocMatiere");
        this.refreshEvent.emit(null);
    }
}


@Component({
    selector: 'lpc',
    directives: [LoadingImage, BlocMatiere],
    providers: [RestLpc, RestEleve],
    template: require('./lpc.html')
})
export class Lpc {
    loadImg = 'assets/img/loading-bar.gif';
    idBloc:number = 0;
    anneeLpc: number;
    lpc = []; // un element par annee
    eleve;

    @Output('refreshEvent')
    refreshEvent: EventEmitter<any> = new EventEmitter<any>();

    constructor(private restLpc:RestLpc, private restEleveService:RestEleve, public appState:AppState) {
    }

    ngOnInit() {
        console.log('hello `lpc` component, id:' )+ this.appState.get('idLpc');

        this.getEleve();

        this.restEleveService.getEleve(this.appState.get('idLpc'))
            .subscribe(
                (eleve:any) => {
                    console.log(eleve.json());
                    this.eleve = eleve.json().eleve;
                    console.log("eleve: ", this.eleve);
                  //  this.eleve.classes.reverse();

                },
                (err) => {
                }
            );


    }

    onBlocSelect(id) {
        this.idBloc = id;
        console.log(id);
    }

    changeAnnee(annee: number) {
        this.anneeLpc = annee;
        console.log("annee: " + annee);
    }


    getEleve() {
        this.restLpc.getLpc(this.appState.get('idLpc'))
            .subscribe(lpc => {

                this.lpc = lpc.json().classe;
                this.anneeLpc = this.anneeLpc | this.lpc.length - 1;

                console.log("lpc complet: ");
                console.log(this.lpc);
            });
    }


    refresh() {
        this.restLpc.getLpc(this.appState.get('idLpc'))
            .subscribe(lpc => {

                this.lpc = lpc.json().classe;
                this.anneeLpc = this.anneeLpc | this.lpc.length - 1;

                console.log("lpc complet: ");
                console.log(this.lpc);
            });
    }





}
