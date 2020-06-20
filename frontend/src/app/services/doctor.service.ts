import { Injectable } from '@angular/core';
import { environment as ENV } from '../../environments/environment.prod';
import { HttpClient } from '@angular/common/http';

export interface DoctorDTO {
  id:number;
  name: string;
  speciality: string
}

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(private http: HttpClient) { }

  retrieveAll(): Promise<DoctorDTO[]> {
    return new Promise((resolve, reject) => {
      this.http.get(ENV.host+'doctors').subscribe(
        (res: DoctorDTO[]) => {
          resolve(res);
        }
      );
    });
  }
}
