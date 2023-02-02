<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<nav class="sidebar" id="Sidebar">
	<ul class="nav">
		<li class="link-item">
			<a class="link-title active">새소식</a>
		</li>
		<ul class="sub-nav">
			<li class="link-item">
				<c:forEach var="menu" items="${boardMenu}">
					<a class="link" href="/board/list?postCategory=${menu.postCategory}">${menu.menu_name}</a>
				</c:forEach>
			</li>
		</ul>
		<li class="link-title">
			<a class="link">마이페이지</a>
		</li>
		<ul class="sub-nav">
			<li class="link-item">
				<a class="link" href="/user/update">회원정보수정</a>
			</li>
			<li class="link-item">
				<a class="link" href="/lib/myBook">내서재</a>
			</li>
		</ul>
	</ul>
</nav>