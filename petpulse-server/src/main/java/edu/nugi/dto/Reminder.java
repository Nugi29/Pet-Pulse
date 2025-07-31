package edu.nugi.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Reminder {

    private Integer id;

    private String title;

    private String message;

    private Date reminderDate;

    private String type;

    private String status;

    @JsonIgnore
    private Owner owner;

}
