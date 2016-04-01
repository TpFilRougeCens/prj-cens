/*
 * Angular 2 decorators and services
 */
import {Component} from "angular2/core";
import {RouteConfig, Router, ROUTER_DIRECTIVES} from "angular2/router";
import {Home} from "./pages/home";
import {ListEvaluation} from "./pages/liste-evaluation";
import {ListEleve} from "./pages/liste-eleve";
import {AppState} from "./app.service";
import {isLoggedin} from "./service/is-loggedin";
import {Authentification} from "./service/authentification";
import {Login} from "./pages/login/login";
import {Profil} from "./pages/profil/profil";
import {Lpc} from "./pages/lpc/lpc";

//require('bootstrap/less/bootstrap.less');

/*
 * App Component
 * Top Level Component
 */
// in-memory web api imports
@Component({
    selector: 'private-app',
    pipes: [],
    providers: [],
    directives: [ROUTER_DIRECTIVES],
    styles: [require('./private.app.scss')],
    template: require('./private-app.html')
})
@RouteConfig([
    {path: '/', name: 'Index', component: Home, useAsDefault: true},
    {path: '/login', as: 'Login', component: Login},
    {path: '/home', name: 'Home', component: Home},
    {path: '/liste-eleve', name: 'ListEleve', component: ListEleve},
    {path: '/liste-evaluation', name: 'ListEvaluation', component: ListEvaluation},
    {path: '/lpc', name: 'Lpc', component: Lpc},
    // Async load a component using Webpack's require with es6-promise-loader and webpack `require`
    {path: '/profil', name: 'Profil', component: Profil} //loader: () => require('es6-promise!./profil')('Profil') }
])
export class PrivateApp {
    logoLPCFull = 'assets/img/logoLPCFull.png';
    name = 'Angular 2 Webpack Starter';
    url = 'https://twitter.com/AngularClass';
    errorMessage:string;
    nameProfil:string = "Chargement...";
    isLoggedin:boolean = false;

    constructor(public appState:AppState,public auth:Authentification, public router:Router) {

    }

    get state() {
        return this.appState.get();
    }

    ngOnInit() {
        console.log("Im in Private App ngOnInit");
        console.log("Im logged");
        console.log(isLoggedin());
        if (!isLoggedin()) {
            console.log("redirecting ...");
            //this.router.navigate(['../Login']);
        }

        console.log('Initial App State', this.state);
    }


    onLogout() {
        this.auth.logout()
            .subscribe(
                () => this.router.navigate(['../Login'])
            );
    }



}

/*
 * Please review the https://github.com/AngularClass/angular2-examples/ repo for
 * more angular app examples that you may copy/paste
 * (The examples may not be updated as quickly. Please open an issue on github for us to update it)
 * For help or questions please contact us at @AngularClass on twitter
 * or our chat on Slack at https://AngularClass.com/slack-join
 */
