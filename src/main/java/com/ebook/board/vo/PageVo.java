package com.ebook.board.vo;

public class PageVo {
	//paging 처리를 위해 추가
	private int nowPage; //현재페이지
	private int prevNowPage; //이전 10개를 클릭시 적용되는 nowpage
	private int nextNowPage; //다음 10개를 클릭시 적용되는  nowpage
	
	private int totalCount; //전체 ROW 수
	private int totalPageCount; //화면에 보여줄 페이지 수
	private int pageStartNum; //화면에 보여줄 페이지 시작 숫자
	private int pagEendNum; //화면에 보여줄 페이지 마지막 숫자
	private int pageGrpNum; //페이지 그룹 숫자
	private int pageCount; //한페이지에 보여줄 ROW 숫자
	
	private boolean isShowPagePrev;
	private boolean isShowPageNext;
	// 생성자
	public PageVo() {}
	public PageVo(int nowPage, int prevNowPage, int nextNowPage, int totalCount, int totalPageCount, int pageStartNum,
			int pagEendNum, int pageGrpNum, int pageCount, boolean isShowPagePrev, boolean isShowPageNext) {
		this.nowPage = nowPage;
		this.prevNowPage = prevNowPage;
		this.nextNowPage = nextNowPage;
		this.totalCount = totalCount;
		this.totalPageCount = totalPageCount;
		this.pageStartNum = pageStartNum;
		this.pagEendNum = pagEendNum;
		this.pageGrpNum = pageGrpNum;
		this.pageCount = pageCount;
		this.isShowPagePrev = isShowPagePrev;
		this.isShowPageNext = isShowPageNext;
	}
	//
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
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
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getPageStartNum() {
		return pageStartNum;
	}
	public void setPageStartNum(int pageStartNum) {
		this.pageStartNum = pageStartNum;
	}
	public int getPagEendNum() {
		return pagEendNum;
	}
	public void setPagEendNum(int pagEendNum) {
		this.pagEendNum = pagEendNum;
	}
	public int getPageGrpNum() {
		return pageGrpNum;
	}
	public void setPageGrpNum(int pageGrpNum) {
		this.pageGrpNum = pageGrpNum;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public boolean isShowPagePrev() {
		return isShowPagePrev;
	}
	public void setShowPagePrev(boolean isShowPagePrev) {
		this.isShowPagePrev = isShowPagePrev;
	}
	public boolean isShowPageNext() {
		return isShowPageNext;
	}
	public void setShowPageNext(boolean isShowPageNext) {
		this.isShowPageNext = isShowPageNext;
	}
	//
	@Override
	public String toString() {
		return "PageVo [nowPage=" + nowPage + ", prevNowPage=" + prevNowPage + ", nextNowPage=" + nextNowPage
				+ ", totalCount=" + totalCount + ", totalPageCount=" + totalPageCount + ", pageStartNum=" + pageStartNum
				+ ", pagEendNum=" + pagEendNum + ", pageGrpNum=" + pageGrpNum + ", pageCount=" + pageCount
				+ ", isShowPagePrev=" + isShowPagePrev + ", isShowPageNext=" + isShowPageNext + "]";
	}
	
}
