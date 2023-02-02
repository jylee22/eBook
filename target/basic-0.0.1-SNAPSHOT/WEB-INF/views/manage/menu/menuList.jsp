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
							<h2>메뉴관리</h2>
						</div>
						<div class="content-middle">
							<div class="group-3">
								<select name="searchSeclect">
									<option value="all">전체</option>
									<option value="">메뉴 아이디</option>
									<option value="">메뉴 이름</option>
								</select>
								<input type="search" name="searchInput"/>
								<button class="btn btn-primary">검색</button>
							</div>
							
							<div class="btn-group">
								<a class="btn btn-primary" href="/manage/menu/writeForm">등록</a>
								<select name="sortSelect">
									<option value="joinDate">오름차순</option>
									<option value="userId">메뉴 번호순</option>
									<option value="userId">메뉴 이름순</option>
								</select>
							</div>
						</div>
						<div class="content-body">
							<div class="list-table">
								<table class="table">
									<thead>
										<tr>
											<th>번호</th>
											<th>메뉴 번호</th>										
											<th>메뉴 아이디</th>										
											<th>메뉴 이름</th>																		
											<th></th>										
										</tr>
									</thead>
									<tbody>
										<c:forEach var="menu" items="${menuList}">
											<tr>
												<td>${menu.menu_seq}</td>
												<td>${menu.menu_ctgr}</td>
												<td>${menu.postCategory}</td>
												<td>${menu.menu_name}</td>
												<td class="t-center"><a class="btn btn-primary" href="/manage/menu/view?menu_seq=${menu.menu_seq}">보기</a></td>
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
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>