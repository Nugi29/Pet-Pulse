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

public class Veterinarian {

    private Integer id;

    private String name;

    private String email;

    private String password;

    private String phone;

    private String specialization;

    private Byte available;

    private Date doregistered;

    private Collection<Appointment> appointments;

    private Collection<Medicalrecord> medicalrecords;

}
