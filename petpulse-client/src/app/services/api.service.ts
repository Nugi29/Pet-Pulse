import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { Owner, Pet, Veterinarian, Appointment, MedicalRecord, Reminder, PetType, Gender } from '../models/owner.model';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  private handleError(error: HttpErrorResponse) {
    console.error('API Error:', error);
    return throwError(() => error);
  }

  // Owner endpoints
  getAllOwners(): Observable<Owner[]> {
    return this.http.get<Owner[]>(`${this.baseUrl}/owners/get-all`)
      .pipe(catchError(this.handleError));
  }

  getOwnerById(id: number): Observable<Owner> {
    return this.http.get<Owner>(`${this.baseUrl}/owners/get-by-id/${id}`)
      .pipe(catchError(this.handleError));
  }

  createOwner(owner: Owner): Observable<void> {
    return this.http.post<void>(`${this.baseUrl}/owners/create`, owner)
      .pipe(catchError(this.handleError));
  }

  updateOwner(id: number, owner: Owner): Observable<Owner> {
    return this.http.put<Owner>(`${this.baseUrl}/owners/update/${id}`, owner)
      .pipe(catchError(this.handleError));
  }

  deleteOwner(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/owners/delete/${id}`)
      .pipe(catchError(this.handleError));
  }

  // Pet endpoints
  getAllPets(): Observable<Pet[]> {
    return this.http.get<Pet[]>(`${this.baseUrl}/pets/get-all`)
      .pipe(catchError(this.handleError));
  }

  getPetById(id: number): Observable<Pet> {
    return this.http.get<Pet>(`${this.baseUrl}/pets/get-by-id/${id}`)
      .pipe(catchError(this.handleError));
  }

  getPetsByOwner(ownerId: number): Observable<Pet[]> {
    return this.http.get<Pet[]>(`${this.baseUrl}/pets/get-by-owner/${ownerId}`)
      .pipe(catchError(this.handleError));
  }

  createPet(pet: Pet): Observable<void> {
    return this.http.post<void>(`${this.baseUrl}/pets/create`, pet)
      .pipe(catchError(this.handleError));
  }

  updatePet(id: number, pet: Pet): Observable<Pet> {
    return this.http.put<Pet>(`${this.baseUrl}/pets/update/${id}`, pet)
      .pipe(catchError(this.handleError));
  }

  deletePet(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/pets/delete/${id}`)
      .pipe(catchError(this.handleError));
  }

  // Veterinarian endpoints
  getAllVeterinarians(): Observable<Veterinarian[]> {
    return this.http.get<Veterinarian[]>(`${this.baseUrl}/veterinarians/get-all`)
      .pipe(catchError(this.handleError));
  }

  getAvailableVeterinarians(): Observable<Veterinarian[]> {
    return this.http.get<Veterinarian[]>(`${this.baseUrl}/veterinarians/get-available`)
      .pipe(catchError(this.handleError));
  }

  getVeterinarianById(id: number): Observable<Veterinarian> {
    return this.http.get<Veterinarian>(`${this.baseUrl}/veterinarians/get-by-id/${id}`)
      .pipe(catchError(this.handleError));
  }

  // Appointment endpoints
  getAllAppointments(): Observable<Appointment[]> {
    return this.http.get<Appointment[]>(`${this.baseUrl}/appointments/get-all`)
      .pipe(catchError(this.handleError));
  }

  getAppointmentById(id: number): Observable<Appointment> {
    return this.http.get<Appointment>(`${this.baseUrl}/appointments/get-by-id/${id}`)
      .pipe(catchError(this.handleError));
  }

  getAppointmentsByOwner(ownerId: number): Observable<Appointment[]> {
    return this.http.get<Appointment[]>(`${this.baseUrl}/appointments/get-by-owner/${ownerId}`)
      .pipe(catchError(this.handleError));
  }

  getAppointmentsByVet(vetId: number): Observable<Appointment[]> {
    return this.http.get<Appointment[]>(`${this.baseUrl}/appointments/get-by-vet/${vetId}`)
      .pipe(catchError(this.handleError));
  }

  bookAppointment(appointment: Appointment): Observable<Appointment> {
    return this.http.post<Appointment>(`${this.baseUrl}/appointments/book`, appointment)
      .pipe(catchError(this.handleError));
  }

  updateAppointmentStatus(id: number, status: string): Observable<Appointment> {
    return this.http.put<Appointment>(`${this.baseUrl}/appointments/update-status/${id}?status=${status}`, {})
      .pipe(catchError(this.handleError));
  }

  cancelAppointment(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/appointments/cancel/${id}`)
      .pipe(catchError(this.handleError));
  }

  // Medical Record endpoints
  getAllMedicalRecords(): Observable<MedicalRecord[]> {
    return this.http.get<MedicalRecord[]>(`${this.baseUrl}/medical-records/get-all`)
      .pipe(catchError(this.handleError));
  }

  getMedicalRecordById(id: number): Observable<MedicalRecord> {
    return this.http.get<MedicalRecord>(`${this.baseUrl}/medical-records/get-by-id/${id}`)
      .pipe(catchError(this.handleError));
  }

  getMedicalRecordsByPet(petId: number): Observable<MedicalRecord[]> {
    return this.http.get<MedicalRecord[]>(`${this.baseUrl}/medical-records/get-by-pet/${petId}`)
      .pipe(catchError(this.handleError));
  }

  getMedicalRecordsByVet(vetId: number): Observable<MedicalRecord[]> {
    return this.http.get<MedicalRecord[]>(`${this.baseUrl}/medical-records/get-by-vet/${vetId}`)
      .pipe(catchError(this.handleError));
  }

  createMedicalRecord(record: MedicalRecord): Observable<void> {
    return this.http.post<void>(`${this.baseUrl}/medical-records/create`, record)
      .pipe(catchError(this.handleError));
  }

  updateMedicalRecord(id: number, record: MedicalRecord): Observable<MedicalRecord> {
    return this.http.put<MedicalRecord>(`${this.baseUrl}/medical-records/update/${id}`, record)
      .pipe(catchError(this.handleError));
  }

  deleteMedicalRecord(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/medical-records/delete/${id}`)
      .pipe(catchError(this.handleError));
  }

  // Reminder endpoints
  getAllReminders(): Observable<Reminder[]> {
    return this.http.get<Reminder[]>(`${this.baseUrl}/reminders/get-all`)
      .pipe(catchError(this.handleError));
  }

  getReminderById(id: number): Observable<Reminder> {
    return this.http.get<Reminder>(`${this.baseUrl}/reminders/get-by-id/${id}`)
      .pipe(catchError(this.handleError));
  }

  getRemindersByOwner(ownerId: number): Observable<Reminder[]> {
    return this.http.get<Reminder[]>(`${this.baseUrl}/reminders/get-by-owner/${ownerId}`)
      .pipe(catchError(this.handleError));
  }

  getPendingReminders(): Observable<Reminder[]> {
    return this.http.get<Reminder[]>(`${this.baseUrl}/reminders/get-pending`)
      .pipe(catchError(this.handleError));
  }

  createReminder(reminder: Reminder): Observable<void> {
    return this.http.post<void>(`${this.baseUrl}/reminders/create`, reminder)
      .pipe(catchError(this.handleError));
  }

  updateReminder(id: number, reminder: Reminder): Observable<Reminder> {
    return this.http.put<Reminder>(`${this.baseUrl}/reminders/update/${id}`, reminder)
      .pipe(catchError(this.handleError));
  }

  deleteReminder(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/reminders/delete/${id}`)
      .pipe(catchError(this.handleError));
  }

  // Lookup endpoints
  getAllPetTypes(): Observable<PetType[]> {
    return this.http.get<PetType[]>(`${this.baseUrl}/pettypes/get-all`)
      .pipe(catchError(this.handleError));
  }

  getAllGenders(): Observable<Gender[]> {
    return this.http.get<Gender[]>(`${this.baseUrl}/genders/get-all`)
      .pipe(catchError(this.handleError));
  }
}
