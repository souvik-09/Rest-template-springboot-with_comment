package com.example.crud7.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data   //@Data annotation is from Lombok library,
// and it automatically generates standard methods such as getters, setters
@Entity //Indicating that it will be mapped to a database table.

public class Product {
    @Id // It indicates that the productId field is the primary key for the entity.
    @GeneratedValue(strategy = GenerationType.AUTO) //This annotation typically means that the database will handle the generation
    private Long productId;
    private String productName;
    private Double price;
    private Integer quantity;
}
