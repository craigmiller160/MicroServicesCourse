package com.krishantha.rentcloud.authserver.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
public class AuthServerConfig extends WebSecurityConfigurerAdapter implements AuthorizationServerConfigurer {

    @Override
    public void configure(final AuthorizationServerSecurityConfigurer config) throws Exception {

    }

    @Override
    public void configure(final ClientDetailsServiceConfigurer config) throws Exception {
        config.inMemory()
                .withClient("web")
                .secret("webpass")
                .scopes("READ", "WRITE")
                .authorizedGrantTypes("refresh_token", "authorization_code", "password", "client_credentials");
    }

    @Override
    public void configure(final AuthorizationServerEndpointsConfigurer config) throws Exception {

    }

}
