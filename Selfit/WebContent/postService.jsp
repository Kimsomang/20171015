<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selfit : 우편번호 조회</title>

<script type="text/javascript">
	function addressClick() {
		document.postForm.bt_use.disabled = false;
	}

	function useAddress() {
		var useAddress = document.getElementById("checkedPost");
			
		var getAddress = document.postForm.checkedPost.value;
		var sendPostNum = getAddress.trim().substring(0,7);
		var sendAddress = getAddress.trim().substring(7);

		window.opener.document.getElementById("memberPost").style.color="black";
		window.opener.document.getElementById("memberAddress1").style.color="black";
		
		window.opener.document.getElementById("memberPost").value = sendPostNum;
		window.opener.document.getElementById("memberAddress1").value = sendAddress;
		
		window.opener.document.getElementById("memberAddress1").readOnly=true;
		
		self.close();
		window.opener.document.getElementById("memberAddress2").focus();			
	
	}
</script>

</head>
<body>
<h2>우편번호 찾기</h2>
<hr>
<form action="control" method="post" name="postForm">
<table>
	<tr>
		<th>찾는 주소 입력(읍/면/동 입력)</th>
		<td>
			<input type="text" name="dong">
			<input type="submit" value="검색">
			<input type="hidden" name="action" value="postService">
 		</td> 
	</tr>
	<c:forEach var="posts" items="${requestScope.postData}">
	<tr>
		<td>
			<input type="radio" name="checkedPost" id="checkedPost"
			 value="${posts.zipcode} ${posts.sido} ${posts.gugun} ${posts.dong} ${posts.ri} ${posts.bldg} ${posts.bunji}" 
			 onclick="addressClick()"> 
				${posts.zipcode}&nbsp;
				${posts.sido}&nbsp;
				${posts.gugun}&nbsp;
				${posts.dong}&nbsp;
				${posts.ri}&nbsp;
				${posts.bldg}&nbsp;
				${posts.bunji}&nbsp;			
		</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="2">
			<input type="button" value="사용하기" name="bt_use" disabled onclick="useAddress()">
		</td>
	</tr>
</table>
</form>
</body>
</html>