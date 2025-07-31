import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { PetsComponent } from './components/pets/pets.component';
import { AppointmentsComponent } from './components/appointments/appointments.component';
import { MedicalRecordsComponent } from './components/medical-records/medical-records.component';
import { RemindersComponent } from './components/reminders/reminders.component';
import { OwnersComponent } from './components/owners/owners.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'owners', component: OwnersComponent },
  { path: 'pets', component: PetsComponent },
  { path: 'appointments', component: AppointmentsComponent },
  { path: 'medical-records', component: MedicalRecordsComponent },
  { path: 'reminders', component: RemindersComponent },
  { path: '**', redirectTo: '' }
];
