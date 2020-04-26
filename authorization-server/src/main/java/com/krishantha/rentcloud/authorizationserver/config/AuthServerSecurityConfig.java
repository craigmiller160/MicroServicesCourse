package com.krishantha.rentcloud.authorizationserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerSecurityConfiguration;

@Configuration
public class AuthServerSecurityConfig extends AuthorizationServerSecurityConfiguration {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .requestMatchers()
                .mvcMatchers("/.well-known/jwks.json")
                .and()
                .authorizeRequests().mvcMatchers("/.well-known/jwks.json").permitAll();
    }

}
