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
		$('#WriteForm').on('submit', function(e){
			// 필수 입력
			const titleEl = $('#postTitle');
			const contEl = $('#postContent');
			// 제목
			if(titleEl.val().trim() == ""){
				$('#postTitle').focus();
				return false;
			} 
			// 내용
			if(contEl.val().trim() == ""){
				$('#postContent').focus();
				return false;
			}
		});
		
		// 목록 버튼
		$('#btnList').on('click', function(){
			let url = '/board/list?postCategory=${board.postCategory}';
			location.href = url;
		})
		
		// 취소 버튼
		$('#btnClose').on('click', function(){
			alert("작성이 취소되었습니다.");
			let url = '/board/list?postCategory=${board.postCategory}';
			location.href = url;
		})
		
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
							<h2>${ pageMenu.menu_name } 수정</h2>
						</div>
						
						<div class="content-body">
							<form id="WriteForm" class="form-table" action="/board/update" method="POST">
								<input type="hidden"  name="postKey" value="${ board.postKey }" />
								<input type="hidden"  name="postCategory" value="${ board.postCategory }" />
								<input type="hidden"  name="userId" value="${sessionScope.user.userId}"/>
								<table class="table">
									<tr>
										<th>제목</th>
										<td><input type="text" id="postTitle" name="postTitle" value="${board.postTitle}" placeholder="제목을 입력하세요."/></td>
									</tr>
									<tr>
										<th>작성자</th>
										<td>${sessionScope.user.userId}</td>
									</tr>
									<tr>
										<th>내용</th>
										<td class="cont">
											<textarea name="postContent" id="postContent" placeholder="내용을 입력하세요.">${board.postContent}</textarea>
										</td>
									</tr>
								</table>
							
								<div class="btn-group">
									<button id="btnList" class="btn btn-secondary">목록</button>
									<button id="btnUpdate" class="btn btn-primary right">수정</button>
									<button id="btnClose" class="btn btn-secondary">취소</button>
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