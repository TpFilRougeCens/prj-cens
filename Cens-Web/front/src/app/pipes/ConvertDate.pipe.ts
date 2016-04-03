import {Pipe, PipeTransform} from "angular2/core";

@Pipe({name: 'convertToFrDate'})
export class ConvertDatePipe implements PipeTransform {

    transform(value:string, [dateUS]):string {
        var dateChange = new Date(dateUS);
        var dateFr = dateChange.toLocaleDateString();
        return dateFr;
    }

}