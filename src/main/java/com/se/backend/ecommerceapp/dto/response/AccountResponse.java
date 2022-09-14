package com.se.backend.ecommerceapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class AccountResponse {
    private Long id;
    
    private String username;
    
    private String password;
    
    private String role;
    
}

