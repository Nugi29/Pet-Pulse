package edu.nugi.entity;

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
@ToString
@Entity
@Table(name = "pet")
public class PetEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "breed")
    private String breed;

    @Basic
    @Column(name = "dob")
    private Date dob;

    @OneToMany(mappedBy = "pet")
    private Collection<AppointmentEntity> appointments;

    @OneToMany(mappedBy = "pet")
    private Collection<MedicalrecordEntity> medicalrecords;

    @ManyToOne
    @JoinColumn(name = "pettype_id", referencedColumnName = "id", nullable = false)
    private PettypeEntity pettype;

    @ManyToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "id", nullable = false)
    private GenderEntity gender;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false)
    private OwnerEntity owner;

}
