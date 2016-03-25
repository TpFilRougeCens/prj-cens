/*
 * Angular 2 decorators and services
 */
import {Component} from 'angular2/core';
import {RouteConfig, Router} from 'angular2/router';

import {Home} from './home';
import {ListEvaluation} from './liste-evaluation';
import {ListEleve} from './liste-eleve';

import {AppState} from './app.service';

import {HeroService}       from './app.state.service';

import {isLoggedin}  from './service/is-loggedin';
import {CanActivate} from "angular2/router";


import {Authentification} from './service/authentification';

//require('bootstrap/less/bootstrap.less');

/*
 * App Component
 * Top Level Component
 */
// in-memory web api imports
@Component({
  selector: 'app',
  pipes: [ ],
  providers: [ HeroService ],
  directives: [ ],
  styles: [ require('./app.scss') ],
  template: `
     <header>
     <a [routerLink]=" ['Index'] "><img class="logo" [src]="angularclassLogo"></a>

     <ul class="nav navbar-right top-nav">
         <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> {{nameProfil}} <b
                    class="caret"></b></a>
                    <a href="#" (click)="onLogout()">Logout</a>
            <ul class="dropdown-menu">
                <li>
                    <a href="#"><i class="fa fa-fw fa-user"></i> Profil</a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="#"><i class="fa fa-fw fa-power-off"></i> Déconnexion</a>
                </li>
            </ul>
         </li>
     </ul>

     </header>
     <div class="wrapper">
       <nav>
         <a [routerLink]=" ['Home'] ">NAVIGATION</a>
         <ul>
           <li router-active>
             <a [routerLink]=" ['ListEleve'] ">Mes élèves</a>
           </li>
           <li router-active>
             <a [routerLink]=" ['ListEvaluation'] ">Mes évaluations</a>
           </li>
           <li router-active>
             <a [routerLink]=" ['Profil'] ">Mon profil</a>
           </li>
         </ul>
       </nav>
       <main>
         <router-outlet></router-outlet>
       </main>
     </div>
  `
})
@RouteConfig([
  { path: '/',      name: 'Index', component: Home, useAsDefault: true },
  { path: '/home',  name: 'Home',  component: Home },
    { path: '/liste-eleve',  name: 'ListEleve',  component: ListEleve },
    { path: '/liste-evaluation',  name: 'ListEvaluation',  component: ListEvaluation },
  // Async load a component using Webpack's require with es6-promise-loader and webpack `require`
  { path: '/profil', name: 'Profil', loader: () => require('es6-promise!./profil')('Profil') },
])
export class App {
  angularclassLogo = 'assets/img/logoLPCFull.png';
  name = 'Angular 2 Webpack Starter';
  url = 'https://twitter.com/AngularClass';
  errorMessage: string;
  nameProfil: string = "Loading profil...";
  constructor(public appState: AppState, private _heroService: HeroService,public auth: Authentification, public router: Router) {

  }

  get state() {
    return this.appState.get();
  }

  ngOnInit() {
    console.log("Im in App ngOnInit");
    console.log("Im logged");
    console.log(isLoggedin());
    if(!isLoggedin()) {
      console.log("redirecting ...");
      this.router.navigate(['../Login']);
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
            error =>  {
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
