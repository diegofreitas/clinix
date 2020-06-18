import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';


@Injectable()
export class AuthInterceptor implements HttpInterceptor {
    constructor(private authService: AuthService) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        if (this.authService.credentials) {
            const auth = btoa(`${this.authService.credentials.username}:${this.authService.credentials.password}`);
            request = request.clone({
                setHeaders: { 
                    Authorization: `Basic ${auth}`
                }
            });
        }

        return next.handle(request);
    }
}