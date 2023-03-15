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
							<h2>요청관리</h2>
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
											<th>아이디</th>										
											<th>책 이름</th>										
											<th>요청 사유</th>										
											<th>요청일</th>										
											<th>진행사항</th>										
											<th></th>										
										</tr>
									</thead>
									<tbody>
										<c:forEach var="request" items="${requestList}">
											<tr>
												<td>${request.req_key}</td>
												<td>${request.userId}</td>
												<td>${request.req_book}</td>
												<td>${request.req_cont}</td>
												<td>${request.req_date}</td>
												<td>${request.req_process}</td>
												<td class="t-center"><a class="btn btn-primary" href="/manage/request/view?req_key=${request.req_key}">보기</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>