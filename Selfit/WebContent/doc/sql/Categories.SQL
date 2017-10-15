-- 2017_1009 김소망 v 2.0
-- 초기데이터 설정
insert into CATEGORIES VALUES('100', 'T셔츠', 'T셔츠입니다');
insert into CATEGORIES VALUES('200', 'Y셔츠', 'Y셔츠입니다');
insert into CATEGORIES VALUES('300', '팬츠', '티셔츠입니다');
insert into CATEGORIES VALUES('400','블라우스','블라우스입니다');
insert into CATEGORIES VALUES('500','스커트','스커트입니다');
insert into CATEGORIES VALUES('600','슬랙스','슬랙스입니다');
insert into CATEGORIES VALUES('700','코트','코트입니다');
insert into CATEGORIES VALUES('800','청자켓','청자켓입니다');

-- 카테고리 전체 조회
select * from categories

-- 카테고리별 정보 조회
-- select * from categories where categories_id = ?
select * from categories where categories_id = '300';

-- 카테고리 수정
-- update categories set categories_name = ?, categories_desc = ? where categories_id = ?
update categories set categories_name = '치마', categories_desc = '치마' where categories_id = '200';

-- 카테고리 삭제
-- delete from categories where categories_id = ?
delete from categories where categories_id = 100;

