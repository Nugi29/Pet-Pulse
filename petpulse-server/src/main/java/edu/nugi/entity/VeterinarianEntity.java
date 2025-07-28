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
@Table(name = "veterinarian")
public class VeterinarianEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "phone")
    private String phone;

    @Basic
    @Column(name = "specialization")
    private String specialization;

    @Basic
    @Column(name = "available")
    private Byte available;

    @Basic
    @Column(name = "doregistered")
    private Date doregistered;

    @OneToMany(mappedBy = "veterinarian")
    private Collection<AppointmentEntity> appointments;

    @OneToMany(mappedBy = "veterinarian")
    private Collection<MedicalrecordEntity> medicalrecords;

}
