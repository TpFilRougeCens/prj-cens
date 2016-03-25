// app.ts
import {Component} from 'angular2/core';
import {RouteConfig, ROUTER_DIRECTIVES, Router} from 'angular2/router';
import {App} from './app.ts';
import {Login} from './login.ts';

import {AppState} from './app.service';

//TODO rename filter back to app and rename app to samething else
@Component({
  selector: 'filter',
  directives: [ROUTER_DIRECTIVES],
  template: `
    <router-outlet></router-outlet>
  `
})
@RouteConfig([

  { // we use a loader for async loading when user is logged
    path: '/app/...',
    name: 'App',
    loader: () => require('es6-promise!./app')('App')

  },

  { path: '/', redirectTo: ['Login']},
  { path: '/login', as: 'Login', component: Login}
    // TODO fix routing: routes that do not exist ( /#/donotexist ) will crash the app
])
export class Filter {
  constructor() {}
}