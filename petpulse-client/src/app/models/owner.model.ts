export interface Owner {
  id?: number;
  name: string;
  email: string;
  password?: string;
  phone: string;
  pets?: Pet[];
  reminders?: Reminder[];
}

export interface Pet {
  id?: number;
  name: string;
  breed: string;
  dob: Date;
  pettype: PetType;
  gender: Gender;
  owner?: Owner;
  appointments?: Appointment[];
  medicalrecords?: MedicalRecord[];
}

export interface PetType {
  id: number;
  name: string;
}

export interface Gender {
  id: number;
  name: string;
}

export interface Veterinarian {
  id?: number;
  name: string;
  email: string;
  password?: string;
  phone: string;
  specialization: string;
  available: number;
  doregistered: Date;
  appointments?: Appointment[];
  medicalrecords?: MedicalRecord[];
}

export interface Appointment {
  id?: number;
  date: Date;
  time: string;
  status: string;
  notes: string;
  createdAt?: Date;
  veterinarian: Veterinarian;
  pet: Pet;
}

export interface MedicalRecord {
  id?: number;
  visitDate: Date;
  diagnosis: string;
  treatment: string;
  vaccinations: string;
  file?: any;
  pet: Pet;
  veterinarian: Veterinarian;
}

export interface Reminder {
  id?: number;
  title: string;
  message: string;
  reminderDate: Date;
  type: string;
  status: string;
  owner: Owner;
}