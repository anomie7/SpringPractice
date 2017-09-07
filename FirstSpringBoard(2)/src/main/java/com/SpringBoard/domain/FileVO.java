package com.SpringBoard.domain;

import lombok.Data;

@Data
public class FileVO {
	private int fno;
	private int boardId;
	private long fileSize;
	private String StoredFileName;
	private String OriginalFileName;

}
