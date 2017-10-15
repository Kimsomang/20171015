<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 셀렉터 부분 -->
<form name="categories" action="control" method="post">
	<!-- 액션 설정부 -->
	<input type="hidden" name="action" value="serviceContents">
	<!-- 상단 명령부, 모두 선택하기/모두 해제하기 -->
	<div class="wrapper">
		<div class="left">
		</div>
		<div class="left">
			<input type="button" class="bt_type1" name="bt_unselectAll" id="bt_unselectAll" value="모두 선택하기" title="모두 선택해제하려면 여기를 클릭하세요" onclick="checkAll()">
		</div>
		<div class="left">
			<input type="button" class="bt_type1" name="bt_unselectAll" id="bt_unselectAll" value="모두 해제하기" title="모두 선택해제하려면 여기를 클릭하세요" onclick="reset()">
		</div>
	</div>
	<!-- DBMS 카테고리 조회 내용 셀렉트 박스 생성 -->
	<div class="wrapper">
		<c:forEach var="categories" items="${requestScope.categories}">
			<div class="checkbox left">
				<input type="checkbox" name="cb_category" value="${categories.categoriesId}" id="${categories.categoriesName}">
				<label for="${categories.categoriesName}">${categories.categoriesName}</label>
			</div>
		</c:forEach>
	</div>
	<!-- 하단 명령부, 조회하기/돌아가기 -->
	<div class="wrapper">
		<div class="left">
			<input type="submit" class="bt_type1" name="bt_submit" id="bt_submit" value="조회하기" title="선택한 카테고리에 대한 브랜드 결과를 조회합니다." onclick="return categoriesSubmit()">
		</div>
		<div class="left">
			<input type="reset" class="bt_type1" value="되돌아가기" title="내용을 초기화 하려면 여기를 클릭하세요">	
		</div>
	</div>
	<!-- 에러메시지 표시부 -->
	<div>
		<span id="errMsg" class="warning"></span>
	</div>
</form>
<div id="hotContents">
		<h2>W/E/E/K/L/Y/B/E/S/T</h2>
		<img class="weeklyBest" alt="hotContents1" src="img/img_nike.PNG" title="해당제품 보러가기">
		<img class="weeklyBest" alt="hotContents2" src="img/img_nike2.PNG" title="해당제품 보러가기">
		<img class="weeklyBest" alt="hotContents3" src="img/img_adidas.PNG" title="해당제품 보러가기">
		<img class="weeklyBest" alt="hotContents4" src="img/img_adidas2.PNG" title="해당제품 보러가기">
		<img class="weeklyBest" alt="hotContents6" src="img/img_8seconds.PNG" title="해당제품 보러가기">
		<img class="weeklyBest" alt="hotContents7" src="img/img_toryburch.PNG" title="해당제품 보러가기">
	</div>