import {Component} from 'angular2/core';
import {AppState} from '../../app.service';

@Component({
    selector: 'profil',
    directives: [],
    template: require('./profil.html')
})
export class Profil {

    constructor(public appService: AppState) {

    }

}
