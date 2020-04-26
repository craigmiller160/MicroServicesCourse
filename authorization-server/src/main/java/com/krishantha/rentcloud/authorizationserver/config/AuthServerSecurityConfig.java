package com.krishantha.rentcloud.authorizationserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerSecurityConfiguration;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;

@Configuration
public class AuthServerSecurityConfig extends AuthorizationServerSecurityConfiguration {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .requestMatchers()
                .antMatchers("/jwk")
                .and()
                .authorizeRequests()
                .antMatchers("/jwk").permitAll();
        super.configure(http);
    }

}
