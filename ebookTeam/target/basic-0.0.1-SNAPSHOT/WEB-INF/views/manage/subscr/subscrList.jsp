<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이북저북 : 관리자페이지</title>
	<link rel="icon" type="image/x-icon" href="/img/favicon.ico">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
	<link rel="stylesheet" href="/css/common.css" />
	<link rel="stylesheet" href="/css/custom.css" />
	<link rel="stylesheet" href="/css/media.css" />
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script src="/js/common.js"></script>
	<script type="text/javascript">
		$(function(){ });
	</script>
</head>
<body>
	<div class="wrapper">
		<div class="components">
			<!-- header -->
			<%@ include file="/WEB-INF/include/common/header.jsp" %>
			<!-- header -->
			<div class="contents view">
				<%@ include file="/WEB-INF/include/common/manageSidebar.jsp" %>
				<div class="content">
					<div class="container">
						<div class="content-header">
							<h2>구독관리</h2>
						</div>
						<div class="content-middle">
							<div class="group-3">
								<select name="searchSeclect">
									<option value="all">전체</option>
									<option value="postTitle">제목</option>
									<option value="userId">작성자</option>
								</select>
								<input type="search" name="searchInput"/>
								<button class="btn btn-primary">검색</button>
							</div>
							
							<div class="btn-group">
								<select name="sortSelect">
									<option value="joinDate">가입순</option>
									<option value="userId">아이디순</option>
									<option value="userId">조회순</option>
								</select>
							</div>
						</div>
						<div class="content-body">
							<div class="list-table">
								<table class="table">
									<thead>
										<tr>
											<th>번호</th>
											<th>이름</th>										
											<th>아이디</th>
											<th>가입일</th>												
											<th>구독일</th>										
											<th>만료일</th>										
											<th>결제 방법</th>										
											<th>카드 번호</th>										
											<th></th>										
										</tr>
									</thead>
									<tbody>
										<c:forEach var="subscr" items="${subscrList}">
											<tr>
												<td>${subscr.subscribeKey}</td>
												<td>${subscr.userName}</td>
												<td>${subscr.userId}</td>
												<td>${subscr.joinDate}</td>
												<td>${subscr.subDate}</td>
												<td>${subscr.exDate}</td>
												<td>${subscr.payMent}</td>
												<td>${subscr.cardNum}</td>
												<td class="t-center"><a class="btn btn-primary" href="/manage/subscr/view?userId=${subscr.userId}">보기</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							
<%--								<div class="page-group">--%>
<%--									<button> < </button>--%>
<%--									<button class="active"> 1 </button>--%>
<%--									<button> > </button>--%>
<%--								</div>--%>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>