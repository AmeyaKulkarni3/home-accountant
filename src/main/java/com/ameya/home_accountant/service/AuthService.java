package com.ameya.home_accountant.service;

import com.ameya.home_accountant.dto.AuthResponse;
import com.ameya.home_accountant.dto.GoogleLoginRequest;

public interface AuthService {
    
    AuthResponse googleLogin(GoogleLoginRequest googleLoginRequest);
}
