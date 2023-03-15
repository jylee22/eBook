<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<div class="board-comment-list">
	<h4>댓글 목록 (${comm.commCount})</h4>				
	<ul class="comment-list">
		<c:forEach var="comm" items="${commList}">
		<li class="item">
			<div class="count">
				<span>${comm.userId}</span>
			</div>
			<div class="form-item" id="commList-${comm.commIdx}">
				<div class="group">
					<div class="date">${comm.commDate}</div>
					<c:choose>
						<c:when test="${ sessionScope.user.userId == comm.userId }">
							<a id="btnUpdate-${comm.commIdx}" class="btn ml-auto btnUpdate" onclick="commUpdate('${comm.commIdx}');">수정</a>
							<a id="btnDelete" class="btn" href="/board/view/delete?postCategory=${board.postCategory}&postKey=${board.postKey}&commIdx=${comm.commIdx}&nowPage=${map.nowPage}&pageCount=${map.pageCount}&pageGrpNum=${map.pageGrpNum}">삭제</a>
							<%-- <a id="btnUpdate" class="btn ml-auto" href="/board/view/commUpdateForm?postCategory=${board.postCategory}&postKey=${board.postKey}&commIdx=${comm.commIdx}">수정</a> --%>
						</c:when> 
					</c:choose>
				</div>
				<div class="cont">${comm.commCont}</div>
			</div>
			<div class="form-item" id="commForm-${comm.commIdx}" style="display:none;">
				<form class="comment-form" action="/board/view/commUpdate">
					<input type="hidden"  name="postCategory" value="${board.postCategory}"/>
					<input type="hidden"  name="postKey" value="${board.postKey}"/>
					<input type="hidden"  name="userId" value="${sessionScope.user.userId}"/>
					<input type="hidden"  name="commIdx" value="${comm.commIdx}"/>
					<input type="hidden"  name="nowPage"       value="${ map.nowPage }" />          
		      <input type="hidden"  name="pageCount"     value="${ map.pageCount }" />          
		      <input type="hidden"  name="pageGrpNum"    value="${ map.pageGrpNum }" />  
					<div class="group-2">
						<textarea class="cont" id="commCont" name="commCont" placeholder="댓글을 작성하세요." required>${comm.commCont}</textarea>
						<button type="submit" class="btn btn-primary" id="update-${comm.commIdx}">수정</button>
					</div>
				</form>
			</div>
		</li>
		</c:forEach>
	</ul>
	<script>
		function commUpdate(comm) {
			
			for(var i = 0; i < $(".btnUpdate").length; i++) {
				if(document.getElementsByClassName("btnUpdate")[i].id != "btnUpdate-" + comm) {
					document.getElementsByClassName("btnUpdate")[i].style.visibility = "hidden";
				} 
			}
			
			document.getElementById("commList-" + comm).style.display = "none";
			document.getElementById("commForm-" + comm).style.display = "";
		}
	</script>
</div>