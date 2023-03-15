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
							<h2>메뉴수정</h2>
						</div>
						<div class="content-body">
							<form class="form-table" action="/manage/menu/update" >
								<table class="table">
									<tr>
										<th>번호</th>
										<td>${menu.menu_seq}</td>
									</tr>
									<tr>
										<th>메뉴 번호</th>
										<td><input type="text" name="menu_ctgr" value="${menu.menu_ctgr}" placeholder="메뉴 번호를 입력하세요." /></td>
									</tr>
									<tr>
										<th>메뉴 아이디</th>
										<td><input type="text" name="postCategory" value="${menu.postCategory}" placeholder="메뉴 아이디를 입력하세요." /></td>
									</tr>
									<tr>
										<th>메뉴 이름</th>
										<td><input type="text" name="menu_name" value="${menu.menu_name}" placeholder="메뉴 이름을 입력하세요." /></td>
									</tr>
								</table>
							
								<div class="btn-group">
									<a class="btn btn-secondary" href="/manage/menu">목록</a>
									<button type="submit" class="btn btn-primary right">저장</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>