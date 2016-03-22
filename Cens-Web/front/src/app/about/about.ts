import {Component} from 'angular2/core';
import {CORE_DIRECTIVES} from 'angular2/common';

import {DROPDOWN_DIRECTIVES} from 'ng2-bootstrap/ng2-bootstrap';

/*
 * We're loading this component asynchronously
 * We are using some magic with es6-promise-loader that will  wrap the module with a Promise
 * see https://github.com/gdi2290/es6-promise-loader for more info
 */

console.log('`About` component loaded asynchronously');

@Component({
  selector: 'about',
  directives: [DROPDOWN_DIRECTIVES, CORE_DIRECTIVES],
  template:  require('./about.html')
})
export class About {
  private disabled:boolean = false;
  private status:{isopen:boolean} = {isopen: false};
  private items:Array<string> = ['The first choice!', 'And another choice for you.', 'but wait! A third!'];

  constructor() {

  }

  private toggled(open:boolean):void {
    console.log('Dropdown is now: ', open);
  }

  private toggleDropdown($event:MouseEvent):void {
    $event.preventDefault();
    $event.stopPropagation();
    this.status.isopen = !this.status.isopen;
  }

  ngOnInit() {
    console.log('hello `About` component');
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
