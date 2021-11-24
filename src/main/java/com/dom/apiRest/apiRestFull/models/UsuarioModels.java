package com.dom.apiRest.apiRestFull.models;

public class UsuarioModels {
	
	private String nombre;
	private String apellido;
	private String email;
	private long id;
	
	public UsuarioModels() {
		super();
	}
	
	public UsuarioModels(String nombre, String apellido, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}
	
	public UsuarioModels(String nombre, String apellido, String email, long id) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	

}
