-- 2017_0929 김재림 v 1.0
-- CONTACTS 테이블 생성
create table contacts(
	contact_corp varchar(30) not null,
	contact_person varchar(30) not null,
	contact_tel varchar(13) not null,
	contact_email varchar(100) not null,
	contact_date char(10)
);