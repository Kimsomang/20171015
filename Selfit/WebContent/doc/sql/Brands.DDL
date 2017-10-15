-- 2017_0929 김재림 v 1.0
-- BRAND 테이블 생성
CREATE TABLE BRANDS(	
	BRAND_ID VARCHAR2(6) NOT NULL,
	BRAND_NAME VARCHAR2(30) NOT NULL,
	BRAND_DESC VARCHAR2(300)
);

-- 제약조건 추가
alter table brands add constraint PK_BRANDS_BRAND_ID primary key(brand_id);