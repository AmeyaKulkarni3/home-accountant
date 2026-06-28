package com.ameya.home_accountant.service.google.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.ameya.home_accountant.config.GoogleProperties;
import com.ameya.home_accountant.dto.google.GoogleTokenInfoResponse;
import com.ameya.home_accountant.dto.google.GoogleUser;
import com.ameya.home_accountant.exception.InvalidGoogleTokenException;
import com.ameya.home_accountant.mapper.GoogleMapper;
import com.ameya.home_accountant.service.google.GoogleTokenVerifierService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GoogleTokenVarifierServiceImpl implements GoogleTokenVerifierService {

    private final RestClient restClient;
    private final GoogleMapper googleMapper;
    private final GoogleProperties googleProperties;

    @Override
    public GoogleUser verifyToken(String token) {
        GoogleTokenInfoResponse response = getTokenInfo(token);
        validateAudience(response);
        validateEmail(response);
        return googleMapper.toGoogleUser(response);
            
    }

    private GoogleTokenInfoResponse getTokenInfo(String token){
        try {
            return 
                restClient.get()
                    .uri(uriBuilder -> 
                            uriBuilder
                                .scheme("https")
                                .host("oauth2.googleapis.com")
                                .path("/tokeninfo")
                                .queryParam("id_token", token)
                                .build())
                    .retrieve()
                    .body(GoogleTokenInfoResponse.class);
        } catch (Exception e) {
            throw new InvalidGoogleTokenException("Invalid Token received");
        }
    }

    private void validateAudience(GoogleTokenInfoResponse response){
        if(!response.getAud().equals(googleProperties.getId())){
            throw new InvalidGoogleTokenException("This token was not issued for this application");
        }
    }

    private void validateEmail(GoogleTokenInfoResponse response){
        if(!Boolean.parseBoolean(response.getEmailVerified())){
            throw new InvalidGoogleTokenException("Email not verified");
        }
    }

}