package com.ameya.home_accountant.mapper;

import org.springframework.stereotype.Component;

import com.ameya.home_accountant.dto.response.AuthResponse;

@Component
public class AuthMapper {

    public AuthResponse toAuthResponse(String token) {
        return AuthResponse.builder()
            .token(token)
            .build();
    }
    
}
