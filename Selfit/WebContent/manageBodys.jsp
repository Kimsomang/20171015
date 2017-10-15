<%@ page import="java.util.ArrayList" %>
<%@ page import="com.selfit.model.DTO.Bodys" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selfit 체형관리</title>
<link type="text/css" rel="stylesheet" href="css/common.css">
<link type="text/css" rel="stylesheet" href="css/manage.css">
<script type="text/javascript" src="js/manage.js"></script>
</head>
<body>
<div id="header">
	<%@ include file="header.jsp" %>
</div>
<div id="contents">
	<h2>체 형 관 리</h2>
	<div id="bodyTable">
	<table>
		<tr>
			<td class="table_large">체형식별번호</td>
			<td class="table_large">체형이름</td>
			<td class="table_x-large">체형설명</td>
		</tr>
		<c:forEach var="idx" items="${requestScope.getAllBodys}">
		<c:set var="bodyNo" value="${idx.bodyId}" />
		<tr>
			<td><a href="control?action=updateBody&id=${bodyNo}">${bodyNo}</a></td>
			<td>${idx.bodyName}</td>
			<td>${idx.bodyDesc}</td>
		</tr>
		</c:forEach>
	</table>
	</div>
	<form name="bodyForm" method="post">
	<div id="bodyDiv">
		<div class="trStyle">
			<div class="tdStyle contentsColumn textSize">체형식별번호 : </div>
			<div class="tdStyle">
				<input class="tb_normal" type = "text" name="bodysId" onblur="bodyIdValue()">
				<span class="error_msg" id="bodyIdCheck"></span>
			</div>
		</div>	
		<div class="trStyle">
			<div class="tdStyle contentsColumn textSize">체형이름 : </div>
			<div class="tdStyle">
				<input class="tb_normal" type = "text" name="bodysName" onblur="bodyNameValue()">
				<span class="error_msg" id="bodyNameCheck"></span>
			</div>
		</div>
		<div class="trStyle">	
			<div class="tdStyle contentsColumn textSize">체형설명 : </div>
			<div class="tdStyle">
				<input class="tb_normal" type = "text" name="bodysDesc">
			</div>
		</div>
	</div>		
	<div class="trStyle">
		<input class="bt_size" type="button" id="bt_insert" value="삽입" onClick="insertBody()">
		<input class="bt_size" type="button" id="bt_delete" value="삭제" onClick="deleteBody()">
	</div>
	<h4>* 삭제시에는 체형식별번호만 입력해주세요.</h4>
	</form>
</div>
<div id="footer">
	<%@ include file="footer.jsp" %>
</div>
</body>
</html>