insert into users (username, password, enabled) values ('user', 'dbtime', true);
insert into users (username, password, enabled) values ('admin', 'dbtime', true);

insert into authorities (username, authority) values ('user', 'ROLE_USER');

insert into authorities (username, authority) values ('admin', 'ROLE_ADMIN');
insert into authorities (username, authority) values ('admin', 'ROLE_USER');