<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selfit 관리자페이지</title>
<link type="text/css" rel="stylesheet" href="css/common.css">
<link type="text/css" rel="stylesheet" href="css/manage.css">
<!-- 김재림 추가분 세션 검증 -->
<% String memberId = (String)session.getAttribute("memberId");
String memberGrade = (String)session.getAttribute("memberGrade");
if (memberId == null || memberId.trim().isEmpty()) {
	request.setAttribute("serviceName", "로그인 세션 만료");
	request.setAttribute("errorDesc", "현재 페이지는 로그인이 필요한 페이지 입니다.");
} else if (!memberGrade.equals("A")) {
	response.sendRedirect("gradeError");
}
%>
</head>
<body>
<div id="header">
	<%@ include file="header.jsp" %>
</div>
<div id="contents">
	<div id="banner">
	<input type="image" src="img/img_main.png" name="img_banner" width="900px" height="170px">
	</div>
	<div id="logInfo">
	<p style="text-align: center; line-height: 70px;">관리자님, 환영합니다</p>
	<a href="control?action=adminInfo">
	<input type="image" src="img/bt_adminInfo.png" name="bt_adminInfo"
	width="150px" height="50px"></a>
	<a href="control?action=logout">
	<input type="image" src="img/bt_logout.png" name="bt_logout"
	width="150px" height="50px"></a>
	</div>
	<div id="hotContents">
		<h2>W/E/E/K/L/Y/B/E/S/T</h2>
		<img class="weeklyBest" alt="hotContents1" src="img/img_nike.PNG">
		<img class="weeklyBest" alt="hotContents2" src="img/img_nike2.PNG">
		<img class="weeklyBest" alt="hotContents3" src="img/img_adidas.PNG">
		<img class="weeklyBest" alt="hotContents4" src="img/img_adidas2.PNG">
		<img class="weeklyBest" alt="hotContents6" src="img/img_8seconds.PNG">
		<img class="weeklyBest" alt="hotContents7" src="img/img_toryburch.PNG">
	</div>
</div>	
<div id ="footer">
	<%@ include file="footer.jsp" %>
</div>
</body>
</html>