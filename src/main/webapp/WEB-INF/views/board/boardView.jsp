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
	<script src="/js/common.js"></script>
	<script type="text/javascript">
		$(function(){
			// 삭제 버튼
			$('#btnDelete').on('click', function(){
				var deleteYN = confirm("삭제하시겠습니까?");
				if(deleteYN == true){
					formObj.submit();
				}
			});	
			
			// 목록 버튼
			$('#btnList').on('click', function(){
				//alert("목록");
				let url = '/board/list?postCategory=${board.postCategory}';
				location.href = url;
			});
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
							<h2>${ pageMenu.menu_name } 게시글</h2>
						</div>
						
						<div class="content-body">
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
										<td colspan="5" class="cont">${board.postContent}</td>
									</tr>
								</table>
								<div class="btn-group">
									<button id="btnList" class="btn btn-secondary mr-10">목록</button>
									<c:choose>
					        	<c:when test="${sessionScope.user.userId=='admin2'}">
					          	<a class="btn btn-primary" id="btnReplay" 
										href="/board/replayForm?postCategory=${board.postCategory}&postKey=${board.postKey}&bnum=${boardVo.bnum}&lvl=${boardVo.lvl}&step=${boardVo.step}&nref=${boardVo.nref}">답변</a>
					          </c:when>

					        </c:choose>
					        <a class="btn btn-primary right" id="btnUpdate" href="/board/updateForm?postCategory=${board.postCategory}&postKey=${board.postKey}">수정</a>
									<a class="btn btn-danger" id="btnDelete" href="/board/delete?postCategory=${board.postCategory}&postKey=${board.postKey}">삭제</a>
								</div>
							</div>
							
							<c:if test="${board.postCategory eq 'commu'}" var="commu" scope="session">
								<!-- 댓글 -->
								<%@ include file="/WEB-INF/views/board/comm/boardWrite.jsp" %>
								<!-- 댓글 -->
								
								<!-- 댓글 목록 -->
								<%@ include file="/WEB-INF/views/board/comm/boardList.jsp" %>
								<!-- 댓글 목록 -->
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>