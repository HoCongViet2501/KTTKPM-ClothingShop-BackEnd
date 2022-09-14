package com.se.backend.ecommerceapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BrandResponse {
    private Long id;
    
    private String name;
    
    private String description;
    
    private String phoneNumber;
    
    private String address;
}
