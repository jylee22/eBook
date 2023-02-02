<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>도서 목록</title>
    <link rel="icon" type="image/x-icon" href="/img/favicon.ico">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
    <script src="./bootstrap-4.5.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/css/common.css"/>
    <link rel="stylesheet" href="/css/custom.css"/>
    <link rel="stylesheet" href="/css/media.css"/>

    <script type="text/javascript">
    </script>
</head>
<body>
<div class="wrapper">
	<div class="components">
	 	<!-- header -->
		<%@ include file="/WEB-INF/include/common/header.jsp" %>
		<!-- header -->
		
		<div class="contents view">
			<!-- sidebar -->
			<%@ include file="/WEB-INF/include/common/bookSidebar.jsp" %>
			<!-- sidebar -->
			<div class="container">
				<!-- content -->
				<div class="content w-setting">
					<div class="book-list-component">
						<div class="content-header">
							<h2>자료 검색</h2>
						</div>
						<div class="content-middle">
							<div>
								<!-- 검색 -->
									<form class="search-form group-3" name="search_form" action="/api/searchList2" method="get">
										<select name="type" required>
				                <option selected value="">검색 내용 선택</option>
				                <option value="title">제목</option>
				                <option value="author">저자</option>
				                <option value="publisher">출판사</option>
				            </select>
				            <input type="text" name="keyword" value=""/>
				            <button type="submit" value="검색" class="btn btn-secondary">검색</button>
									</form>
									<!-- 검색 -->
							</div>
						</div>
						<div class="content-body">
							<div class="book-list-content">
								<div class="content-sub-header">
									<h5>검색 결과</h5>
								</div>
								<div class="content-sub-body">
									<div class="row">
										<c:forEach items="${list}" var="list">
											<div class="book">
												<div onclick="PopupEmpInfo(this)">
													<div class="card book-cont">
														<div class="book-item item-img">
															<img src="${list.image}" class="card-img-top" alt="...">
														</div>
                                                        <div class="book-item item-title">${list.title}</div>
														<div class="book-item" style="display:none;">${list.isbn}</div>
					                  <div class="book-item" style="display:none;">${list.author}</div>
					                  <div class="book-item" style="display:none;">${list.publisher}</div>
					                  <div class="book-item" style="display:none;">${list.description}</div>
														<button class="view btn-view" data-toggle="modal" data-target="#bookDetail">상세보기</button>
													</div>
												</div>
											</div>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
                        <div class="pagination">
                            <ul>
                                <c:if test="${pageMaker.prev}">
                                    <li><a href="searchList${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
                                </c:if>

                                <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
                                    <li><a href="searchList${pageMaker.makeQuery(idx)}">${idx}</a></li>
                                </c:forEach>

                                <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
                                    <li><a href="searchList${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
                                </c:if>
                            </ul>
                        </div>
					</div>
					
					<!-- 목록 -->
<%--					<div class="list-content">--%>
<%--						<table class="table">--%>
<%--		          <thead>--%>
<%--			          <tr style="display: none">--%>
<%--			              <th>사진</th>--%>
<%--			              <th>제목</th>--%>
<%--			              <th>isbn</th>--%>
<%--			              <th>저자</th>--%>
<%--			              <th>출판사</th>--%>
<%--			              <th style="display:none;">책 설명</th>--%>
<%--			              <th>상세페이지</th>--%>
<%--			          </tr>--%>
<%--		          </thead>--%>
<%--		          <tbody>--%>
<%--			          <c:forEach items="${list}" var="list">--%>
<%--			              <tr onclick="PopupEmpInfo(this)">--%>
<%--			                  <td><img src="${list.image}" width="230" height="270" class="card-img-top"--%>
<%--			                           alt="..."></td>--%>
<%--			                  <td>${list.title}</td>--%>
<%--			                  <td>${list.isbn}</td>--%>
<%--			                  <td>${list.author}</td>--%>
<%--			                  <td>${list.publisher}</td>--%>
<%--			                  <td style="display:none" ;>${list.description}</td>--%>
<%--			                  <td>--%>
<%--			                      <button class="view" data-toggle="modal" data-target="#bookDetail">상세보기</button>--%>
<%--			                  </td>--%>
<%--			              </tr>--%>
<%--			          </c:forEach>--%>
<%--		          </tbody>--%>
<%--		          <tfoot>--%>
<%--		          	<td colspan="5" class="tablefoot"></td>--%>
<%--		          </tfoot>--%>
<%--	      		</table>--%>
<%--      		</div>--%>
					<!-- 목록 -->
        </div>   
			</div>
		</div>
	</div>
</div>
</body>





<!-- 모달 시작-------------------------------------------------------------------------------------------->
<div class="modal modal-m" id="bookDetail">
    <div class="modal-content">
        <div class="modal-header">
            <h3 id="book_title"></h3>
            <div>
                <button type="button" data-dismiss="modal"><img class="ico" src="/img/icon/icon-close.svg"/></button>
            </div>
        </div>
        <div class="modal-body">
            <form id="detail-form" class="detail-form">
                <div class="detail">
                    <div class="book-image" id="book_image" style="height:300px;">
                    </div>

                    <div class="book-inf">
                        <div class="content-header">
                            <h3>책 정보</h3>
                        </div>
                        <div class="content-body">
                            <ul>
                                <li>
                                    <span>저자</span>
                                    <span id="book_author"></span>
                                </li>

                                <li>
                                    <span>출판사</span>
                                    <span id="book_publisher"></span>
                                </li>

                                <li>
                                    <span>ISBN</span>
                                    <span id="book_isbn"></span>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="book-cont">
                    <div class="content-header">
                        <h3>도서 내용</h3>
                    </div>
                    <div class="content-body">
                        <p id="book_description"></p>
                    </div>
                </div>
            </form>
        </div>
        <div class="modal-footer">
            <button id="gobook" class="btn btn-primary">내서재</button>
        </div>
    </div>
</div>


<script>
    function PopupEmpInfo(clicked_element) {
        // var row_td = clicked_element.getElementsByTagName("td");
        var row_td = clicked_element.getElementsByClassName("book-item");
        // var modal = document.getElementById("myModal");
        document.getElementById("book_image").innerHTML = row_td[0].innerHTML;
        document.getElementById("book_title").innerHTML = row_td[1].innerHTML;
        document.getElementById("book_isbn").innerHTML = row_td[2].innerHTML;
        document.getElementById("book_author").innerHTML = row_td[3].innerHTML;
        document.getElementById("book_publisher").innerHTML = row_td[4].innerHTML;
        document.getElementById("book_description").innerHTML = row_td[5].innerHTML;
    }
    //==============================================================================
    // var close = document.getElementById('modalClose')
    // close.addEventListener("click", close_modal)
    // function close_modal(event) {
    //     $('#bookDetail').modal('hide')
    // }
    //=====================================================================
    var gobook = document.getElementById('gobook')
    gobook.addEventListener("click", go_book)
    function go_book(event) {
        var isbn = $('#book_isbn').text()
        console.log(isbn)
        $.ajax({
            url: "/book/libinsert",
            method: "post",
            data: {"isbn": isbn},
            success: function (data) {
                alert("전송성공");
            },
            error: function (error) {
                alert("전송실패!");
            }
        });
    }
</script>
</html>