package edu.nugi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.util.Arrays;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Medicalrecord {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "visit_date")
    private Date visitDate;

    @Basic
    @Column(name = "diagnosis")
    private String diagnosis;

    @Basic
    @Column(name = "treatment")
    private String treatment;

    @Basic
    @Column(name = "vaccinations")
    private String vaccinations;

    @Basic
    @Column(name = "file")
    private byte[] file;

    @ManyToOne
    @JoinColumn(name = "pet_id", referencedColumnName = "id", nullable = false)
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "veterinarian_id", referencedColumnName = "id", nullable = false)
    private Veterinarian veterinarian;

}
