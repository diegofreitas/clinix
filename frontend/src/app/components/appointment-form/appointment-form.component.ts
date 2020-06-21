import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';
import { AppointmentService } from '../../services/appointment.service';
import { PatientDTO } from 'src/app/services/patient.service';
import { DoctorDTO } from 'src/app/services/doctor.service';
import { DoctorService } from '../../services/doctor.service';
import { PatientService } from '../../services/patient.service';

@Component({
  selector: 'app-appointment-form',
  templateUrl: './appointment-form.component.html',
  styleUrls: ['./appointment-form.component.css']
})
export class AppointmentFormComponent implements OnInit{

  appointmentForm = new FormGroup({
    doctorId: new FormControl(''),
    patientId: new FormControl(''),
    schedule: new FormControl('')
  });

  doctors: DoctorDTO[];

  patients: PatientDTO[];

  constructor(private appointmentService: AppointmentService, private doctorService: DoctorService, private patientService: PatientService, private router: Router) { 

  }

  ngOnInit(): void {
    this.doctorService.retrieveAll().then((value) =>{
      this.doctors = value;
    });
    this.patientService.retrieveAll().then((value) =>{
      this.patients = value;
    });
  }

  createAppointment() {
    this.appointmentService.createAppointment(this.appointmentForm.value)
    .then(()=> {
      this.router.navigate(['appointments']);
    });
  }

}
