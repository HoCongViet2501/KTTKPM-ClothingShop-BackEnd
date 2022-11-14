package com.se.backend.ecommerceapp.controller;

import java.util.List;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.backend.ecommerceapp.model.entity.Brand;
import com.se.backend.ecommerceapp.service.BrandService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/brand")
@CircuitBreaker(name="service-java")
public class BrandController {
	
	@Autowired
    private BrandService brandService;

    @GetMapping("{id}")
    public Brand findBrand(@PathVariable Long id) {
        return brandService.findBrand(id);
    }

    @GetMapping
    public List<Brand> findAll() {
        return brandService.findAll();
    }

    @PostMapping
    public Brand save(@RequestBody Brand brand) {
        return brandService.save(brand);
    }

    @PutMapping
    public Brand update(@RequestBody Brand brand) {
        return brandService.update(brand);
    }

    @DeleteMapping
    public void delete(@RequestBody Brand brand) {
    	brandService.delete(brand);

    }
}