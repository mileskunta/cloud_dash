import { Component, OnInit } from '@angular/core';
import { WidgetCfg } from '../../../../service/data.provider';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  editing:false;

  leftWidgets: WidgetCfg[] = [{
    severity: 'info',
    titleColor: 'green',
    contentSelector: 'host',
    hidden:false
  },{
    severity: 'danger',
    titleColor: 'green',
    contentSelector: 'doc',
    hidden:false
  },{
    severity: 'info',
    titleColor: 'green',
    contentSelector: 'getStart',
    hidden:false
  },{
    severity: 'info',
    titleColor: 'green',
    contentSelector: 'monitor',
    hidden:false
  }];

  rightWidgets:WidgetCfg[] =[{
    severity: 'success',
    titleColor: 'green',
    contentSelector: 'db',
    hidden:false
  },{
    severity: 'info',
    titleColor: 'green',
    contentSelector: 'api',
    hidden:false
  },{
    severity: 'warning',
    titleColor: 'green',
    contentSelector: 'domain',
    hidden:false
  },{
    severity: 'success',
    titleColor: 'green',
    contentSelector: 'error',
    hidden:false
  }];


  itemStringsLeft: any[] = [
    'Windstorm',
    'Bombasto',
    'Magneta',
    'Tornado'
  ];

  constructor() { }

  ngOnInit() {
  }

}
