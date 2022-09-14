package com.se.backend.ecommerceapp.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.backend.ecommerceapp.model.entity.Category;
import com.se.backend.ecommerceapp.repository.CategoryRepository;
import com.se.backend.ecommerceapp.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{	

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category save(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.saveAndFlush(category);
	}
	
	@Override
	public Category findCategory(Long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}
	
	@Override
	public Category update(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.saveAndFlush(category);
	}

	@Override
	public void delete(Category category) {
		// TODO Auto-generated method stub
		categoryRepository.delete(category);
		
	}

	


}
