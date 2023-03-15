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
		$(function(){
			$('#btnBook').on('click',function(){
		    $('#bookDetail').fadeIn();
		  });
				
		  $('#btnClose').on('click',function(){
		    $('#bookDetail').fadeOut();
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
				<%@ include file="/WEB-INF/include/common/bookSidebar.jsp" %>
				<div class="content">
					<div class="container">
						<div class="content-body">
							<div class="row">
								<div class="book" id="btnBook">
									<div class="card book-cont" >
										<div class="item-img"></div>
										<div class="item-title">트렌드 코리아 2023</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<%@ include file="/WEB-INF/views/book/bookDetail.jsp" %>
		</div>
	</div>
</body>
</html>