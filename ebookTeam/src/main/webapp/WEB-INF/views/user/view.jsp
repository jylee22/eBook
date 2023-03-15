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
    <script type="text/javascript">
        $(function () {

        });
    </script>
</head>
<body>
<div class="wrapper">
    <div class="components">
        <!-- header -->
        <%@ include file="/WEB-INF/include/common/header.jsp" %>
        <!-- header -->
        <div class="contents view">
            <%@ include file="/WEB-INF/include/common/BoardSidebar.jsp" %>
            <div class="content">
                <div class="container">
                    <div class="content-header">
                        <h2>회원 정보</h2>
                    </div>

                    <div class="content-body">
                        <div class="form-table">
                            <table class="table">
                                <tr>
                                    <th>이름</th>
                                    <td>이름</td>
                                </tr>
                                <tr>
                                    <th>아이디</th>
                                    <td>admin</td>
                                </tr>
                                <tr>
                                    <th>이메일</th>
                                    <td>이메일</td>
                                </tr>
                                <tr>
                                    <th>연락처</th>
                                    <td>연락처</td>
                                </tr>
                                <tr>
                                    <th>가입일</th>
                                    <td>가입일</td>
                                </tr>
                                <tr>
                                    <th>구독</th>
                                    <td>
                                        <span>구독일 - 만료일</span>
                                    </td>
                                </tr>
                            </table>
                            <div class="btn-group">
                                <a class="btn btn-primary" href="#">구독연장</a>
                                <a class="btn btn-primary ml-10" href="#">구독해지</a>
                                <a class="btn btn-primary right" href="/user/update">수정</a>
                                <a class="btn btn-danger" href="#">탈퇴</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>