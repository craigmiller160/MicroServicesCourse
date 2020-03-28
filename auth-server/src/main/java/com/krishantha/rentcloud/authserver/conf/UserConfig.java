package com.krishantha.rentcloud.authserver.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig extends GlobalAuthenticationConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public UserConfig(final PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("krish")
                .password(passwordEncoder.encode("krishpass"))
                .roles("ADMIN", "USER")
                .authorities("CAN_READ", "CAN_WRITE", "CAN_DELETE")
                .and()
                .withUser("krish2")
                .password(passwordEncoder.encode("krishpass"))
                .roles("ADMIN", "USER")
                .authorities("CAN_READ", "CAN_WRITE", "CAN_DELETE");
    }
}
