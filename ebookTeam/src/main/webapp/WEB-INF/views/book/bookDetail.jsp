<div class="modal modal-m" id="detailmodal">
	<div class="modal-content">
		<div class="modal-header">
			<h3 id="book_title"></h3>
			<div>
				<img id="modalClose" class="ico" src="/img/icon/icon-close.svg"/>
			</div>
		</div>
		<div class="modal-body">
			<form id="detail-form" class="detail-form">
				<div class="detail">
					<div class="book-image" id="book_image" style="height:400px;width: 200px">
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
