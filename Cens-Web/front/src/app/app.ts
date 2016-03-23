/*
 * Angular 2 decorators and services
 */
import {Component} from 'angular2/core';
import {RouteConfig, Router} from 'angular2/router';

import {Home} from './home';
import {AppState} from './app.service';


//require('bootstrap/less/bootstrap.less');


/*
 * App Component
 * Top Level Component
 */
@Component({
  selector: 'app',
  pipes: [ ],
  providers: [ ],
  directives: [ ],
  styles: [ require('./app.scss') , require('bootstrap/dist/css/bootstrap.css') ],
  template: `
<div id="wrapper">

      <nav class="navbar navbar-default navbar-fixed-top" role="navigation">

          <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                  <span class="sr-only">Navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
              </button>

              <img [src]="angularclassLogo">
          </div>

          <ul class="nav navbar-right top-nav">

              <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i> <b
                      class="caret"></b></a>
                  <ul class="dropdown-menu alert-dropdown">
                      <li>
                          <a href="#">
                              <small>12/01/2016</small>
                              - Auto-évaluation <span class="label label-danger">à faire</span></a>
                      </li>
                      <li>
                          <a href="#">
                              <small>13/01/2016</small>
                              - Auto-évaluation<span class="label label-danger">à faire</span></a>
                      </li>
                      <li>
                          <a href="#">
                              <small>30/12/2016</small>
                              - Auto-évaluation <span class="label label-danger">à faire</span></a>
                      </li>
                      <li>
                          <a href="#">
                              <small>31/12/2016</small>
                              - Auto-évaluation <span class="label label-danger">à faire</span></a>
                      </li>
                      <li class="divider"></li>
                      <li>
                          <a href="#">Voir toutes les alertes</a>
                      </li>
                  </ul>
              </li>
              <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> John Smith <b
                      class="caret"></b></a>
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



          <div class="collapse navbar-collapse navbar-ex1-collapse">
              <ul class="nav navbar-nav side-nav">
                  <li class="entete">
                    <div>lien</div>
                  </li>
                  <li class="active">
                    <div>lien</div>
                  </li>
                  <li>
                    <div>lien</div>
                  </li>
                  <li>
                      <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i
                          class="fa fa-fw fa-bar-chart-o"></i> Évaluations <i class="fa fa-fw fa-caret-down"></i></a>
                      <ul id="demo" class="collapse">
                          <li>
                              <a href="#">Ajouter une évaluation à une classe</a>
                          </li>
                          <li>
                              <a href="#">Vérifier les évaluations</a>
                          </li>
                      </ul>
                  </li>
                  <li>
                      <a href="samples/bootstrap/blank-page.html"><i class="fa fa-fw fa-file"></i> Samples</a>
                  </li>

              </ul>
          </div>

      </nav>

      <div id="page-wrapper">

          <div class="container-fluid">





              <div class="row">
                  <div class="col-lg-12" id="contentHeader">
                      <div class="panel panel-default">
                          <div class="panel-heading">
                              <h1 class="panel-title">
                                  <i class="fa fa-dashboard"></i> Tableau de bord

                              </h1>
                          </div>
                          <div class="panel-body">

                              <aside>
                                  <ul>
                                      <li>Products</li>
                                      <li>Orders</li>
                                  </ul>
                              </aside>
                              <main>

                              </main>

                              <div class="row">
                                  <div class="col-lg-3 col-md-6">
                                      <div class="panel panel-blue">
                                          <div class="panel-heading">
                                              <div class="row">
                                                  <div class="col-xs-3">
                                                      <i class="fa fa-comments fa-5x"></i>
                                                  </div>
                                                  <div class="col-xs-9 text-right">
                                                      <div class="huge">26</div>
                                                      <div>Sciences humaines</div>
                                                  </div>
                                              </div>
                                          </div>
                                          <a href="#">
                                              <div class="panel-footer">
                                                  <span class="pull-left">S.V.T</span>
                                                  <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                                  <div class="clearfix"></div>
                                                  <span class="pull-left">Economie et social</span>
                                                  <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                                  <div class="clearfix"></div>
                                              </div>
                                          </a>
                                      </div>
                                  </div>
                                  <div class="col-lg-3 col-md-6">
                                      <div class="panel panel-green">
                                          <div class="panel-heading">
                                              <div class="row">
                                                  <div class="col-xs-3">
                                                      <i class="fa fa-tasks fa-5x"></i>
                                                  </div>
                                                  <div class="col-xs-9 text-right">
                                                      <div class="huge">12</div>
                                                      <div>Technologie</div>
                                                  </div>
                                              </div>
                                          </div>
                                          <a href="#">
                                              <div class="panel-footer">
                                                  <span class="pull-left">SSI</span>
                                                  <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                                  <div class="clearfix"></div>
                                                  <span class="pull-left">Mécanique</span>
                                                  <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                                  <div class="clearfix"></div>
                                              </div>
                                          </a>
                                      </div>
                                  </div>
                                  <div class="col-lg-3 col-md-6">
                                      <div class="panel panel-yellow">
                                          <div class="panel-heading">
                                              <div class="row">
                                                  <div class="col-xs-3">
                                                      <i class="fa fa-shopping-cart fa-5x"></i>
                                                  </div>
                                                  <div class="col-xs-9 text-right">
                                                      <div class="huge">124</div>
                                                      <div>Sciences</div>
                                                  </div>
                                              </div>
                                          </div>
                                          <a href="#">
                                              <div class="panel-footer">
                                                  <span class="pull-left">View Details</span>
                                                  <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                                  <div class="clearfix"></div>

                                                  <span class="pull-left">View Details</span>
                                                  <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                                  <div class="clearfix"></div>
                                              </div>
                                          </a>
                                      </div>
                                  </div>
                                  <div class="col-lg-3 col-md-6">
                                      <div class="panel panel-red">
                                          <div class="panel-heading">
                                              <div class="row">
                                                  <div class="col-xs-3">
                                                      <i class="fa fa-support fa-5x"></i>
                                                  </div>
                                                  <div class="col-xs-9 text-right">
                                                      <div class="huge">13</div>
                                                      <div>Langues</div>
                                                  </div>
                                              </div>
                                          </div>
                                          <a href="#">
                                              <div class="panel-footer">
                                                  <span class="pull-left">View Details</span>
                                                  <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                                  <div class="clearfix"></div>
                                                  <span class="pull-left">View Details</span>
                                                  <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                                  <div class="clearfix"></div>
                                              </div>
                                          </a>
                                      </div>
                                  </div>
                              </div>

                              <div class="row">
                                  <div class="col-lg-12">
                                      <div class="panel panel-default">
                                          <div class="panel-heading">
                                              <h3 class="panel-title"><i class="fa fa-bar-chart-o fa-fw"></i> Vue statistique</h3>
                                          </div>
                                          <div class="panel-body">

                                          </div>
                                      </div>
                                  </div>
                              </div>

                              <div class="row">
                                  <div class="col-lg-12">
                                      <div class="panel panel-default">
                                          <div class="panel-heading">
                                              <h3 class="panel-title"><i class="fa fa-money fa-fw"></i> Vue des évaluations</h3>
                                          </div>
                                          <div class="panel-body">
                                              <div class="table-responsive">
                                                  <table class="table table-bordered table-hover table-striped">
                                                      <thead>
                                                      <tr>
                                                          <th>Order #</th>
                                                          <th>Order Date</th>
                                                          <th>Order Time</th>
                                                          <th>Amount (USD)</th>
                                                      </tr>
                                                      </thead>
                                                      <tbody>
                                                      <tr>
                                                          <td>Order #</td>
                                                          <td>Order Date</td>
                                                          <td>Order Time</td>
                                                          <td>Amount (USD)</td>
                                                      </tr>
                                                      </tbody>
                                                  </table>
                                              </div>
                                              <div class="text-right">
                                              <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                                                  <a href="#">View All Transactions <i class="fa fa-arrow-circle-right"></i></a>
                                              </div>
                                          </div>
                                      </div>
                                  </div>
                              </div>


                          </div>
                      </div>
                  </div>
              </div>

          </div>


      </div>


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
