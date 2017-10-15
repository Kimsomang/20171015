<%@ page import="java.util.ArrayList" %>
<%@ page import="com.selfit.model.DTO.Contacts" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selfit 제휴문의 관리</title>
<link type="text/css" rel="stylesheet" href="css/common.css">
<link type="text/css" rel="stylesheet" href="css/manage.css">
</head>
<body>
<div id="header">
	<%@ include file="header.jsp" %>
</div>
<div id="contents">
	<h2>제 휴 문 의 관 리</h2>
	<div id="contactTable">
	
	<table>
		<tr>
			<td class="table_large">업체명</td>
			<td class="table_large">담당자명</td>
			<td class="table_large">업체전화번호</td>
			<td class="table_large">업체이메일</td>
			<td class="table_large">문의일자</td>
		</tr>
		<c:forEach var="idx" items="${requestScope.getAllContacts}">
		<tr>
			<td>${idx.contactCorp}</td>
			<td>${idx.contactPerson}</td>
			<td>${idx.contactTel}</td>
			<td>${idx.contactEmail}</td>
			<td>${idx.contactDate}</td>
		</tr>
		</c:forEach>
	</table>
	</div>
</div>
<div id="footer">
	<%@ include file="footer.jsp" %>
</div>
</body>
</html>