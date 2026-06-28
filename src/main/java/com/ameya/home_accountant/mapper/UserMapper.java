package com.ameya.home_accountant.mapper;

import org.springframework.stereotype.Component;

import com.ameya.home_accountant.dto.response.AuthResponse;
import com.ameya.home_accountant.entities.User;

@Component
public class UserMapper {
    public AuthResponse toAuthResponse(User user) {
        return AuthResponse.builder()
            .userId(user.getId())
            .email(user.getEmail())
            .name(user.getName())
            .build();
    }
}
