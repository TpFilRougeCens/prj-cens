/*
 * Angular 2 decorators and services
 */
import {Component} from 'angular2/core';
import {RouteConfig, Router} from 'angular2/router';

import {Home} from './home';
import {AppState} from './app.service';

/*
 * App Component
 * Top Level Component
 */
@Component({
  selector: 'app',
  pipes: [ ],
  providers: [ ],
  directives: [ ],
  styles: [ require('./app.scss') ],
  template: `
    <header>
       <img [src]="angularclassLogo">
    </header>
    <div class="wrapper">
      <nav>
        <a [routerLink]=" ['Index'] ">NAVIGATION</a>
        <ul>
          <li router-active>
            <a [routerLink]=" ['Home'] ">Mes évaluations</a>
          </li>
          <li router-active>
            <a [routerLink]=" ['About'] ">Mes élèves</a>
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
  // Async load a component using Webpack's require with es6-promise-loader and webpack `require`
  { path: '/about', name: 'About', loader: () => require('es6-promise!./about')('About') },
])
export class App {
  angularclassLogo = 'assets/img/logoLPCFull.png';
  name = 'Angular 2 Webpack Starter';
  url = 'https://twitter.com/AngularClass';

  constructor(public appState: AppState) {}

  get state() {
    return this.appState.get();
  }

  ngOnInit() {
    console.log('Initial App State', this.state);
  }

}

/*
 * Please review the https://github.com/AngularClass/angular2-examples/ repo for
 * more angular app examples that you may copy/paste
 * (The examples may not be updated as quickly. Please open an issue on github for us to update it)
 * For help or questions please contact us at @AngularClass on twitter
 * or our chat on Slack at https://AngularClass.com/slack-join
 */
