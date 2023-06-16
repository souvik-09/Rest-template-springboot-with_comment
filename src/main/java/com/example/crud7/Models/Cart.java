package com.example.crud7.Models;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data   //@Data annotation is from Lombok library,
// and it automatically generates standard methods such as getters, setters
@Entity //Indicating that it will be mapped to a database table.

public class Cart {
    @Id // It indicates that the productId field is the primary key for the entity.
    @GeneratedValue(strategy = GenerationType.AUTO) //This annotation typically means that the database will handle the generation
    private Long Id;
    private String name;
    private String email;

    @ManyToMany(targetEntity = Product.class) //This indicates a many-to-many relationship
    // between Cart table and Product table

    @JoinColumn // It is used to specify the join column for the relationship between Cart and Product
    private List<Product> products; //products variable is like a container or a list where you can store multiple Product objects.
}
