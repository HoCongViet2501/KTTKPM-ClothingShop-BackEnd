package com.se.backend.ecommerceapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {
    @NotNull(message = "Required")
    private String name;
    
    private String description;
}
