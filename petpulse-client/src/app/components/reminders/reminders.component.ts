import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../../services/api.service';
import { Reminder, Owner } from '../../models/owner.model';

@Component({
  selector: 'app-reminders',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './reminders.component.html',
  styleUrls: ['./reminders.component.css']
})
export class RemindersComponent implements OnInit {
  reminders: Reminder[] = [];
  filteredReminders: Reminder[] = [];
  urgentReminders: Reminder[] = [];
  owners: Owner[] = [];
  showAddForm = false;
  editingReminder = false;
  selectedStatus = '';
  selectedType = '';
  currentReminder: Reminder = this.getEmptyReminder();

  constructor(private apiService: ApiService) {}

  ngOnInit() {
    this.loadReminders();
    this.loadOwners();
  }

  loadReminders() {
    this.apiService.getAllReminders().subscribe({
      next: (reminders) => {
        this.reminders = reminders;
        this.filterReminders();
        this.loadUrgentReminders();
      },
      error: (error) => console.error('Error loading reminders:', error)
    });
  }

  loadOwners() {
    this.apiService.getAllOwners().subscribe({
      next: (owners) => this.owners = owners,
      error: (error) => console.error('Error loading owners:', error)
    });
  }

  loadUrgentReminders() {
    const now = new Date();
    const threeDaysFromNow = new Date();
    threeDaysFromNow.setDate(now.getDate() + 3);

    this.urgentReminders = this.reminders.filter(reminder => {
      const reminderDate = new Date(reminder.reminderDate);
      return reminder.status === 'pending' && 
             reminderDate >= now && 
             reminderDate <= threeDaysFromNow;
    });
  }

  saveReminder() {
    if (this.editingReminder && this.currentReminder.id) {
      this.apiService.updateReminder(this.currentReminder.id, this.currentReminder).subscribe({
        next: () => {
          this.loadReminders();
          this.cancelForm();
          alert('Reminder updated successfully!');
        },
        error: (error) => {
          console.error('Error updating reminder:', error);
          alert('Failed to update reminder.');
        }
      });
    } else {
      this.currentReminder.status = 'pending';
      this.apiService.createReminder(this.currentReminder).subscribe({
        next: () => {
          this.loadReminders();
          this.cancelForm();
          alert('Reminder created successfully!');
        },
        error: (error) => {
          console.error('Error creating reminder:', error);
          alert('Failed to create reminder.');
        }
      });
    }
  }

  editReminder(reminder: Reminder) {
    this.currentReminder = { ...reminder };
    this.editingReminder = true;
    this.showAddForm = true;
  }

  deleteReminder(id: number) {
    if (confirm('Are you sure you want to delete this reminder?')) {
      this.apiService.deleteReminder(id).subscribe({
        next: () => {
          this.loadReminders();
          alert('Reminder deleted successfully!');
        },
        error: (error) => {
          console.error('Error deleting reminder:', error);
          alert('Failed to delete reminder.');
        }
      });
    }
  }

  markComplete(id: number) {
    const reminder = this.reminders.find(r => r.id === id);
    if (reminder) {
      reminder.status = 'completed';
      this.apiService.updateReminder(id, reminder).subscribe({
        next: () => {
          this.loadReminders();
          alert('Reminder marked as complete!');
        },
        error: (error) => {
          console.error('Error updating reminder:', error);
          alert('Failed to update reminder.');
        }
      });
    }
  }

  filterReminders() {
    this.filteredReminders = this.reminders.filter(reminder => {
      const statusMatch = !this.selectedStatus || reminder.status === this.selectedStatus;
      const typeMatch = !this.selectedType || reminder.type === this.selectedType;
      return statusMatch && typeMatch;
    });
  }

  isOverdue(reminder: Reminder): boolean {
    const now = new Date();
    const reminderDate = new Date(reminder.reminderDate);
    return reminder.status === 'pending' && reminderDate < now;
  }

  cancelForm() {
    this.showAddForm = false;
    this.editingReminder = false;
    this.currentReminder = this.getEmptyReminder();
  }

  private getEmptyReminder(): Reminder {
    return {
      title: '',
      message: '',
      reminderDate: new Date(),
      type: '',
      status: 'pending',
      owner: { id: 0, name: '', email: '', phone: '' }
    };
  }
}
