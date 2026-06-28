package com.ameya.home_accountant.service.impl;

import org.springframework.stereotype.Service;

import com.ameya.home_accountant.config.GoogleProperties;
import com.ameya.home_accountant.dto.google.GoogleUser;
import com.ameya.home_accountant.dto.request.GoogleLoginRequest;
import com.ameya.home_accountant.dto.response.AuthResponse;
import com.ameya.home_accountant.entities.User;
import com.ameya.home_accountant.mapper.UserMapper;
import com.ameya.home_accountant.repository.UserRepository;
import com.ameya.home_accountant.service.AuthService;
import com.ameya.home_accountant.service.google.GoogleTokenVerifierService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final GoogleProperties googleProperties;
    private final UserMapper userMapper;
    private final GoogleTokenVerifierService googleTokenVerifierService;

    @Override
    public AuthResponse googleLogin(GoogleLoginRequest googleLoginRequest) {
        
        GoogleUser googleUser = googleTokenVerifierService.verifyToken(googleLoginRequest.getIdToken());

        User user = getUser(googleUser);

        return userMapper.toAuthResponse(user);

    }

    private User getUser(GoogleUser user){
        return userRepository.findByEmail(user.getEmail())
            .orElseGet(() -> createUser(user));
    }

    private User createUser(GoogleUser googleUser){
        User user = 
            User.builder()
                .email(googleUser.getEmail())
                .name(googleUser.getName())
                .googleId(googleUser.getGoogleId())
                .profilePicture(googleUser.getPicture())
                .build();

        return userRepository.save(user);
    }


}
