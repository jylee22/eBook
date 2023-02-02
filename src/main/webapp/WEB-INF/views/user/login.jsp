<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="modal modal-s" id="Login">
    <div class="modal-content">
        <div class="modal-header">
            <div id="btnClose">
                <img class="ico" src="/img/icon/icon-close.svg"/>
            </div>
        </div>
        <div class="modal-body">
            <h2 class="t-center">로그인</h2>
            <form class="login-form" action="/user/login" method="POST">
                <input type="text" id="userId" name="userId" placeholder="아이디"/>
                <input type="password" id="userPass" name="userPass" placeholder="비밀번호"/>
                <button type="submit" id="btn_login" class="btn btn-primary">로그인</button>
            </form>
        </div>
    </div>
</div>