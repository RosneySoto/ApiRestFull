package com.dom.apiRest.apiRestFull.handlets;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiErrorhandler {

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ErrorMessage devolverError(Exception e) {
		System.out.println(e.getMessage());
		System.out.println(e.getClass());
		ErrorMessage resp = new ErrorMessage(500, "Error controlado");
		return resp;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadRequest.class)
	@ResponseBody
	public ErrorMessage badRequest(BadRequest e) {
		ErrorMessage resp = new ErrorMessage(e.error);
		return resp;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFountException.class)
	@ResponseBody
	public ErrorMessage notFound(NotFountException e) {
		ErrorMessage resp = new ErrorMessage(e.getCode(), e.getMessage());
		return resp;
	}
}
