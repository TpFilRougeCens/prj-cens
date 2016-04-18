import { Pipe } from 'angular2/core';

@Pipe({
    name: 'sortDate'
})
export class SortDatePipe {
    transform(array: Array<string>, args: string): Array<string> {
        array.sort((a: any, b: any) => {
            if (a.date > b.date) {
                return -1;
            } else if (a.date < b.date) {
                return 1;
            } else {
                return 0;
            }
        });
        return array;
    }
}
