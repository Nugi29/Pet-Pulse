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
@ToString(exclude = "owner")
@Entity
@Table(name = "reminder")
public class ReminderEntity {

    // ... other fields are fine ...
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Id @Column(name = "id") private Integer id;
    @Basic @Column(name = "title") private String title;
    @Basic @Column(name = "message") private String message;
    @Basic @Column(name = "reminder_date") private Date reminderDate;
    @Basic @Column(name = "type") private String type;
    @Basic @Column(name = "status") private String status;

    // CORRECTED: Changed from @JsonIgnore to @JsonBackReference for consistency.
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false)
    private OwnerEntity owner;
}