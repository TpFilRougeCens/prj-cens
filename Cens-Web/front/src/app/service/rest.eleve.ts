// authentication.ts
import {Injectable} from 'angular2/core';
import {Headers, Http} from 'angular2/http';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/catch';

@Injectable()
export class RestEleve {

    token: string;
    constructor(private http: Http) {
        //this.token = localStorage.getItem('token');
    }


    getClasse() {


      // return this.http.get('/rest/profil/name');
         // If we had a login api, we would have done something like this

        // TODO doit retourner les eleves d'un enseignant passé en paramètre
         return this.http.get('rest/eleve/classe/enseignant/1');


         //for the purpose of this cookbook, we will just simulate that


/*
        if (username === 'bob' && password === 'P@ssword') {
            this.token = 'ze4r8z5r6az4r8aze4aze';
            localStorage.setItem('token', this.token);
            return Observable.of('token');
        }

        return Observable.throw('authentication failure');*/

    }

    // eleve profil
    getEleve(id: number) {
        return this.http.get('rest/eleve/' + id);
    }

    getAllEleve() {

        return this.http.get('rest/eleve');

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
             console.log('res:');
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
