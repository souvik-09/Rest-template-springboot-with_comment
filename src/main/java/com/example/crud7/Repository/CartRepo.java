package com.example.crud7.Repository;

import com.example.crud7.Models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//JpaRepository provides a set of generic CRUD operations and other common database operations
public interface CartRepo extends JpaRepository<Cart, Long> { //Cart is the entity type and Long is for primary key type
    List<Cart> findByName(String name); //This query method is used search cart by name
}
