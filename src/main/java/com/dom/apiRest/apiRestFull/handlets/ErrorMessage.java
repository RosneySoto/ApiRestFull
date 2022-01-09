package com.dom.apiRest.apiRestFull.handlets;

public class ErrorMessage {

	private int code;
	private String message;
	
	public ErrorMessage() {
		super();
	}
	public ErrorMessage(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public ErrorMessage(ErrorEnum error) {
		this.code = error.getCode();
		this.message = error.getDescripcion();
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
