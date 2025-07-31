import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../../services/api.service';
import { Pet, PetType, Gender, Owner } from '../../models/owner.model';

@Component({
  selector: 'app-pets',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './pets.component.html',
  styleUrls: ['./pets.component.css']
})

export class PetsComponent implements OnInit {
  pets: Pet[] = [];
  petTypes: PetType[] = [];
  genders: Gender[] = [];
  owners: Owner[] = [];
  showAddForm = false;
  editingPet = false;
  currentPet: Pet = this.getEmptyPet();

  constructor(private apiService: ApiService) {}

  ngOnInit() {
    this.loadPets();
    this.loadPetTypes();
    this.loadGenders();
    this.loadOwners();
  }

  loadPets() {
    this.apiService.getAllPets().subscribe({
      next: (pets) => this.pets = pets,
      error: (error) => console.error('Error loading pets:', error)
    });
  }

  loadPetTypes() {
    this.apiService.getAllPetTypes().subscribe({
      next: (types) => this.petTypes = types,
      error: (error) => console.error('Error loading pet types:', error)
    });
  }

  loadGenders() {
    this.apiService.getAllGenders().subscribe({
      next: (genders) => this.genders = genders,
      error: (error) => console.error('Error loading genders:', error)
    });
  }

  loadOwners() {
    this.apiService.getAllOwners().subscribe({
      next: (owners) => this.owners = owners,
      error: (error) => console.error('Error loading owners:', error)
    });
  }

  savePet() {
    if (this.editingPet && this.currentPet.id) {
      this.apiService.updatePet(this.currentPet.id, this.currentPet).subscribe({
        next: () => {
          this.loadPets();
          this.cancelForm();
        },
        error: (error) => console.error('Error updating pet:', error)
      });
    } else {
      this.apiService.createPet(this.currentPet).subscribe({
        next: () => {
          this.loadPets();
          this.cancelForm();
        },
        error: (error) => console.error('Error creating pet:', error)
      });
    }
  }

  editPet(pet: Pet) {
    this.currentPet = { ...pet };
    this.editingPet = true;
    this.showAddForm = true;
  }

  deletePet(id: number) {
    if (confirm('Are you sure you want to delete this pet?')) {
      this.apiService.deletePet(id).subscribe({
        next: () => this.loadPets(),
        error: (error) => console.error('Error deleting pet:', error)
      });
    }
  }

  cancelForm() {
    this.showAddForm = false;
    this.editingPet = false;
    this.currentPet = this.getEmptyPet();
  }

  private getEmptyPet(): Pet {
    return {
      name: '',
      breed: '',
      dob: new Date(),
      pettype: { id: 0, name: '' },
      gender: { id: 0, name: '' }
    };
  }
}