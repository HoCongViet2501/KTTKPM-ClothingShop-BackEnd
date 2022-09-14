package com.se.backend.ecommerceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.se.backend.ecommerceapp.model.entity.Product;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long>{

}