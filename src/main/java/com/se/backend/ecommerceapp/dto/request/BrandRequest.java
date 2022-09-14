package com.se.backend.ecommerceapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BrandRequest {
    
    private String name;
    
    private String description;
    
    private String phoneNumber;
    
    private String address;
}
