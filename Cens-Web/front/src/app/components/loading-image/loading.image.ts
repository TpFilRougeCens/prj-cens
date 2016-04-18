import {Component} from 'angular2/core';

/*
 * We're loading this component asynchronously
 * We are using some magic with es6-promise-loader that will  wrap the module with a Promise
 * see https://github.com/gdi2290/es6-promise-loader for more info
 */


@Component({
    selector: 'loading-image',
    directives: [],
    template: `
    <img src="{{loadImg}}" class="img-responsive center-block" style="margin-top:60px;margin-bottom: 60px;">
  `,
    styles: [`
  img {
    width: 5%;
  }
  `]
})
export class LoadingImage {

    loadImg = 'assets/img/loading-bar.gif';

    ngOnInit() {
        console.log('hello loading image component');
    }


}
