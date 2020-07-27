import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpModule } from '@angular/http';
import { CarouselModule,PaginationModule} from 'ngx-bootstrap';

import { SortableModule } from 'ngx-bootstrap/sortable';
import { HighchartsChartModule } from 'highcharts-angular';
import {
    HupaiComponent,
    DataProvider,

    DashboardComponent,
    DocWidgetComponent,
    DbWidgetComponent,
    GetStartWidgetComponent,
    ApiWidgetComponent,
    HostWidgetComponent,
    WidgetComponent,
    DomainWidgetComponent,
    MonitorWidgetComponent,
    ErrorWidgetComponent,

    OrderByPipePipe
} from './index';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
    imports: [
        FormsModule,
        BrowserModule,
        CarouselModule.forRoot(),
        PaginationModule.forRoot(),
        SortableModule.forRoot(),
        RouterModule,
        HttpClientModule,
        HighchartsChartModule
    ],
    declarations: [
        HupaiComponent,
        OrderByPipePipe,
        DashboardComponent,
        WidgetComponent,
        DocWidgetComponent,
        GetStartWidgetComponent,
        ApiWidgetComponent,
        HostWidgetComponent,
        DomainWidgetComponent,
        MonitorWidgetComponent,
        DbWidgetComponent,
        ErrorWidgetComponent
    ],
    providers:[DataProvider],
    exports: [HupaiComponent]
})
export class HupaiModule {
}
