package com.krishantha.rentcloud.configclient.controller;

import com.krishantha.rentcloud.configclient.service.ConfigService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/configs")
public class ConfigController {

    private final ConfigService configService;

    public ConfigController(final ConfigService configService) {
        this.configService = configService;
    }

    @GetMapping("/all")
    public Map<String, Object> getAllConfigs() {
        return configService.getAllConfigs();
    }

}
