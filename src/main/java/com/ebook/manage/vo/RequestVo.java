package com.ebook.manage.vo;

public class RequestVo {
	
  private int req_key;
  private String postCategory;
  private String req_book;
  private String req_date;
  private String userId;
  private String req_cont;
  private String req_process;
  // 생성자
  public RequestVo() {}
  public RequestVo(int req_key, String postCategory, String req_book, String req_date, String userId, String req_cont,
		String req_process) {
	super();
	this.req_key = req_key;
	this.postCategory = postCategory;
	this.req_book = req_book;
	this.req_date = req_date;
	this.userId = userId;
	this.req_cont = req_cont;
	this.req_process = req_process;
  }
  // getter, setter
	public int getReq_key() {
		return req_key;
	}
	public void setReq_key(int req_key) {
		this.req_key = req_key;
	}
	public String getPostCategory() {
		return postCategory;
	}
	public void setPostCategory(String postCategory) {
		this.postCategory = postCategory;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
  //toString
	@Override
	public String toString() {
		return "RequestVo [req_key=" + req_key + ", postCategory=" + postCategory + ", req_book=" + req_book
				+ ", req_date=" + req_date + ", userId=" + userId + ", req_cont=" + req_cont + ", req_process="
				+ req_process + "]";
	}
}
