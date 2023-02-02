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
            <%@ include file="/WEB-INF/include/common/mySidebar.jsp" %>
            <div class="content">
                <div class="container">
                    <div class="content-header">
                        <h2>내서재</h2>
                    </div>

                    <div class="content-body">
                        <table>
                            <thead>
                            <tr>
                                <th>사진</th>
                                <th>제목</th>
                                <th>읽기</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${list}" var="list">
                                <tr>
                                    <td><img src="${list.apiDTO.image}" width="230" height="270" class="card-img-top"
                                             alt="..."></td>
                                    <td>${list.apiDTO.title}</td>
                                    <td> <a href="https://mozilla.github.io/pdf.js/web/viewer.html?file=https://mozilla.github.io/pdf.js/web/compressed.tracemonkey-pldi-09.pdf">읽기</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>