package com.krishantha.rentcloud.configclient.controller;

import com.krishantha.rentcloud.configclient.model.MemberProfileConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    private final MemberProfileConfiguration memConfig;

    public ProfileController(final MemberProfileConfiguration memConfig) {
        this.memConfig = memConfig;
    }

    @GetMapping("/memconfig")
    public MemberProfileConfiguration getMemConfig() {
        return this.memConfig;
    }

}
