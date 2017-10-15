<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 컨텐츠 내용 -->
<form name="Contents" action="control" method="post">
	<!-- 액션 설정부 -->
	<input type="hidden" name="action" value="serviceMap">
	<!-- 검색바 -->
	<div class="wrapper">
		<!-- 검색어 입력창  -->
		<div class="left">
			<input type="text" class="tb_search" name="tb_search" id="tb_search" value="검색어 입력">
		</div>
		<!-- 검색버튼 -->
		<div class="left">
			<input type="button" class="bt_search" name="bt_search" id="bt_search" value="검색">
		</div>
	</div>
	<!-- 조회내용 -->
	<div class="wrapper">
		<!-- 결과 조회부 -->
		<c:forEach var="detail" items="${requestScope.result}">
			<div>
				<!-- 카테고리 분류내용/더보기버튼 -->
				<!-- 더보기버튼 -->
				<div class="result_header">
					<div>
						<a href="javascript:viewMore('${detail['key']}')" title="상세결과를 보려면 클릭하세요.">
							${detail['key']}
						</a>
					</div>
				</div>
				<!-- 카테고리별 추천결과 -->
				<div class="result_detail" id="${detail['key']}">
					<c:forEach var="brand" items="${detail.value}">
						<div>
							<div class="left">
								<input type="radio" name="rb_brand">
							</div>
							<div class="result_lineItem">
								${brand.brandName}
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</c:forEach>
	</div>
	<!-- 버튼 -->
	<div class="wrapper">
		<div class="left">
			<input type="submit" class="bt_type1" value="지도보기" title="해당정보의 지도를 보려면 클릭하세요">
		</div>
		<div>
			<input type="button" class="bt_type1" value="되돌아가기" title="해당정보의 지도를 보려면 클릭하세요">
		</div>
	</div>
</form>