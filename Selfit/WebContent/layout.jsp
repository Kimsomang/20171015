<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="header">
<%@ include file="header.jsp" %>
</div>
<div id="contents">
	<a href="control?action=allMembers">
	<input type="image" src="img/img_navi_member.png" class="navi"></a>
	<a href="control?action=allBodys">
	<input type="image" src="img/img_navi_body.png" class="navi"></a>
	<a href="control?action=allContents">
	<input type="image" src="img/img_navi_category.png" class="navi"></a>
	<a href="control?action=allBrand">
	<input type="image" src="img/img_navi_brand.png" class="navi"></a>
	<a href="control?action=allContacts">
	<input type="image" src="img/img_navi_contact.png" class="navi"></a>
</div>
<div id="footer">
<%@ include file="footer.jsp" %>
</div>
</body>
</html>