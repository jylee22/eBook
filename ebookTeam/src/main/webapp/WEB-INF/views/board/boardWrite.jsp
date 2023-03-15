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
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
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
							<h2>${ pageMenu.menu_name } 작성</h2>
						</div>
						<div class="content-body">
							<form id="WriteForm" class="form-table" action="/board/write" method="GET">
								<input type="hidden"  name="postCategory"  value="${postCategory}"/>
								<input type="hidden"  name="userId"        value="${sessionScope.user.userId}"/>
								<input type="hidden"  name="nowPage"       value="${ map.nowPage }" />          
					      <input type="hidden"  name="pageCount"     value="${ map.pageCount }" />          
					      <input type="hidden"  name="pageGrpNum"    value="${ map.pageGrpNum }" />  
								<table class="table">
									<tr>
										<th>제목</th>
										<td><input type="text" id="postTitle" name="postTitle" placeholder="제목을 입력하세요." required/></td>
									</tr>
									<tr>
										<th>작성자</th>
										<td>${sessionScope.user.userId}</td>
									</tr>
									<tr>
										<th>내용</th>
										<td class="cont">
											<textarea  id="postContent" name="postContent" placeholder="내용을 입력하세요." required></textarea>
										</td>
									</tr>

								</table>
							
								<div class="btn-group">
									<button id="btnList" class="btn btn-secondary">목록</button>
									<button type="submit" id="btnCreate" class="btn btn-primary right">등록</button>
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