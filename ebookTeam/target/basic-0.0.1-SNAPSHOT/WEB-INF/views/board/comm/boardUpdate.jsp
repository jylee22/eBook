<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form class="comment-form" action="/board/view/updateForm?postCategory=${board.postCategory}&postKey=${board.postKey}">
	<input type="hidden"  name="postCategory" value="${comm.postCategory}"/>
	<input type="hidden"  name="postKey" value="${comm.postKey}"/>
	<input type="hidden"  name="userId" value="${sessionScope.user.userId}"/>
	<input type="hidden"  name="nowPage"       value="${ map.nowPage }" />          
  <input type="hidden"  name="pageCount"     value="${ map.pageCount }" />          
  <input type="hidden"  name="pageGrpNum"    value="${ map.pageGrpNum }" />  
	<div class="input-form">
		${comm.userId}
	</div>
	<div class="group-2">
		<textarea class="cont" name="commCont" placeholder="댓글을 작성하세요.">${comm.commCont}</textarea>
		<button type="submit" class="btn btn-primary">등록</button>
	</div>
</form>