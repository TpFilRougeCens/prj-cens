// authentication.ts
import {Injectable} from 'angular2/core';
import {Headers, Http} from 'angular2/http';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/catch';

@Injectable()
export class RestLpc {

    constructor(private http: Http) {
        //this.token = localStorage.getItem('token');
    }

    getLpc(id: number) {

        // If we had a login api, we would have done something like this

         return this.http.get('rest/eleve/' + id + '/lpc');

         //for the purpose of this cookbook, we will just simulate that
/*
        if (username === 'bob' && password === 'P@ssword') {
            this.token = 'ze4r8z5r6az4r8aze4aze';
            localStorage.setItem('token', this.token);
            return Observable.of('token');
        }
        return Observable.throw('authentication failure');*/
    }


    delete(id: number) {
        return this.http.delete('rest/eleve/lpc/evaluation/' + id);
    }

    putEval(evaluation) {

        // TODO convert "31/01/1989" to "1989-01-27"
        // evalution.date
        console.log(evaluation.date);
        //var date = evaluation.date.split("-");
        //evaluation.date = date[2] + "/" + date[1] + "/" + date[0];
        //console.log(date);
        return this.http.put(
            'rest/eleve/lpc/evaluation',
            JSON.stringify({evaluation: evaluation}),
            {
                headers: new Headers({
                    'Content-Type': 'application/json'
                })
            });
    }



    add(evaluation) {
        return this.http.post(
            'rest/eleve/lpc/evaluation',
            JSON.stringify({
                evaluation: evaluation
            }),
            {
                headers: new Headers({
                    'Content-Type': 'application/json'
                })
            });
    }

}
