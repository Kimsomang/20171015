<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 해더영역 -->
<div>
	<!-- 로고 -->
	<div>
		<a href="index.jsp">
			<img src="img/img_logo.png" height="80px" />
		</a>
	</div>
	<!-- 네비게이터 영역 -->
	<div id="header_navi">
		<form action="control" method="post">
			<!-- 관리자 네비게이터 -->
			<c:if test="${sessionScope.memberGrade eq 'A'}">
				<input type="image" name="action" value="manage" src="img/img_navi_manageMain.png" class="navi" title="메인페이지">
				<input type="image" name="action" value="allMembers" src="img/img_navi_member.png" class="navi" title="회원관리">
				<input type="image" name="action" value="allBodys" src="img/img_navi_body.png" class="navi" title="체형관리">
				<input type="image" name="action" value="allContents" src="img/img_navi_category.png" class="navi" title="카테고리관리">
				<input type="image" name="action" value="allBrand" src="img/img_navi_brand.png" class="navi" title="브랜드관리">
				<input type="image" name="action" value="allContacts"  src="img/img_navi_contact.png" class="navi" title="제휴문의관리">
			</c:if>
			<c:if test='${not empty sessionScope.memberId}'>
				<input type="image" name="action" value="serviceCategories" src="img/img_navi_serviceMain.png" class="navi" title="메인페이지">
				<input type="image" name="action" value="mypage" src="img/img_navi_mypage.png" class="navi" title="내정보보기">
				<input type="image" name="action" value="logout" src="img/img_navi_logout.png" class="navi" title="로그아웃">
			</c:if>
		</form>
	</div>
</div>