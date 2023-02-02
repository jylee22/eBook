<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div class="content-middle">
	<div class="group-3">
		<select name="searchSelect" id="searchSelect">
			<option value="all">전체</option>
			<option value="postTitle">제목</option>
			<option value="userId">작성자</option>
		</select>
		<input type="search" name="keyword" id="keyword"/>
		<button id="btnSearch" class="btn btn-primary">검색</button>
	</div>
	
	<div class="btn-group">
		<c:if test="${sessionScope.user.userId=='admin2'}" var="commu" scope="session">
			<a class="btn btn-primary" id="btnCreate" href="/board/writeForm?postCategory=${postCategory}">등록</a>
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
					<c:if test="${postCategory eq 'commu'}" var="commu" scope="session">
						<th>댓글</th>
					</c:if>				
					<th>조회수</th>										
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${boardList}">
					<tr>
						<td>${board.sorting}</td>
						<td><a id="boardView" href="/board/view?postCategory=${board.postCategory}&postKey=${board.postKey}">${board.postTitle}</a></td>
						<td>${board.userId}</td>
						<td>${board.postDate}</td>
						<c:if test="${postCategory eq 'refer'}" var="refer" scope="session">
							<td>다운로드</td>
						</c:if>
						<c:if test="${postCategory eq 'commu'}" var="commu" scope="session">
							<th>댓글 수</th>
						</c:if>
						<td>${board.postViewCount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
		<div class="page-group">
			<button> < </button>
			<button class="active"> 1 </button>
			<button> > </button>
		</div>
	</div>
</div>