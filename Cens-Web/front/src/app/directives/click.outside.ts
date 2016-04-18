import {Directive, ElementRef, Input} from 'angular2/core';
import {EventEmitter} from 'angular2/core';


@Directive({
    selector: "[clickOutside]",
    outputs: [ "clickOutside" ],
    host: {
        "(click)": "trackEvent( $event )",
        "(document: click)": "compareEvent( $event )"
    }
})
export class ClickOutsideDirective {

    // Setup the output event stream.
    clickOutside = new EventEmitter();
    // I keep track of the last internal click event so that we can
    // compare target-local events to global events.
    localEvent = null;

    constructor(el: ElementRef) {
    }

    // PUBLIC METHODS.
    // ---
    // I track and compare the click event at the document root.
    compareEvent( event ) {
        // If the event at the document root is the same reference as the
        // event at the target, it means that the event originated from
        // within the target and bubbled all the way to the root. As such,
        // if the event at the document root does NOT MATCH the last known
        // event at the target, the event must have originated from
        // outside of the target.
        if ( event !== this.localEvent ) {
            this.clickOutside.emit( event );
        }
        this.localEvent = null;
    }
    // I track the click event on the bound target.
    trackEvent( event ) {
        // When the user clicks inside the bound target, we need to start
        // tracking the event as it bubbles up the DOM tree. This way,
        // when a click event hits the document root, we can determine if
        // the event originated from within the target.
        this.localEvent = event;
    }
}
