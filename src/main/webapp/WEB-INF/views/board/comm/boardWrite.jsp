<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
$(function(){ 
	$('#WriteForm').on('submit', function(e){
		// 필수 입력
		const contEl = $('#commCont');
		// 내용
		if(contEl.val().trim() == ""){
			$('#commCont').focus();
			return false;
		}
	});
	
});
</script>


<form id="WriteForm" class="comment-form" action="/board/view/comment?postCategory=${board.postCategory}&postKey=${board.postKey}">
	<input type="hidden"  name="postCategory" value="${board.postCategory}"/>
	<input type="hidden"  name="postKey" value="${board.postKey}"/>
	<input type="hidden"  name="userId" value="${sessionScope.user.userId}"/>
	
	<div class="item">
		<div class="count">
			<span>${sessionScope.user.userId}</span>
		</div>
		<div class="group-2">
			<textarea class="cont" id="commCont" name="commCont" placeholder="댓글을 작성하세요."></textarea>
			<button type="submit" class="btn btn-primary">등록</button>
		</div>
	</div>
</form>