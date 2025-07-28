package edu.nugi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "veterinarian")
public class VeterinarianEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private String password;
    private String phone;
    private String specialization;
    private Boolean available;

    @Column(name = "doregistered")
    private Date doregistered;

    @OneToMany(mappedBy = "veterinarian", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<AppointmentEntity> appointments;

    @OneToMany(mappedBy = "veterinarian", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<MedicalrecordEntity> medicalRecords;

}
