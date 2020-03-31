package com.krishantha.rentcloud.profileservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.util.StringUtils;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private final String resourceId;

    public ResourceServerConfig(@Value("${craigmiller160.security.oauth2.resource.resource-id}") final String resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public void configure(final ResourceServerSecurityConfigurer resources) throws Exception {
        if (StringUtils.isEmpty(resourceId)) {
            throw new Exception("Cannot create resource server without resourceId");
        }
        resources.resourceId("profile");
    }
}
