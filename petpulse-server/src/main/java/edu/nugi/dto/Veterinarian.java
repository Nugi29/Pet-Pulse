package edu.nugi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

public class Veterinarian {

    private Integer id;

    private String name;

    private String email;

    @JsonIgnore
    private String password;

    private String phone;

    private String specialization;

    private Byte available;

    private Date doregistered;

    @JsonManagedReference
    private Collection<Appointment> appointments;

    @JsonManagedReference
    private Collection<Medicalrecord> medicalrecords;

}
