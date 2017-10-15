<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selfit</title>
<link type="text/css" rel="stylesheet" href="css/common.css">
</head>
<body>
	<div id="header">
		<%@ include file="header.jsp"%>
	</div>
	<div id="contents">
		<form action="control" name="main" method="get">
		<input type="image" src="img/img_index.png" title="클릭시 페이지가 이동됩니다." width="1300px"
			height="600px" name="action" value="index" onclick="document.main.submit()">
		</form>
	</div>
	<div id="footer">
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>