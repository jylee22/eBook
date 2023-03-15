package com.ebook.board.service.impl;

import com.ebook.board.vo.PageVo;

public class BoardPaging {
	// Fields
		private  int      totalCount;       // 전체 Row 수
		private  int      nowPage;          // 현재 페이지 번호
		private  int      pageCount;        // 한 페이지에 출력될 row(line) 수 
		private  int      pageTotalCount;   // 한화면에 보여줄 총 페이지 번호 숫
		private  int      pageGrpNum;  
		    // 한화면에 보여질 페이지 그룹의 페이지 숫자
			
		private  int      prevNowPage;      // 이전페이지 번호
		private  int      nextNowPage;      // 다음페이지 번호
		
		private  int      startPageNum;    // 페이지 시작번호
		private  int      endPageNum;      // 페이지 끝번호
		
		private  int      totalRecordPageCount;  // totalCount / pageCount;
		  // 총 row 수 ( 전채자료수 )로 표현가능한 총 페이지 수 
		
		private boolean showPagePrev = true;   
		private boolean showPageNext = true;
		
		// 기본 생성자
		public BoardPaging() {
		}
		
		public BoardPaging(int nowpage, int pagecount, int totalcount,
				int pagetotalcount, int pagegrpnum) {
			this.nowPage        = nowpage;
			this.pageCount      = pagecount;
			this.totalCount     = totalcount;
			this.pageTotalCount = pagetotalcount;
			this.pageGrpNum     = pagegrpnum;		
		}

		// Getter / Setter
		public int getTotalCount() {
			return totalCount;
		}

		public void setTotalCount(int totalCount) {
			this.totalCount = totalCount;
		}

		public int getNowPage() {
			return nowPage;
		}

		public void setNowPage(int nowPage) {
			this.nowPage = nowPage;
		}

		public int getPageCount() {
			return pageCount;
		}

		public void setPageCount(int pageCount) {
			this.pageCount = pageCount;
		}

		public int getPageTotalCount() {
			return pageTotalCount;
		}

		public void setPageTotalCount(int pageTotalCount) {
			this.pageTotalCount = pageTotalCount;
		}

		public int getPageGrpNum() {
			return pageGrpNum;
		}

		public void setPageGrpNum(int pageGrpNum) {
			this.pageGrpNum = pageGrpNum;
		}

		public int getPrevNowPage() {
			return prevNowPage;
		}

		public void setPrevNowPage(int prevNowPage) {
			this.prevNowPage = prevNowPage;
		}

		public int getNextNowPage() {
			return nextNowPage;
		}

		public void setNextNowPage(int nextNowPage) {
			this.nextNowPage = nextNowPage;
		}

		public int getStartPageNum() {
			return startPageNum;
		}

		public void setStartPageNum(int startPageNum) {
			this.startPageNum = startPageNum;
		}

		public int getEndPageNum() {
			return endPageNum;
		}

		public void setEndPageNum(int endPageNum) {
			this.endPageNum = endPageNum;
		}

		public int getTotalRecordPageCount() {
			return totalRecordPageCount;
		}

		public void setTotalRecordPageCount(int totalRecordPageCount) {
			this.totalRecordPageCount = totalRecordPageCount;
		}

		public boolean isShowPagePrev() {
			return showPagePrev;
		}

		public void setShowPagePrev(boolean showPagePrev) {
			this.showPagePrev = showPagePrev;
		}

		public boolean isShowPageNext() {
			return showPageNext;
		}

		public void setShowPageNext(boolean showPageNext) {
			this.showPageNext = showPageNext;
		}
		

	    //------------------------------------------
		
		
		// Method
		public PageVo getPdsPagingInfo() {
			PageVo   page = new PageVo();
			
			// 76.0 /10.0 =? Math.ceil(7.6)
			this.totalRecordPageCount = 
				(int) Math.ceil ((double) totalCount / (double) pageCount) ;	
				
			//   startPageNum                       endPageNum
			//       1      2   3  4  5  6  7  8  9   10         ▶
			//  ◀   11     12  13 14 15 16 17 18 19   20         ▶
			//  ◀   21     22  23 24 25 26            30
			// 페이지 시작 번호
			this.startPageNum = 
				(pageGrpNum-1) * pageTotalCount + 1;	
						    
			// 페이지 끝 번호
			this.endPageNum   = 
				( totalRecordPageCount < (pageGrpNum * pageTotalCount) ) ?   		
				 totalRecordPageCount  :  (pageGrpNum * pageTotalCount);
			
			System.out.println("startNum : "  + startPageNum);
			System.out.println("endNum : "  + endPageNum);
			System.out.println("totalNum : "  + totalRecordPageCount);
			
			
			// ◀ [이전 10 개] [다음 10개] ▶ 출력 여부
			if( startPageNum == 1 ) 
				this.showPagePrev = false;
			if( endPageNum == totalRecordPageCount ) 
				this.showPageNext = false;
			
			// ◀  [이전 10 개] 클릭시 이동할 페이지 번호 계산
			this.prevNowPage = startPageNum - 1;
			// ▶  [다음 10 개] 클릭시 이동할 페이지 번호 계산
			this.nextNowPage = endPageNum   + 1;
			// 게산끝
			
			// 계산된 값을 page 에 저장
			page.setNowPage(this.nowPage);
			page.setPrevNowPage(this.prevNowPage);
			page.setNextNowPage(this.nextNowPage);
			
			page.setTotalCount(this.totalCount);
			page.setTotalPageCount(this.pageTotalCount);
			
			page.setPageStartNum(this.startPageNum);
			page.setPagEendNum(this.endPageNum);
			
			page.setPageCount(this.pageCount);
			page.setPageGrpNum(this.pageGrpNum);
			
			page.setShowPagePrev(this.showPagePrev);
			page.setShowPageNext(this.showPageNext);
			
		//	vo.setTotalRecordPageCount(this.totalRecordPageCount);

			return  page;
		}

		
}
