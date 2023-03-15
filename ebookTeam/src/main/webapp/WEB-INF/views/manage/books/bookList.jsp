<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	<style>
	
	
	</style>
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
							<h2>도서관리</h2>
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
									<option value="title">제목</option>
									<option value="author">저자</option>
									<option value="publisher">출판사</option>
								</select>
								<a class="btn btn-primary" href="/manage/book/writeForm">등록</a>
							</div>
						</div>
						<div class="content-body">
							<div class="list-table">
								<table class="table">
									<thead>
										<tr>
											<th>번호</th>
											<th>이미지</th>
											<th>제목</th>											
											<th>저자</th>										
											<th>도서 번호</th>										
											<th>출판사</th>																		
										</tr>
									</thead>
									<tbody>
										<tr>
											<c:forEach items="${bookList}" var="list">
												<tr>
													<td>${list.bookkey}</td>
													<td><img src="${list.image}" width="230" height="270" class="card-img-top"
			                                            alt="..."></td>
													<td>${list.title}</td>
													<td>${list.author}</td>
													<td>${list.isbn}</td>
													<td>${list.publisher}</td>
													<td>
														<td class="t-center"><a class="btn btn-primary" href="/manage/book/updateForm?bookkey=${list.bookkey}">수정</a></td>
											            <td><a class="btn btn-danger" id="btnDelete"    href="/manage/book/delete?bookkey=${list.bookkey}">삭제</a></td>
													</td>
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