import { Component, OnInit } from '@angular/core';
import { DoctorService, DoctorDTO } from '../../services/doctor.service';

@Component({
  selector: 'app-doctors',
  templateUrl: './doctors.component.html',
  styleUrls: ['./doctors.component.css']
})
export class DoctorsComponent implements OnInit {

  doctors: DoctorDTO[] = [];

  constructor(private doctorService:DoctorService) { }

  ngOnInit() {
    this.doctorService.retrieveAll().then((result)=>{
      this.doctors = result;
      console.log( this.doctors);
    });
  }

}
