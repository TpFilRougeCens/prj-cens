// authentication.ts
import {Injectable} from 'angular2/core';
import {Headers, Http} from 'angular2/http';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/catch';
import {AuthHttp, AuthConfig, JwtHelper} from 'angular2-jwt';
import {AppState} from '../app.service';

@Injectable()
export class AuthentificationFake {
    token: string;
    jwtHelper: JwtHelper = new JwtHelper();

    constructor(private http: Http, public appState: AppState) {
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


        this.token = 'ze4r8z5r6az4r8aze4aze';
        localStorage.setItem('token', this.token);

        if (username === 'jean' && password === 'password') {
            this.appState.set('classesEnseignant', [
                {
                    'id': 1,
                    'voie': 'Générale',
                    'filiere': 'Scientifique',
                    'libelle': 'A',
                    'niveau': '2sd',
                    'matiere': [
                        {
                            'id': 1,
                            'libelle': 'Mathématiques',
                        },
                        {
                            'id': 2,
                            'libelle': 'Sciences',
                        }
                    ]
                },
                {
                    'id': 2,
                    'voie': 'Technologique',
                    'filiere': 'STMG',
                    'libelle': 'B',
                    'niveau': 'Term',
                    'matiere': [{
                        'id': 1,
                        'libelle': 'Mathématiques',
                    }]
                }
            ]);
            this.appState.set('prenom', 'Jean');
            this.appState.set('nom', 'Dupond');
            this.appState.set('id', 1);
            this.appState.set('role', 'Enseignant');
            return Observable.of('token');
        } else if (username === 'paul' && password === 'password') {
            this.appState.set('classesEnseignant', [
                {
                    'id': 1,
                    'voie': 'Générale',
                    'filiere': 'Scientifique',
                    'libelle': 'A2',
                    'niveau': '1ere',
                    'matiere': [{
                        'id': 1,
                        'libelle': 'Mathématiques',
                    }]
                }
            ]);
            this.appState.set('classesManager', [
                {
                    'id': 1,
                    'voie': 'Générale',
                    'filiere': 'Scientifique',
                    'libelle': 'A',
                    'niveau': '2sd'
                },
                {
                    'id': 2,
                    'voie': 'Technologique',
                    'filiere': 'STMG',
                    'libelle': 'B',
                    'niveau': 'Term'
                }
            ]);
            this.appState.set('prenom', 'Paul');
            this.appState.set('nom', 'Dupont');
            this.appState.set('id', 4);
            this.appState.set('role', 'Manager');
            return Observable.of('token');
        } else if (username === 'delphine' && password === 'password') {
            this.appState.set('classesEnseignant', [
                {
                    'id': 1,
                    'voie': 'Générale',
                    'filiere': 'Scientifique',
                    'libelle': 'A',
                    'niveau': '2sd',
                    'matiere': [{
                        'id': 1,
                        'libelle': 'Mathématiques',
                    }]
                }
            ]);
            this.appState.set('prenom', 'Delphine');
            this.appState.set('nom', 'Dube');
            this.appState.set('id', 6);
            this.appState.set('role', 'Pedagogie');
            return Observable.of('token');
        } else if (username === 'philippe' && password === 'password') {
            this.appState.set('classesEnseignant', [
                {
                    'id': 1,
                    'voie': 'Générale',
                    'filiere': 'Scientifique',
                    'libelle': 'A',
                    'niveau': '2sd',
                    'matiere': [{
                        'id': 1,
                        'libelle': 'Mathématiques',
                    }]
                }
            ]);
            this.appState.set('prenom', 'Philippe');
            this.appState.set('nom', 'Hervé');
            this.appState.set('id', 3);
            this.appState.set('role', 'Directeur');
            return Observable.of('token');
        } else if (username === 'olivier' && password === 'password') {
            this.appState.set('classeEleve', [
                {
                    'id': 1,
                    'voie': 'Générale',
                    'filière': 'Scientifique',
                    'libelle': 'A',
                    'niveau': '2sd'
                }
            ]);
            this.appState.set('prenom', 'Olivier');
            this.appState.set('nom', 'Lebatellier');
            this.appState.set('id', 2);
            this.appState.set('idLpc', 7);
            this.appState.set('role', 'Eleve');
            return Observable.of('token');
        } else {
            return Observable.throw('authentication failure');
        }

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
