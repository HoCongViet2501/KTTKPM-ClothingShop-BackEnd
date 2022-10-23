package com.se.backend.ecommerceapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    @NotNull(message = "required")
    private String name;
    
    private String description;
    
    @NotNull(message = "required")
    private double price;
    
    private Date createdDate;
    
    private Date updatedDate;
}
