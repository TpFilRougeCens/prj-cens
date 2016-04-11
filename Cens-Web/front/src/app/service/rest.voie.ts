// authentication.ts
import {Injectable} from 'angular2/core';
import {Headers, Http} from "angular2/http";
import {Observable} from "rxjs/Rx";
import 'rxjs/add/operator/catch';

@Injectable()
export class RestVoie {

    //token: string;

    private _voieUrl = 'rest/voie';  // URL to web api

    constructor(private http: Http) {
        //this.token = localStorage.getItem('token');
    }

    getVoie() {
         return this.http.get(this._voieUrl);
    }

    delete(id: number) {
        return this.http.delete(this._voieUrl+'/'+id);
    }

    update(voie) {
        return this.http.put(
            this._voieUrl,
            JSON.stringify({
                voie: voie
            }),
            {
            headers: new Headers({
                'Content-Type': 'application/json'
            })
        });
    }


    add(voie) {
        return this.http.post(
            this._voieUrl,
            JSON.stringify({
                voie: { libelle: voie}
            }),
            {
                headers: new Headers({
                    'Content-Type': 'application/json'
                })
            });
    }



}