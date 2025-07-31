import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../../services/api.service';
import { MedicalRecord, Pet, Veterinarian } from '../../models/owner.model';

@Component({
  selector: 'app-medical-records',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './medical-records.component.html',
  styleUrls: ['./medical-records.component.css']
})
export class MedicalRecordsComponent implements OnInit {
  medicalRecords: MedicalRecord[] = [];
  filteredRecords: MedicalRecord[] = [];
  pets: Pet[] = [];
  veterinarians: Veterinarian[] = [];
  showAddForm = false;
  editingRecord = false;
  selectedPetId = '';
  selectedVetId = '';
  currentRecord: MedicalRecord = this.getEmptyRecord();

  constructor(private apiService: ApiService) {}

  ngOnInit() {
    this.loadMedicalRecords();
    this.loadPets();
    this.loadVeterinarians();
  }

  loadMedicalRecords() {
    this.apiService.getAllMedicalRecords().subscribe({
      next: (records) => {
        this.medicalRecords = records;
        this.filterRecords();
      },
      error: (error) => console.error('Error loading medical records:', error)
    });
  }

  loadPets() {
    this.apiService.getAllPets().subscribe({
      next: (pets) => this.pets = pets,
      error: (error) => console.error('Error loading pets:', error)
    });
  }

  loadVeterinarians() {
    this.apiService.getAllVeterinarians().subscribe({
      next: (vets) => this.veterinarians = vets,
      error: (error) => console.error('Error loading veterinarians:', error)
    });
  }

  saveRecord() {
    if (this.editingRecord && this.currentRecord.id) {
      this.apiService.updateMedicalRecord(this.currentRecord.id, this.currentRecord).subscribe({
        next: () => {
          this.loadMedicalRecords();
          this.cancelForm();
          alert('Medical record updated successfully!');
        },
        error: (error) => {
          console.error('Error updating medical record:', error);
          alert('Failed to update medical record.');
        }
      });
    } else {
      this.apiService.createMedicalRecord(this.currentRecord).subscribe({
        next: () => {
          this.loadMedicalRecords();
          this.cancelForm();
          alert('Medical record added successfully!');
        },
        error: (error) => {
          console.error('Error creating medical record:', error);
          alert('Failed to add medical record.');
        }
      });
    }
  }

  editRecord(record: MedicalRecord) {
    this.currentRecord = { ...record };
    this.editingRecord = true;
    this.showAddForm = true;
  }

  deleteRecord(id: number) {
    if (confirm('Are you sure you want to delete this medical record?')) {
      this.apiService.deleteMedicalRecord(id).subscribe({
        next: () => {
          this.loadMedicalRecords();
          alert('Medical record deleted successfully!');
        },
        error: (error) => {
          console.error('Error deleting medical record:', error);
          alert('Failed to delete medical record.');
        }
      });
    }
  }

  filterRecords() {
    this.filteredRecords = this.medicalRecords.filter(record => {
      const petMatch = !this.selectedPetId || record.pet?.id?.toString() === this.selectedPetId;
      const vetMatch = !this.selectedVetId || record.veterinarian?.id?.toString() === this.selectedVetId;
      return petMatch && vetMatch;
    });
  }

  cancelForm() {
    this.showAddForm = false;
    this.editingRecord = false;
    this.currentRecord = this.getEmptyRecord();
  }

  private getEmptyRecord(): MedicalRecord {
    return {
      visitDate: new Date(),
      diagnosis: '',
      treatment: '',
      vaccinations: '',
      pet: { id: 0, name: '', breed: '', dob: new Date(), pettype: { id: 0, name: '' }, gender: { id: 0, name: '' } },
      veterinarian: { id: 0, name: '', email: '', phone: '', specialization: '', available: 1, doregistered: new Date() }
    };
  }
}
