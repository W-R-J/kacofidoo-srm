drop table if exists srm_user;
create table srm_user(
id int(19) auto_increment primary key,
name varchar(255) not null unique,
password varchar(60),
nickname varchar(255),
birthday TIMESTAMP,
gender int(1),
company_id int(19),
company_admin_flag int(1),
system_admin_flag int(1)
) engine=innodb;

