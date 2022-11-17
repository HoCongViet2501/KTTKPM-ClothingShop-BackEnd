package com.se.backend.ecommerceapp.service;

import java.util.List;

import com.se.backend.ecommerceapp.model.entity.Category;

public interface CategoryService {

	Category findCategory(Long id);
    List<Category> findAll();
    Category save(Category category);
    Category updateCategory(Category category, Long id);
    void delete(Category category);
}
