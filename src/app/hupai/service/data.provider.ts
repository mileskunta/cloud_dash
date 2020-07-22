
import { Injectable } from '@angular/core';
import * as _ from 'lodash';

export interface WidgetCfg {
    severity: string;
    titleColor:string;
    contentSelector:string;
    hidden:boolean;
}

@Injectable()
export class DataProvider {
}

