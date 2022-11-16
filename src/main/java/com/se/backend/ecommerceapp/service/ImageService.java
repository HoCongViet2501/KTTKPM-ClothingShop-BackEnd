package com.se.backend.ecommerceapp.service;


import com.se.backend.ecommerceapp.dto.ImageDTO;
import org.apache.maven.InternalErrorException;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    ImageDTO upload(MultipartFile multipartFile, Long productId) throws InternalErrorException;
    
}
