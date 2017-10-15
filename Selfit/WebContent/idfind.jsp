<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selfit : 아이디 찾기</title>

<!-- 외부 공통 css 연결 -->
<link type="text/css" rel="stylesheet" href="css/signin.css">
<link type="text/css" rel="stylesheet" href="css/login.css">
 
<!-- javascript 내부 -->
<script type="text/javascript" src="js/members.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>

</head>
<body>
<h2>아이디 찾기</h2>
<hr width="500px" align="left">
<form action="control" method="post" name="idfindForm">
	<div>
		<div class="idfind_frame">
			<input class="tb_signin_s" type="text" id="memberName" name="memberName" 
					value="이  름" onfocus="idfind_name()" onblur="idfind_name2()">
		</div>
			<span class="msg_s" id="nameCheck"> </span>
		<div class="idfind">
			<input class="tb_signin_xs" type="text" id="memberBirth1" name="memberBirth1" 
					value="'YYYY'" onfocus="idfind_birth_year()" onblur="idfind_birth_year2()"
					onkeyup="idfind_birth_year3()">
			<font style="font-size: x-large;">-</font>
			<input class="tb_signin_xxs" type="text" id="memberBirth2" name="memberBirth2" 
					value="'MM'" onfocus="idfind_birth_mth()" onblur="idfind_birth_mth2()"
					onkeyup="idfind_birth_mth3()">
			<font style="font-size: x-large;">-</font>
			<input class="tb_signin_xxs" type="text" id="memberBirth3" name="memberBirth3" 
					value="'DD'" onfocus="idfind_birth_date()" onkeyup="idfind_birth_date2()"
					onblur="idfind_birth_date3()" maxlength="2">
			<br>
			<font class="detail">[생년월일은 'YYYY-MM-DD'의 형식으로 입력하세요.]</font>
		</div>
			<span class="msg_s" id="birthCheck"></span>
		<hr class="idfind_1" align="left">
			<span class="msg_m">${requestScope.idfindMsg }</span>
		<hr class="idfind_2" align="left">
		<div class="idfind">
			<input class="bt_footer2" type="submit" value="아이디 조회" onclick="return searchId()">
			<input type="hidden" name="action" value="idfind">	
			<input class="bt_footer" type="button" value="회원가입" onclick="goSignin()">		
			<input class="bt_footer" type="button" value="로그인" onclick="goback()">	
			<input class="bt_footer2" type="button" value="비밀번호 찾기" onclick="goPwfind()">
		</div>
	</div>
</form>
</body>
</html>