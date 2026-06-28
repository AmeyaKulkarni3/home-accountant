package com.ameya.home_accountant.dto.google;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GoogleTokenInfoResponse {

    private String sub;

    private String email;

    private String name;

    private String picture;

    @JsonProperty("email_verified")
    private String emailVerified;

    private String aud;

    private String iss;

    private String exp;
}
