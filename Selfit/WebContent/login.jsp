<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selfit : 로그인</title>

<!-- 외부 공통 css 연결 -->
<link type="text/css" rel="stylesheet" href="css/login.css">
 
<!-- javascript 내부 -->
<script type="text/javascript" src="js/members.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>

</head>
<body>
<h2>로 그 인</h2>
<hr width="520px" align="left">
<form action="control" method="post" name="loginForm">
<div class="frame">
	<div style="float: left;">
		<div class="tb_login">
			<input class="tb_login" type="text" id="loginId" name="loginId" 
					value="아 이 디(이메일 주소)" onfocus="login_id()" onblur="login_id2()">
		</div>
			<span class="msg_s" id="idCheck"></span>
		<div class="tb_login">
			<input class="tb_login" type="text" id="loginPw" name="loginPw" 
					value="비 밀 번 호" onfocus="login_pw()" onblur="login_pw2()">	
		</div>
			<span class="msg_s" id="pwCheck"></span>
	</div>
	<div>
		<input class="bt_login" type="submit" value="로그인" onclick="return checkLogin()">
		<input type="hidden" name="action" value="login">
	</div>
	<div style="clear: both;">
		<span style="margin-left: 10px;">
			<input type="checkbox" value="autoLogin" id="autoLogin" onclick="">로그인 상태 유지
		</span>
		<span style="margin-left: 40px;">
			<a href="signin.jsp">회원가입</a>	
		</span>
		<span>|</span>
		<span>
			<a href="idfind.jsp">아이디 찾기</a>	
		</span>
		<span>|</span>
		<span>
			<a href="pwfind.jsp">비밀번호 찾기</a>		
		</span>
	</div>
	<hr width="520px" align="left">
	<span class="msg_m" style="margin-left: 10px;" id="loginCheck">${requestScope.logMsg }</span>
</div>
</form>
</body>
</html>