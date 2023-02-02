<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<div class="board-comment-list">
	<h4>댓글 목록</h4>				
	<ul class="comment-list">
		<c:forEach var="comm" items="${commList}">
		<li class="item">
			<div class="count">
				<span>${comm.userId}</span>
			</div>
			<div class="form-item">
				<div class="group">
					<div class="date">${comm.commDate}</div>
					<a id="btnUpdate" class="btn ml-auto" href="/board/view/updateForm?commIdx=${comm.commIdx}">수정</a>
					<a id="btnDelete" class="btn" href="/board/view/delete?postCategory=${board.postCategory}&postKey=${board.postKey}&commIdx=${comm.commIdx}">삭제</a>
				</div>
				<div class="cont">${comm.commCont}</div>
			</div>
		</li>
		</c:forEach>
	</ul>
</div>