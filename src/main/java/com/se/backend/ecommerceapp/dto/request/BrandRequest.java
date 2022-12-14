package com.se.backend.ecommerceapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BrandRequest {
    
    @NotNull(message = "Required")
    private String name;
    
    private String description;
    
    @NotNull(message = "Required")
    private String phoneNumber;
    
    private String address;
}
