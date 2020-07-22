import { Component, Input, OnInit, ChangeDetectionStrategy } from '@angular/core';



@Component({
    moduleId: module.id,
    selector: 'as-navbar',
    templateUrl: 'navbar.html',
    styleUrls: ['navbar.css'],
    changeDetection: ChangeDetectionStrategy.OnPush
})
export class NavbarComponent implements OnInit{
    @Input() brand: string;

    showBiddingInfo:boolean = false;
    constructor(){}
    price:number;
    num_head:string="A";
    num_1:string="8";
    num_2:string="8";
    num_3:string="8";
    num_4:string="8";
    num_5:string="8";

    obj={
        plateNumber: "A88100"
    }
    
    ngOnInit(){

        var showBiddingInfo = localStorage.getItem('showBiddingInfo');
        this.showBiddingInfo = showBiddingInfo? true:false;
    }
    confirmPlate(obj){
        // this.plateNumber = this.plateNumber || "";
        var plateNumber = obj.plateNumber ||"";
        if(plateNumber.length==6){
            this.num_head = plateNumber.substr(0,1).toUpperCase();
            this.num_1 = plateNumber.substr(1,1).toUpperCase();
            this.num_2 = plateNumber.substr(2,1).toUpperCase();
            this.num_3 = plateNumber.substr(3,1).toUpperCase();
            this.num_4 = plateNumber.substr(4,1).toUpperCase();
            this.num_5 = plateNumber.substr(5,1).toUpperCase();
        }
    }
}
