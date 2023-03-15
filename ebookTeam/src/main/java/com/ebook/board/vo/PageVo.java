package com.ebook.board.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PageVo {
	//게시판
	private int postKey;
	private String postTitle;
	private String postContent;
	private String postDate;
	private String userId;
	private String postCategory;
	private int postViewCount;
	private String postFileUrl;
	private int sorting;
	private int bNum;
	private int lvl;
	private int step;
	private int nref;
	// 파일
	private int file_num; // 파일번호
	private String fileName; // 파일명
	private String fileExt; // 파일확장자
	private String sFileName; // 실제 저장 파일
	// 검색
	private String bSearchType = "";
	private String bKeyWord = "";	
    // 도서 요청
	private int req_key;
	private String req_book;
	private String req_date;
	private String req_cont;
	private String req_process;
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
	
	/*
	 * private boolean isShowPagePrev; private boolean isShowPageNext;
	 */
	private boolean showPagePrev;
	private boolean showPageNext;
	// 생성자
	public PageVo() {}
	public PageVo(int postKey, String postTitle, String postContent, String postDate, String userId,
			String postCategory, int postViewCount, String postFileUrl, int sorting, int bNum, int lvl, int step,
			int nref, int file_num, String fileName, String fileExt, String sFileName, String bSearchType,
			String bKeyWord, int req_key, String req_book, String req_date, String req_cont, String req_process,
			int nowPage, int prevNowPage, int nextNowPage, int totalCount, int totalPageCount, int pageStartNum,
			int pagEendNum, int pageGrpNum, int pageCount, boolean showPagePrev, boolean showPageNext) {
		this.postKey = postKey;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postDate = postDate;
		this.userId = userId;
		this.postCategory = postCategory;
		this.postViewCount = postViewCount;
		this.postFileUrl = postFileUrl;
		this.sorting = sorting;
		this.bNum = bNum;
		this.lvl = lvl;
		this.step = step;
		this.nref = nref;
		this.file_num = file_num;
		this.fileName = fileName;
		this.fileExt = fileExt;
		this.sFileName = sFileName;
		this.bSearchType = bSearchType;
		this.bKeyWord = bKeyWord;
		this.req_key = req_key;
		this.req_book = req_book;
		this.req_date = req_date;
		this.req_cont = req_cont;
		this.req_process = req_process;
		this.nowPage = nowPage;
		this.prevNowPage = prevNowPage;
		this.nextNowPage = nextNowPage;
		this.totalCount = totalCount;
		this.totalPageCount = totalPageCount;
		this.pageStartNum = pageStartNum;
		this.pagEendNum = pagEendNum;
		this.pageGrpNum = pageGrpNum;
		this.pageCount = pageCount;
		this.showPagePrev = showPagePrev;
		this.showPageNext = showPageNext;
	}
	//
	public int getPostKey() {
		return postKey;
	}
	public void setPostKey(int postKey) {
		this.postKey = postKey;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPostCategory() {
		return postCategory;
	}
	public void setPostCategory(String postCategory) {
		this.postCategory = postCategory;
	}
	public int getPostViewCount() {
		return postViewCount;
	}
	public void setPostViewCount(int postViewCount) {
		this.postViewCount = postViewCount;
	}
	public String getPostFileUrl() {
		return postFileUrl;
	}
	public void setPostFileUrl(String postFileUrl) {
		this.postFileUrl = postFileUrl;
	}
	public int getSorting() {
		return sorting;
	}
	public void setSorting(int sorting) {
		this.sorting = sorting;
	}
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getNref() {
		return nref;
	}
	public void setNref(int nref) {
		this.nref = nref;
	}
	public int getFile_num() {
		return file_num;
	}
	public void setFile_num(int file_num) {
		this.file_num = file_num;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileExt() {
		return fileExt;
	}
	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}
	public String getsFileName() {
		return sFileName;
	}
	public void setsFileName(String sFileName) {
		this.sFileName = sFileName;
	}
	public String getbSearchType() {
		return bSearchType;
	}
	public void setbSearchType(String bSearchType) {
		this.bSearchType = bSearchType;
	}
	public String getbKeyWord() {
		return bKeyWord;
	}
	public void setbKeyWord(String bKeyWord) {
		this.bKeyWord = bKeyWord;
	}
	public int getReq_key() {
		return req_key;
	}
	public void setReq_key(int req_key) {
		this.req_key = req_key;
	}
	public String getReq_book() {
		return req_book;
	}
	public void setReq_book(String req_book) {
		this.req_book = req_book;
	}
	public String getReq_date() {
		return req_date;
	}
	public void setReq_date(String req_date) {
		this.req_date = req_date;
	}
	public String getReq_cont() {
		return req_cont;
	}
	public void setReq_cont(String req_cont) {
		this.req_cont = req_cont;
	}
	public String getReq_process() {
		return req_process;
	}
	public void setReq_process(String req_process) {
		this.req_process = req_process;
	}
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
	//
	@Override
	public String toString() {
		return "PageVo [postKey=" + postKey + ", postTitle=" + postTitle + ", postContent=" + postContent
				+ ", postDate=" + postDate + ", userId=" + userId + ", postCategory=" + postCategory
				+ ", postViewCount=" + postViewCount + ", postFileUrl=" + postFileUrl + ", sorting=" + sorting
				+ ", bNum=" + bNum + ", lvl=" + lvl + ", step=" + step + ", nref=" + nref + ", file_num=" + file_num
				+ ", fileName=" + fileName + ", fileExt=" + fileExt + ", sFileName=" + sFileName + ", bSearchType="
				+ bSearchType + ", bKeyWord=" + bKeyWord + ", req_key=" + req_key + ", req_book=" + req_book
				+ ", req_date=" + req_date + ", req_cont=" + req_cont + ", req_process=" + req_process + ", nowPage="
				+ nowPage + ", prevNowPage=" + prevNowPage + ", nextNowPage=" + nextNowPage + ", totalCount="
				+ totalCount + ", totalPageCount=" + totalPageCount + ", pageStartNum=" + pageStartNum + ", pagEendNum="
				+ pagEendNum + ", pageGrpNum=" + pageGrpNum + ", pageCount=" + pageCount + ", showPagePrev="
				+ showPagePrev + ", showPageNext=" + showPageNext + "]";
	}
	
	
	
}
