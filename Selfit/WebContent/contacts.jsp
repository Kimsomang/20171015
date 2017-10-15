<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selfit 제휴문의</title>
<link type="text/css" rel="stylesheet" href="css/common.css">
<link type="text/css" rel="stylesheet" href="css/contacts.css">

<script type="text/javascript" src="js/contacts.js"></script>
<script type="text/javascript">

window.onload = function() {
	init();
}

</script>
</head>
<body>
<div id="header">
	<%@ include file="header.jsp" %>
</div>
<h2>제 휴 문 의</h2>
<hr>
<div id="contents">
<h3>신청서 작성하기</h3>
<h4>* 는 필수입력 사항입니다.</h4>
<form name="contactForm" method="post" action="control?action=contact">
	<div id="contactContents">
		<div class="title tdStyle">* 업체명 : </div>
		<div>
			<input class="tdStyle tb_normal" type = "text" name = "corpName" id = "corpName"
			size="35" onblur="corpNameValue()">
			<span class="error_msg" id="corpNameCheck"></span>
		</div>
	</div>	
	<div id="contactContents">
		<div class="title tdStyle">* 담당자 : </div>
		<div>
			<input class="tdStyle tb_normal" type = "text" name = "corpManager" id = "corpManager"
			size="35" onblur="corpManagerValue()">
			<span class="error_msg" id="corpManagerCheck"></span>
		</div>
	</div>
	<div id="contactContents">
		<div class="title tdStyle">* 연락처 : </div>
		<div class="tdStyle">
			<input class="tb_phone1" type="text" id="phone1" name="phone1" 
					value="01X" onfocus="phone_fst()" onblur="phone_fst2()" onkeyup="phone_fst3()">
			<font style="font-size: x-large;">-</font>
			<input class="tb_phone2" type="text" id="phone2" name="phone2" 
					value="XXXX" onfocus="phone_mid()" onblur="phone_mid2()" onkeyup="phone_mid3()">
			<font style="font-size: x-large;">-</font>
			<input class="tb_phone2" type="text" id="phone3" name="phone3" 
					value="XXXX" onfocus="phone_end()" onblur="phone_end2()" onkeyup="phone_end3()">
			<span class="error_msg" id="phoneCheck1"></span>
			<span class="error_msg" id="phoneCheck2"></span>
			<span class="error_msg" id="phoneCheck3"></span>
		</div>
	</div>
	<div id="contactContents">	
		<div class="title tdStyle">* 이메일 : </div>
		<div>
			<input class="tdStyle tb_normal" type = "text" name = "email" id = "email"
			size="35" onblur="emailValue()">
			<span class="error_msg" id="emailCheck"></span>
		</div>
	</div>
	<div id="contactContents">
<pre class="textSize">

제휴 문의 등록시 문의에 대한 회신 메일이 발송되오니,
수신 가능한 정확한 이메일로 등록 해주시기 바랍니다.
</pre>
	</div>
	<div>
		<input class="bt_size" type = "submit" value="문의등록" onClick="return enroll()">
		<input class="bt_size" type = "reset" value="취소">
	</div>
</form>
</div>
<div id="footer">
	<%@ include file="footer.jsp" %>
</div>
</body>
</html>