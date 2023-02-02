package com.ebook.manage.vo;

public class UserVo {
	private int userIdx;
	private String userId;
	private String userPass;
	private String userName;
	private String userEmail;
	private String userPhone;
	private String joinDate;
	// 생성자
	public UserVo() {}
	public UserVo(int userIdx, String userId, String userPass, String userName, String userEmail, String userPhone,
			String joinDate) {
		this.userIdx = userIdx;
		this.userId = userId;
		this.userPass = userPass;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.joinDate = joinDate;
	}
	// getter, setter
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	// toString
	@Override
	public String toString() {
		return "UserVo [userIdx=" + userIdx + ", userId=" + userId + ", userPass=" + userPass + ", userName=" + userName
				+ ", userEmail=" + userEmail + ", userPhone=" + userPhone + ", joinDate=" + joinDate + "]";
	}
	
}
