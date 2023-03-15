<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<nav class="sidebar">
	<ul class="nav">
		<c:forEach var="menu" items="${manageMenu}">
			<li class="link-item">
				<a class="link" href="/manage/${menu.postCategory}">${menu.menu_name}</a>
			</li>
		</c:forEach>
	</ul>
</nav>