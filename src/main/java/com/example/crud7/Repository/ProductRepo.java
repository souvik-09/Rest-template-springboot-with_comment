package com.example.crud7.Repository;

import com.example.crud7.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;


// JpaRepository provides a set of generic CRUD operations and other common database operations
public interface ProductRepo extends JpaRepository<Product, Long> {
}
