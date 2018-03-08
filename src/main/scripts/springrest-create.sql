create table hibernate_sequence (
    next_val    bigint
);

insert into hibernate_sequence values ( 100 );

create table users (
    id          bigint primary key,
    username    varchar(255) not null unique,
    password    varchar(255) not null,
    enabled     boolean not null default true
);

insert into users (id, username, password) values (1, 'admin', '1234');
insert into users (id, username, password) values (2, 'cysun', 'abcd');

create table roles (
    id      bigint primary key,
    name    varchar(255) not null unique
);

insert into roles values (1, 'ADMIN');

create table authorities (
    user_id bigint not null references users(id),
    role_id bigint not null references roles(id),
  primary key (user_id, role_id)
);

insert into authorities (user_id, role_id) value (1, 1);
