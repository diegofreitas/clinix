import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';
import { AppointmentService } from '../../services/appointment.service';
import { PatientDTO } from 'src/app/services/patient.service';
import { DoctorDTO } from 'src/app/services/doctor.service';
import { DoctorService } from '../../services/doctor.service';
import { PatientService } from '../../services/patient.service';

@Component({
  selector: 'app-doctor-form',
  templateUrl: './doctor-form.component.html',
  styleUrls: ['./doctor-form.component.css']
})
export class DoctorFormComponent{

  doctorForm = new FormGroup({
    name: new FormControl(''),
    speciality: new FormControl('')
  });

  constructor( private doctorService: DoctorService, private router: Router) { 

  }

  createDoctor() {
    this.doctorService.createDoctor(this.doctorForm.value)
    .then(()=> {
      this.router.navigate(['doctors']);
    });
  }

}
