// authentication.ts
import {Injectable} from "angular2/core";
import {Http} from "angular2/http";
import "rxjs/add/operator/catch";

@Injectable()
export class RestProfil {

    constructor(private http:Http) {
    }

    getProfil(type:string, idUser:number) {

        return this.http.get('rest/profil/' + type + '/' + idUser);

    }

}