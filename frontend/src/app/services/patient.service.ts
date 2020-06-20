import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment as ENV } from '../../environments/environment.prod';

export interface PatientDTO {
  id:number;
  name: string;
}

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private http: HttpClient) { }

  retrieveAll(): Promise<PatientDTO[]> {
    return new Promise((resolve, reject) => {
      this.http.get(ENV.host+'patients').subscribe(
        (res: PatientDTO[]) => {
          resolve(res);
        }
      );
    });
  }
}
