package com.krishantha.rentcloud.authorizationserver.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "oauth_approvals")
public class OAuthApprovals {
    private String userId;
    private String clientId;
    private String scope;
    private String status;
    private LocalDateTime expiresAt;
    private LocalDateTime lastModifiedAt;
}
