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
--rollback DROP SEQUENCE IF EXISTS owner_id_sequence;

--changeset karan:3
CREATE TABLE IF NOT EXISTS baserent.owner(
    id INTEGER DEFAULT nextval('baserent.owner_id_sequence') PRIMARY KEY,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL
);
--rollback DROP TABLE IF EXISTS owner;
