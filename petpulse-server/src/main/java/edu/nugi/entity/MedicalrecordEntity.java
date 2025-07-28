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
@ToString
@Entity
@Table(name = "medicalrecord")
public class MedicalrecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "visit_date")
    private Date visitDate;

    private String diagnosis;
    private String treatment;
    private String vaccinations;

    @Lob
    private byte[] file;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private PetEntity pet;

    @ManyToOne
    @JoinColumn(name = "veterinarian_id")
    private VeterinarianEntity veterinarian;
}
