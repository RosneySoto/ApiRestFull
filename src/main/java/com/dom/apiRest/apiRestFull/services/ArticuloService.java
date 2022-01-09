package com.dom.apiRest.apiRestFull.services;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dom.apiRest.apiRestFull.handlets.NotFountException;
import com.dom.apiRest.apiRestFull.models.ArticuloModel;


@Service
public class ArticuloService {

	private ArrayList<ArticuloModel> articulosMock = new ArrayList<>();
	private int idContador;
	
	public ArrayList<ArticuloModel> obtenerArticulo(Integer id) {
		if(id!=1) {
			throw new NotFountException();
		}else {
		System.out.println("Estoy buscando el articulo con el ID " + id);
		ArticuloModel art = new ArticuloModel(1, "Cafe", "Cafe en granos");
		articulosMock.stream().filter(u->u.getId()==id).collect(Collectors.toList());
		return articulosMock;
		}
	}
	
	public ArrayList<ArticuloModel> obtenerAticulos(){
		return articulosMock;
	}
	
	public ArticuloModel insetarArticulo(ArticuloModel articulo) {
		if(articulo.getId() != 0) {
			throw new NotFountException(500, "El ID no puede ser mayor a 0");
		}else {
		idContador++;
		articulo.setId(idContador);
		articulosMock.add(articulo);
		return articulo;	
		}
	}
	
	public ArrayList<ArticuloModel> deleteArticulo (Integer id){
		System.out.println("Estoy eliminando el usuario con el ID " + id);
		articulosMock = (ArrayList<ArticuloModel>) articulosMock.stream().filter(articulo->articulo.getId() != id).collect(Collectors.toList());
		return articulosMock;
	}
}
