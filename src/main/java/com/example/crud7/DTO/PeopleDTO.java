package com.example.crud7.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //@Data annotation is from Lombok library,
// and it automatically generates standard methods such as getters, setters
@AllArgsConstructor  // It generates a constructor with parameters for all the fields in the class.
@NoArgsConstructor  // It generates a no-argument constructor for the class

public class PeopleDTO {
    private long id;
    private String name;
    private String email;
}
