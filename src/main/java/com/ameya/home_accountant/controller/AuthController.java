package com.ameya.home_accountant.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ameya.home_accountant.dto.AuthResponse;
import com.ameya.home_accountant.dto.GoogleLoginRequest;
import com.ameya.home_accountant.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping
    public String test() {
        return "Hello World";
    }

    @PostMapping("/google")
    public AuthResponse login(@Valid @RequestBody GoogleLoginRequest googleLoginRequest) {

        return authService.googleLogin(googleLoginRequest);
    }
    
}
