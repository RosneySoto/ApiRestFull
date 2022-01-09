package com.dom.apiRest.apiRestFull.handlets;

public enum ErrorEnum {
	
	usuarioInvalido(101, "usuario inexistente"),
	idIncorrecto(201, "Se debe ingresar ID en cero (0) para crear un usuario"),
	NoAutorizado(202, "Usuario o contraseña invalidos");
	

	private int code;
	private String descripcion;
	
	private ErrorEnum(int code, String descripcion) {
		this.code = code;
		this.descripcion = descripcion;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	
	
	
	
	
	
}
