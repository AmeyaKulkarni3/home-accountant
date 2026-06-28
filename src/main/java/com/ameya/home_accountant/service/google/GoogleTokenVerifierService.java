package com.ameya.home_accountant.service.google;

import com.ameya.home_accountant.dto.google.GoogleUser;

public interface GoogleTokenVerifierService {

    GoogleUser verifyToken(String token);
    
}
