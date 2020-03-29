package com.krishantha.rentcloud.configclient.service;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ConfigService {

    private static final String AUTH_SERVER_HOST = "security.oauth2.auth-server-host";
    private static final String TOKEN_INFO_URI = "security.oauth2.resource.token-info-uri";
    private static final String DB_URL = "spring.datasource.url";
    private static final String DEFAULT_SCHEMA = "spring.jpa.properties.hibernate.default_schema";
    private static final String OTHER = "spring.other";

    private final Environment environment;

    public ConfigService(final Environment environment) {
        this.environment = environment;
    }

    public Map<String,Object> getAllConfigs() {
        final Map<String,Object> configs = new HashMap<>();

        System.out.println("CLASS: " + environment.getClass().getName()); // TODO delete this

        final String activeProfiles = String.join(",", environment.getActiveProfiles());
        final String defaultProfiles = String.join(",", environment.getDefaultProfiles());
        configs.put("activeProfiles", activeProfiles);
        configs.put("defaultProfiles", defaultProfiles);
        configs.put(AUTH_SERVER_HOST, environment.getProperty(AUTH_SERVER_HOST));
        configs.put(TOKEN_INFO_URI, environment.getProperty(TOKEN_INFO_URI));
        configs.put(DB_URL, environment.getProperty(DB_URL));
        configs.put(DEFAULT_SCHEMA, environment.getProperty(DEFAULT_SCHEMA));
        configs.put(OTHER, environment.getProperty(OTHER));
        return configs;
    }

}
