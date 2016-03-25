// app.ts
import {Component} from 'angular2/core';
import {RouteConfig, ROUTER_DIRECTIVES, Router} from 'angular2/router';
import {App} from './app.ts';
import {Login} from './login.ts';

import {AppState} from './app.service';

@Component({
  selector: 'filter',
  directives: [ROUTER_DIRECTIVES],
  template: `
    <h1>Hello world</h1>

    <router-outlet></router-outlet>
  `
})
@RouteConfig([

  { // Crisis Center child route
    path: '/app/...',
    name: 'App',
    component: App

  },

  { path: '/', redirectTo: ['Login'] },
  { path: '/login', as: 'Login', component: Login, useAsDefault: true }
])
export class Filter {
  constructor() {}
}