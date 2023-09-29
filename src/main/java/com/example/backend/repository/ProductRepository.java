package com.example.backend.repository;

import com.example.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// The ProductRepository interface extends the JpaRepository interface and is used to perform CRUD operations on the Product entity.
public interface ProductRepository extends JpaRepository<Product, Long> {

}
