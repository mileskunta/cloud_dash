
import { CustomReuseStrategy } from './shared/angular-reuse-router';

import { Routes, RouterModule, RouteReuseStrategy } from '@angular/router';


import { HupaiRoutes } from './hupai/index';

const appRoutes: Routes = [
    ...HupaiRoutes
];

export const appRoutingProviders: any[] = [
 {provide:RouteReuseStrategy,useClass:CustomReuseStrategy}
];

export const routing = RouterModule.forRoot(appRoutes, { useHash: true });
