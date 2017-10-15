<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="styleSeet" href="css/common.css">
<title>Error</title>
</head>
<body>
<div id="header">
	<jsp:include page="header.jsp" />
</div>
<div id="contents">
	에러 요청내용 : ${requestScope.serviceName} <br>
	에러 메시지 : ${requestScope.errorDesc}<br>
	관리자에게 요청바랍니다.<br>
	<a href="index.jsp">되돌아가기</a>
</div>
<div id="footer">
<%@ include file="footer.jsp" %>
</div>
</body>
</html>