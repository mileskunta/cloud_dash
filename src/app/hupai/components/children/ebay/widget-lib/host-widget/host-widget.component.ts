import { Component, OnInit } from '@angular/core';

@Component({
  selector: '[app-host-widget]',
  templateUrl: './host-widget.component.html',
  styleUrls: ['./host-widget.component.css']
})
export class HostWidgetComponent implements OnInit {

  constructor() { }

  hosts=[{
    name:"ivapp1.ebay.com",
    location:'ny'
  },{
    name:"ivapp2.ebay.com",
    location:'ln'
  },{
    name:"ivapp3.ebay.com",
    location:'tk'
  },{
    name:"ivapp4.ebay.com",
    location:'tk'
  },{
    name:"ivapp5.ebay.com",
    location:'sh'
  }]

  ngOnInit() {
  }
}
