<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selfit 카테고리 수정관리</title>
<link type="text/css" rel="stylesheet" href="css/common.css">
<link type="text/css" rel="stylesheet" href="css/manage.css">
<script type="text/javascript">
function init() {
	document.categoryForm.categoriesId.value="${requestScope.getCategory.categoriesId}";
	document.categoryForm.categoriesName.value="${requestScope.getCategory.categoriesName}";
	document.categoryForm.categoriesDesc.value="${requestScope.getCategory.categoriesDesc}";
}

function cancel() {
	document.categoryForm.reset();
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
	<h2>카 테 고 리 관 리</h2>
	<form name="categoryForm" method="post" action="control?action=updateCategory">
	<div id="updateContentForm">
		<div class="trStyle">
			<div class="tdStyle textSize contentsColumn2">카테고리식별번호 : </div>
			<div class="tdStyle">
				<input class="tb_normal" type ="text" name="categoriesId" readOnly>
			</div>
		</div>
		<div class="trStyle">	
			<div class="tdStyle textSize contentsColumn2">카테고리이름 : </div>
			<div class="tdStyle">
				<input class="tb_normal" type ="text" name="categoriesName">
			</div>
		</div>
		<div class="trStyle">	
			<div class="tdStyle textSize contentsColumn2">카테고리설명 : </div>
			<div class="tdStyle">
				<input class="tb_normal" type ="text" name="categoriesDesc">
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