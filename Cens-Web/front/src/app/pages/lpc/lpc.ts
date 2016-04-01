import {Component} from "angular2/core";
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
  selector: 'bloc-competance',
  inputs: ['comp'],
  template: `
  <div *ngIf="show">
      <div *ngFor="#cap of comp.capacite">
        <div>Capacité: {{cap.libelle}}</div>
        <div *ngFor="#eval of cap.evaluation">
          <div>Date: {{eval.date}}</div>
        </div>
    </div>
  </div>
  `
})
class BlocCompetence {
  comp;
  show: boolean = false;

  toggle(){
    this.show = !this.show;
  }
}


@Component({
  /*selector: 'bloc-matiere',
   inputs: ['matiere'],
   directive:['BlocCompetence'],
   template: `
   <h3 (click)="toggle()">Matières: {{matiere.libelle}}</h3>
   <div *ngIf="show">
   <div *ngFor="#comp of matiere.competence">
   <h4>Compétence: {{comp.libelle}}</h4>
   <bloc-competance [comp]="comp"></bloc-competance>
   </div>
   </div>
   `*/
})
class BlocMatiere {
  matiere;
  show: boolean = false;

  toggle(){
    this.show = !this.show;
  }
}


@Component({
  selector: 'lpc',
  directives: [LoadingImage, BlocMatiere],
  providers: [ RestLpc ],
  template: `
  <h2>Lpc</h2>
  <div  *ngIf="lpc.length != 0">
    <div class="row">
      <div class="col-sm-3" (click)="onBlocSelect(0)">Bloc 1</div>
      <div class="col-sm-3" (click)="onBlocSelect(1)">Bloc 2</div>
      <div class="col-sm-3" (click)="onBlocSelect(2)">Bloc 3</div>
      <div class="col-sm-3" (click)="onBlocSelect(3)">Bloc 4</div>
    </div>

    <div *ngFor="#matiere of lpc[idBloc].matiere">
      <bloc-matiere [matiere]="matiere" ></bloc-matiere>
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
