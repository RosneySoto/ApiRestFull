package com.dom.apiRest.apiRestFull.handlets;

public class NotFountException extends RuntimeException {
	
	private int code;
	
	public NotFountException() {
		super();
	}

	public NotFountException(int code, String message) {
		super(message);
		this.code = code;
	}
	
	public NotFountException(ErrorEnum error) {
		super(error.getDescripcion());
		this.code = error.getCode();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	
	
	
	

}
