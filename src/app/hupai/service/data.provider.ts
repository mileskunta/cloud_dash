
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

import * as _ from 'underscore';
import { subscribeOn } from 'rxjs/operator/subscribeOn';
export interface WidgetCfg {
    type: string;
    severity: string;
    titleColor: string;
    hidden: boolean;
}

const LOAD_CONFIG_BY_ID = '../hupai/app/layout/find-by-id';
const LOAD_DEFAULT_CONFIGS = '../hupai/app/layout/all-default';
const SAVE_CONFIG = '../hupai/app/layout/save';

@Injectable()
export class DataProvider {

    defaultConfig= {
        name: 'Default',
        layout: {
            leftWidgets: [{
                severity: 'info',
                titleColor: 'green',
                type: 'host',
                hidden: false
            }, {
                severity: 'danger',
                titleColor: 'green',
                type: 'doc',
                hidden: false
            }, {
                severity: 'info',
                titleColor: 'green',
                type: 'getStart',
                hidden: false
            }, {
                severity: 'info',
                titleColor: 'green',
                type: 'monitor',
                hidden: false
            }],

            rightWidgets: [{
                severity: 'success',
                titleColor: 'green',
                type: 'db',
                hidden: false
            }, {
                severity: 'info',
                titleColor: 'green',
                type: 'api',
                hidden: false
            }, {
                severity: 'warning',
                titleColor: 'green',
                type: 'domain',
                hidden: false
            }, {
                severity: 'success',
                titleColor: 'green',
                type: 'error',
                hidden: false
            }]
        },
    };

    globalWidgetCfgs: any[] = [];

    constructor(private http: HttpClient) {
        this.loadAllPredefinedCfgs();
    }

    loadConfig(id: string): Observable<any> {
        if (id) {
            return this.http.post(LOAD_CONFIG_BY_ID, { id: id }).pipe(map((cfg:any) => {
                if(cfg){
                    cfg.layout = JSON.parse(cfg.layoutConfigStr);
                    return cfg;
                } else {
                    return this.defaultConfig;
                }
            }));
        } else {
            return Observable.of(this.defaultConfig);
        }
    }

    loadAllPredefinedCfgs() {
        this.http.post(LOAD_DEFAULT_CONFIGS,{}).subscribe((globalCfgs:any[]) => {
            _.each(globalCfgs,cfg =>{
                cfg.layout = JSON.parse(cfg.layoutConfigStr);
                delete cfg.layoutConfigStr;
                this.globalWidgetCfgs.push(cfg);
            })
        })
    }

    saveConfig(config) {
        config.layoutConfigStr = JSON.stringify(config.layout);
        return this.http.post(SAVE_CONFIG, config).subscribe(res => {
            _.extend(config, res);
        });
    }

}

