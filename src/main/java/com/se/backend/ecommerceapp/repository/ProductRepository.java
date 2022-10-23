package com.se.backend.ecommerceapp.repository;

import com.se.backend.ecommerceapp.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByNameContainingIgnoreCase(String name);
    
    List<Product> findAll();
}
