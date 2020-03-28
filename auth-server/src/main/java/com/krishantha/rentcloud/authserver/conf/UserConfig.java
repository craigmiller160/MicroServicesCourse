package com.krishantha.rentcloud.authserver.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;

@Configuration
public class UserConfig extends GlobalAuthenticationConfigurerAdapter {

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("krish")
                .password("krishpass")
                .roles("ADMIN", "USER")
                .authorities("CAN_READ", "CAN_WRITE", "CAN_DELETE")
                .and()
                .withUser("krish2")
                .password("krishpass")
                .roles("ADMIN", "USER")
                .authorities("CAN_READ", "CAN_WRITE", "CAN_DELETE");
    }
}
