package edu.iot.common.exception;

public class PasswordMissmathchException extends Exception{

	public PasswordMissmathchException() {
		super("비밀번호가 일치하지 않습니다.");
	}
}
