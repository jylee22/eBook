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
							<h2>요청수정</h2>
						</div>
						<div class="content-body">
							<form class="form-table" action="/manage/request/update" method="POST">
								<input type="hidden" name="req_key" value="${request.req_key}"/>
								<input type="hidden" id="req_process" name="req_process" value="${request.req_process}"/>
								<table class="table">
									<tr>
										<th>번호</th>
										<td>${request.req_key}</td>
									</tr>
									<tr>
										<th>아이디</th>
										<td>${request.userId}</td>
									</tr>
									<tr>
										<th>책 이름</th>
										<td>${request.req_book}</td>
									</tr>
									<tr>
										<th>요청 사유</th>
										<td>${request.req_cont}</td>
									</tr>
									<tr>
										<th>요청일</th>
										<td>${request.req_date}</td>
									</tr>
									<tr>
										<th>진행사항</th>
										<%-- <td><input type="text" name="req_process" value="${request.req_process}"/></td> --%>
										<td>
											<select name="request-s" id="request-s" onchange="chageSelect(this.value);">
												<option value="one">요청</option>
												<option value="two">승인</option>
												<option value="three">거절</option>
											</select>
										</td>
									</tr>
								</table>
							
								<div class="btn-group">
									<a class="btn btn-secondary" href="/manage/request">목록</a>
									<button type="submit" class="btn btn-primary right">저장</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		function chageSelect(value) {
			var result = null;
			if(value == "one") {
				result = "요청";
			}
			
			if(value == "two") {
				result = "승인";
			}
			
			if(value == "three") {
				result = "거절";
			}
			
			document.getElementById("req_process").value = result;
		}
	</script>
</body>
</html>