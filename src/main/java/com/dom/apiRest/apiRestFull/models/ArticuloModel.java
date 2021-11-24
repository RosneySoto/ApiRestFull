package com.dom.apiRest.apiRestFull.models;

public class ArticuloModel {

	private long id;
	private String articulo;
	private String descripcion;
	
	public ArticuloModel() {
	}

	public ArticuloModel(String articulo, String descripcion) {
		this.articulo = articulo;
		this.descripcion = descripcion;
	}

	public ArticuloModel(long id, String articulo, String descripcion) {
		this.id = id;
		this.articulo = articulo;
		this.descripcion = descripcion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	
}
