package com.ameya.home_accountant.service.impl;

import org.springframework.stereotype.Service;

import com.ameya.home_accountant.config.GoogleProperties;
import com.ameya.home_accountant.dto.AuthResponse;
import com.ameya.home_accountant.dto.GoogleLoginRequest;
import com.ameya.home_accountant.repository.UserRepository;
import com.ameya.home_accountant.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final GoogleProperties googleProperties;

    @Override
    public AuthResponse googleLogin(GoogleLoginRequest googleLoginRequest) {
        
        return null;
    }


}
