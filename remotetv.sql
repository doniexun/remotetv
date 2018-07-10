drop database if exists remotetv;
create database remotetv;
use remotetv;
create table tv_list (TV_CODE int(11) not null auto_increment,
						TV_CREATE_TIME char(19) not null,
						TV_APP_LIST varchar(2000),
						primary key(TV_CODE)
					)engine=InnoDB,DEFAULT CHARSET=utf8;
create table mobile_list (MOBILE_CODE int(11) not null auto_increment,
						MOBILE_CREATE_TIME char(19) not null,
						primary key(mobile_code)
					)engine=InnoDB DEFAULT CHARSET=utf8;

create table mobile_log (MOBILE_CODE int(11) not null,
							MOBILE_USE_LOG varchar(50) not null,
							MOBILE_LOG_CREATE_TIME char(19) not null,
							foreign key(MOBILE_CODE) references mobile_list (MOBILE_CODE)
					)engine=InnoDB DEFAULT CHARSET=utf8;