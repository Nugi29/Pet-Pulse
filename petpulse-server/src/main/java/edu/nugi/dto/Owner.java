package edu.nugi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.nugi.entity.PetEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Owner {

    private Integer id;

    private String name;

    private String email;

    @JsonIgnore
    private String password;

    private String phone;

    @JsonManagedReference
    private Collection<PetEntity> pets;

    @JsonManagedReference
    private Collection<Reminder> reminder;

}
