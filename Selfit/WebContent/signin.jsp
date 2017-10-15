<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selfit : 회원가입</title>

<!-- 외부 공통 css 연결 -->
<link type="text/css" rel="stylesheet" href="css/signin.css">
<link type="text/css" rel="stylesheet" href="css/login.css">
 
<!-- javascript 내부 -->
<script type="text/javascript" src="js/members.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>

</head>
<body>
<h2>회 원 가 입</h2>
<hr>
<form action="control" method="post" name="signinForm">
	<div id="frame">
		<div>
			<div>
				<input class="tb_signin_s" type="text" id="memberId1" name="memberId1" 
						value="아 이 디" onfocus="signin_id()" onblur="signin_id2(this.value)"
						maxlength="15">
				<font style="font-size: x-large;">@</font>
				<input class="tb_signin_s" type="text" id="memberId2" name="memberId2" 
						value="이메일 주소" onfocus="signin_email()" onblur="signin_email2()">
				<span class="error_msg" id="idCheck"></span>
				<br>
				<font class="detail">[아이디는 영문소문자/숫자, 7~15자리 입력]</font>
			</div>
				<br>
			<div>
				<input class="tb_signin_r" type="text" id="memberPw" name="memberPw" 
						value="비 밀 번 호" onfocus="signin_pw()" onblur="signin_pw2()"
						maxlength="15">
				<span class="error_msg" id="pwCheck"></span>
				<br>
				<font class="detail">[비밀번호는 영문소문자/숫자, 7~15자리 입력]</font>
			</div>
			<div>
				<input class="tb_signin_r" type="text" id="memberPwChk" name="memberPwChk" 
						value="비 밀 번 호 확 인" onfocus="signin_pw_chk()" onblur="signin_pw_chk2()">
			</div>
				<br>
			<div>
				<input class="tb_signin_s" type="text" id="memberName" name="memberName" 
						value="이  름" onfocus="signin_name()" onblur="signin_name2()"
						maxlength="7">
				<span class="error_msg" id="nameCheck"></span>
			</div>	
				<br>
			<div>
				<input class="tb_signin_xs" type="text" id="memberBirth1" name="memberBirth1" 
						value="'YYYY'" onfocus="signin_birth_year()" onblur="signin_birth_year2()"
						onkeyup="signin_birth_year3()">
				<font style="font-size: x-large;">-</font>
				<input class="tb_signin_xxs" type="text" id="memberBirth2" name="memberBirth2" 
						value="'MM'" onfocus="signin_birth_mth()" onblur="signin_birth_mth2()"
						onkeyup="signin_birth_mth3()">
				<font style="font-size: x-large;">-</font>
				<input class="tb_signin_xxs" type="text" id="memberBirth3" name="memberBirth3" 
						value="'DD'" onfocus="signin_birth_date()" onblur="signin_birth_date2()"
						onkeyup="signin_birth_date3()">
				<span class="error_msg" id="birthCheck1"></span>
				<span class="error_msg" id="birthCheck2"></span>
				<span class="error_msg" id="birthCheck3"></span>
				<br>
				<font class="detail">[생년월일은 'YYYY-MM-DD'의 형식으로 입력하세요.]</font>
			</div>
				<br>
			<div>
				<input class="rb_signin" type="radio" name="memberSex" value="M">
				<font style="font-size: 20px; font-weight: bold;">남자</font>&nbsp;&nbsp;
				<input class="rb_signin" type="radio" name="memberSex" value="W">
				<font style="font-size: 20px; font-weight: bold;">여자</font>
			</div>					
				<br>
			<div>
				<input class="tb_signin_xxs" type="text" id="memberPhone1" name="memberPhone1" 
						value="01X" onfocus="signin_phone_fst()" onblur="signin_phone_fst2()"
						onkeyup="signin_phone_fst3()">
				<font style="font-size: x-large;">-</font>
				<input class="tb_signin_xs" type="text" id="memberPhone2" name="memberPhone2" 
						value="XXXX" onfocus="signin_phone_mid()" onblur="signin_phone_mid2()"
						onkeyup="signin_phone_mid3()">
				<font style="font-size: x-large;">-</font>
				<input class="tb_signin_xs" type="text" id="memberPhone3" name="memberPhone3" 
						value="XXXX" onfocus="signin_phone_end()" onblur="signin_phone_end2()"
						onkeyup="signin_phone_end3()">
				<span class="error_msg" id="phoneCheck1"></span>
				<span class="error_msg" id="phoneCheck2"></span>
				<span class="error_msg" id="phoneCheck3"></span>
			</div>	
				<br>
			<div>
				<div style="margin-top: 10px;">
					<input class="tb_signin_xs" type="text" id="memberPost" name="memberPost" 
							value="우편번호" readonly>
					<input class="bt_post" type="button" id="btPost" name="btPost" value="우편번호 찾기" onclick="postService()">
				</div>
				<div style="margin-top: 10px;">
					<input class="tb_signin_l" type="text" id="memberAddress1" name="memberAddress1" 
							value="우편번호 포함된 주소">
				</div>
				<div style="margin-top: 10px;">
					<input class="tb_signin_l" type="text" id="memberAddress2" name="memberAddress2" 
							value="상세주소(직접입력)" onfocus="signin_address_dt()" onblur="signin_address_dt2()">
				</div>
			</div>
				<br>
			<div>
				<input class="rb_signin" type="radio" name="memberBody" value="100">
				<font style="font-size: 20px; font-weight: bold;">허벅지만 굵은</font>&nbsp;
				<input class="rb_signin" type="radio" name="memberBody" value="200">
				<font style="font-size: 20px; font-weight: bold;">하체비만</font>&nbsp;
				<input class="rb_signin" type="radio" name="memberBody" value="300">
				<font style="font-size: 20px; font-weight: bold;">상체비만</font>&nbsp;
				<input class="rb_signin" type="radio" name="memberBody" value="400">
				<font style="font-size: 20px; font-weight: bold;">상체빈약</font>&nbsp;
				<input class="rb_signin" type="radio" name="memberBody" value="500">
				<font style="font-size: 20px; font-weight: bold;">하체빈약</font>&nbsp;<br>
				<input class="rb_signin" type="radio" name="memberBody" value="600">
				<font style="font-size: 20px; font-weight: bold;">전체적으로 빈약</font>&nbsp;
				<input class="rb_signin" type="radio" name="memberBody" value="700">
				<font style="font-size: 20px; font-weight: bold;">전체적으로 비만</font>&nbsp;
				<input class="rb_signin" type="radio" name="memberBody" value="800">
				<font style="font-size: 20px; font-weight: bold;">뱃살이 많은</font>&nbsp;
			</div>	
			<br>
			<span class="msg_l" id="essMsg"></span>
			<br>			
			<span class="msg_l" id="validMsg"></span>
		</div>
		<div>
			<div style="float: right; margin: 30px;">
				<input class="bt_footer" type="submit" value="회원가입" onclick="return essCheck()">
				<input type="hidden" name="action" value="signin">
				<input class="bt_footer" type="button" value="돌아가기" onclick="goback()">
			</div>
		</div>
	</div>
</form>
</body>
</html>