package edu.nugi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "reminder")
public class ReminderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String message;

    @Column(name = "reminder_date")
    private Date reminderDate;

    private String type;
    private String status;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private OwnerEntity owner;

}
