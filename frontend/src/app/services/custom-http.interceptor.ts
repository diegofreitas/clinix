import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor, HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { AuthService } from './auth.service';
import { NotificationDataService, NotificationType } from './notification-data.service';


@Injectable()
export class CustomHttpInterceptor implements HttpInterceptor {
    constructor(private authService: AuthService, private notification: NotificationDataService) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        if (this.authService.credentials) {
            const auth = btoa(`${this.authService.credentials.username}:${this.authService.credentials.password}`);
            request = request.clone({
                setHeaders: { 
                    Authorization: `Basic ${auth}`
                }
            });
        }
        return next.handle(request).pipe(
            catchError((resp: HttpErrorResponse) => {
                if (resp.error) {
                    if (resp.url.indexOf("verify")> -1) { 
                        this.notification.notificationData.next({
                            message: "Authentication Error! Verify your password",
                            type: NotificationType.ERROR
                        })
                    } else  if (resp.url.indexOf("register")> -1) { 
                        this.notification.notificationData.next({
                            message: "Registration error! try another email",
                            type: NotificationType.ERROR
                        })
                    } else if( resp.error.message) {
                        this.notification.notificationData.next({
                            message: resp.error.message,
                            type: NotificationType.ERROR
                        })
                    }
                }
                return throwError(resp);
            })
        );
    }
}