package com.se.backend.ecommerceapp.service.impl;

import com.se.backend.ecommerceapp.dto.request.ProductRequest;
import com.se.backend.ecommerceapp.dto.response.ProductResponse;
import com.se.backend.ecommerceapp.exceptions.ResourceNotFoundException;
import com.se.backend.ecommerceapp.mapping.MapData;
import com.se.backend.ecommerceapp.model.entity.Product;
import com.se.backend.ecommerceapp.model.enums.Status;
import com.se.backend.ecommerceapp.repository.ProductRepository;
import com.se.backend.ecommerceapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    
    @Override
    @Cacheable(value = "Product")
    public List<ProductResponse> findProductByName(String name) {
        List<Product> products = this.productRepository.findAllByNameContainingIgnoreCase(name);
        return MapData.mapList(products, ProductResponse.class);
    }
    
    @Override
    @Cacheable(value = "Product")
    public List<ProductResponse> getListProduct() {
        List<Product> products = this.productRepository.findAll();
        return MapData.mapList(products, ProductResponse.class);
    }
    
    @Override
    @CachePut(value = "Product")
    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product = MapData.mapOne(productRequest, Product.class);
        product.setCreatedDate(new Date());
        product.setStatus(Status.STOKING);
        Product saveProduct = this.productRepository.save(product);
        return MapData.mapOne(saveProduct, ProductResponse.class);
    }
    
    @Override
    @CachePut(value = "Product", key = "#productId")
    public ProductResponse updateProduct(long productId, ProductRequest productRequest) {
        Product product = this.productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("not found product id"));
        Product productMap = MapData.mapOne(productRequest, Product.class);
        productMap.setId(product.getId());
        productMap.setUpdatedDate(new Date());
        this.productRepository.save(productMap);
        return MapData.mapOne(productMap, ProductResponse.class);
    }
    
    @Override
    @CacheEvict(value = "Product", key = "#productId")
    public void delete(long productId) {
        Product product = this.productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("not found product id"));
        this.productRepository.delete(product);
    }
}
