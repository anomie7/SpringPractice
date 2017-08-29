package com.SpringBoard.domain;

public class BoardVO {
	
	private int id;
	private String name;
	private String regdate;
	private String subject;
	private String content;
	private int count;
	private String searchKeyword;
	private String searchCondition;
	
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

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", name=" + name + ", regDate=" + regdate + ", subject="
				+ subject + ", content=" + content + ", count=" + count + "]";
	}

}
