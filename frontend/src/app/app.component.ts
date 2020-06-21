import { Component, OnInit, ApplicationRef } from '@angular/core';

import { AuthService } from './services/auth.service';
import { NotificationDataService } from './services/notification-data.service';
import { MatSnackBarRef, SimpleSnackBar, MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Clinix';

  constructor(public authService: AuthService, notficationService: NotificationDataService, private _snackBar: MatSnackBar) {
    notficationService.notificationData.subscribe((data) => {
      if(data !== null) {
        this._snackBar.open(data.message, 'Error', {
          duration: 5000,
          horizontalPosition: 'center',
          verticalPosition: 'top',
          panelClass: 'error'
        });
      }
    }); 
    
  }


}
