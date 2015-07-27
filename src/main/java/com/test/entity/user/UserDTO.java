package com.test.entity.user;

public class UserDTO {
	
	String userId;
	String passwd;
	String submit;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", passwd=" + passwd + ", submit="
				+ submit + "]";
	}
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDTO(String userId, String passwd, String submit) {
		super();
		this.userId = userId;
		this.passwd = passwd;
		this.submit = submit;
	}
	
	
	
	
}
