package com.ebook.board.vo;

public class CommentVo {
	private int commIdx;
	private int postKey;
	private String postCategory;
	private String userId;
	private String commCont;
	private String commDate;
	private String commCount;
  // 생성자
  	public CommentVo() {}
  	public CommentVo(int commIdx, int postKey, String postCategory, String userId, String commCont, String commDate,
		String commCount) {
	this.commIdx = commIdx;
	this.postKey = postKey;
	this.postCategory = postCategory;
	this.userId = userId;
	this.commCont = commCont;
	this.commDate = commDate;
	this.commCount = commCount;
  	}
	// GETTER, SETTER
	public int getCommIdx() {
		return commIdx;
	}
	public void setCommIdx(int commIdx) {
		this.commIdx = commIdx;
	}
	public int getPostKey() {
		return postKey;
	}
	public void setPostKey(int postKey) {
		this.postKey = postKey;
	}
	public String getPostCategory() {
		return postCategory;
	}
	public void setPostCategory(String postCategory) {
		this.postCategory = postCategory;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCommCont() {
		return commCont;
	}
	public void setCommCont(String commCont) {
		this.commCont = commCont;
	}
	public String getCommDate() {
		return commDate;
	}
	public void setCommDate(String commDate) {
		this.commDate = commDate;
	}
	public String getCommCount() {
		return commCount;
	}
	public void setCommCount(String commCount) {
		this.commCount = commCount;
	}
	// TOSTRING
	@Override
	public String toString() {
		return "CommentVo [commIdx=" + commIdx + ", postKey=" + postKey + ", postCategory=" + postCategory + ", userId="
				+ userId + ", commCont=" + commCont + ", commDate=" + commDate + ", commCount=" + commCount + "]";
	}

	
}	
