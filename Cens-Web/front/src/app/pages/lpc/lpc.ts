import {Component} from "angular2/core";
import {RestLpc} from "../../service/rest.lpc";
import {AppState} from "../../app.service";
import {LoadingImage} from "../../components/loading-image/loading.image";
import {ConvertDatePipe} from "../../pipes/ConvertDate.pipe";
import {ClickOutsideDirective} from "../../directives/click.outside";
import {EventEmitter} from "angular2/core";

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
    inputs: ['comp'],
    directives: [CommentaireEditable],
    template: `
  <!--<div class="col-sm-12">-->
      <div class="panel panel-default bloc-competence">
          <div class="panel-heading roll-cursor-pointer" (click)="toggle()">
              <span class="label label-info">Compétence</span> {{comp.libelle}}
          </div>
          <div *ngIf="show">
              <div class="panel-body">
                 <div *ngFor="#cap of comp.capacite">
                    <div><span class="label label-default">Capacité</span><b> {{cap.libelle}}</b></div>
                    <table class="table table-striped table-bordered table-hover">
                        <tr>
                          <th class="text-center">Date</th>
                          <th class="text-center">Evaluation</th>
                          <th class="text-center">Auto-évaluation</th>
                          <th *ngIf="appState.get('role') == 'Enseignant'" style="width:70%;">Commentaire</th>
                        </tr>
                        <tr *ngFor="#eval of cap.evaluation">
                          <td class="text-center">{{"FR" | convertToFrDate: eval.date}}</td>
                          <td [style.color]="eval.evalEnseignant.couleur" class="text-center"><b>{{eval.evalEnseignant.abvr}}</b></td>
                          <td [style.color]="eval.evalEleve.couleur" class="text-center"><b>{{eval.evalEleve.abvr}}</b></td>
                          <td *ngIf="appState.get('role') == 'Enseignant'"  [ngStyle]="{'padding':'0px'}"><commentaire-editable [eval]="eval"  (nouvelEval)="saveEval($event, cap)"></commentaire-editable></td>
                        </tr>
                    </table>
                    <hr/>
                 </div>
              </div>
          </div>
      </div>
  <!--</div>-->
  `,
    pipes: [ConvertDatePipe]
})
class BlocCompetence {
    comp;
    show: boolean = false;

    constructor(public appState:AppState, public restLpc:RestLpc) {
        // Les petites paquerettes dans la prairie
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

        /*
        "evaluation":{
            "id":1,
            "enseignant": 2,
            "eleve": 7,
            "capacite":49,
            "evalEnseignant": 2,
            "evalEleve": 3,
            "date": "31/01/1989",
            "commentaire": "youpiiii un commentaire"}
            */

        /*

         date: "2016-01-01",
         evalEleve: Object,
         evalEnseignant: Object,
         id: 2,
         commentaire: "un commentaire de la part du prof sur cette eval"}

         */

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
          <bloc-competence [comp]="comp"></bloc-competence>
        </div>
    </div>
 </div>
  `
})
class BlocMatiere {
    matiere;
    show:boolean = true;

    toggle() {
        console.log("toggle matiere");
        this.show = !this.show;
    }
}


@Component({
    selector: 'lpc',
    directives: [LoadingImage, BlocMatiere],
    providers: [RestLpc],
    template: require('./lpc.html')
})
export class Lpc {
    loadImg = 'assets/img/loading-bar.gif';
    idBloc:number = 0;
    lpc = []; // un element par bloc

    constructor(private restLpc:RestLpc, public appState:AppState) {
        // Les petites paquerettes dans la prairie
    }

    ngOnInit() {

        console.log('hello `lpc` component, id:' + this.appState.get('idLpc'));
        this.restLpc.getLpc(this.appState.get('idLpc'))
            .subscribe(lpc => {
                lpc.json().classe[lpc.json().classe.length - 1].bloc.forEach((bloc) => {
                    this.lpc.push(bloc);
                });


                console.log(this.lpc);
            });

    }

    onBlocSelect(id) {
        this.idBloc = id;
        console.log(id);
    }

}
