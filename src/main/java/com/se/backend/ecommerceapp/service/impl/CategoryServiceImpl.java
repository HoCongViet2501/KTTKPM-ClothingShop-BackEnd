package com.se.backend.ecommerceapp.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.se.backend.ecommerceapp.model.entity.Category;
import com.se.backend.ecommerceapp.repository.CategoryRepository;
import com.se.backend.ecommerceapp.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{	

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	@Cacheable(value = "Category")
	public Category save(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.saveAndFlush(category);
	}
	
	@Override
	@Cacheable(value = "Category", key = "#id")
	public Category findCategory(Long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
	@Override
	@Cacheable(value = "Category")
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}
	
	@Override
	@CachePut(value = "Category", key = "#id")
	public Category updateCategory(Category category, Long id) {
		// TODO Auto-generated method stub
		return categoryRepository.saveAndFlush(category);
	}

	@Override
	@CacheEvict(value = "Category", key = "#id")
	public void delete(Category category) {
		// TODO Auto-generated method stub
		categoryRepository.delete(category);
		
	}

	


}
