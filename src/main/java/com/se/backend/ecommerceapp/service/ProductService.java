package com.se.backend.ecommerceapp.service;

import com.se.backend.ecommerceapp.dto.request.ProductRequest;
import com.se.backend.ecommerceapp.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> findProductByName(String name);
    
    List<ProductResponse> getListProduct();
    
    ProductResponse addProduct(ProductRequest productRequest);
    
    ProductResponse updateProduct(long productId, ProductRequest productRequest);
    
    void delete(long productId);
    
}
