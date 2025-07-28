package edu.nugi.dto;

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

    private String password;

    private String phone;

    private Collection<PetEntity> pets;

    private Collection<Reminder> reminder;

}
