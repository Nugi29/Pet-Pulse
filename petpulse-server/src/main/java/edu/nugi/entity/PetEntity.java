package edu.nugi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@ToString(exclude = {"owner", "appointments", "medicalrecords"})
@Entity
@Table(name = "pet")
public class PetEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    // ... other fields like name, breed, dob are fine ...
    @Basic @Column(name = "name") private String name;
    @Basic @Column(name = "breed") private String breed;
    @Basic @Column(name = "dob") private Date dob;

    @ManyToOne
    @JoinColumn(name = "pettype_id", referencedColumnName = "id", nullable = false)
    private PettypeEntity pettype;

    @ManyToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "id", nullable = false)
    private GenderEntity gender;

    @JsonBackReference("owner-pet")
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false)
    private OwnerEntity owner;

    @JsonManagedReference("pet-appointment")
    @OneToMany(mappedBy = "pet")
    private Collection<AppointmentEntity> appointments;

    @JsonManagedReference("pet-medicalrecord")
    @OneToMany(mappedBy = "pet")
    private Collection<MedicalrecordEntity> medicalrecords;
}