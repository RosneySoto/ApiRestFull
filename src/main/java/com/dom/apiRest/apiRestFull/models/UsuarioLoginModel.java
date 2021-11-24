package com.dom.apiRest.apiRestFull.models;

public class UsuarioLoginModel {
	
	private String email;
	private String password;
	
	public UsuarioLoginModel() {
		super();
	}
	
	public UsuarioLoginModel(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
