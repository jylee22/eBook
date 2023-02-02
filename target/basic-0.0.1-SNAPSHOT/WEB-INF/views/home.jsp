<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>이북 저북</title>
	<link rel="icon" type="image/x-icon" href="/img/favicon.ico">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
	<link rel="stylesheet" href="/css/common.css" />
	<link rel="stylesheet" href="/css/custom.css" />
	<link rel="stylesheet" href="/css/media.css" />
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script src="/js/common.js"></script>
	<script type="text/javascript">
	</script>
</head>
<body>
	<div class="wrapper">
		<div class="components">
			<!-- header -->
			<%@ include file="/WEB-INF/include/common/header.jsp" %>
			<!-- header -->
			<div class="contents">
				<!-- main -->
				<%@ include file="/WEB-INF/views/home/main.jsp" %>
				<!-- main -->
				<div class="container">
					
					<!-- 추천 도서 목록 -->
					<%@ include file="/WEB-INF/views/home/bookList.jsp" %>
					<!-- 추천 도서 목록 -->
				</div>
				<!-- 구독 -->
				<%@ include file="/WEB-INF/views/home/subscription.jsp" %>
				<!-- 구독 -->
				
				<!-- footer -->
				<%@ include file="/WEB-INF/include/common/footer.jsp" %>
				<!-- footer -->
				
				<%@ include file="/WEB-INF/views/user/login.jsp" %>
				<%@ include file="/WEB-INF/views/user/register.jsp" %>
			</div>
		</div>
	</div>
</body>
</html>












