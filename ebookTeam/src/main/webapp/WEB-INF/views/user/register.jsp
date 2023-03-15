<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<head>
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="/img/favicon.ico">
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
    <script src="/js/common.js"></script>
</head>
<div class="modal modal-s" id="Register">
    <div class="modal-content">
        <div class="modal-header">
            <div class="ml-auto">
                <button type="button" id="RegisterClose"><img class="ico" src="/img/icon/icon-close.svg"/></button>
            </div>
        </div>
        <div class="modal-body">
            <h2 class="t-center">회원가입</h2>
            <form class="login-form" id="login-form">
                <div class="group-2">
	            		<input type="text" id="inputId" name="userId" placeholder="아이디" required="required"/>
	                <button class="idcheck btn btn-primary" type="button" id="idcheck" value="N">중복확인</button>
	            	</div>
                <input type="password" id="inputPass" name="userPass" placeholder="패스워드" required="required"/>
                <input type="text" id="userName" name="userName" placeholder="이름" required="required"/>
                <input type="email" id="userEmail" name="userEmail" placeholder="이메일" required="required"/>
                <input type="text" id="userPhone" name="userPhone" placeholder="연락처" required="required"/>
                <button type="button" id="btn_Register" class="btn btn-primary">회원가입</button>
            </form>
        </div>
    </div>
    <script type="text/javascript">
        var t1 = document.getElementById('idcheck');
        t1.addEventListener("click", t1_click);

        function t1_click(event) {

            var userId = $('#inputId').val();
            console.log(userId)
            $.ajax({
                url: "/user/idcheck",
                type: "Post",
                dataType: "json",
                data: {"userId": userId},
                success: function (data) {
                    if (data == 1) {
                        alert("중복된 아이디입니다.");
                    } else if (data == 0) {
                        $("#idcheck").attr("value", "Y");
                        alert("사용가능한 아이디입니다.");
                    }
                }
            })
        }

        var register = document.getElementById('btn_Register')
        register.addEventListener("click", register_click)
        function register_click(event) {
            var userId = $('#inputId').val();
            console.log(userId)
            var userPass = $('#inputPass').val();
            console.log(userPass)
            var userName = $('#userName').val();
            console.log(userName)
            var userEmail = $('#userEmail').val();
            console.log(userEmail)
            var userPhone = $('#userPhone').val();
            console.log(userPhone)

            if (userId == "" || userId == null || userPass == "" || userPass == null || userName == "" || userName == null || userEmail == "" || userEmail == null || userPhone == "" || userPhone == null) {
                alert("모든 항목을 빈칸없이 작성해주시기 바랍니다.");
                return false;
            } else {
                var form1 = $('#login-form').serialize();
                console.log(form1)
                $.ajax({
                    url: "/user/register",
                    type: "POST",
                    data: form1,
                    success: function (data) {
                        alert("회원가입완료!   " + userId + "  님 환영 합니다.");
                        window.location.href = '/';
                    },
                    error: function (error) {
                        alert("회원가입실패!");
                        window.location.href = '/';
                    }
                });

            }

        }

        var t3 = document.getElementById('RegisterClose')
        t3.addEventListener("click", close_register)

        function close_register(event) {
            window.location.href = '/';
        }

    </script>
</div>