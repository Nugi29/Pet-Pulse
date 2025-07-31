package edu.nugi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"appointments", "medicalrecords"})
@Entity
@Table(name = "veterinarian")
public class VeterinarianEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    // ... other fields are fine ...
    @Basic @Column(name = "name") private String name;
    @Basic @Column(name = "email") private String email;
    @Basic @Column(name = "password") private String password;
    @Basic @Column(name = "phone") private String phone;
    @Basic @Column(name = "specialization") private String specialization;
    @Basic @Column(name = "available") private Byte available;
    @Basic @Column(name = "doregistered") private Date doregistered;

    @JsonManagedReference("vet-appointment")
    @OneToMany(mappedBy = "veterinarian")
    private Collection<AppointmentEntity> appointments;

    @JsonIgnore
    @OneToMany(mappedBy = "veterinarian")
    private Collection<MedicalrecordEntity> medicalrecords;
}