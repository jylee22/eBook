<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">

        $(document).ready(function () {
            $('button#inputButton').click(function () {
                $.ajax({
                    type: "post",
                    url: "/api/search",
                    data: {query: $('#query').val()}
                })
                console.log($('#query').val())
            })
        })

    </script>

    <title>api 검색 테스트 </title>

</head>


<body>
<form name="search">
    <p><input type="text" id="query">
        <button id="inputButton">검색</button>
    </p>
</form>

<table>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>등록일</th>
    </tr>

    <c:forEach items="${list}" var="list">
        <tr>
            <td><c:out value="${list.title}"/></td>
        </tr>
    </c:forEach>

</table>
</form>
</body>
</html>