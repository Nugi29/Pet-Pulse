import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../../services/api.service';
import { Appointment, Pet, Veterinarian } from '../../models/owner.model';

@Component({
  selector: 'app-appointments',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './appointments.component.html',
  styleUrls: ['./appointments.component.css']
})
export class AppointmentsComponent implements OnInit {
  appointments: Appointment[] = [];
  filteredAppointments: Appointment[] = [];
  pets: Pet[] = [];
  availableVets: Veterinarian[] = [];
  showBookingForm = false;
  selectedStatus = '';
  currentAppointment: Appointment = this.getEmptyAppointment();

  constructor(private apiService: ApiService) {}

  ngOnInit() {
    this.loadAppointments();
    this.loadPets();
    this.loadVeterinarians();
  }

  loadAppointments() {
    this.apiService.getAllAppointments().subscribe({
      next: (appointments) => {
        this.appointments = appointments;
        this.filterAppointments();
      },
      error: (error) => console.error('Error loading appointments:', error)
    });
  }

  loadPets() {
    this.apiService.getAllPets().subscribe({
      next: (pets) => this.pets = pets,
      error: (error) => console.error('Error loading pets:', error)
    });
  }

  loadVeterinarians() {
    this.apiService.getAvailableVeterinarians().subscribe({
      next: (vets) => this.availableVets = vets,
      error: (error) => console.error('Error loading veterinarians:', error)
    });
  }

  bookAppointment() {
    this.apiService.bookAppointment(this.currentAppointment).subscribe({
      next: () => {
        this.loadAppointments();
        this.cancelBooking();
        alert('Appointment booked successfully!');
      },
      error: (error) => {
        console.error('Error booking appointment:', error);
        alert('Failed to book appointment. Please try again.');
      }
    });
  }

  updateStatus(id: number, status: string) {
    this.apiService.updateAppointmentStatus(id, status).subscribe({
      next: () => {
        this.loadAppointments();
        alert('Appointment status updated successfully!');
      },
      error: (error) => {
        console.error('Error updating appointment status:', error);
        alert('Failed to update appointment status.');
      }
    });
  }

  cancelAppointment(id: number) {
    if (confirm('Are you sure you want to cancel this appointment?')) {
      this.apiService.cancelAppointment(id).subscribe({
        next: () => {
          this.loadAppointments();
          alert('Appointment cancelled successfully!');
        },
        error: (error) => {
          console.error('Error cancelling appointment:', error);
          alert('Failed to cancel appointment.');
        }
      });
    }
  }

  filterAppointments() {
    if (!this.selectedStatus) {
      this.filteredAppointments = this.appointments;
    } else {
      this.filteredAppointments = this.appointments.filter(
        appointment => appointment.status.toLowerCase() === this.selectedStatus.toLowerCase()
      );
    }
  }

  cancelBooking() {
    this.showBookingForm = false;
    this.currentAppointment = this.getEmptyAppointment();
  }

  private getEmptyAppointment(): Appointment {
    return {
      date: new Date(),
      time: '',
      status: 'scheduled',
      notes: '',
      veterinarian: { id: 0, name: '', email: '', phone: '', specialization: '', available: 1, doregistered: new Date() },
      pet: { id: 0, name: '', breed: '', dob: new Date(), pettype: { id: 0, name: '' }, gender: { id: 0, name: '' } }
    };
  }
}
