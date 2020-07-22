import { Routes } from '@angular/router';

import {
  DashboardComponent,
} from './index';

const childRoutes: Routes = [
  { path: 'dash', component: DashboardComponent },
  { path: '**', redirectTo: 'dash' }
];

export const HupaiRoutes: Routes = [
  ...childRoutes
];