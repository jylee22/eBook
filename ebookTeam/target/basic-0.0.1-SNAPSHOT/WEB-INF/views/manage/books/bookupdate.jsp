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
		//form
		$('form').on('submit', function(e){
			// 필수 입력
			const titleEl = $('[name=postTitle]');
			const contEl = $('[name=postContent]');
			if(titleEl.val().trim() == ""){
				alert("제목을 입력하세요.");
				$('input').css('border-color', '#F25041');
				return false;
			}
			if(contEl.val().trim() == ""){
				alert("내용을 입력하세요.");
				$('input').css('border-color', '#F25041');
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
				<%@ include file="/WEB-INF/include/common/manageSidebar.jsp" %>
				<div class="content">
					<div class="container">
						<div class="content-header">
							<h2>수정</h2>
						</div>
						
						<div class="content-body">
							<form class="form-table" action="/manage/book/update" method="POST">
								<table class="table">
									<tr>
										<th></th>
										<td><input type="hidden" class="bookkey" name="bookkey" value="${book.bookkey}" /></td>
									</tr>
						            <tr>
										<th>이미지</th>
										<td><input type="text" class="image" name="image" value="${book.image}" /></td>
									</tr>
									<tr>
										<th>제목</th>
										<td><input type="text" class="title" name="title" value="${book.title}" /></td>
									</tr>
									<tr>
										<th>저자</th>
										<td><input type="text" class="author" name="author" value="${book.author}"/></td>
									</tr>
									<tr>
										<th>출판사</th>
										<td><input type="text" class="publisher" name="publisher" value="${book.publisher}"/></td>
									</tr>
									<tr>
										<th>표준 도서 번호</th>
										<td><input type="text" class="isbn" name="isbn" value="${book.isbn}"/></td>
									</tr>
									<tr>
										<th>내용</th>
										<td class="description">
											<textarea name="description" class="description">${book.description}</textarea>
										</td>
									</tr>
									
								</table>
							
								<div class="btn-group">
									<button id="btnList" class="btn btn-secondary" href="/manage/books">목록</button>
									<button type ="submit" id="btnUpdate" class="btn btn-primary right">수정</button>
									<button id="btnClose" class="btn btn-secondary" onclick="history.back()">취소</button>
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