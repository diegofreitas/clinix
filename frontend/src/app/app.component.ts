import { Component, OnInit, ApplicationRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { interval } from 'rxjs';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Clinix';
  apiData: any;

  constructor(
    private http: HttpClient,
    private appRef: ApplicationRef,
    public authService: AuthService

  ) {
  }


}
