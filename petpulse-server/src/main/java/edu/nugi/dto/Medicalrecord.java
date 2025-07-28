package edu.nugi.dto;

import edu.nugi.entity.PetEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Medicalrecord {

    private Integer id;

    private Date visitDate;

    private String diagnosis;

    private String treatment;

    private String vaccinations;

    private byte[] file;

    private PetEntity pet;

    private Veterinarian veterinarian;

}
