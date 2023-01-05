--liquibase formatted sql

--changeset nvoxland:1
create table person (
    id int primary key,
    name varchar(255)
);