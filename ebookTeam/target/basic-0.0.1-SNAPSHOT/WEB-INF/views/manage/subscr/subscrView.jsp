<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
							<h2>구독 정보</h2>
						</div>
						
						<div class="content-body">
							<div class="form-table">
								<table class="table">
									<tr>
										<th>번호</th>
										<td>${subscr.subscribeKey}</td>
									</tr>
									<tr>
										<th>이름</th>
										<td>${subscr.usersVO.userName}</td>
									</tr>
									<tr>
										<th>아이디</th>
										<td>${subscr.userId}</td>
									</tr>
									<tr>
										<th>가입일</th>
										<td>${subscr.usersVO.joinDate}</td>
									</tr>
									<tr>
										<th>구독일</th>
										<td>${subscr.subDate}</td>
									</tr>
									<tr>
										<th>만료일</th>
										<td>${subscr.exDate}</td>
									</tr>
									<tr>
										<th>결제 방법</th>
										<td>${subscr.payMent}</td>
									</tr>
									<tr>
										<th>카드 번호</th>
										<td>${subscr.cardNum}</td>
									</tr>
								</table>
								<div class="btn-group">
									<a class="btn btn-secondary" href="/manage/subscr">목록</a>
									<a class="btn btn-primary right" href="/manage/user/view?userId=${subscr.userId}">회원 정보</a>
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