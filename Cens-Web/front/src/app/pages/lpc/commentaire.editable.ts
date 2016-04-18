import {Component} from "angular2/core";
import {ClickOutsideDirective} from "../../directives/click.outside";
import {ConvertDatePipe} from "../../pipes/convert.date.pipe";
import {EventEmitter} from "angular2/core";
import {AppState} from "../../app.service";
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
export class CommentaireEditable {
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


