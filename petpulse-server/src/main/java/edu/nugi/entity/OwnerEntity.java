package edu.nugi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "owner")
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private String password;
    private String phone;
    private String role;

    @JsonManagedReference
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<PetEntity> pets;

    @JsonManagedReference
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<ReminderEntity> reminders;

}
