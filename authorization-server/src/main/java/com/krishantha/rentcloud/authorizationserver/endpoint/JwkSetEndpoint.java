package com.krishantha.rentcloud.authorizationserver.endpoint;

import com.nimbusds.jose.jwk.JWKSet;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Map;

@FrameworkEndpoint
public class JwkSetEndpoint {

    private final JWKSet jwkSet;


    public JwkSetEndpoint(final JWKSet jwkSet) {
        this.jwkSet = jwkSet;
    }

    @GetMapping("/jwk")
    @ResponseBody
    public Map<String,Object> getKey(final Principal principal) { // TODO try removing this argument
        return this.jwkSet.toJSONObject();
    }

}
