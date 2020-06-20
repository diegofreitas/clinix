import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment as ENV } from '../../environments/environment.prod';

export interface AppointmentItemDTO{
  appointmentId: number;
  doctorName:string;
  speciality: string;
  patientName: string;
  schedule:Date;
}

export interface AppointmentFormDTO {
  doctorId: number;
  patientId: number;
  schedule: number;
}

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  constructor(private http: HttpClient) { }

  retrieveAll(): Promise<AppointmentItemDTO[]> {
    return new Promise((resolve, reject) => {
      this.http.get(ENV.host+'appointments').subscribe(
        (res: AppointmentItemDTO[]) => {
          resolve(res);
        },
        (err) => {
          console.error(err);
          reject("error");
        }
      );
    });
  }

  createAppointment(newAppointment: AppointmentFormDTO): Promise<AppointmentFormDTO> {
    return new Promise((resolve, reject) => {
      this.http.post(ENV.host+'appointments', newAppointment).subscribe(
        (res: AppointmentFormDTO) => {
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
