/*
 * Angular 2 decorators and services
 */
import {Component} from "angular2/core";
import {RouteConfig, Router, ROUTER_DIRECTIVES} from "angular2/router";
import {Home} from "./pages/home";
import {ListEvaluation} from "./pages/liste-evaluation";
import {ListEleve} from "./pages/liste-eleve";
import {AppState} from "./app.service";
import {HeroService} from "./app.state.service";
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
    providers: [HeroService],
    directives: [ROUTER_DIRECTIVES],
    styles: [require('./private.app.scss')],
    template: require('./private-app.html')
    /*template: `

     <div id="wrapper">

     <!-- Navigation -->
     <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
     <div class="navbar-header">
     <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
     <span class="sr-only">Menu</span>
     <span class="icon-bar"></span>
     <span class="icon-bar"></span>
     <span class="icon-bar"></span>
     </button>
     <a class="navbar-brand" [routerLink]=" ['Index'] ">Livret de compétences LPC <img src="/assets/img/logo/perso30x30.png" alt="CENS" class="logo-general"></a>
     </div>
     <!-- /.navbar-header -->

     <ul class="nav navbar-top-links navbar-right">

     <li class="dropdown">
     <a class="dropdown-toggle" data-toggle="dropdown" href="#">
     {{nameProfil}} <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
     </a>
     <ul class="dropdown-menu dropdown-user">
     <li><a [routerLink]=" ['Profil'] "><i class="fa fa-user fa-fw"></i> Profil utilisateur</a>
     </li>
     <li class="divider"></li>
     <li><a href="#" (click)="onLogout()"><i class="fa fa-sign-out fa-fw"></i> Déconnexion</a>
     </li>
     </ul>
     <!-- /.dropdown-user -->
     </li>

     </ul>
     <!-- /.navbar-top-links -->

     <div class="navbar-default sidebar" role="navigation">
     <div class="sidebar-nav navbar-collapse">
     <ul class="nav" id="side-menu">
     <li>
     <a [routerLink]=" ['Home'] "><i class="fa fa-dashboard fa-fw"></i> Tableau de bord</a>
     </li>
     <li router-active>
     <a [routerLink]=" ['ListEleve'] "><i class="fa fa-female fa-fw"></i> Liste des élèves</a>
     </li>
     <li router-active>
     <a [routerLink]=" ['ListEvaluation'] "><i class="fa fa-bar-chart-o fa-fw"></i> Mes évaluations</a>
     </li>
     </ul>
     </div>
     <!-- /.sidebar-collapse -->
     </div>
     <!-- /.navbar-static-side -->
     </nav>

     <!-- Page Content -->
     <div id="page-wrapper">
     <div class="container-fluid">
     <div class="row">
     <div class="col-lg-12">
     <main>
     <router-outlet></router-outlet>
     </main>
     </div>
     <!-- /.col-lg-12 -->
     </div>
     <!-- /.row -->
     </div>
     <!-- /.container-fluid -->
     </div>
     <!-- /#page-wrapper -->

     </div>
     <!-- /#wrapper -->

     `*/
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
    nameProfil:string = "Loading profil...";
    isLoggedin:boolean = false;

    constructor(public appState:AppState, private _heroService:HeroService, public auth:Authentification, public router:Router) {

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
        this.getName();
    }


    onLogout() {
        this.auth.logout()
            .subscribe(
                () => this.router.navigate(['../Login'])
            );
    }

    getName() {
        this._heroService.getHeroes()
            .subscribe(
                response => {
                    console.log('result from rest api');
                    console.log(response.json())
                    this.nameProfil = response.json().name;
                },
                error => {
                    this.errorMessage = <any>error;
                    console.log("cant get data from api");
                    console.log(this.errorMessage);
                }
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
