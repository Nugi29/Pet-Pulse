# 🐾 Pet Pulse

Pet Pulse is a full-stack web application designed to help veterinary clinics manage their operations efficiently. The system provides functionality for managing pets, owners, appointments, medical records, and reminders.

## 🏗️ Architecture

- **Frontend**: Angular 20 with TypeScript
- **Backend**: Spring Boot 3.5.3 with Java 17
- **Database**: MySQL
- **Build Tools**: Maven (Backend), Angular CLI (Frontend)

## ✨ Features

- 🏠 **Dashboard**: Overview of clinic operations
- 🐕 **Pet Management**: Register and manage pet information
- 👤 **Owner Management**: Maintain owner details and contact information
- 📅 **Appointment Scheduling**: Book and manage veterinary appointments
- 🏥 **Medical Records**: Track pet health history and treatments
- ⏰ **Reminders**: Set up notifications for follow-ups and vaccinations
- 🩺 **Veterinarian Management**: Manage veterinary staff information

## 🛠️ Tech Stack

### Frontend
- Angular 20.1.0
- TypeScript
- RxJS
- Angular Router
- CSS3

### Backend
- Spring Boot 3.5.3
- Java 17
- Spring Data JPA
- Hibernate
- Maven

### Database
- MySQL

## 📁 Project Structure

```
Pet-Pulse/
├── petpulse-client/          # Angular frontend
│   ├── src/
│   │   ├── app/
│   │   │   ├── components/   # Angular components
│   │   │   ├── models/       # TypeScript models
│   │   │   └── services/     # Angular services
│   │   └── ...
│   └── ...
├── petpulse-server/          # Spring Boot backend
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── edu/nugi/
│   │       │       ├── controller/  # REST controllers
│   │       │       ├── entity/      # JPA entities
│   │       │       ├── repository/  # Data repositories
│   │       │       ├── service/     # Business logic
│   │       │       └── dto/         # Data transfer objects
│   │       └── resources/
│   └── pom.xml
└── EER.png                   # Entity Relationship Diagram
```

## 🚀 Getting Started

### Prerequisites

- **Java 17** or higher
- **Node.js 18** or higher
- **npm** or **yarn**
- **MySQL 8.0** or higher
- **Maven 3.6** or higher

### Database Setup

1. Install MySQL and create a database:
```sql
CREATE DATABASE petpulse;
```

2. Update database credentials in `petpulse-server/src/main/resources/application.yml`:
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/petpulse
    username: your_username
    password: your_password
```

### Backend Setup

1. Navigate to the server directory:
```bash
cd petpulse-server
```

2. Install dependencies and run:
```bash
mvn clean install
mvn spring-boot:run
```

The backend server will start on `http://localhost:8080`

### Frontend Setup

1. Navigate to the client directory:
```bash
cd petpulse-client
```

2. Install dependencies:
```bash
npm install
```

3. Start the development server:
```bash
npm start
```

The frontend application will be available at `http://localhost:4200`


## 📊 Database Schema

The application uses the following main entities:
- **Pets**: Pet information and details
- **Owners**: Pet owner contact information
- **Appointments**: Scheduled veterinary visits
- **Medical Records**: Health history and treatments
- **Reminders**: Scheduled notifications
- **Veterinarians**: Staff information

## License

This project is open source, educational purpose you can get and edit anything.

## Author

⭐️ From [Nugi29](https://github.com/Nugi29)

