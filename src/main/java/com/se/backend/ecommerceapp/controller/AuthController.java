package com.se.backend.ecommerceapp.controller;

import com.se.backend.ecommerceapp.dto.request.AccountRequest;
import com.se.backend.ecommerceapp.dto.request.LoginRequest;
import com.se.backend.ecommerceapp.dto.response.AccountResponse;
import com.se.backend.ecommerceapp.dto.response.LoginResponse;
import com.se.backend.ecommerceapp.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authenticationService;
    
    
    @Autowired
    public AuthController(AuthService authenticationService) {
        this.authenticationService = authenticationService;
    }
    
    @PostMapping("/login")
    @Operation(summary = "login for user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "login successfully!"),
            @ApiResponse(responseCode = "403", description = "incorrect username or password")
    })
    public ResponseEntity<Object> login(@RequestBody @Valid LoginRequest loginRequest) {
        String password = loginRequest.getPassword();
        LoginResponse loginResponse = this.authenticationService.login(loginRequest.getUsername(), password);
        return ResponseEntity.accepted().body(loginResponse);
    }
    
    @Operation(summary = "register for new user")
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create New User successfully")
    })
    public ResponseEntity<Object> register(@Valid @RequestBody AccountRequest accountRequest) {
        AccountResponse accountResponse = this.authenticationService.register(accountRequest);
        return ResponseEntity.ok().body(accountResponse);
    }
    
    @Operation(summary = "logout for user")
    @PostMapping("/logout")
    public ResponseEntity<String> logoutUser(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        this.authenticationService.logout(httpServletRequest, httpServletResponse);
        return ResponseEntity.ok("Logout.user.successfully!");
    }
}
