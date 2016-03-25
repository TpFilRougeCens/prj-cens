// authentication.ts
import {Injectable} from 'angular2/core';
import {Headers, Http} from "angular2/http";

@Injectable()
export class Authentification {
    token: string;

    constructor(private http: Http) {
        this.token = localStorage.getItem('token');
    }

    private _heroesUrl = 'rest/authentification';  // URL to web api
    login(username: String, password: String) {

      // return this.http.get('/rest/profil/name');
         // If we had a login api, we would have done something like this
         return this.http.post(this._heroesUrl, JSON.stringify({
         username: username,
         password: password
         }), {
         headers: new Headers({
         'Content-Type': 'application/x-www-form-urlencoded'
         })
         })
         .map((res : any) => {
         let data = res.json();
         this.token = data.token;
         localStorage.setItem('token', this.token);
         });

         //for the purpose of this cookbook, we will just simulate that


/*
        if (username === 'test' && password === 'test') {
            this.token = 'token';
            localStorage.setItem('token', this.token);
            return Rx.Observable.of('token');
        }

        return Rx.Observable.throw('authentication failure');
        */
    }

    logout() {

         // If we had a login api, we would have done something like this
/*
         return this.http.get('rest/profil/name')
         .map((res : any) => {
         this.token = undefined;
         localStorage.removeItem('token');
         });
*/



         return this.http.get('rest/logout', {
             headers: new Headers({
                 'x-security-token': this.token
             })
         })
         .map((res : any) => {
             console.log("res:");
             console.log(res);
             this.token = undefined;
             localStorage.removeItem('token');
         });





/*
        this.token = undefined;
        localStorage.removeItem('token');

        return Rx.Observable.of(true);
        */
    }
}