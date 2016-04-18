import {
  it,
  inject,
  injectAsync,
  beforeEachProviders,
  TestComponentBuilder
} from 'angular2/testing';

// Load the implementations that should be tested
import {Home} from './home';
import {AppState} from "../../app.service";
import {WebpackState} from "angular2-hmr/dist/index";
import {Router} from "angular2/router";

describe('Home', () => {
  // provide our implementations or mocks to the dependency injector
  beforeEachProviders(() => [
    Home,
    AppState,
    WebpackState
  ]);

  it("L'état initial doit être vide", inject([ Home ], (home) => {
    expect(home.localState).toEqual({ value: '' });
  }));

});
