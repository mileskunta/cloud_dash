import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'orderBy'
})
export class OrderByPipePipe implements PipeTransform {

  transform(array: Array<any>, args: string): Array<any> {
    array.sort((a: any, b: any) => {
      return a[args] < b[args] ? 1 : -1;
    });
    return array;
  }


}
