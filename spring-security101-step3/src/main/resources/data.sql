insert into users (username, password, enabled) values ('user', 'dbtime', true);

insert into authorities (username, authority) values ('user', 'ROLE_ADMIN');
insert into authorities (username, authority) values ('user', 'ROLE_USER');