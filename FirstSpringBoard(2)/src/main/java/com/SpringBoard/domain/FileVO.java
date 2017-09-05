package com.SpringBoard.domain;

public class FileVO {
	private int fno;
	private int boardId;
	private long fileSize;
	private String StoredFileName;
	private String OriginalFileName;

	public int getFno() {
		return fno;
	}
	
	public void setFno(int fno) {
		this.fno = fno;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long l) {
		this.fileSize = l;
	}

	public String getStoredFileName() {
		return StoredFileName;
	}

	public void setStoredFileName(String storedFileName) {
		StoredFileName = storedFileName;
	}

	public String getOriginalFileName() {
		return OriginalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		OriginalFileName = originalFileName;
	}

	@Override
	public String toString() {
		return "FileVO [fno=" + fno + ", boardId=" + boardId + ", fileSize=" + fileSize + ", StoredFileName="
				+ StoredFileName + ", OriginalFileName=" + OriginalFileName + "]";
	}

}
