// app.ts
import {Component} from 'angular2/core';
import {RouteConfig, ROUTER_DIRECTIVES, Router} from 'angular2/router';
import {PrivateApp} from './private.app.ts';
import {Login} from './pages/login';

import {AppState} from './app.service';

@Component({
  selector: 'app',
  directives: [ROUTER_DIRECTIVES],
  template: `
    <router-outlet></router-outlet>
  `
})
@RouteConfig([

  { // we use a loader for async loading when user is logged
    path: '/app/...',
    name: 'PrivateApp',
    loader: () => require('es6-promise!./private.app')('PrivateApp')

  },

  { path: '/', redirectTo: ['Login']},
  { path: '/login', as: 'Login', component: Login}
  // TODO fix routing: routes that do not exist ( /#/donotexist ) will crash the app
])
export class App {
  constructor() {}
}