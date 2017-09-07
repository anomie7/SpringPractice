package com.SpringBoard.domain;

import lombok.Data;

@Data
public class BoardVO {

	private int id;
	private String name;
	private String regdate;
	private String subject;
	private String content;
	private int count;
	private String searchKeyword;
	private String searchCondition;

}
