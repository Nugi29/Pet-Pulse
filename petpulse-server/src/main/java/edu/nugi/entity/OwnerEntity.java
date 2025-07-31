package edu.nugi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"pets", "reminder"})
@Entity
@Table(name = "owner")
public class OwnerEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "phone")
    private String phone;

    @JsonManagedReference("owner-pet")
    @OneToMany(mappedBy = "owner")
    private Collection<PetEntity> pets;

    @JsonManagedReference("owner-reminder")
    @OneToMany(mappedBy = "owner")
    private Collection<ReminderEntity> reminder;
}