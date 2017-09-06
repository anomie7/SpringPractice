package com.SpringBoard.exceptions;

public class PasswordNotMatchException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg = "비밀번호가 일치하지 않습니다.";

	@Override
	public String getMessage() {
		return msg;
	}
}
