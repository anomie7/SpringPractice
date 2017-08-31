package com.SpringBoard.domain;

public class CommendVO {
	private int boardId;
	private int commendNum;
	private String content;
	private String name;
	private int cno;

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getCommendNum() {
		return commendNum;
	}

	public void setCommendNum(int commendNum) {
		this.commendNum = commendNum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	@Override
	public String toString() {
		return "CommendVO [boardId=" + boardId + ", commendNum=" + commendNum + ", content=" + content + ", name="
				+ name + ", cno=" + cno + "]";
	}

}
