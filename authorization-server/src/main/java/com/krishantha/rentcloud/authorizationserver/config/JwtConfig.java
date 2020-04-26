package com.krishantha.rentcloud.authorizationserver.config;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.RSAKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;

@Configuration
public class JwtConfig {

    @Bean
    public KeyPair keyPair(@Value("${craigmiller160.security.oauth2.auth-server.kid}") final String kid) {
        final var keystore = new ClassPathResource("keystore.jks");
        final var keyStoreFactory = new KeyStoreKeyFactory(keystore, "password".toCharArray());
        return keyStoreFactory.getKeyPair(kid);
    }

    @Bean
    public JWKSet jwkSet(final KeyPair keyPair) {
        final var builder = new RSAKey.Builder((RSAPublicKey) keyPair.getPublic())
                .keyUse(KeyUse.SIGNATURE)
                .algorithm(JWSAlgorithm.RS256)
                .keyID("oauth-jwt");
        return new JWKSet(builder.build());
    }

}
