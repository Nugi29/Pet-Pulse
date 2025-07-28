package edu.nugi.dto;

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

public class Pet {

    private Integer id;

    private String name;

    private String breed;

    private Date dob;

    private Collection<Appointment> appointments;

    private Collection<Medicalrecord> medicalrecords;

    private Pettype pettype;

    private Gender gender;

    private Owner owner;

}
