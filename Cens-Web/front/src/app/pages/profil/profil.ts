import {Component} from "angular2/core";
import {AppState} from "../../app.service";

@Component({
    selector: 'profil',
    directives: [],
    template: require('./profil.html')
})
export class Profil {

    constructor(public appService:AppState) {

    }

    ngOnInit() {
        // static data that is bundled
        var profilData = require('assets/mock-data/mock-data.json');
        // if you're working with mock data you can also use http.get('assets/mock-data/mock-data.json')
        this.asyncDataWithWebpack();
    }

    asyncDataWithWebpack() {
        // you can also async load mock data with 'es6-promise-loader'
        // you would do this if you don't want the mock-data bundled
        // remember that 'es6-promise-loader' is a promise
        var asyncMockDataPromiseFactory = require('es6-promise!assets/mock-data/mock-data.json');
        setTimeout(() => {

            let asyncDataPromise = asyncMockDataPromiseFactory();
            asyncDataPromise.then(json => {
                console.log('async mockData', json);
            });

        });
    }

}
