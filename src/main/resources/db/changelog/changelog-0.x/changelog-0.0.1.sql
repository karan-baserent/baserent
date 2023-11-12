--liquibase formatted sql
--changeset karan:1
CREATE SCHEMA IF NOT EXISTS baserent;
--rollback DROP SCHEMA IF EXISTS baserent;

--changeset karan:2
CREATE SEQUENCE IF NOT EXISTS baserent.owner_id_sequence
INCREMENT BY 1
MINVALUE 1
MAXVALUE 2147483647
NO CYCLE;
--rollback DROP SEQUENCE IF EXISTS baserent.owner_id_sequence;

--changeset karan:3
CREATE TABLE IF NOT EXISTS baserent.owner(
    id INTEGER DEFAULT nextval('baserent.owner_id_sequence') PRIMARY KEY,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL
);
--rollback DROP TABLE IF EXISTS baserent.owner;

--changeset karan:4
CREATE SEQUENCE IF NOT EXISTS baserent.authentication_roles_id_sequence
INCREMENT BY 1
MINVALUE 1
MAXVALUE 128
NO CYCLE;
--rollback DROP SEQUENCE IF EXISTS baserent.authentication_roles_id_sequence;

--changeset karan:5
CREATE TYPE baserent.roles as ENUM('OWNER', 'RENTER', 'ADMIN');
--rollback DROP TYPE IF EXISTS baserent.roles;

--changeset karan:6
CREATE TABLE IF NOT EXISTS baserent.authentication_roles(
    id INTEGER DEFAULT nextval('baserent.owner_id_sequence') PRIMARY KEY,
    role_name baserent.roles
);
--rollback DROP TABLE IF EXISTS baserent.authentication_roles;