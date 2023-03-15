<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div class="request-list-content">
	<h4>요청 목록 <span>(${page.totalCount})</span></h4>
	<ul class="request-list">
		<c:forEach var="request" items="${requestList}">
			<li class="item">
				<div class="count">
					<span>${request.userId}</span>
				</div>
				<div class="form-item">
					<div class="group">
						<div class="title">${request.req_book}</div>
						<div class="date">${request.req_date}</div>
						<c:choose>
							<c:when test="${sessionScope.user.userId == request.userId}">
								<a id="btnDelete" class="btn ml-auto"  href="/board/list/delete?postCategory=${request.postCategory}&req_key=${request.req_key}&nowPage=${map.nowPage}&pageCount=${map.pageCount}&pageGrpNum=${map.pageGrpNum}">삭제</a>
							</c:when>
						</c:choose>
					</div>
					<div class="cont">${request.req_cont}</div>
				</div>
			</li>
		</c:forEach>
	</ul>
	
	<%@include file="/WEB-INF/include/common/paging.jspf" %>
</div>