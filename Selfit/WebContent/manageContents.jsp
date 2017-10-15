<%@ page import = "com.selfit.model.DTO.Categories" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selfit 카테고리관리</title>
<link type="text/css" rel="stylesheet" href="css/common.css">
<link type="text/css" rel="stylesheet" href="css/manage.css">
<script type="text/javascript" src="js/manage.js"></script>
</head>
<body>
<div id="header">
	<%@ include file="header.jsp" %>
</div>
<div id="contents">
	<h2>카 테 고 리 관 리</h2>
	<div id="categoryTable">
	<table>
		<tr>
			<td class="table_large">카테고리식별번호</td>
			<td class="table_large">카테고리명</td>
			<td class="table_x-large">카테고리설명</td>
		</tr>
		<c:forEach var="idx" items="${requestScope.getAllContents}">
		<c:set var="contentsId" value="${idx.categoriesId}" />
		<tr>
			<td><a href="control?action=updateContents&id=${contentsId}">${contentsId}</a></td>
			<td>${idx.categoriesName}</td>
			<td>${idx.categoriesDesc}</td>
		</tr>
		</c:forEach>
	</table>
	</div>
	<form name="categoryForm" method="post">
	<div id="categoryDiv">
		<div class="trStyle">
			<div class="textSize tdStyle contentsColumn2">카테고리식별번호 : </div>
			<div class="tdStyle">
				<input class="tb_normal" type = "text" name="categoriesId" onblur="categoryIdValue()">
				<span class="error_msg" id="categoryIdCheck"></span>
			</div>
		</div>
		<div class="trStyle">
			<div class="textSize tdStyle contentsColumn2">카테고리명 : </div>
			<div class="tdStyle">
				<input class="tb_normal" type = "text" name="categoriesName" onblur="categoryNameValue()">
				<span class="error_msg" id="categoryNameCheck"></span>
			</div>
		</div>
		<div class="trStyle">
			<div class="textSize tdStyle contentsColumn2">카테고리설명 : </div>
			<div class="tdStyle">
				<input class="tb_normal" type = "text" name="categoriesDesc">
			</div>
		</div>
	</div>
	<div class="trStyle">
		<input class="bt_size" type="button" id="bt_insert" value="삽입" onClick="insertCategory()">
		<input class="bt_size" type="button" id="bt_delete" value="삭제" onClick="deleteCategory()">
	</div>
	<h4>* 삭제시에는 카테고리식별번호만 입력해주세요.</h4>
	</form>
</div>
<div id="footer">
	<%@ include file="footer.jsp" %>
</div>
</body>
</html>