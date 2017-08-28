package com.SpringBoard.domain;

public class UserVO {
	private String id;
	private String password;
	private String email;
	private String tel;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", email=" + email + ", tel=" + tel + "]";
	}

}
