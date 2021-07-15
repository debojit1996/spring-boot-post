DROP TABLE IF EXISTS employee;

create table employee (
    id bigint auto_increment,
    name varchar(100),
    email varchar(100),
    primary key (id)
);

insert into employee (name, email) values
    ('sam curran', 'sam@gmail.com'),
    ('mike hussey', 'mike@gmail.com');


