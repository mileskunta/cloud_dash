import {RouteReuseStrategy,DetachedRouteHandle,ActivatedRouteSnapshot} from '@angular/router';

export class CustomReuseStrategy implements RouteReuseStrategy {
    
        handlers: {[key: string]: DetachedRouteHandle} = {};
    
        shouldDetach(route: ActivatedRouteSnapshot): boolean {
            if(route.data["shouldReuse"]) {return true;}
            return false;
        }
    
        store(route: ActivatedRouteSnapshot, handle: DetachedRouteHandle): void {
            console.debug('CustomReuseStrategy:store', route, handle);
            this.handlers[route.routeConfig.path] = handle;
        }
    
        shouldAttach(route: ActivatedRouteSnapshot): boolean {
            console.debug('CustomReuseStrategy:shouldAttach', route);
            return !!route.routeConfig && !!this.handlers[route.routeConfig.path];
        }
    
        retrieve(route: ActivatedRouteSnapshot): DetachedRouteHandle {
            console.debug('CustomReuseStrategy:retrieve', route);
            if (!route.routeConfig) return null;
            return this.handlers[route.routeConfig.path];
        }
    
        shouldReuseRoute(future: ActivatedRouteSnapshot, curr: ActivatedRouteSnapshot): boolean {
            console.debug('CustomReuseStrategy:shouldReuseRoute', future, curr);
            return future.routeConfig === curr.routeConfig;
        }
    
    }