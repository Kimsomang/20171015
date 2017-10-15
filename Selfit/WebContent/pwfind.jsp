<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selfit : 비밀번호 찾기</title>

<!-- 외부 공통 css 연결 -->
<link type="text/css" rel="stylesheet" href="css/signin.css">
<link type="text/css" rel="stylesheet" href="css/login.css">
 
<!-- javascript 내부 -->
<script type="text/javascript" src="js/members.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>

</head>
<body>
<h2>비밀번호 찾기</h2>
<hr width="650px" align="left">
<form action="control" method="post" name="pwfindForm">
	<div>
		<div class="pwfind_frame">
			<input class="tb_signin_s" type="text" id="memberId" name="memberId" 
					value="아 이 디" onfocus="pwfind_id()" onblur="pwfind_id2(this.value)">
			<font style="font-size: x-large;">@</font>
			<input class="tb_signin_s" type="text" id="memberId2" name="memberId2" 
					value="이메일 주소" onfocus="pwfind_email()" onblur="pwfind_email2()">
			<br>
			<font class="detail">[아이디는 영문소문자/숫자, 7~15자리 입력]</font>
		</div>
			<span class="msg_s" id="idCheck"> </span>
		<div class="pwfind">
			<input class="tb_signin_xs" type="text" id="memberBirth1" name="memberBirth1" 
					value="'YYYY'" onfocus="pwfind_birth_year()" onblur="pwfind_birth_year2()"
					onkeyup="pwfind_birth_year3()">
			<font style="font-size: x-large;">-</font>
			<input class="tb_signin_xxs" type="text" id="memberBirth2" name="memberBirth2" 
					value="'MM'" onfocus="pwfind_birth_mth()" onblur="pwfind_birth_mth2()"
					onkeyup="pwfind_birth_mth3()">
			<font style="font-size: x-large;">-</font>
			<input class="tb_signin_xxs" type="text" id="memberBirth3" name="memberBirth3" 
					value="'DD'" onfocus="pwfind_birth_date()" onkeyup="pwfind_birth_date2()"
					onblur="pwfind_birth_date3()" maxlength="2">
			<br>
			<font class="detail">[생년월일은 'YYYY-MM-DD'의 형식으로 입력하세요.]</font>
		</div>
			<span class="msg_s" id="birthCheck"></span>
		<div class="pwfind">
			<input class="tb_signin_xxs" type="text" id="memberPhone1" name="memberPhone1" 
					value="01X" onfocus="pwfind_phone_fst()" onblur="pwfind_phone_fst2()"
					onkeyup="pwfind_phone_fst3()">
			<font style="font-size: x-large;">-</font>
			<input class="tb_signin_xs" type="text" id="memberPhone2" name="memberPhone2" 
					value="XXXX" onfocus="pwfind_phone_mid()" onblur="pwfind_phone_mid2()"
					onkeyup="pwfind_phone_mid3()">
			<font style="font-size: x-large;">-</font>
			<input class="tb_signin_xs" type="text" id="memberPhone3" name="memberPhone3" 
					value="XXXX" onfocus="pwfind_phone_end()" onblur="pwfind_phone_end2()"
					onkeyup="pwfind_phone_end3()" maxlength="4">
		</div>	
			<span class="msg_s" id="phoneCheck"></span>
		<hr class="pwfind_1" align="left">
				<span class="msg_m">${requestScope.pwfindMsg }</span>
				<br>
				<span class="msg_m" style="font-weight: bold;">${requestScope.pwfindMsg2 }</span>
		<hr class="pwfind_2" align="left">
		<div class="pwfind">
			<input class="bt_footer2" type="submit" value="비밀번호 조회" onclick="return searchPw()">	
			<input type="hidden" name="action" value="pwfind">	
			<input class="bt_footer" type="button" value="회원가입" onclick="goSignin()">		
			<input class="bt_footer" type="button" value="로그인" onclick="goback()">		
			<input class="bt_footer2" type="button" value="아이디 찾기" onclick="goIdfind()">
		</div>
	</div>
</form>
</body>
</html>