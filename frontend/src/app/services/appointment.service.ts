import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment as ENV } from '../../environments/environment.prod';

export interface AppointmentView {
  appointmentId: number;
  doctorName:string;
  speciality: string;
  patientName: string;
  schedule:Date;
} 

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

   

  constructor(private http: HttpClient) { }

  retrieveAll(): Promise<AppointmentView[]> {
    return new Promise((resolve, reject) => {
      this.http.get(ENV.host+'appointments').subscribe(
        (res: AppointmentView[]) => {
          resolve(res);
        },
        (err) => {
          console.error(err);
          reject("error");
        }
      );
    });
  }
}
