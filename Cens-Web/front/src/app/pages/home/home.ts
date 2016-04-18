import {Component} from "angular2/core";
import {AppState} from "../../app.service";
import {Router} from "angular2/router";
import {isLoggedin} from "../../service/is-loggedin";

@Component({
    // The selector is what angular internally uses
    // for `document.querySelectorAll(selector)` in our index.html
    // where, in this case, selector is the string 'home'
    selector: 'home',  // <home></home>
    // We need to tell Angular's compiler which custom pipes are in our template.
    pipes: [],
    // Our list of styles in our component. We may add more to compose many styles together
    styles: [require('./home.scss')],
    // Every Angular template is first compiled by the browser before Angular runs it's compiler
    template: require('./home.html')
})
export class Home {
    // Set our default values
    localState = { value: '' };
    // TypeScript public modifiers
    constructor(public appState:AppState) {

    }

    ngOnInit() {
        console.log("Im in Home ngOnInit");
        console.log("Im logged");
        console.log(isLoggedin());
        if (!isLoggedin()) {
            console.log("redirecting ...");
            //this.router.navigate(['../../Login']);
        }
        this.localState.value = this.appState.get('value');
    }

    submitState(value) {
        console.log('submitState', value);
        this.appState.set('value', value);
    }


}
