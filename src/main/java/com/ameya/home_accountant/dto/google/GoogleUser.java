package com.ameya.home_accountant.dto.google;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoogleUser {

    private String googleId;
    private String email;
    private String name;
    private String picture;
    private boolean emailVerified;
    
}
