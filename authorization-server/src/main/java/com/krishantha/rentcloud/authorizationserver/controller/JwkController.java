package com.krishantha.rentcloud.authorizationserver.controller;

import com.nimbusds.jose.jwk.JWKSet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//@RestController
//@RequestMapping("/jwk")
public class JwkController {

    private final JWKSet jwkSet;

    public JwkController(final JWKSet jwkSet) {
        this.jwkSet = jwkSet;
    }

//    @GetMapping
    public Map<String, Object> keys() {
        return this.jwkSet.toJSONObject();
    }

}
