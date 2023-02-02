<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<script type="text/javascript">
	$(function(){
		$('#WriteForm').on('submit', function(e){
			// 필수 입력
			const bookEl = $('#reqBook');
			const contEl = $('#reqCont');
			// 제목
			if(bookEl.val().trim() == ""){");
				$('#reqBook').focus();
				return false;
			} 
			// 내용
			if(contEl.val().trim() == ""){
				$('#reqCont').focus();
				return false;
			}
		});
	});
</script>

<form id="WriteForm" class="request-form" action="/board/list/requestWrite?postCategory=${postCategory}" >
	<input type="hidden"  name="postCategory" value="${postCategory}"/>
	<input type="hidden" name="req_process" value="요청"/>
	<input type="hidden" name="userId" value="${sessionScope.user.userId}"/>
	<div class="input-form">
		<input type="text" id="userId" name="userId" value="${sessionScope.user.userId}" disabled/>
		<input type="text" id="reqBook" name="req_book" placeholder="책 제목"/>
		<input type="text" id="reqProcess" name="req_process" value="요청" disabled/>
	</div>
	<div class="group-2">
		<textarea class="cont" id="reqCont" name="req_cont" placeholder="댓글을 작성하세요."></textarea>
		<button type="submit" class="btn btn-primary">등록</button>
	</div>
</form>
