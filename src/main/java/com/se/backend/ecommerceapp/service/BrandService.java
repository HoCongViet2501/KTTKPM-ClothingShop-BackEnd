package com.se.backend.ecommerceapp.service;

import java.util.List;

import com.se.backend.ecommerceapp.model.entity.Brand;

public interface BrandService {
    Brand findBrand(Long id);
    
    List<Brand> findAll();
    
    Brand save(Brand brand);
    
    Brand updateBrand(Brand brand, Long id);
    
    void delete(Long id);
    
}
