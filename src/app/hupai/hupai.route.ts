import { Routes } from '@angular/router';

import {
  DashboardComponent,
} from './index';

const childRoutes: Routes = [
  { path: 'dash', component: DashboardComponent,data:{shouldReuse:false} },
  { path: 'dash/:cfgId', component: DashboardComponent,data:{shouldReuse:false} },
  { path: '**', redirectTo: 'dash' }
];

export const HupaiRoutes: Routes = [
  ...childRoutes
];