-- 김재림 V 1.0
-- 인서트 쿼리
insert into recommend values('100', '100' '111111', 1, 19410);
insert into recommend values('200','100', '100000', 6, 10);
insert into recommend values('200', '100', '110000', 4, 410);
insert into recommend values('200', '100', '111000', 5, 110);
insert into recommend values('200', '100', '111100', 2, 9410);
insert into recommend values('200', '100', '111110', 3, 1940);

-- 알고리즘 로직
select a.brand_id brand_id, b.brand_name brand_name, b.brand_desc brand_desc, a.view_count view_count 
	from (select brand_id, view_count 
		from recommend 
		where body_id = ?) a, brands b
	where a.brand_id = b.brand_id
	order by view_count asc;