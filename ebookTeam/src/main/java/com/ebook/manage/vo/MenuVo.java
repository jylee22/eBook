package com.ebook.manage.vo;

public class MenuVo {
	private int menu_seq;
	private int menu_ctgr;
	private String postCategory;
	private String menu_name;
	// 생성자
	public MenuVo() {}
	public MenuVo(int menu_seq, int menu_ctgr, String postCategory, String menu_name) {
		this.menu_seq = menu_seq;
		this.menu_ctgr = menu_ctgr;
		this.postCategory = postCategory;
		this.menu_name = menu_name;
	}
	// getter, setter
	public int getMenu_seq() {
		return menu_seq;
	}
	public void setMenu_seq(int menu_seq) {
		this.menu_seq = menu_seq;
	}
	public int getMenu_ctgr() {
		return menu_ctgr;
	}
	public void setMenu_ctgr(int menu_ctgr) {
		this.menu_ctgr = menu_ctgr;
	}
	public String getPostCategory() {
		return postCategory;
	}
	public void setPostCategory(String postCategory) {
		this.postCategory = postCategory;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	// toString
	@Override
	public String toString() {
		return "MenuVo [menu_seq=" + menu_seq + ", menu_ctgr=" + menu_ctgr + ", postCategory=" + postCategory
				+ ", menu_name=" + menu_name + "]";
	}
	
}
