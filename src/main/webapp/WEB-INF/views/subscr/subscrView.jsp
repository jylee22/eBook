<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이북 저북</title>
	<link rel="icon" type="image/x-icon" href="/img/favicon.ico">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
	<link rel="stylesheet" href="/css/common.css" />
	<link rel="stylesheet" href="/css/custom.css" />
	<link rel="stylesheet" href="/css/media.css" />
	<script src="/js/common.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
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
				<div class="content">
					<div class="container">
						<div class="content-header">
							<h2 class="t-center m-auto">구독해주셔서 감사합니다.</h2>
						</div>
						
						<div class="content-body">
							<div class="form-table">
								<table class="table">
									<tr>
										<th>아이디</th>
										<td>${info.userId}</td>
									</tr>
									<tr>
										<th>결제방법</th>
										<td>${info.payMent}</td>
									</tr>
									<tr>
										<th>카드번호</th>
										<td>${info.cardNum}</td>
									</tr>
									<tr>
										<th>구독일</th>
										<td>${info.subDate}</td>
									</tr>
									<tr>
										<th>만료일</th>
										<td>${info.exDate}</td>
									</tr>
								</table>
								<div class="btn-group">
								<a class="btn btn-primary" href="/">확인</a>
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