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
    selector: 'bloc-matiere',
    inputs: ['eval'],
    // template: require('./lpc.html')
    template: `
     <h3 (click)="toggle()">Matières: {{eval.libelle}}</h3>
     <div *ngIf="show" *ngFor="#comp of eval.competence">
     <div>Compétence: {{comp.libelle}}</div>
     <div *ngFor="#cap of comp.capacite">
     <div>Capacité: {{cap.libelle}}</div>
     <div *ngFor="#cap of comp.capacite">
     <div>Capacité: {{cap.libelle}}</div>
     <div *ngFor="#eval of cap.evaluation">
     <div>Date: {{eval.date}}</div>
     </div>
     </div>
     </div>
     </div>
     `
})
class BlocMatiere {
    eval;
    show:boolean = false;
    // the EventEmitter is used to emit the event
    //ponySelected: EventEmitter<Pony> = new EventEmitter<Pony>();

    /**
     * Selects a pony when the component is clicked.
     * Emits a custom event.
     */
    selectPony() {
        //this.ponySelected.emit(this.eval);
    }

    toggle() {
        this.show = !this.show;
    }
}


@Component({
    selector: 'lpc',
    directives: [LoadingImage, BlocMatiere],
    providers: [RestLpc],
    // template: require('./lpc.html'),
    template: `
     <h2>Lpc</h2>
     <div  *ngIf="lpc.length != 0">
     <div class="row">
     <div class="col-sm-3" (click)="onBlocSelect(0)">Bloc 1</div>
     <div class="col-sm-3" (click)="onBlocSelect(1)">Bloc 2</div>
     <div class="col-sm-3" (click)="onBlocSelect(2)">Bloc 3</div>
     <div class="col-sm-3" (click)="onBlocSelect(3)">Bloc 4</div>
     </div>
     <h3>bloc</h3>

     <div *ngFor="#eval of lpc[idBloc].matiere">
     <bloc-matiere [eval]="eval" ></bloc-matiere>
     </div>
     </div>

     <div  *ngIf="lpc.length == 0">
     <loading-image></loading-image>
     </div>

     `

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
