import {
  it,
  inject,
  injectAsync,
  describe,
  beforeEachProviders,
  TestComponentBuilder
} from 'angular2/testing';

import {Component, provide} from 'angular2/core';

// Load the implementations that should be tested
import {Profil} from './profil';

describe('Profil', () => {
  // provide our implementations or mocks to the dependency injector
  beforeEachProviders(() => [
    Profil
  ]);

  it('should log ngOnInit', inject([ Profil ], (profil) => {
    spyOn(console, 'log');
    expect(console.log).not.toHaveBeenCalled();

    profil.ngOnInit();
    expect(console.log).toHaveBeenCalled();
  }));

});
