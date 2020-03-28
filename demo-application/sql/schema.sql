-- In database micro_service_course
CREATE SCHEMA demo_application;

CREATE TABLE demo_application.student (
	id SERIAL NOT NULL,
	first_name VARCHAR(255),
	last_name VARCHAR(255),
	PRIMARY KEY (id)
);