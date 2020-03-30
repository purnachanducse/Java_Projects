insert into user(username,password,enabled) values('user','user',true);
insert into user(username,password,enabled) values('admin','admin',true);
insert into authority (username,authority) values('user','ROLE_USER');
insert into authority (username,authority) values('admin','ROLE_ADMIN');