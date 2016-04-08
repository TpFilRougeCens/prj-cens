// authentication.ts
import {Injectable} from 'angular2/core';
import {Headers, Http} from "angular2/http";
import {Observable} from "rxjs/Rx";
import 'rxjs/add/operator/catch';

@Injectable()
export class RestClasse {

    token: string;
    constructor(private http: Http) {
        //this.token = localStorage.getItem('token');
    }

    getClasse() {

         return this.http.get('rest/eleve/classe');

    }

}