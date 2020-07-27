import { Component, OnInit } from '@angular/core';

@Component({
  selector: '[app-db-widget]',
  templateUrl: './db-widget.component.html',
  styleUrls: ['./db-widget.component.css']
})
export class DbWidgetComponent implements OnInit {

  constructor() { }

  dbs=[{
    name:"hupai",
    type:'MYSQL'
  },{
    name:"location_storage",
    type:'DB2'
  },{
    name:"p_country",
    type:'MYSQL'
  },{
    name:"shared_db",
    type:'SYBASE'
  },{
    name:"testDB",
    type:'SYBASE'
  }]

  ngOnInit() {
  }

}
