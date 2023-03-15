<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>이북저북</title>
    <link rel="icon" type="image/x-icon" href="/img/favicon.ico">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="/css/common.css"/>
    <link rel="stylesheet" href="/css/custom.css"/>
    <link rel="stylesheet" href="/css/media.css"/>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
</head>
</head>
<body>
<div class="wrapper">
    <div class="components">
        <!-- header -->
        <%@ include file="/WEB-INF/include/common/header.jsp" %>
        <!-- header -->
        <div class="contents view">
            <%@ include file="/WEB-INF/include/common/mySidebar.jsp" %>
            <div class="content">
                <div class="container">
                    <div class="content-header">
                        <h2>회원 정보 수정</h2>
                    </div>

                    <div class="content-body">
                        <form id= "form-userUpdate" class="form-table">
                            <table>
                            <tr>
                                <th>이름</th>
                                <td><input type="text" class="disabled" name="userName" placeholder="이름"
                                           value="${user.userName}"/></td>
                            </tr>
                            <tr>
                                <th>아이디</th>
                                <td><input type="text" class="disabled" name="userId" placeholder="아이디"
                                           value="${user.userId}"/></td>
                            </tr>
                            <tr>
                                <th>비밀번호</th>
                                <td><input type="password" id="userPass2"  name="userPass" placeholder="비밀번호" value="${user.userPass}"/>
                                </td>
                            </tr>
                            <tr>
                                <th>비밀번호 확인</th>
                                <td><input type="password" id="userPassCheck" name="userPassCheck" placeholder="비밀번호 확인"/></td>
                            </tr>
                            <tr>
                                <th>이메일</th>
                                <td><input type="email" name="userEmail" placeholder="이메일" value="${user.userEmail}"/>
                                </td>
                            </tr>
                            <tr>
                                <th>연락처</th>
                                <td><input type="tel" name="userPhone" placeholder="연락처" value="${user.userPhone}"/>
                                </td>
                            </tr>
                            <tr>
                                <th>가입일</th>
                                <td><input class="" type="text" name="joinDate" value="${user.joinDate}" disabled/></td>
                            </tr>
                            </table>

                            <div class="btn-group">
                                <button type="button" id="btnUserUpdate" class="btn btn-primary ml-auto">회원정보수정</button>
                                <button type="button" onclick="location.href='/user/delete'" class="btn btn-danger">회원탈퇴</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>