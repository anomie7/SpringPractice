package com.SpringBoard.exceptions;

public class IdNotMatchException extends LoginException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg = "아이디가 존재하지 않습니다.";

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return msg;
	}
}
