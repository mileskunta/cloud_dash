import { Component, OnInit, Input } from '@angular/core';
import { WidgetCfg } from '../../../../service/data.provider';

@Component({
  selector: 'app-widget',
  templateUrl: './widget.component.html',
  styleUrls: ['./widget.component.css']
})
export class WidgetComponent implements OnInit {

  @Input() widgetCfg: any = {};
  @Input() editing;


  constructor() { }

  ngOnInit() {
  }

  setStyle(){
    
  }

}
