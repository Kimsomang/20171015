<%@ page import="com.selfit.model.DTO.Members" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selfit 회원관리</title>
<link type="text/css" rel="stylesheet" href="css/common.css">
<link type="text/css" rel="stylesheet" href="css/manage.css">
</head>
<body>
<div id="header">
	<%@ include file="header.jsp" %>
</div>
<div id="contents">
	<h2>회 원 관 리</h2>
	<div id="memberTable">
	<table>
		<tr>
			<td class="table_large">아이디</td>
			<td class="table_small">이름</td>
			<td class="table_small">생년월일</td>
			<td>성별</td>
			<td class="table_normal">핸드폰번호</td>
			<td class="table_larger">주소</td>
			<td>체형</td>
			<td>회원등급</td>
			<td class="table_normal">선호브랜드</td>
			<td class="table_small">가입일</td>
			<td class="table_small">회원상태</td>
			<td class="tabel_small">마지막회원상태변경일</td>
			<td class="table_small">활동횟수</td>
		</tr>
		<c:forEach var="idx" items="${requestScope.getAllMembers}">
		<c:set var="memberId" value="${idx.memberId}"/>
		<tr>
			<td><a href="control?action=updateMembers&id=${memberId}">${memberId}</a></td>
			<td>${idx.memberName}</td>
			<td>${idx.memberBirth}</td>
			<td>${idx.memberSex}</td>
			<td>${idx.memberPhone}</td>
			<td>${idx.memberAddress1}</td>
			<td>${idx.memberBody}</td>
			<td>${idx.memberGrade}</td>
			<td>${idx.memberBrand}</td>
			<td>${idx.memberEnt}</td>
			<td>${idx.memberStatus}</td>
			<td>${idx.memberUpdate}</td>
			<td>${idx.memberActcnt}</td>
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