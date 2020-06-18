import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {
   MatInputModule,
} from '@angular/material/input';

import {
   MatButtonModule,
} from '@angular/material/button';

import {
   MatToolbarModule
} from '@angular/material/toolbar';

import {
   MatIconModule
} from '@angular/material/icon';

import {
   MatBadgeModule
} from '@angular/material/badge';

import {
   MatSidenavModule
} from '@angular/material/sidenav';
import {

   MatListModule
   
} from '@angular/material/list';

import {

   MatGridListModule
 
} from '@angular/material/grid-list';

import {

   MatFormFieldModule,
  
} from '@angular/material/form-field';
import {
   MatSelectModule
} from '@angular/material/select';

import {

   MatRadioModule,
  
} from '@angular/material/radio';

import {

   MatDatepickerModule,

} from '@angular/material/datepicker';

import {

   MatChipsModule,
  
} from '@angular/material/chips';
import {
  
   MatTooltipModule
} from '@angular/material/tooltip';

import {
  
   MatTableModule
} from '@angular/material/table';

import {

   MatPaginatorModule
} from '@angular/material/paginator';
import {
   MatCardModule
} from '@angular/material/card';
import { MatNativeDateModule } from '@angular/material/core';

@NgModule({
   imports: [
      MatCardModule,
      CommonModule,
      MatButtonModule,
      MatToolbarModule,
      MatIconModule,
      MatSidenavModule,
      MatBadgeModule,
      MatListModule,
      MatGridListModule,
      MatFormFieldModule,
      MatInputModule,
      MatSelectModule,
      MatRadioModule,
      MatDatepickerModule,
      MatNativeDateModule,
      MatChipsModule,
      MatTooltipModule,
      MatTableModule,
      MatPaginatorModule
   
   ],
   exports: [
      MatCardModule,
      MatButtonModule,
      MatToolbarModule,
      MatIconModule,
      MatSidenavModule,
      MatBadgeModule,
      MatListModule,
      MatGridListModule,
      MatInputModule,
      MatFormFieldModule,
      MatSelectModule,
      MatRadioModule,
      MatDatepickerModule,
      MatChipsModule,
      MatTooltipModule,
      MatTableModule,
      MatPaginatorModule
   ],
   providers: [
      MatDatepickerModule,
   ]
})

export class AngularMaterialModule { }