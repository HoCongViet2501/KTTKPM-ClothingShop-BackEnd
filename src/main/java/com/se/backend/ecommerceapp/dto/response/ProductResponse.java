package com.se.backend.ecommerceapp.dto.response;

import com.se.backend.ecommerceapp.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Long id;
    
    private String name;
    
    private String description;
    
    private double price;
    
    private Status status;
    
    private Date createdDate;
    
    private Date updatedDate;
}
