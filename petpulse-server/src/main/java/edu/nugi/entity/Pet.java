package edu.nugi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Pet {

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
    private Collection<Appointment> appointments;

    @OneToMany(mappedBy = "pet")
    private Collection<Medicalrecord> medicalrecords;

    @ManyToOne
    @JoinColumn(name = "pettype_id", referencedColumnName = "id", nullable = false)
    private Pettype pettype;

    @ManyToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "id", nullable = false)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false)
    private Owner owner;

}
