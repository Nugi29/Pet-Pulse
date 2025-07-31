import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../../services/api.service';
import { Owner } from '../../models/owner.model';

@Component({
  selector: 'app-owners',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './owners.component.html',
  styleUrls: ['./owners.component.css']
})
export class OwnersComponent implements OnInit {
  owners: Owner[] = [];
  showAddForm = false;
  editingOwner = false;
  currentOwner: Owner = this.getEmptyOwner();

  constructor(private apiService: ApiService) {}

  ngOnInit() {
    this.loadOwners();
  }

  loadOwners() {
    this.apiService.getAllOwners().subscribe({
      next: (owners) => this.owners = owners,
      error: (error) => console.error('Error loading owners:', error)
    });
  }

  saveOwner() {
    if (this.editingOwner && this.currentOwner.id) {
      // If backend supports update owner, add this functionality
      console.log('Update owner functionality not implemented in API service');
      alert('Update functionality not available. Please implement updateOwner in API service.');
    } else {
      this.apiService.createOwner(this.currentOwner).subscribe({
        next: () => {
          this.loadOwners();
          this.cancelForm();
          alert('Owner added successfully!');
        },
        error: (error) => {
          console.error('Error creating owner:', error);
          alert('Failed to add owner. Please try again.');
        }
      });
    }
  }

  editOwner(owner: Owner) {
    this.currentOwner = { ...owner };
    this.editingOwner = true;
    this.showAddForm = true;
  }

  deleteOwner(id: number) {
    if (confirm('Are you sure you want to delete this owner? This will also affect their pets and appointments.')) {
      // If backend supports delete owner, add this functionality
      console.log('Delete owner functionality not implemented in API service');
      alert('Delete functionality not available. Please implement deleteOwner in API service.');
    }
  }

  cancelForm() {
    this.showAddForm = false;
    this.editingOwner = false;
    this.currentOwner = this.getEmptyOwner();
  }

  private getEmptyOwner(): Owner {
    return {
      name: '',
      email: '',
      phone: ''
    };
  }
}
