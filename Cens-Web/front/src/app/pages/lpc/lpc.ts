import {Component} from "angular2/core";
import {RestLpc} from "../../service/rest.lpc";
import {AppState} from "../../app.service";
import {LoadingImage} from "../../components/loading-image/loading.image";
import {ConvertDatePipe} from "../../pipes/ConvertDate.pipe";


/*
 * We're loading this component asynchronously
 * We are using some magic with es6-promise-loader that will  wrap the module with a Promise
 * see https://github.com/gdi2290/es6-promise-loader for more info
 */

console.log('`Liste evaluation` component loaded asynchronously');


@Component({
    selector: 'bloc-competence',
    inputs: ['comp'],
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
                          <td class="text-center">Date</td>
                          <td class="text-center">Evaluation</td>
                          <td class="text-center">Auto-évaluation</td>
                          <td *ngIf="appState.get('role') == 'Enseignant'" style="width:70%;">Commentaire</td>
                        </tr>
                        <tr *ngFor="#eval of cap.evaluation"  data-toggle="modal" data-target="#UpdateEvaluation">
                          <td class="text-center">{{"FR" | convertToFrDate: eval.date}}</td>
                          <td [style.color]="eval.evalEnseignant.couleur" class="text-center"><b>{{eval.evalEnseignant.abvr}}</b></td>
                          <td [style.color]="eval.evalEleve.couleur" class="text-center"><b>{{eval.evalEleve.abvr}}</b></td>
                          <td *ngIf="appState.get('role') == 'Enseignant'">{{eval.commentaire}}</td>
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
    show:boolean = false;

    constructor(public appState:AppState) {
        // Les petites paquerettes dans la prairie
    }

    toggle() {
        console.log("toggle comp");
        this.show = !this.show;
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
