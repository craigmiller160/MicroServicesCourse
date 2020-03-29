package com.krishantha.rentcloud.authorizationserver;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderRunner {

    public static void main(String[] args) {
        final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        final String result = passwordEncoder.encode("npass");
        System.out.println(result);
    }

}
