--liquibase formatted sql
--changeset karan:1
CREATE SCHEMA IF NOT EXISTS baserent;
--rollback DROP SCHEMA IF EXISTS baserent;

--changeset karan:2
CREATE SEQUENCE IF NOT EXISTS owner_id_sequence
INCREMENT BY 1
MINVALUE 1
MAXVALUE 2147483647
NO CYCLE;
--rollback DROP SEQUENCE IF EXISTS owner_id_sequence;

--changeset karan:3
CREATE TABLE IF NOT EXISTS owner(
    id INTEGER DEFAULT nextval('owner_id_sequence') PRIMARY KEY,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL
);
--rollback DROP TABLE IF EXISTS owner;

--changeset karan:4
ALTER SEQUENCE owner_id_sequence OWNED BY owner.id;
