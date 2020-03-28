CREATE SCHEMA auth_server;

CREATE TABLE auth_server.oauth_client_details (
     client_id VARCHAR(255) NOT NULL,
     client_secret VARCHAR(255) NOT NULL,
     web_server_redirect_uri VARCHAR(2048) DEFAULT NULL,
     scope VARCHAR(255) DEFAULT NULL,
     access_token_validity INT DEFAULT NULL,
     refresh_token_validity INT DEFAULT NULL,
     resource_ids VARCHAR(1024) DEFAULT NULL,
     authorized_grant_types VARCHAR(1024) DEFAULT NULL,
     authorities VARCHAR(1024) DEFAULT NULL,
     additional_information VARCHAR(4096) DEFAULT NULL,
     autoapprove VARCHAR(255) DEFAULT NULL,
     PRIMARY KEY (client_id)
);

CREATE TABLE auth_server.permission (
    id BIGSERIAL NOT NULL,
    name VARCHAR(512) DEFAULT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE auth_server.role (
    id BIGSERIAL NOT NULL,
    name VARCHAR(255) DEFAULT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE auth_server.user (
    id BIGSERIAL NOT NULL,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(1024) NOT NULL,
    email VARCHAR(1024) NOT NULL,
    enabled SMALLINT NOT NULL,
    accountNonExpired SMALLINT NOT NULL,
    credentialsNonExpired SMALLINT NOT NULL,
    accountNonLocked SMALLINT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE auth_server.permission_role (
    permission_id BIGINT DEFAULT NULL,
    role_id BIGINT DEFAULT NULL,
    PRIMARY KEY (permission_id, role_id),
    FOREIGN KEY (permission_id) REFERENCES auth_server.permission (id),
    FOREIGN KEY (role_id) REFERENCES auth_server.role (id)
);

CREATE TABLE auth_server.role_user (
    role_id BIGINT DEFAULT NULL,
    user_id BIGINT DEFAULT NULL,
    PRIMARY KEY (role_id, user_id),
    FOREIGN KEY (role_id) REFERENCES auth_server.role (id),
    FOREIGN KEY (user_id) REFERENCES auth_server.user (id)
);

-- token store
CREATE TABLE auth_server.oauth_client_token (
    token_id VARCHAR(256),
    token BYTEA,
    authentication_id VARCHAR(256),
    user_name VARCHAR(256),
    client_id VARCHAR(256),
    PRIMARY KEY (authentication_id)
);

CREATE TABLE auth_server.oauth_access_token (
    token_id VARCHAR(256),
    token BYTEA,
    authentication_id VARCHAR(256),
    user_name VARCHAR(256),
    client_id VARCHAR(256),
    authentication BYTEA,
    refresh_token VARCHAR(256),
    PRIMARY KEY (authentication_id)
);

CREATE TABLE auth_server.oauth_refresh_token (
    token_id VARCHAR(256),
    token BYTEA,
    authentication BYTEA
);

CREATE TABLE auth_server.oauth_code (
    code VARCHAR(256),
    authentication BYTEA
);

CREATE TABLE auth_server.oauth_approvals (
    userId VARCHAR(256),
    clientId VARCHAR(256),
    scope VARCHAR(256),
    status VARCHAR(10),
    expiresAt TIMESTAMP,
    lastModifiedAt TIMESTAMP
);