import {Component} from "angular2/core";
import {ClickOutsideDirective} from "../directives/click.outside";
import {EventEmitter} from "angular2/core";
import {AppState} from "../app.service";

@Component({
    selector: 'editable-component',
    inputs: ['val', 'id'],
    outputs: ['newVal'],
    directives: [ClickOutsideDirective],
    template: `
       <div *ngIf="!editable" id={{id}} (click)="edit($event,id)"
             [ngStyle]="{'width':'100%','padding':'10px','margin': '0px','box-sizing': 'border-box',
               '-webkit-box-sizing':'border-box',
               '-moz-box-sizing': 'border-box'}">{{val}}</div>
       <input *ngIf="editable"
           id={{id}}
           [ngStyle]="{'width':'100%','padding':'10px','margin': '0px','box-sizing': 'border-box',
               '-webkit-box-sizing':'border-box',
               '-moz-box-sizing': 'border-box'}"
           #comInput
           value="{{val}}"
           (clickOutside)="clickOutside($event, comInput.value)"
           >

  `
})
export class EditableComponent {
    editable: boolean = false;
    targetId;
    newVal: EventEmitter<any> = new EventEmitter<any>();
    val: string;
    id: number;
    comInput;

    constructor(public appState:AppState) {
    }

    ngInit() {
    }

    edit(event, id, comInput) {
        console.log("Click inside! " +event.target.tagName);
        console.log("event: " ,event);

        console.log("id: " ,id);
        this.editable = true;
        this.targetId = id;


    }

    clickOutside(event, val ) {
        if (this.targetId != event.target.id) {
            this.val = val;
            this.editable = false;
            console.log( "Click outside! ", event.target.tagName );
            console.log( "new comment: ", val );
            console.log( "new val: ", this.val );
            this.newVal.emit(this.val);
        }
    }
}