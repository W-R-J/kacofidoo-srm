drop table if exists srm_user;
create table srm_user(
id int(19) auto_increment primary key,
name varchar(255) not null unique,
password varchar(60),
nickname varchar(255),
birthday TIMESTAMP,
gender int(1),
company_id int(19),db
company_admin_flag int(1),
system_admin_flag int(1),

status int(1) null default 0,
create_time timestamp,
modify_time timestamp,
creator int(19),
modifier int(19)
) engine=innodb;

drop table if exists srm_company;
create table srm_company()
id int(19) auto_increment primary key,
name varchar(255) not null unique,
description varchar(2000),
website varchar(255),
address varchar(255),
zipcode varchar(6),

status int(1) null default 0,
create_time timestamp,
modify_time timestamp,
creator int(19),
modifier int(19)
)engine=innodb;

