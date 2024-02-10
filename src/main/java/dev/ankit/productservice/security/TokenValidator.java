package dev.ankit.productservice.security;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TokenValidator {
    private RestTemplateBuilder restTemplateBuilder;

    public TokenValidator(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public Optional<JwtData> validateToken(String token) {
        // Use rest template to make a call to user service
        return Optional.empty();
    }
}
