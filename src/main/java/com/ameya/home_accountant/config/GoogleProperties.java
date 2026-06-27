package com.ameya.home_accountant.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "google.client")
@Component
@Getter
@Setter
public class GoogleProperties {

    private String id;
    private String secret;
    
}
