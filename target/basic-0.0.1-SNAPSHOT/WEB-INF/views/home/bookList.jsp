<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 베스트 도서 -->
	<div class="content best-list">
		<div class="content-header">
			<h2 class="title">베스트 도서</h2>
			<a class="link" href="/api/searchList">더보기</a>
		</div>
		<div class="content-body">

			<div class="row">
				<a class="book" href="/api/searchList2?type=title&keyword=${random.get(0).getTitle()}">
					<div class="card book-cont">
						<img src="${random.get(0).getImage()}" class="item-img"/>
					</div>
				</a>
				<a class="book" href="/api/searchList2?type=title&keyword=${random.get(1).getTitle()}">
					<div class="card book-cont">
						<img src="${random.get(1).getImage()}" class="item-img"/>
					</div>
				</a>
				<a class="book" href="/api/searchList2?type=title&keyword=${random.get(2).getTitle()}">
					<div class="card book-cont">
						<img src="${random.get(2).getImage()}" class="item-img"/>
					</div>
				</a>
				<a class="book" href="/api/searchList2?type=title&keyword=${random.get(3).getTitle()}">
					<div class="card book-cont">
						<img src="${random.get(3).getImage()}" class="item-img"/>
					</div>
				</a>
			</div>
		</div>
	</div>
	<!-- 베스트 도서 -->
	
	<!-- 신간도서 -->
	<div class="content new-list">
		<div class="content-header">
			<h2 class="title">신간 도서</h2>
			<a class="link" href="/api/searchList">더보기</a>
		</div>
		<div class="content-body">
			<div class="row">
				<a class="book" href="/api/searchList2?type=title&keyword=${random.get(4).getTitle()}">
					<div class="card book-cont">
						<img src="${random.get(4).getImage()}" class="item-img"/>
					</div>
				</a>
				<a class="book" href="/api/searchList2?type=title&keyword=${random.get(5).getTitle()}">
					<div class="card book-cont">
						<img src="${random.get(5).getImage()}" class="item-img"/>
					</div>
				</a>
				<a class="book" href="/api/searchList2?type=title&keyword=${random.get(6).getTitle()}">
					<div class="card book-cont">
						<img src="${random.get(6).getImage()}" class="item-img"/>
					</div>
				</a>
				<a class="book" href="/api/searchList2?type=title&keyword=${random.get(7).getTitle()}">
					<div class="card book-cont">
						<img src="${random.get(7).getImage()}" class="item-img"/>
					</div>
				</a>
			</div>
		</div>
		<h2 class="title"></h2>
	</div>
	<!-- 신간도서 -->
	
	<!-- 추천도서-->
	<div class="content rec-list">
		<div class="content-header">
			<h2 class="title">추천 도서</h2>
			<a class="link" href="/api/searchList">더보기</a>
		</div>
		<div class="content-body">
			<div class="row">
				<a class="book" href="/api/searchList2?type=title&keyword=${random.get(8).getTitle()}">
					<div class="card book-cont">
						<img src="${random.get(8).getImage()}" class="item-img"/>
					</div>
				</a>
				<a class="book" href="/api/searchList2?type=title&keyword=${random.get(9).getTitle()}">
					<div class="card book-cont">
						<img src="${random.get(9).getImage()}" class="item-img"/>
					</div>
				</a>
				<a class="book" href="/api/searchList2?type=title&keyword=${random.get(10).getTitle()}">
					<div class="card book-cont">
						<img src="${random.get(10).getImage()}" class="item-img"/>
					</div>
				</a>
				<a class="book" href="/api/searchList2?type=title&keyword=${random.get(11).getTitle()}">
					<div class="card book-cont">
						<img src="${random.get(11).getImage()}" class="item-img"/>
					</div>
				</a>
			</div>
		</div>
	</div>
	<!-- 추천도서-->
