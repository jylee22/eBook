<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="header">
    <div class="logo">
       <a href="/"><h1><img src="../../img/ebook_logo.png"/></h1></a>
    </div>
    <div class="head-nav">
    	<div class="nav-category" id="btnMenu"><i class="bi bi-list"></i></div>
        
      <ul class="nav ml-auto">
            <li class="item-link"><a class="link" href="/user/update">${sessionScope.user.userId}</a></li>
    		<li class="item-link"><a class="link" href="/board/list?postCategory=notice">새소식</a></li>
    		
    		<c:choose>
        	<c:when test="${sessionScope.user.userId=='admin2'}">
          	<li><a class="link" href="/manage/user">관리자페이지</a></li>
          </c:when>
        	<c:otherwise>
          	<li class="item-link"><a class="link" href="/lib/myBook">내서재</a></li>
          </c:otherwise>
        </c:choose>
        
        <c:choose>
        	<c:when test="${not empty user}">
          	<li><a class="link" href="/user/logout">로그아웃</a></li>
          </c:when>
          <c:otherwise>
          <li class="item-link"><a class="link" id="btnRegister">회원가입</a></li>
         	<li><a class="link" id="btnLogin">로그인</a></li>
          </c:otherwise>
        </c:choose>
    	</ul>
      
      <div class="menu" id="headMenu">
         <div class="menu-form">
             <ul class="menu-nav">
                 <li class="link-title">도서</li>
                 <li class="link-item"><a class="link" href="/api/searchList">자료검색</a></li>
             </ul>

             <ul class="menu-nav">
                 <li class="link-title">새소식</li>
                 <c:forEach var="board" items="${boardMenu}">
                     <li class="link-item">
                         <a class="link"
                            href="/board/list?postCategory=${board.postCategory}">${board.menu_name}</a>
                     </li>
                 </c:forEach>
             </ul>

             <ul class="menu-nav">
                 <li class="link-title">마이페이지</li>
                 <li class="link-item">
                   <a class="link" href="/user/update">회원정보수정</a>
                 </li>
                 <li class="link-item">
                   <a class="link" href="/lib/myBook">내서재</a>
                 </li>
             </ul>
         </div>
   		</div>
    </div>
		
		<%@ include file="/WEB-INF/views/user/login.jsp" %>
		<%@ include file="/WEB-INF/views/user/register.jsp" %>
</header>