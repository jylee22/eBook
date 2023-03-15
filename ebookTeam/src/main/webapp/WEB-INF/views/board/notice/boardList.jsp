<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="content-middle">
	<span>${page.totalCount} 건</span>
	
	<div class="btn-group">
		<c:if test="${sessionScope.user.userId=='admin2'}" var="commu" scope="session">
			<a class="btn btn-primary" id="btnCreate" href="/board/writeForm?postCategory=${postCategory}&nowPage=${map.nowPage}&pageCount=${map.pageCount}&pageGrpNum=${map.pageGrpNum}">등록</a>
		</c:if>
		
		<select name="sortSelect">
			<option value="all">작성일순</option>
			<option value="postTitle">제목순</option>
			<option value="userId">조회순</option>
		</select>
	</div>
</div>

<div class="content-body">
	<div class="list-table">
		<table class="table">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>										
					<th>작성자</th>										
					<th>작성일</th>				
					<th>조회수</th>										
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${boardList}">
					<tr>
						<td>${board.postKey}</td>
						<td><a id="boardView" href="/board/view?postCategory=${board.postCategory}&postKey=${board.postKey}&nowPage=${map.nowPage}&pageCount=${map.pageCount}&pageGrpNum=${map.pageGrpNum}">${board.postTitle}</a></td>
						<td>${board.userId}</td>
						<td>${board.postDate}</td>
						<td>${board.postViewCount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<%@include file="/WEB-INF/include/common/paging.jspf" %>

	</div>
</div>