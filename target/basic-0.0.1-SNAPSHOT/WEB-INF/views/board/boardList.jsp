<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이북저북</title>
	<link rel="icon" type="image/x-icon" href="/img/favicon.ico">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
	<link rel="stylesheet" href="/css/common.css" />
	<link rel="stylesheet" href="/css/custom.css" />
	<link rel="stylesheet" href="/css/media.css" />
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script src="/js/common.js"></script>
	<script type="text/javascript">
		$(function(){

		});
	</script>
</head>
<body>
	<div class="wrapper">
		<div class="components">
			<!-- header -->
			<%@ include file="/WEB-INF/include/common/header.jsp" %>
			<!-- header -->
			<div class="contents view">
				<%@ include file="/WEB-INF/include/common/BoardSidebar.jsp" %>
				<div class="content">
					<div class="container">
						<div class="content-header">
							<h2>${ pageMenu.menu_name }</h2>
						</div>
						<c:choose>
							<c:when test="${postCategory eq 'qna' or postCategory eq 'notice'}">
								<%@ include file="/WEB-INF/views/board/notice/boardList.jsp" %>
							</c:when>
							
							<c:when test="${postCategory eq 'commu'}">
								<div class="content-middle">
									<div class="group-3">
										<select name="searchSelect" id="searchSelect">
											<option value="all">전체</option>
											<option value="postTitle">제목</option>
											<option value="userId">작성자</option>
										</select>
										<input type="search" name="keyword" id="keyword"/>
										<button id="btnSearch" class="btn btn-primary">검색</button>
									</div>
									
									<div class="btn-group">
										<a class="btn btn-primary" id="btnCreate" href="/board/writeForm?postCategory=${postCategory}">등록</a>
										
										<select name="sortSelect">
											<option value="all">작성일순</option>
											<option value="postTitle">제목순</option>
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
													<th>제목</th>										
													<th>작성자</th>										
													<th>작성일</th>			
													<c:if test="${postCategory eq 'commu'}" var="commu" scope="session">
														<th>댓글</th>
													</c:if>				
													<th>조회수</th>										
												</tr>
											</thead>
											<tbody>
												<c:forEach var="board" items="${boardList}">
													<tr>
														<td>${board.sorting}</td>
														<td><a id="boardView" href="/board/view?postCategory=${board.postCategory}&postKey=${board.postKey}">${board.postTitle}</a></td>
														<td>${board.userId}</td>
														<td>${board.postDate}</td>
														<c:if test="${postCategory eq 'refer'}" var="refer" scope="session">
															<td>다운로드</td>
														</c:if>
														<c:if test="${postCategory eq 'commu'}" var="commu" scope="session">
															<th>댓글 수</th>
														</c:if>
														<td>${board.postViewCount}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									
										<div class="page-group">
											<button> < </button>
											<button class="active"> 1 </button>
											<button> > </button>
										</div>
									</div>
							</c:when>
							
							<c:when test="${postCategory eq 'bookrequest'}">
								<div class="content-body">
									<!-- 도서요청 작성 -->
									<%@ include file="/WEB-INF/views/board/request/boardWrite.jsp" %>
									<!-- 도서요청 작성 -->
									
									<!-- 도서요청 목록 -->
									<%@ include file="/WEB-INF/views/board/request/boardList.jsp" %>
									<!-- 도서요청 목록 -->
								</div>
							</c:when>
						</c:choose>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>