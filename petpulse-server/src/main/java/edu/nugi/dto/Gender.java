package edu.nugi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Gender {

    private Integer id;

    private String name;

    private Collection<Pet> pets;

}
