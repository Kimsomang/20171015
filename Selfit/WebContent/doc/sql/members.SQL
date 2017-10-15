-- 2017_1009 김소망 v 2.0
--members DML에 해당하는 부분

--//회원 부분
--회원가입 후 DB 삽입(insert)
--insert into members values(?,?,?,?,?,?,?,?,?,?,?,'','','','','');
Insert into MEMBERS values ('testidid@gmail.com','test1234','김보배','1998.09.14','W','010-4194-1156','435-709',' 경기 군포시 광정동  주몽아파트','1013동','700','G',null,'2017.10.09','B','2017.10.09',0);
Insert into MEMBERS values ('test1234@nate.com','testtest','사용자3','1999.01.01','M','010-1111-1111','380-814',' 충북 충주시 동량면 용교리','123123','300','G',null,'2017.10.09','O','2017.10.09',0);
Insert into MEMBERS values ('leewh3611@naver.com','80149076','이원호','1993.12.11','M','010-3611-3608','360-776',' 충북 청주시 상당구 율량동  현대아파트','11동 1001호','100','G',null,'2017.10.06','U',null,0);
Insert into MEMBERS values ('kimbill@hanmail.net','kim1234','김지환','1991.03.04','M','010-2222-2222','140-723',' 서울 용산구 이촌1동  현대아파트','11동 1001호','100','G',null,'2017.10.06','U',null,0);
Insert into MEMBERS values ('xmflrtm2@naver.com','aa54135413','박한울','1993.06.07','M','010-7108-4259','441-763',' 경기 수원시 권선구 서둔동  센트라우스아파트 (101∼117동)','115동 706호','600','G',null,'2017.10.06','U',null,0);
Insert into MEMBERS values ('user001@hanmail.net','password01','사용자1','2000.01.01','W','010-1111-1111','140-774',' 서울 용산구 이촌1동  LG한강자이아파트 (101∼110동)','11동 1001호','200','G',null,'2017.10.06','O','2017.10.09',0);
Insert into MEMBERS values ('manager','rhksflwk123','관리자','2017.10.09','W','010-1234-1234','380-814','충북 충주시 동량면 용교리','313','100','A',null,'2017.10.09','U','2017.10.09',0);
Insert into MEMBERS values ('chanmii@hanmail.net','1231234','김찬미','1992.08.28','W','010-1111-2222','135-280',' 서울 강남구 대치동','930-21','700','G',null,'2017.10.09','U',null,0);
Insert into MEMBERS values ('minjeong@naver.com','qwer1234','이민정','1994.02.04','W','010-1234-4321','445-811',' 경기 화성시 동탄면 금곡리','12345','600','G',null,'2017.10.09','U',null,0);
Insert into MEMBERS values ('ssomang@daum.net','qwerqwer','김소망','1995.01.23','W','010-1234-5678','435-709',' 경기 군포시 광정동  주몽아파트','1013동 510호','200','G',null,'2017.10.09','B','2017.10.09',0);
Insert into MEMBERS values ('testidentity@nate.com','1234qwer','사용자2','1995.01.23','W','010-9876-5432','380-814',' 충북 충주시 동량면 용교리','1234','800','G',null,'2017.10.09','U',null,0);
Insert into MEMBERS values ('somang_k@naver.com','1231234','김소망','1995.01.23','W','010-3330-3084','380-814',' 충북 충주시 동량면 용교리','313-7','100','G',null,'2017.10.06','U',null,0);

--회원 아이디 존재확인 / 회원 단일객체 조회(select)
select * from members where member_id=?

--회원 정보 수정(update)
update members set member_phone=?, member_post=?, member_address1=?, member_address2=?, member_body=? where member_id=?

--회원 아이디 찾기(select)
select member_id from members where member_name=? and member_birth=?

--회원 비밀번호 찾기(select)
select member_pw from members where member_id=? and member_birth=? and member_phone=?

--회원 비밀번호 변경(update)
update members set member_pw=? where member_id=?

--회원 로그인 시 정보일치 확인 조회 및 세션정보 불러오기(select)
select member_id, member_body, member_grade from members where member_id=? and member_pw=?

--//관리자 부분
--회원 전체조회(select)
select * from members;

--관리자 권한 회원 정보 수정(update)
update members set member_pw=?, member_name=?, member_phone=?, member_post=?, member_address1=?, member_address2=?, member_body=?, member_grade=?, member_brand=?, member_status=? where member_id=?
