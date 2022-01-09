package com.dom.apiRest.apiRestFull.handlets;

public class BadRequest extends RuntimeException {

	private int code;
	ErrorEnum error;


	public BadRequest(int code, String message) {
		super(message);
		this.code = code;
	}
	
	public BadRequest(ErrorEnum error) {
		super(error.getDescripcion());
		this.error = error;
	}
	

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
	
}
