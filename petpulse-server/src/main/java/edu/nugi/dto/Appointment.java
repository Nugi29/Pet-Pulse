package edu.nugi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Appointment {

    private Integer id;

    private Date date;

    private Time time;

    private String status;

    private String notes;

    private Timestamp createdAt;


    private Veterinarian veterinarian;


    private Pet pet;
}
