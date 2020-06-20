import { Component, OnInit } from '@angular/core';
import { AppointmentService, AppointmentItemDTO } from '../../services/appointment.service';

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css']
})
export class AppointmentComponent implements OnInit {

  appointments: AppointmentItemDTO[] = [];

  constructor(private appointmentService:AppointmentService) { }

  ngOnInit() {
    this.appointmentService.retrieveAll().then((result)=>{
      this.appointments = result;
      console.log( this.appointments);
    });
  }

}
