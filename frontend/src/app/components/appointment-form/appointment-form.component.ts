import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';
import { AppointmentService } from '../../services/appointment.service';

@Component({
  selector: 'app-appointment-form',
  templateUrl: './appointment-form.component.html',
  styleUrls: ['./appointment-form.component.css']
})
export class AppointmentFormComponent {

  appointmentForm = new FormGroup({
    doctorId: new FormControl(''),
    patientId: new FormControl(''),
    schedule: new FormControl('')
  });

  doctors = [
    {
      id: 1,
      name: "asdfasdf",
      speciality: "asdfasd"
    }
  ]

  patients = [
    {
      id: 1,
      name: "diego"
    }
  ]

  constructor(private appointmentService: AppointmentService, private router: Router) { 

  }

  createAppointment() {
    console.log(Date.parse(this.appointmentForm.value.schedule));
    console.log(this.appointmentForm.value.schedule);
    this.appointmentService.createAppointment({
      doctorId: this.appointmentForm.value.doctorId,
      patientId: this.appointmentForm.value.patientId,
      schedule: Date.parse(this.appointmentForm.value.schedule)
    })
    .then(()=> {
      this.router.navigate(['appointments']);
    });
  }

}
