import { Component, OnInit } from '@angular/core';
import * as Highcharts from 'highcharts';
@Component({
  selector: '[app-api-widget]',
  templateUrl: './api-widget.component.html',
  styleUrls: ['./api-widget.component.css']
})
export class ApiWidgetComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  runOutsideAngularFlag = false;
  Highcharts = Highcharts; // 必填
  chartConstructor = 'chart'; // 可选 String，默认为 'chart'
  updateFlag = false; // 可选 Boolean
  oneToOneFlag = true; // 可选 Boolean，默认为 false
  runOutsideAngular = false;

  chartCallback(){};

  chartOptions = {
    title: {
      text: 'API Usage'
    },
    // subtitle: {
    //   text: '数据来源：thesolarfoundation.com'
    // },
    yAxis: {
      title: {
        text: 'number of visits'
      }
    },
    legend: {
      layout: 'vertical',
      align: 'right',
      verticalAlign: 'middle'
    },
    plotOptions: {
      series: {
        label: {
          connectorAllowed: false
        },
        pointStart: 1 / 22
      }
    },
    series: [{
      name: 'findAll',
      data: [43934, 52503, 57177, 69658, 97031, 119931, 137133, 154175]
    }, {
      name: 'findOne',
      data: [24916, 24064, 29742, 29851, 32490, 30282, 38121, 40434]
    }, {
      name: 'sell',
      data: [11744, 17722, 16005, 19771, 20185, 24377, 32147, 39387]
    }, {
      name: 'project',
      data: [null, null, 7988, 12169, 15112, 22452, 34400, 34227]
    }, {
      name: 'other',
      data: [12908, 5948, 8105, 11248, 8989, 11816, 18274, 18111]
    }],
    responsive: {
      rules: [{
        condition: {
          maxWidth: 500
        },
        chartOptions: {
          legend: {
            layout: 'horizontal',
            align: 'center',
            verticalAlign: 'bottom'
          }
        }
      }]
    }
  }

}
