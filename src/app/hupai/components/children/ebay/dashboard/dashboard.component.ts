import { Component, OnInit } from '@angular/core';
import { WidgetCfg, DataProvider } from '../../../../service/data.provider';
import { ActivatedRoute } from '@angular/router';

import * as _ from 'underscore';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  editing: false;
  defaultCfgSelected='';

  defaultConfigs=[];

  config: {
    layout:{
      leftWidgets: WidgetCfg[],
      rightWidgets: WidgetCfg[]
    },
  };

  constructor(private dataService: DataProvider, private route: ActivatedRoute) { }

  ngOnInit() {
    this.defaultConfigs = this.dataService.globalWidgetCfgs;
    let cfgId = this.route.snapshot.paramMap.get("cfgId");
    this.dataService.loadConfig(cfgId).subscribe(config => {
      this.config = config;
    });
  }

  saveConfig() {
    this.dataService.saveConfig(this.config);
  }

  selectDefaultCfg(id){
    var defaultCfg =  _.find(this.defaultConfigs,c=>c.id == id);
    if(this.editing){
      if(defaultCfg){
        var cfg = _.omit(defaultCfg,'id','defaultConfig',name);
        cfg.name = "copy of " + defaultCfg.name;
        this.config = cfg;
      }
    } else {
      this.config = defaultCfg;
    }
  }
}
