import {Pipe, PipeTransform} from 'angular2/core';

@Pipe({name: 'convertToFrDate'})
export class ConvertDatePipe implements PipeTransform {

    transform(value: string): string {
        var dateChange = new Date(value);
        var dateFr = dateChange.toLocaleDateString();
        return dateFr;
    }

}
