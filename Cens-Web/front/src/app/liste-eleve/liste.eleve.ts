import {Component} from 'angular2/core';

/*
 * We're loading this component asynchronously
 * We are using some magic with es6-promise-loader that will  wrap the module with a Promise
 * see https://github.com/gdi2290/es6-promise-loader for more info
 */

console.log('`About` component loaded asynchronously');

@Component({
  selector: 'liste-eleve',
  directives: [],
  template: `
  <div>Liste des élèves</div>
  <div class="form-group">
    <label for="name">Name</label>
    <input type="text" class="form-control" required
      [(ngModel)]="model.name" >
    </div>
    <div class="form-group">
    <label for="alterEgo">Alter Ego</label>
    <input type="text"  class="form-control"
      [(ngModel)]="model.alterEgo">
    </div>
    <div class="form-group">
    <label for="power">Hero Power</label>
    <select class="form-control"  required
      [(ngModel)]="model.power" >
      <option *ngFor="#p of powers" [value]="p">{{p}}</option>
    </select>
  </div>
  `
})
export class ListEleve {

  powers = ['Really Smart', 'Super Flexible',
    'Super Hot', 'Weather Changer'];
  model = {'id':18, 'name':'Dr IQ', 'power':this.powers[0], 'alterEgo':'Chuck Overstreet'};
  submitted = false;
  onSubmit() { this.submitted = true; }
  // TODO: Remove this when we're done
  get diagnostic() { return JSON.stringify(this.model); }


  ngOnInit() {
    console.log('hello `Liste eleve` component');
    // static data that is bundled
    var mockData = require('assets/mock-data/mock-data.json');
    console.log('mockData', mockData);
    // if you're working with mock data you can also use http.get('assets/mock-data/mock-data.json')
    this.asyncDataWithWebpack();
  }
  asyncDataWithWebpack() {
    // you can also async load mock data with 'es6-promise-loader'
    // you would do this if you don't want the mock-data bundled
    // remember that 'es6-promise-loader' is a promise
    var asyncMockDataPromiseFactory = require('es6-promise!assets/mock-data/mock-data.json');
    setTimeout(() => {

      let asyncDataPromise = asyncMockDataPromiseFactory();
      asyncDataPromise.then(json => {
        console.log('async mockData', json);
      });

    });
  }

}
