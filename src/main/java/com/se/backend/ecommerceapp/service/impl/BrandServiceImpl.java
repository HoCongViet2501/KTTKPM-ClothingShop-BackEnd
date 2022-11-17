package com.se.backend.ecommerceapp.service.impl;

import java.util.List;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.se.backend.ecommerceapp.model.entity.Brand;
import com.se.backend.ecommerceapp.repository.BrandRepository;
import com.se.backend.ecommerceapp.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
    
    @Autowired
    private BrandRepository brandRepository;
    
    @Override
    @Cacheable(value = "Brand", key = "#id")
    public Brand findBrand(Long id) {
        // TODO Auto-generated method stub
        return brandRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    
    @Override
    @Cacheable(value = "Brand")
    public List<Brand> findAll() {
        // TODO Auto-generated method stub
        return brandRepository.findAll();
    }
    
    @Override
    @Cacheable(value = "Brand")
    public Brand save(Brand brand) {
        // TODO Auto-generated method stub
        return brandRepository.saveAndFlush(brand);
    }
    
    @Override
    @Cacheable(value = "Brand", key = "#id")
    public Brand updateBrand(Brand brand, Long id) {
        // TODO Auto-generated method stub
        return brandRepository.saveAndFlush(brand);
    }
    
    @Override
    @CacheEvict(value = "Brand", key = "#id")
    public void delete(Long id) {
        // TODO Auto-generated method stub
        brandRepository.delete(this.brandRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }
    
    
}
