use new_servlet;
insert into role(code,name) values ('ADMIN','Quản Trị') ;
insert into role(code,name) values ('USER','người dùng') ;

insert into user(name , password,fullname ,status,roleid) values ('admin','123456','admin',1,1) ;
insert into user(name , password,fullname ,status,roleid) values ('nguyen van a','123456','NGUYEN VAN A',1,2) ;
insert into user(name , password,fullname ,status,roleid) values ('nguyen van b','123456','NGUYEN VAN B',1,2) ;
