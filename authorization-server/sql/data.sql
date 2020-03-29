INSERT INTO auth_server.oauth_client_details (client_id, client_secret, web_server_redirect_uri, scope, access_token_validity, refresh_token_validity, resource_ids, authorized_grant_types, additional_information)
VALUES ('mobile', '{bcrypt}$2a$10$gPhlXZfms0EpNHX0.HHptOhoFD1AoxSr/yUIdTqA8vtjeP4zi0DDu', 'http://localhost:8080/code', 'READ,WRITE', '3600', '10000', 'inventory,payment', 'authorization_code,password,refresh_token,implicit', '{}');

 INSERT INTO auth_server.permission (name)
 VALUES ('create_profile'), ('read_profile'), ('update_profile'), ('delete_profile');

 INSERT INTO auth_server.role (name)
 VALUES ('ROLE_admin'),('ROLE_operator');

 INSERT INTO auth_server.permission_role (permission_id, role_id)
 VALUES
     (1,1), /*create-> admin */
     (2,1), /* read admin */
     (3,1), /* update admin */
     (4,1), /* delete admin */
     (2,2),  /* read operator */
     (3,2);  /* update operator */
INSERT INTO auth_server.user (id, username,password, email, enabled, account_non_expired, credentials_non_expired, account_non_locked)
VALUES ('1', 'krish','{bcrypt}$2a$10$Hy78BrPoCuC3jVgOhj/zVuFNnJM2glwdIsl0G35XfDBGrCF4nKOR6', 'k@krishantha.com', '1', '1', '1', '1'),
('2', 'suranga', '{bcrypt}$2a$10$wQ8vZl3Zm3.zDSIcZEYym.bGq3fPMJXH9k.Vhudcfr6O6KQwDPSt6','k@krishantha.com', '1', '1', '1', '1'),
('3', 'nuwan', '{bcrypt}$2a$10$wQ8vZl3Zm3.zDSIcZEYym.bGq3fPMJXH9k.Vhudcfr6O6KQwDPSt6','k@krishantha.com', '1', '1', '1', '1');

INSERT INTO auth_server.role_user (role_id, user_id)
    VALUES
    (1, 1) /* krish-admin */,
    (2, 2) /* suranga-operatorr */