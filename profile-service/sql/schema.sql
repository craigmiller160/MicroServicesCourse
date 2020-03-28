CREATE SCHEMA profile_service;

CREATE TABLE profile_service.customers (
    customer_id BIGSERIAL NOT NULL,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    dl_number VARCHAR(255),
    zip_code VARCHAR(255),
    PRIMARY KEY (customer_id)
);