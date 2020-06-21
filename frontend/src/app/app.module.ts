import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { environment } from '../environments/environment';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

/* Angular Material */
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AngularMaterialModule } from './angular-material.module';

/* FormsModule */
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

/* Angular Flex Layout */
import { FlexLayoutModule } from "@angular/flex-layout";

/* Components */
import { LogInComponent } from './components/log-in/log-in.component';
import { RegisterComponent } from './components/register/register.component';
import { AuthService } from './services/auth.service';
import { CustomHttpInterceptor } from './services/custom-http.interceptor';
import { AppointmentComponent } from './components/appointment/appointment.component';
import { AppointmentService } from './services/appointment.service';
import { AppointmentFormComponent } from './components/appointment-form/appointment-form.component';
import { NgxMatNativeDateModule } from '@angular-material-components/datetime-picker';
import { DoctorService } from './services/doctor.service';
import { PatientService } from './services/patient.service';
import { DoctorsComponent } from './components/doctors/doctors.component';
import { DoctorFormComponent } from './components/doctor-form/doctor-form.component';


@NgModule({
  declarations: [
    AppComponent,
    LogInComponent,
    RegisterComponent,
    AppointmentComponent,
    AppointmentFormComponent,
    DoctorsComponent,
    DoctorFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    AngularMaterialModule,
    ReactiveFormsModule,
    FormsModule,
    FlexLayoutModule,
    NgxMatNativeDateModule
  ],
  providers: [
    AuthService, 
    AppointmentService, 
    DoctorService, 
    PatientService, 
    NgxMatNativeDateModule,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: CustomHttpInterceptor,
      multi: true,
    }],
  bootstrap: [AppComponent],
})
export class AppModule {}