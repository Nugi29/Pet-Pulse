package edu.nugi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"veterinarian", "pet"})
@Entity
@Table(name = "appointment")
public class AppointmentEntity {

    // ... other fields are fine ...
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Id @Column(name = "id") private Integer id;
    @Basic @Column(name = "date") private Date date;
    @Basic @Column(name = "time") private Time time;
    @Basic @Column(name = "status") private String status;
    @Basic @Column(name = "notes") private String notes;
    @Basic @Column(name = "created_at") private Timestamp createdAt;

    @JsonBackReference("vet-appointment")
    @ManyToOne
    @JoinColumn(name = "veterinarian_id", referencedColumnName = "id", nullable = false)
    private VeterinarianEntity veterinarian;

    @JsonBackReference("pet-appointment")
    @ManyToOne
    @JoinColumn(name = "pet_id", referencedColumnName = "id", nullable = false)
    private PetEntity pet;
}