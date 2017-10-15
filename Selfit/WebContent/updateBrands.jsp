<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selfit 브랜드 수정관리</title>
<link type="text/css" rel="stylesheet" href="css/common.css">
<link type="text/css" rel="stylesheet" href="css/manage.css">
<script type="text/javascript">

function init() {
	document.brandForm.brandsId.value="${requestScope.getBrand.brandId}";
	document.brandForm.brandsName.value="${requestScope.getBrand.brandName}";
	document.brandForm.brandsDesc.value="${requestScope.getBrand.brandDesc}";
}

function cancel() {
	document.brandForm.reset();
	init();
}

window.onload = function() {
	init();
}
</script>
</head>
<body>
<div id="header">
	<%@ include file="header.jsp" %>
</div>
<div id="contents">
	<h2>브 랜 드 관 리</h2>
	<form name="brandForm" method="post" action="control?action=updateBrands">
	<div id="updateBrandForm">
		<div class="trStyle">
			<div class="tdStyle textSize contentsColumn">브랜드식별번호 : </div>
			<div class="tdStyle">
				<input class="tb_normal" type ="text" name="brandsId" readOnly>
			</div>
		</div>
		<div class="trStyle">	
			<div class="tdStyle textSize contentsColumn">브랜드명 : </div>
			<div class="tdStyle">
				<input class="tb_normal" type ="text" name="brandsName">
			</div>
		</div>
		<div class="trStyle">	
			<div class="tdStyle textSize contentsColumn">브랜드설명 : </div>
			<div class="tdStyle">
				<input class="tb_normal" type ="text" name="brandsDesc">
			</div>
		</div>
		<div class="trStyle">
			<input class="bt_size" type="submit" id="bt_update" value="수정">
			<input class="bt_size" type="button" value="취소" onClick="cancel()">
		</div>
	</div>
	</form>
</div>
<div id="footer">
	<%@ include file="footer.jsp" %>
</div>
</body>
</html>