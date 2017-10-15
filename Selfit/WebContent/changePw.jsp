<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selfit : 비밀번호 변경</title>

<!-- 외부 공통 css 연결 -->
<link type="text/css" rel="stylesheet" href="css/login.css">
<link type="text/css" rel="stylesheet" href="css/signin.css">
 
<!-- javascript 내부 -->
<script type="text/javascript" src="js/members.js"></script>
<script type="text/javascript">
<%
	String isPw = (String)request.getAttribute("memberPw");
%>
	function goChangePw() {
		var isPwMsg = document.getElementById("isPwCheck");
		var change_pw = document.changePwForm.changePw;
		var change_pw_chk = document.changePwForm.changePwChk;
		if(change_pw!=null && change_pw.value.trim().length>0 && change_pw.value!="변경할 비밀번호"){
			isPwMsg.innerText = "";
		}else{			
			isPwMsg.innerText = "비밀번호 필수 입력!";
		}
		
		if(change_pw_chk!=null && change_pw_chk.value.trim().length>0 && change_pw_chk.value!="변경할 비밀번호 확인"){
			isPwMsg.innerText = "";
		}else{			
			isPwMsg.innerText = "비밀번호 필수 입력!";
		}
		
		if(isPwMsg.innerText.length>0){
			return false;
		}
		
		if(document.getElementById("pwCheck").value.length==0 && <%=isPw%>==document.getElementById("changePw").value){
			isPwMsg.innerText = "기존에 사용하던 비밀번호 입니다!";
			
			return false;
		}	
	}
	
	function clearPw() {
		document.changePwForm.changePw.value=null;
		document.changePwForm.changePwChk.value=null;
	}
	
</script>

</head>
<body>
<h2>비밀번호 변경</h2>
<hr width="500px" align="left">
<br>
<form action="control" method="post" name="changePwForm">
	<input class="tb_login" type="text" id="changePw" name="changePw" 
			value="변경할 비밀번호" onfocus="change_pw()" onblur="change_pw2()">
	<br>
	<span class="msg_s" id="pwCheck"></span>
	<br>
	<input class="tb_login" type="text" id="changePwChk" name="changePwChk" 
			value="변경할 비밀번호 확인" onfocus="change_pwChk()" onblur="change_pwChk2()">
	<br>
	<span class="msg_s" id="isPwCheck"></span>
	<br>
	<input class="bt_footer2" type="submit" value="비밀번호 변경" onclick="return goChangePw()">&nbsp;&nbsp;
	<input type="hidden" name="action" value="changePw">
	<input class="bt_footer" type="button" value="초기화" onclick="clearPw()">
</form>
</body>
</html>