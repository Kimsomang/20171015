-- 2017_1009 김소망 v 2.0
-- 브랜드 전체조회
select * from brands;

-- 브랜드 항목조회
select * from where brand_id = '300';

-- 브랜드 이름검색
select * from where brand_name like '%brandId%';

-- 브랜드 수정
-- update brands set brand_name = ?, brand_desc = ? where brand_id = ?
update brands set brand_name = '샤넬', brand_desc = '샤넬' where brand_id = '200'

-- 브랜드 삭제
-- delete from brands where brand_id = ?
delete from brands where brand_id = '300';


--브랜드 생성
insert into brands values ('100000', '나이키', '나이키입니다.');
insert into brands values ('110000', '아디다스', '아디다스입니다.');
insert into brands values ('111000', '베르사체', '베르사체입니다.');
insert into brands values ('111100', '루이비통', '루이비통입니다.');
insert into brands values ('111110', '샤넬', '샤넬입니다.');
insert into brands values ('111111', '퓨마', '퓨마입니다.');
insert into brands values ('200000','에잇세컨즈','에잇세컨즈입니다.');
insert into brands values ('220000','토리버치','토리버치입니다.');
insert into brands values ('222000','구찌','구찌입니다.');

