package com.se.backend.ecommerceapp.controller;

import java.util.List;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@Retry(name="service-java", fallbackMethod = "fallback")
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

    @PutMapping("{id}")
    public Brand update(@PathVariable Long id,@RequestBody Brand brand) {
        return brandService.updateBrand(brand, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
    	brandService.delete(id);
    }
    
    public ResponseEntity<Object> fallback() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fallback method called");
    }
}