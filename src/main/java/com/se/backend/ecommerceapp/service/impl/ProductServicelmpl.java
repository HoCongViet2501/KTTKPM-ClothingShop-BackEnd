package com.se.backend.ecommerceapp.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.backend.ecommerceapp.model.entity.Product;
import com.se.backend.ecommerceapp.repository.ProductRepository;
import com.se.backend.ecommerceapp.service.ProductService;

@Service
public class ProductServicelmpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product findProduct(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return productRepository.saveAndFlush(product);
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return productRepository.saveAndFlush(product);
	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		productRepository.delete(product);
	}

}
