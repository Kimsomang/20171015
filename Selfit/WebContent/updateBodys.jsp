<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selfit 체형 수정관리</title>
<link type="text/css" rel="stylesheet" href="css/common.css">
<link type="text/css" rel="stylesheet" href="css/manage.css">
<script type="text/javascript">
function init() {
	document.bodyForm.bodysId.value="${requestScope.getBody.bodyId}";
	document.bodyForm.bodysName.value="${requestScope.getBody.bodyName}";
	document.bodyForm.bodysDesc.value="${requestScope.getBody.bodyDesc}";
}

function cancel() {
	document.bodyForm.reset();
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
	<h2>체 형 관 리</h2>
	<form name="bodyForm" method="post" action="control?action=updateBodys">
	<div id="updateBodyForm">
		<div class="trStyle">
			<div class="tdStyle textSize contentsColumn">체형식별번호 : </div>
			<div class="tdStyle">
				<input class="tb_normal" type ="text" name="bodysId" readOnly>
			</div>
		</div>
		<div class="trStyle">	
			<div class="tdStyle textSize contentsColumn">체형이름 : </div>
			<div class="tdStyle">
				<input class="tb_normal" type ="text" name="bodysName">
			</div>
		</div>
		<div class="trStyle">	
			<div class="tdStyle textSize contentsColumn">체형설명 : </div>
			<div class="tdStyle">
				<input class="tb_normal" type ="text" name="bodysDesc">
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