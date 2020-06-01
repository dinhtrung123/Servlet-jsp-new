use new_servlet;

 CREATE TABLE role(
  id bigint not null primary key auto_increment,
  name varchar(255) not null ,
  code varchar(255) not null,
  createddate timestamp null,            /*sắp xếp tăng dần hoặc giảm dần */
   modifieddate timestamp null,   /* lưu ngày nào  sửa bàu viết */
   createdby varchar(255),  /* người nào tạo bài viết đó */
   modifiedby varchar(255)  /* ten người sửa bài */
);
 CREATE TABLE user(
  id bigint not null primary key auto_increment,
  name varchar(255) not null ,
  password varchar(255) not null,
  fullname varchar(255) not null,
  status int not null,
  roleid bigint not null,
  createddate timestamp null,          
   modifieddate timestamp null,
  createdby varchar(255), 
   modifiedby varchar(255)
);
alter table user add constraint fk_user_role foreign key (roleid) references role(id);
 CREATE TABLE news(
  id bigint not null primary key auto_increment,
  title varchar(255)  null ,
  thumbnail varchar(255) null,  /* ten hinh anh*/
  shortdese text null,  /* mo ta ngan */
  content text null,
  categoryid bigint(255) not null,
  createddate timestamp null,          
  modifieddate timestamp null,
  createdby varchar(255), 
  modifiedby varchar(255)
);
 CREATE TABLE category(
  id bigint not null primary key auto_increment,
  name varchar(255) not null ,
  code varchar(255) not null,
  createddate timestamp null,         
   modifieddate timestamp null,   
   createdby varchar(255), 
   modifiedby varchar(255)  
);
alter table news add constraint fk_news_category foreign key (categoryid) references category(id);
 CREATE TABLE comment(
  id bigint not null primary key auto_increment,
  content text not null ,
  user_id bigint not null,
  news_id bigint not null,
  createddate timestamp null,         
   modifieddate timestamp null,   
   createdby varchar(255), 
   modifiedby varchar(255)  
);
alter table comment add constraint fk_comment_user foreign key (user_id) references user(id);
alter table comment add constraint fk_comment_news foreign key (news_id) references news(id);

