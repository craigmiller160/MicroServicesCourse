package com.krishantha.rentcloud.configclient.model;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MemberProfileConfiguration {

    private final Environment environment;

    public MemberProfileConfiguration(final Environment environment) {
        this.environment = environment;
    }

    public String getDefaultModel() {
        return environment.getProperty("vehicle.default.model");
    }

    public String getMinRentPeriod() {
        return environment.getProperty("member.rent.min");
    }

}
