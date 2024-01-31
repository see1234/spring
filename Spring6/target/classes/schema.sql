create table if not exists task
(
    id          int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name        varchar(1024)   not null,
    description TEXT            not null,
    createdDate TIMESTAMP
);
