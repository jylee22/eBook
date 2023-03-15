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
			
			$('.replay-form textarea').css('height','100px');
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
							<h2>Q&A 답글</h2>
						</div>
						
						<div class="content-body">
						<!-- 답글 내용 -->
							<div class="form-table">
								<table class="table">
									<tr>
										<th>제목</th>
										<td colspan="5">${board.postTitle}</td>
									</tr>
									<tr>
										<th>작성자</th>
										<td>${board.userId}</td>
										<th>작성일</th>
										<td>${board.postDate}</td>
										<th>조회수</th>
										<td>${board.postViewCount}</td>
									</tr>
									<tr>
										<th>내용</th>
										<td colspan="5">${board.postContent}</td>
									</tr>
								</table>
							</div>
							<!-- 답글 내용 -->
							
							<!-- 답글 쓰기-->
							<form id="WriteForm" class="form-table replay-form" action="/board/replay">
								<input type="hidden"  name="postCategory" value="${board.postCategory}"/>
								<input type="hidden"  name="postKey" value="${board.postKey}"/>
					      <input type="hidden"  name="bNum"    value="${board.bNum}" />   
					      <input type="hidden"  name="lvl"     value="${board.lvl}" />   
					      <input type="hidden"  name="step"    value="${board.step}" />   
					      <input type="hidden"  name="nref"    value="${board.nref}" />
					      <input type="hidden"  name="userId" value="${sessionScope.user.userId}"/>
								<table class="table">
									<tr>
										<th>제목</th>
										<td><input type="text"  id="postTitle" name="postTitle" value="[답변] ${board.postTitle}" placeholder="제목을 입력하세요." required/></td>
									</tr>
									<tr>
										<th>작성자</th>
										<td>${sessionScope.user.userId}</td>
									</tr>
									<tr>
										<th>내용</th>
										<td>
											<textarea name="postContent" id="postContent" placeholder="내용을 입력하세요." required></textarea>
										</td>
									</tr>
								</table>
							
								<div class="btn-group">
									<button id="btnList" class="btn btn-secondary">목록</button>
									<button type="submit" id="btnCreate" class="btn btn-primary right">등록</button>
								</div>
							</form>
							<!-- 답글 쓰기-->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>