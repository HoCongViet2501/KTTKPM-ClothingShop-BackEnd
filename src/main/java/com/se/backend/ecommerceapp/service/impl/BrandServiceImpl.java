package com.se.backend.ecommerceapp.service.impl;

import java.util.List;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.backend.ecommerceapp.model.entity.Brand;
import com.se.backend.ecommerceapp.repository.BrandRepository;
import com.se.backend.ecommerceapp.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandRepository brandRepository;

	@Override
	public Brand findBrand(Long id) {
		// TODO Auto-generated method stub
		return brandRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<Brand> findAll() {
		// TODO Auto-generated method stub
		return brandRepository.findAll();
	}

	@Override
	public Brand save(Brand brand) {
		// TODO Auto-generated method stub
		return brandRepository.saveAndFlush(brand);
	}

	@Override
	public Brand update(Brand brand) {
		// TODO Auto-generated method stub
		return brandRepository.saveAndFlush(brand);
	}

	@Override
	public void delete(Brand brand) {
		// TODO Auto-generated method stub
		brandRepository.delete(brand);
	}

	
	
}
