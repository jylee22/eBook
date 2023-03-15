<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 댓글 -->
<c:choose>
	<c:when test="${not empty user}">
		<%@ include file="/WEB-INF/views/board/comm/commentWrite.jsp" %>								
	</c:when>
	<c:otherwise>
		<div class="t-center" style="padding: 10px;">
			로그인 후 댓글 작성 가능합니다.
		</div>
	</c:otherwise>
</c:choose>
<!-- 댓글 -->

<!-- 댓글 목록 -->
<%@ include file="/WEB-INF/views/board/comm/commentList.jsp" %>
<!-- 댓글 목록 -->