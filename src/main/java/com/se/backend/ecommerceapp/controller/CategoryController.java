package com.se.backend.ecommerceapp.controller;

import java.util.List;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.backend.ecommerceapp.model.entity.Category;
import com.se.backend.ecommerceapp.service.CategoryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/category")
@CircuitBreaker(name = "service-java")
@Retry(name = "service-java")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("{id}")
    public Category findCategory(@PathVariable Long id) {
        return categoryService.findCategory(id);
    }

    @GetMapping
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @PostMapping
    public Category save(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @PutMapping("{id}")
    public Category update(@RequestBody Category category, @PathVariable Long id) {
        return categoryService.updateCategory(category, id);
    }

    @DeleteMapping
    public void delete(@RequestBody Category category) {
        categoryService.delete(category);
    }

}
