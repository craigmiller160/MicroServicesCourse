package com.krishantha.rentcloud.authserver.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
public class AuthServerConfig implements AuthorizationServerConfigurer {

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthServerConfig(final PasswordEncoder passwordEncoder, final AuthenticationManager authenticationManager) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void configure(final AuthorizationServerSecurityConfigurer config) throws Exception {
        config.checkTokenAccess("permitAll()");
    }

    @Override
    public void configure(final ClientDetailsServiceConfigurer config) throws Exception {
        config.inMemory()
                .withClient("web")
                .secret(passwordEncoder.encode("webpass"))
                .scopes("READ", "WRITE")
                .authorizedGrantTypes("refresh_token", "authorization_code", "password", "client_credentials");
    }

    @Override
    public void configure(final AuthorizationServerEndpointsConfigurer config) throws Exception {
        config.authenticationManager(authenticationManager);
    }

}
