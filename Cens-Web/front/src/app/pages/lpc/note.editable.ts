import {Component, Input} from "angular2/core";
import {ClickOutsideDirective} from "../../directives/click.outside";
import {ConvertDatePipe} from "../../pipes/convert.date.pipe";
import {EventEmitter} from "angular2/core";
import {AppState} from "../../app.service";
console.log('`Liste evaluation` component loaded asynchronously');

@Component({
    selector: 'note-editable',
    inputs: ['eval', 'autoEval'],
    outputs: ['nouvelEval'],
    directives: [ClickOutsideDirective],
    template: `
       <div *ngIf="!editable && !autoEval" id={{eval.id}} (click)="edit($event,eval.id)"
             [ngStyle]="{'width':'100%','padding':'10px','margin': '0px','box-sizing': 'border-box',
               '-webkit-box-sizing':'border-box',
               '-moz-box-sizing': 'border-box'}">{{eval.evalEnseignant.abvr}}
       </div>
        <div *ngIf="!editable && autoEval" id={{eval.id}} (click)="edit($event,eval.id)"
             [ngStyle]="{'width':'100%','padding':'10px','margin': '0px','box-sizing': 'border-box',
               '-webkit-box-sizing':'border-box',
               '-moz-box-sizing': 'border-box'}">{{eval.evalEleve.abvr}}
       </div>
       <select *ngIf="editable"
        (change)="onChange($event.target.value)"
        id={{eval.id}}
        [ngStyle]="{'width':'100%','padding':'10px','margin': '0px','box-sizing': 'border-box',
               '-webkit-box-sizing':'border-box',
               '-moz-box-sizing': 'border-box'}"
        (clickOutside)="clickOutside($event, eval.id)">
            <option *ngFor="#note of notes; #j = index" [value]="j" [ngStyle]="{'color':note.couleur}">{{note.abvr}} {{note.libelle}}</option>
       </select>
  `,
    pipes: [ConvertDatePipe]
})
export class NoteEditable {
    editable: boolean = false;
    targetTagName;
    targetId;
    nouvelEval: EventEmitter<any> = new EventEmitter<any>();
    eval;

    autoEval: boolean;


    // TODO  remplacer ce mock
    // récupérer les valeurs depuis la table note, web service à faire
    notes = [
        {'abvr': '', 'libelle': "", 'valeur': '',	'couleur': '', 'id': 0 },
        {'abvr': '', 'libelle': "Non évalué", 'valeur': '',	'couleur': '#00af4c', 'id': 1 },
        {'abvr': 'A',	'libelle': "Compétence acquise",	'valeur': 20,	'couleur': '#00af4c', 'id': 2 },
        {'abvr': 'PA',	'libelle': "Compétence presque acquise",	'valeur': 15,	'couleur': '#007baf', 'id': 3 },
        {'abvr': 'VA',	'libelle': "Compétence encore fragile, en voie d'acquisition",	'valeur': 10,	'couleur': '#ffd600', 'id': 4 },
        {'abvr': 'EA',	'libelle': "Compétence en cours d'acquisition, débutant",	'valeur': 5,	'couleur': '#ff9600', 'id': 5 },
        {'abvr': 'NA',	'libelle': "Compétence non acquise",	'valeur': 0,	'couleur': '#ff0000', 'id': 6 },
        {'abvr': 'DEC',	'libelle': "Compétence désactivée",	'valeur': 0,	'couleur': '#ff1000', 'id': 7 }
    ];

    constructor(public appState:AppState) {
        this.eval = eval;
    }

    edit(event, id) {
        console.log("Click inside! " +event.target.tagName);
        console.log("event: " ,event);

        console.log("id: " ,id);
        this.editable = !this.editable;
        this.targetTagName = event.target.tagName;
        this.targetId = id;

    }

    clickOutside(event, commentaire ) {
        // Des paquerettes dans ton ...
        if (this.targetId != event.target.id) {
            this.editable = false;
        }
    }

    onChange(event) {
        console.log('select changed');
        console.log(event);


        var position = event;

        // FIXME event devrait retourner l'id de la note, ce n'est pas le cas...
        /*console.log("slice",event.split(" "));
        let postition = this.arrayObjectIndexOf(this.notes, event.split(" ")[0], "abvr");
        console.log(postition);*/

        this.editable = false;

        if (event != 0) {
            if (this.autoEval) {
                this.eval.evalEleve.abvr = this.notes[position].abvr;
                this.eval.evalEleve.libelle = this.notes[position].libelle;
                this.eval.evalEleve.couleur = this.notes[position].couleur;
                this.eval.evalEleve.id = this.notes[position].id;
                this.eval.evalEleve.valeur = this.notes[position].valeur;
            }
            else {
                this.eval.evalEnseignant.abvr = this.notes[position].abvr;
                this.eval.evalEnseignant.libelle = this.notes[position].libelle;
                this.eval.evalEnseignant.couleur = this.notes[position].couleur;
                this.eval.evalEnseignant.id = this.notes[position].id;
                this.eval.evalEnseignant.valeur = this.notes[position].valeur;
            }
        }

        this.nouvelEval.emit(this.eval);
    }


    arrayObjectIndexOf(myArray, searchTerm, property) {
    for(var i = 0, len = myArray.length; i < len; i++) {
        if (myArray[i][property] === searchTerm) return i;
    }
    return -1;
}
}


