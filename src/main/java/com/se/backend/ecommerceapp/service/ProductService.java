package com.se.backend.ecommerceapp.service;

import java.util.List;

import com.se.backend.ecommerceapp.model.entity.Product;

public interface ProductService {
	Product findProduct(Long id);
    List<Product> findAll();
    Product save(Product product);
    Product update(Product product);
    void delete(Product product);

}
