package edu.nugi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "pet")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String breed;
    private Date dob;

    @Lob
    private byte[] photo;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private OwnerEntity owner;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private GenderEntity gender;

    @ManyToOne
    @JoinColumn(name = "pettype_id")
    private PettypeEntity petType;

    @JsonManagedReference
    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<AppointmentEntity> appointments;

    @JsonManagedReference
    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<MedicalrecordEntity> medicalRecords;

}
