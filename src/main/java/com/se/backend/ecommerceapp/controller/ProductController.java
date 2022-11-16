package com.se.backend.ecommerceapp.controller;

import com.se.backend.ecommerceapp.dto.request.ProductRequest;
import com.se.backend.ecommerceapp.dto.response.ProductResponse;
import com.se.backend.ecommerceapp.service.ProductService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CircuitBreaker(name="service-java")
@Retry(name="service-java", fallbackMethod = "fallback")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @GetMapping
    @Operation(summary = "get list product order by id desc")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "get list product success"),
            @ApiResponse(responseCode = "500", description = "internal server error")
    })
    public ResponseEntity<Object> getListProduct() {
        List<ProductResponse> productResponses = this.productService.getListProduct();
        return ResponseEntity.ok().body(productResponses);
    }
    
    @GetMapping("/{name}")
    @Operation(summary = "find product by name")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "get list product by name success"),
            @ApiResponse(responseCode = "500", description = "internal server error")
    })
    public ResponseEntity<Object> findProductByName(@PathVariable String name) {
        List<ProductResponse> productResponses = this.productService.findProductByName(name);
        return ResponseEntity.ok().body(productResponses);
    }
    
    @PostMapping
    @Operation(summary = "add new product")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "add product success"),
            @ApiResponse(responseCode = "500", description = "internal server error")
    })
    public ResponseEntity<Object> addProduct(@Valid @RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = this.productService.addProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }
    
    @PutMapping("/update/{productId}")
    @Operation(summary = "update product")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "update product success"),
            @ApiResponse(responseCode = "500", description = "internal server error"),
            @ApiResponse(responseCode = "404", description = "not found id")
    })
    public ResponseEntity<Object> updateProduct(@Valid @PathVariable long productId, @RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = this.productService.updateProduct(productId, productRequest);
        return ResponseEntity.ok().body(productResponse);
    }
    
    @DeleteMapping("/delete/{productId}")
    @Operation(summary = "delete product by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "deleted product"),
            @ApiResponse(responseCode = "404", description = "not found id")
    })
    @Retry(name="service-java", fallbackMethod = "fallback")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
        this.productService.delete(productId);
        return ResponseEntity.ok().body("deleted");
    }
    
    public ResponseEntity<Object> fallback() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Service is down! Fallback method called");
    }
    
}
