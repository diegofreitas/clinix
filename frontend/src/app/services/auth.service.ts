import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment as ENV } from '../../environments/environment.prod';
import { User } from '../model/user.model';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  authenticated: boolean = false;
  credentials: User;

  constructor(private http: HttpClient) { }

  auth(username: string, password: string): Promise<string> {
    return new Promise((resolve, reject) => {
      this.credentials = new User();
      this.credentials.username = username;
      this.credentials.password = password;
      this.http.get(ENV.host+'verify-credentials').subscribe(
        (res: any) => {
          this.authenticated = true;
          resolve("OK");
        },
        (err) => {
          console.error(err);
          reject("auth-failed");
        }
      );
    });
  }
}
