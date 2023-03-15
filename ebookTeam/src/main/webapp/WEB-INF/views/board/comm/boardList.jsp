<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div class="content-middle">
	<span>${page.totalCount} 건</span>

	<div class="btn-group">
		<c:choose>
			<c:when test="${not empty user}">
				<a class="btn btn-primary" id="btnCreate" href="/board/writeForm?postCategory=${postCategory}&postKey=${board.postKey}&nowPage=${map.nowPage}&pageCount=${map.pageCount}&pageGrpNum=${map.pageGrpNum}">등록</a>
			</c:when>
		</c:choose>
		<select name="sortSelect">
			<option value="sorting">순번</option>
			<option value="postDate">작성일</option>
			<option value="postViewCount">조회수</option>
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