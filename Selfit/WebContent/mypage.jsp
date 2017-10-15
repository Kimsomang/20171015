<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="com.selfit.model.DTO.Members"%>

<%
	Members member = (Members)request.getAttribute("member");

	String memberId = member.getMemberId();
	String [] memberIds = memberId.split("\\@");
	String memberName = member.getMemberName();
	String memberBirth = member.getMemberBirth();
	String [] memberBirths = memberBirth.split("\\.");
	String memberSex = member.getMemberSex();
	if(memberSex.equals("M")) {
		memberSex = "남자";
	}else {
		memberSex = "여자";		
	}
	String memberPhone = member.getMemberPhone();
	String [] memberPhones = memberPhone.split("\\-");
	String memberPost = member.getMemberPost();
	String memberAddress1 = member.getMemberAddress1();
	String memberAddress2 = member.getMemberAddress2();
	String memberBody = member.getMemberBody();

%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selfit : 내정보 보기</title>

<!-- 외부 공통 css 연결 -->
<link type="text/css" rel="stylesheet" href="css/signin.css">
 
<!-- javascript 내부 -->
<script type="text/javascript">
	window.onload = function() {
		document.mypageForm.memberBody.value="<%=memberBody%>";
	}
	
	function mypage_birth_year(){
		var mypage_year = document.mypageForm.memberBirth1;
		var init_year = "<%=memberBirths[0]%>";
		
		if(mypage_year.value==init_year) {
			mypage_year.value="";		
			document.getElementById("memberBirth1").style.color="black";
		}
	}
	
	function mypage_birth_year2(){
		var mypage_year = document.mypageForm.memberBirth1;
		var init_year = "<%=memberBirths[0]%>";
		if(mypage_year.value.trim().length==0) {
			document.getElementById("memberBirth1").style.color="#E3E3E3";
			mypage_year.value = init_year;			
		}			
	}

	function mypage_birth_year3(){
		var mypage_year = document.mypageForm.memberBirth1;	
		if( isNaN(mypage_year.value) ) {
			alert("숫자만 입력가능합니다!")
			mypage_year.value="";
		}
		
		if(mypage_year.value.trim().length==4) {
			document.mypageForm.memberBirth2.focus();
		}
	}
	
	function mypage_birth_mth(){
		var mypage_mth = document.mypageForm.memberBirth2;
		var init_mth = "<%=memberBirths[1]%>";
		
		if(mypage_mth.value==init_mth) {
			mypage_mth.value="";		
			document.getElementById("memberBirth2").style.color="black";
		}
	}
	
	function mypage_birth_mth2(){
		var mypage_mth = document.mypageForm.memberBirth2;
		var init_mth = "<%=memberBirths[1]%>";
		if(mypage_mth.value.trim().length==0) {
			document.getElementById("memberBirth2").style.color="#E3E3E3";
			mypage_mth.value = init_mth;			
		}			
	}

	function mypage_birth_mth3(){
		var mypage_mth = document.mypageForm.memberBirth2;	
		if( isNaN(mypage_mth.value) ) {
			alert("숫자만 입력가능합니다!")
			mypage_mth.value="";
		}
		
		if(mypage_mth.value.trim().length==2) {
			document.mypageForm.memberBirth3.focus();
		}
	}
	
	function mypage_birth_date(){
		var mypage_date = document.mypageForm.memberBirth3;
		var init_date = "<%=memberBirths[2]%>";
		
		if(mypage_date.value==init_date) {
			mypage_date.value="";		
			document.getElementById("memberBirth3").style.color="black";
		}
	}
	
	function mypage_birth_date2(){
		var mypage_date = document.mypageForm.memberBirth3;
		var init_date = "<%=memberBirths[2]%>";
		if(mypage_date.value.trim().length==0) {
			document.getElementById("memberBirth3").style.color="#E3E3E3";
			mypage_date.value = init_date;			
		}			
	}
	
	function mypage_birth_date3(){
		var mypage_date = document.mypageForm.memberBirth3;
		if( isNaN(mypage_date.value) ) {
			alert("숫자만 입력가능합니다!")
			mypage_date.value="";
		}
		
		if(mypage_date.value.trim().length==2) {
			document.mypageForm.memberPhone1.focus();
		}
	}
	
	function mypage_phone_fst(){
		var mypage_fst = document.mypageForm.memberPhone1;
		var init_fst = "<%=memberPhones[0]%>";
		
		if(mypage_fst.value==init_fst) {
			mypage_fst.value="";		
			document.getElementById("memberPhone1").style.color="black";
		}
	}
	
	function mypage_phone_fst2(){
		var mypage_fst = document.mypageForm.memberPhone1;
		var init_fst = "<%=memberPhones[0]%>";
		if(mypage_fst.value.trim().length==0) {
			document.getElementById("memberPhone1").style.color="#E3E3E3";
			mypage_fst.value = init_fst;			
		}			
	}

	function mypage_phone_fst3(){
		var mypage_fst = document.mypageForm.memberPhone1;	
		if( isNaN(mypage_fst.value) ) {
			alert("숫자만 입력가능합니다!")
			mypage_fst.value="";
		}
		
		if(mypage_fst.value.trim().length==3) {
			document.mypageForm.memberPhone2.focus();
		}
	}
	
	function mypage_phone_mid(){
		var mypage_mid = document.mypageForm.memberPhone2;
		var init_mid = "<%=memberPhones[1]%>";
		
		if(mypage_mid.value==init_mid) {
			mypage_mid.value="";		
			document.getElementById("memberPhone2").style.color="black";
		}
	}
	
	function mypage_phone_mid2(){
		var mypage_mid = document.mypageForm.memberPhone2;
		var init_mid = "<%=memberPhones[1]%>";
		if(mypage_mid.value.trim().length==0) {
			document.getElementById("memberPhone2").style.color="#E3E3E3";
			mypage_mid.value = init_mid;			
		}			
	}

	function mypage_phone_mid3(){
		var mypage_mid = document.mypageForm.memberPhone2;	
		if( isNaN(mypage_mid.value) ) {
			alert("숫자만 입력가능합니다!")
			mypage_mid.value="";
		}
		
		if(mypage_mid.value.trim().length==4) {
			document.mypageForm.memberPhone3.focus();
		}
	}
	
	function mypage_phone_end(){
		var mypage_end = document.mypageForm.memberPhone3;
		var init_end = "<%=memberPhones[2]%>";
		
		if(mypage_end.value==init_end) {
			mypage_end.value="";		
			document.getElementById("memberPhone3").style.color="black";
		}
	}
	
	function mypage_phone_end2(){
		var mypage_end = document.mypageForm.memberPhone3;
		var init_end = "<%=memberPhones[2]%>";
		if(mypage_end.value.trim().length==0) {
			document.getElementById("memberPhone3").style.color="#E3E3E3";
			mypage_end.value = init_end;			
		}			
	}
	
	function mypage_phone_end3(){
		var mypage_end = document.mypageForm.memberPhone3;
		if( isNaN(mypage_end.value) ) {
			alert("숫자만 입력가능합니다!")
			mypage_end.value="";
		}
		
		if(mypage_end.value.trim().length==4) {
			document.mypageForm.memberAddress1.focus();
		}
	}
	
	function mypage_address_dt(){
		var mypage_address_dt = document.mypageForm.memberAddress2;
		var init_address_dt = "<%=memberAddress2%>";
		
		if(mypage_address_dt.value==init_address_dt) {
			mypage_address_dt.value="";		
			document.getElementById("memberAddress2").style.color="black";
		}
	}
	
	function mypage_address_dt2(){
		var mypage_address_dt = document.mypageForm.memberAddress2;
		var init_address_dt = "<%=memberAddress2%>";
		if(mypage_address_dt.value.trim().length==0) {
			document.getElementById("memberAddress2").style.color="#E3E3E3";
			mypage_address_dt.value = init_address_dt;			
		}			
	}
	
	function postService() {
		var url = 'postService.jsp';
		var winName = 'searchAddress';
		var winChar = 'top=100, left=300, height=500, width=800, resizable=no';
		var childWin = window.open(url, winName, winChar);		
	}
	
	function changePw(){
<%
		String memberPw = member.getMemberPw();	
		request.setAttribute("memberPw", memberPw);
%>
		location.href="changePw.jsp";
	}
	
</script>

</head>
<body>
<h2>내정보 보기</h2>
<hr>
<form action="control" method="post" name="mypageForm">
	<div id="frame">
		<div>
			<div>
				<input class="tb_mypage_s" type="text" id="memberId1" name="memberId1" 
						value="<%=memberIds[0] %>" disabled>
				<font style="font-size: x-large;">@</font>
				<input class="tb_mypage_s" type="text" id="memberId2" name="memberId2" 
						value="<%=memberIds[1] %>" disabled>
			</div>
				<br>
			<div>
				<input class="tb_mypage_s" type="text" id="memberName" name="memberName" 
						value="<%=memberName%>" disabled>
			</div>	
				<br>
			<div>
				<input class="tb_mypage_xs" type="text" id="memberBirth1" name="memberBirth1" 
						value="<%=memberBirths[0] %>" disabled>
				<font style="font-size: x-large;">-</font>
				<input class="tb_mypage_xxs" type="text" id="memberBirth2" name="memberBirth2" 
						value="<%=memberBirths[1] %>" disabled>
				<font style="font-size: x-large;">-</font>
				<input class="tb_mypage_xxs" type="text" id="memberBirth3" name="memberBirth3" 
						value="<%=memberBirths[2] %>" disabled>
			</div>
				<br>
			<div>
				<input class="rb_signin" type="radio" name="memberSex" checked>
				<font style="font-size: 20px; font-weight: bold;"><%=memberSex %></font>
			</div>					
				<br>
			<div>
				<input class="tb_mypage_xxs" type="text" id="memberPhone1" name="memberPhone1" 
						value="<%=memberPhones[0] %>" onfocus="mypage_phone_fst()" onblur="mypage_phone_fst2()"
						onkeyup="mypage_phone_fst3()">
				<font style="font-size: x-large;">-</font>
				<input class="tb_mypage_xs" type="text" id="memberPhone2" name="memberPhone2" 
						value="<%=memberPhones[1] %>" onfocus="mypage_phone_mid()" onblur="mypage_phone_mid2()"
						onkeyup="mypage_phone_mid3()">
				<font style="font-size: x-large;">-</font>
				<input class="tb_mypage_xs" type="text" id="memberPhone3" name="memberPhone3" 
						value="<%=memberPhones[2] %>" onfocus="mypage_phone_end()" onblur="mypage_phone_end2()"
						onkeyup="mypage_phone_end3()">
			</div>	
				<br>
			<div>
				<div style="margin-top: 10px;">
					<input class="tb_mypage_xs" type="text" id="memberPost" name="memberPost" 
							value="<%=memberPost %>" readonly>
					<input class="bt_post" type="button" id="btPost" name="btPost" value="우편번호 찾기" onclick="postService()">
				</div>
				<div style="margin-top: 10px;">
					<input class="tb_mypage_l" type="text" id="memberAddress1" name="memberAddress1" 
							value="<%=memberAddress1 %>" readonly>
				</div>
				<div style="margin-top: 10px;">
					<input class="tb_mypage_l" type="text" id="memberAddress2" name="memberAddress2" 
							value="<%=memberAddress2 %>" onfocus="mypage_address_dt()" onblur="mypage_address_dt2()">
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
		</div>
			<br>
		<div>
			<div style="float: right; margin: 40px;">
				<input class="bt_footer" type="submit" value="수정하기">&nbsp;&nbsp;
				<input type="hidden" name="action" value="update">
				<input class="bt_footer2" type="button" value="비밀번호 변경" onclick="changePw()">
			</div>
		</div>
	</div>
</form>
</body>
</html>