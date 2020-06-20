import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LogInComponent } from './components/log-in/log-in.component';
import { RegisterComponent } from './components/register/register.component';
import { AppointmentComponent } from './components/appointment/appointment.component';
import { AuthGuard } from './services/auth.guard';
import { AppointmentFormComponent } from './components/appointment-form/appointment-form.component';
import { DoctorsComponent } from './components/doctors/doctors.component';
import { DoctorFormComponent } from './components/doctor-form/doctor-form.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'login' },
  { path: 'login', component: LogInComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'appointments', component: AppointmentComponent, canActivate: [AuthGuard]},
  { path: 'appointment', component: AppointmentFormComponent, canActivate: [AuthGuard]},
  { path: 'doctors', component: DoctorsComponent, canActivate: [AuthGuard]},
  { path: 'doctor', component: DoctorFormComponent, canActivate: [AuthGuard]}

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
