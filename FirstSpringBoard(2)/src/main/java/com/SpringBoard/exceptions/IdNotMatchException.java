package com.SpringBoard.exceptions;

public class IdNotMatchException extends Exception {
	private String msg = "아이디가 존재하지 않습니다.";

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return msg;
	}
}
