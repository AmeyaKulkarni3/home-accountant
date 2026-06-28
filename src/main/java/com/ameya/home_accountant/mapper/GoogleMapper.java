package com.ameya.home_accountant.mapper;

import org.springframework.stereotype.Component;

import com.ameya.home_accountant.dto.google.GoogleTokenInfoResponse;
import com.ameya.home_accountant.dto.google.GoogleUser;

@Component
public class GoogleMapper {
    
    public GoogleUser toGoogleUser(GoogleTokenInfoResponse response) {

        return GoogleUser.builder()
            .googleId(response.getSub())
            .email(response.getEmail())
            .name(response.getName())
            .picture(response.getPicture())
            .emailVerified(Boolean.parseBoolean(response.getEmailVerified()))
            .build();
    }
}
