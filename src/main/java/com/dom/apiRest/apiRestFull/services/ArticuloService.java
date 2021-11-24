package com.dom.apiRest.apiRestFull.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.dom.apiRest.apiRestFull.models.ArticuloModel;

@Service
public class ArticuloService {

	private ArrayList<ArticuloModel> articulosMock = new ArrayList<>();
	private int idContador;
	
	public ArticuloModel obtenerArticulo(Integer id) {
		ArticuloModel art = new ArticuloModel(1, "Cafe", "Cafe en granos");
		return art;
	}
	
	public ArrayList<ArticuloModel> obtenerAticulos(){
		return articulosMock;
	}
	
	public ArticuloModel insetarArticulo(ArticuloModel articulo) {
		idContador++;
		articulo.setId(idContador);
		articulosMock.add(articulo);
		return articulo;
		
	}
}
