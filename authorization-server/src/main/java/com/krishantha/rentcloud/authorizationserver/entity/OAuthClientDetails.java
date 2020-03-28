package com.krishantha.rentcloud.authorizationserver.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "oauth_client_details")
public class OAuthClientDetails {
    @Id
    private String clientId;
    private String clientSecret;
    private String webServerRedirectUri;
    private String scope;
    private int accessTokenValidity;
    private int refreshTokenValidity;
    private String resourceIds;
    private String authorizedGrantTypes;
    private String authorities;
    private String additionalInformation;
    private String autoapprove;
}
