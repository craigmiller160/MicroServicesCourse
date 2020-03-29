package com.krishantha.rentcloud.configclient.service;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ConfigService {

    private final Environment environment;

    public ConfigService(final Environment environment) {
        this.environment = environment;
    }

    public Map<String,Object> getAllConfigs() {
        final Map<String,Object> configs = new HashMap<>();
        final String activeProfiles = String.join(",", environment.getActiveProfiles());
        final String defaultProfiles = String.join(",", environment.getDefaultProfiles());
        configs.put("activeProfiles", activeProfiles);
        configs.put("defaultProfiles", defaultProfiles);
        return configs;
    }

}
