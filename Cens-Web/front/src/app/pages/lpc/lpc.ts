import {Component} from 'angular2/core';
import {RestLpc} from "../../service/rest.lpc";
import {AppState} from "../../app.service";
import {LoadingImage} from "../../components/loading-image/loading.image";

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
  <div class="col-sm-12">
      <div class="panel panel-default ">
          <div class="panel-heading" (click)="toggle()">
              Compétence: {{comp.libelle}}
          </div>
          <div *ngIf="show">
              <div class="panel-body">
                 <div *ngFor="#cap of comp.capacite">
                    <div>Capacité: {{cap.libelle}}</div>
                    <table class="table table-bordered">
                        <tr>
                          <td>Date</td>
                          <td>Evaluation</td>
                          <td>Auto évaluation</td>
                          <td *ngIf="appState.get('role') == 'Enseignant'">Commentaire</td>
                        </tr>
                        <tr *ngFor="#eval of cap.evaluation">
                          <td>{{eval.date}}</td>
                          <td [style.background]="eval.evalEnseignant.couleur">{{eval.evalEnseignant.abvr}}</td>
                          <td [style.background]="eval.evalEleve.couleur">{{eval.evalEleve.abvr}}</td>
                          <td *ngIf="appState.get('role') == 'Enseignant'">{{eval.commentaire}}</td>
                        </tr>
                    </table>
                 </div>
              </div>
          </div>
      </div>
  </div>
  `
})
class BlocCompetence {
  comp;
  show: boolean = false;

  constructor (public appState: AppState) {
    // Les petites paquerettes dans la prairie
  }

  toggle(){
    console.log("toggle comp");
    this.show = !this.show;
  }
}


@Component({
  selector: 'bloc-matiere',
  inputs: ['matiere'],
  directives:[BlocCompetence],
  template: `
  <h3 (click)="toggle()">Matières: {{matiere.libelle}}</h3>
  <div *ngIf="show">
    <div *ngFor="#comp of matiere.competence">
      <bloc-competence [comp]="comp"></bloc-competence>
    </div>
  </div>
  `
})
class BlocMatiere {
  matiere;
  show: boolean = true;

  toggle(){
    console.log("toggle matiere");
    this.show = !this.show;
  }
}


@Component({
  selector: 'lpc',
  directives: [LoadingImage, BlocMatiere],
  providers: [ RestLpc ],
  template: `
    <div class="row">
      <div class="col-xs-12">
          <h1 class="page-header"><i class="fa fa-female fa-fw"></i> LIVRET DE COMPÉTENCES</h1>

      </div>
    <!-- /.col-lg-12 -->
    </div>

  <div  *ngIf="lpc.length != 0">

    <div class="row">
      <div *ngFor="#bloc of lpc; #i = index">
        <div class="col-sm-3" (click)="onBlocSelect(i)">
          <div class="panel panel-default ">
              <div class="panel-heading">
                  {{lpc[i].libelle}}
              </div>
              <div class="panel-body">
                  stats go here
              </div>
          </div>
        </div>
      </div>

      <div *ngFor="#matiere of lpc[idBloc].matiere">
        <div class="col-sm-12">
          <bloc-matiere [matiere]="matiere" ></bloc-matiere>

        </div>

      </div>

    </div>
  </div>

  <div  *ngIf="lpc.length == 0">
    <loading-image></loading-image>
  </div>
  `
})
export class Lpc {
  loadImg = 'assets/img/load_img_1.gif';
  idBloc: number = 0;
  lpc = []; // un element par bloc

  constructor ( private restLpc: RestLpc, public appState: AppState) {
  // Les petites paquerettes dans la prairie
  }

  ngOnInit() {

    console.log('hello `lpc` component, id:' + this.appState.get('idLpc'));
    this.restLpc.getLpc(this.appState.get('idLpc'))
        .subscribe(lpc => {
          lpc.json().classe[lpc.json().classe.length-1].bloc.forEach( (bloc) => {
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
