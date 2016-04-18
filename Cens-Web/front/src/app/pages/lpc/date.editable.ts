import {Component} from "angular2/core";
import {ClickOutsideDirective} from "../../directives/click.outside";
import {ConvertDatePipe} from "../../pipes/convert.date.pipe";
import {AppState} from "../../app.service";
import {EventEmitter} from "angular2/core";
console.log('`Liste evaluation` component loaded asynchronously');

 // <td class="text-center">{{eval.date | convertToFrDate}}</td>

@Component({
    selector: 'date-editable',
    inputs: ['eval'],
    outputs: ['nouvelEval'],
    directives: [ClickOutsideDirective],
    template: `
       <div *ngIf="!editable" id={{eval.id}} (click)="edit($event,eval.id)"
           [ngStyle]="{'width':'100%','padding':'10px','margin': '0px','box-sizing': 'border-box',
               '-webkit-box-sizing':'border-box',
               '-moz-box-sizing': 'border-box'}">{{eval.date | convertToFrDate}}</div>
       <input *ngIf="editable"
           id={{eval.id}}
           [ngStyle]="{'width':'100%','padding':'10px','margin': '0px','box-sizing': 'border-box',
               '-webkit-box-sizing':'border-box',
               '-moz-box-sizing': 'border-box'}"
           #comInput
           value="{{eval.date | convertToFrDate}}"
           (clickOutside)="clickOutside($event, comInput.value, eval.id)">

  `,
    pipes: [ConvertDatePipe]
})
export class DateEditable {
    editable: boolean = false;
    targetTagName;
    targetId;
    nouvelEval: EventEmitter<any> = new EventEmitter<any>();
    eval;

    constructor(public appState:AppState) {
        this.eval = eval;
        console.log("eval: " ,eval);
    }

    edit(event, id) {
        console.log("Click inside! " +event.target.tagName);
        console.log("event: " ,event);

        console.log("id: " ,id);
        this.editable = true;
        this.targetTagName = event.target.tagName;
        this.targetId = id;

    }

    clickOutside(event, date ) {
        // Des paquerettes dans ton ...
        if (this.targetId != event.target.id) {
            this.editable = false;

            var dateArray = date.split("/");
            console.log(dateArray);
            var dateFormated = dateArray[2] + "-" + dateArray[1] + "-" + dateArray[0];
            console.log(dateFormated);


            this.eval.date = dateFormated;
            console.log( "Click outside! ", event.target.tagName );
            console.log( "new comment: ", date );
            console.log( "new eval: ", this.eval );
            this.nouvelEval.emit(this.eval);
        }
    }
}


