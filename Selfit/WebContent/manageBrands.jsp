<%@ page import = "com.selfit.model.DTO.Brands" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selfit 브랜드관리</title>
<link type="text/css" rel="stylesheet" href="css/common.css">
<link type="text/css" rel="stylesheet" href="css/manage.css">
<script type="text/javascript" src="js/manage.js"></script>
</head>
<body>
<div id="header">
	<%@ include file="header.jsp" %>
</div>
<div id="contents">
	<h2>브 랜 드 관 리</h2>
	<div id="brandTable">
	<table>
		<tr>
			<td class="table_large">브랜드식별번호</td>
			<td class="table_large">브랜드명</td>
			<td class="table_x-large">브랜드설명</td>
		</tr>
		<c:forEach var="idx" items="${requestScope.getAllBrands}">
		<c:set var="brandNo" value="${idx.brandId}" />
		<tr>
			<td><a href="control?action=updateBrand&id=${brandNo}">${brandNo}</a></td>
			<td>${idx.brandName}</td>
			<td>${idx.brandDesc}</td>
		</tr>
		</c:forEach>
	</table>
	</div>
	<form name="brandForm" method="post">
	<div id="brandDiv">
		<div class="trStyle">
			<div class="textSize tdStyle contentsColumn">브랜드식별번호 : </div>
			<div class="tdStyle">
				<input class="tb_normal" type = "text" name="brandsId" onblur="brandIdValue()">
				<span class="error_msg" id="brandIdCheck"></span>
			</div>
		</div>
		<div class="trStyle">	
			<div class="textSize tdStyle contentsColumn">브랜드명 : </div>
			<div class="tdStyle">
				<input class="tb_normal" type = "text" name="brandsName" onblur="brandNameValue()">
				<span class="error_msg" id="brandNameCheck"></span>
			</div>
		</div>
		<div class="trStyle">	
			<div class="textSize tdStyle contentsColumn">브랜드설명 : </div>
			<div class="tdStyle">
				<input class="tb_normal" type = "text" name="brandsDesc">
			</div>
		</div>
	</div>	
	<div class="trStyle">	
		<input class="bt_size" type="button" id="bt_insert" value="삽입" onClick="insertBrand()">
		<input class="bt_size" type="button" id="bt_delete" value="삭제" onClick="deleteBrand()">
	</div>
	<h4>* 삭제시에는 브랜드식별번호만 입력해주세요.</h4>
	</form>
</div>
<div id="footer">
	<%@ include file="footer.jsp" %>
</div>
</body>
</html>