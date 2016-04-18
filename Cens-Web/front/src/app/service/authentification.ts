// authentication.ts
import {Injectable} from 'angular2/core';
import {Headers, Http} from 'angular2/http';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/catch';
import {AuthHttp, AuthConfig, JwtHelper} from 'angular2-jwt';

@Injectable()
export class Authentification {
    token: string;
    jwtHelper: JwtHelper = new JwtHelper();

    constructor(private http: Http) {
        this.token = localStorage.getItem('token');
    }

    private _authUrl = 'rest/authentification';  // URL to web api
    login(username: String, password: String) {


         // return this.http.get('/rest/profil/name');
         // If we had a login api, we would have done something like this
/*
         return this.http.post(this._authUrl, JSON.stringify({
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
             console.log( 'token' + this.token);
             console.log( 'jwt token' + this.jwtHelper.decodeToken(this.token));
                 localStorage.setItem('token', this.token);
         });

*/
         //for the purpose of this cookbook, we will just simulate that



        if (username === 'bob' && password === 'P@ssword') {
            this.token = 'ze4r8z5r6az4r8aze4aze';
            localStorage.setItem('token', this.token);
            return Observable.of('token');
        }

        return Observable.throw('authentication failure');

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
         localStorage.removeItem('token');
    };





/*
        this.token = undefined;
        localStorage.removeItem('token');

        return Rx.Observable.of(true);
        */

}
