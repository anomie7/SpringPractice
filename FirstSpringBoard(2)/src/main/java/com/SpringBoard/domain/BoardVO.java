package com.SpringBoard.domain;

public class BoardVO {
	
	private int id;
	private String name;
	private String password;
	private String regdate;
	private String subject;
	private String content;
	private int count;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegDate() {
		return regdate;
	}

	public void setRegDate(String regDate) {
		this.regdate = regDate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", name=" + name + ", password=" + password + ", regDate=" + regdate + ", subject="
				+ subject + ", content=" + content + ", count=" + count + "]";
	}

}
