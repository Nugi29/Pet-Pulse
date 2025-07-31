package edu.nugi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"pet", "veterinarian"})
@Entity
@Table(name = "medicalrecord")
public class MedicalrecordEntity {

    // ... other fields are fine ...
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Id @Column(name = "id") private Integer id;
    @Basic @Column(name = "visit_date") private Date visitDate;
    @Basic @Column(name = "diagnosis") private String diagnosis;
    @Basic @Column(name = "treatment") private String treatment;
    @Basic @Column(name = "vaccinations") private String vaccinations;
    @Basic @Column(name = "file") private byte[] file;

    // CORRECTED: This is correct. It's the back-reference to Pet.
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "pet_id", referencedColumnName = "id", nullable = false)
    private PetEntity pet;

    // CORRECTED: Changed from @JsonIgnore to @JsonBackReference for consistency.
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "veterinarian_id", referencedColumnName = "id", nullable = false)
    private VeterinarianEntity veterinarian;
}