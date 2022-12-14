package com.se.backend.ecommerceapp.controller;

import com.se.backend.ecommerceapp.service.ImageService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.apache.maven.InternalErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/images")
@Slf4j
@CircuitBreaker(name = "service-java")

public class ImageController {
    
    @Autowired
    private ImageService imageService;
    
    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    @Retry(name = "service-java", fallbackMethod = "uploadImageFallback")
    public ResponseEntity<Object> uploadImage(@RequestParam("file") MultipartFile file, @RequestParam Long productId) throws InternalErrorException {
        log.info("upload image:  File Name : {}", file.getOriginalFilename());
        return ResponseEntity.ok().body(imageService.upload(file, productId));
    }
    
    public ResponseEntity<Object> uploadImageFallback() {
        log.error("upload image fallback");
        return ResponseEntity.ok().body("upload image fallback method called");
    }
    
}
