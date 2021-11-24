package com.dom.apiRest.apiRestFull.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dom.apiRest.apiRestFull.models.ArticuloModel;
import com.dom.apiRest.apiRestFull.services.ArticuloService;

@RestController
@RequestMapping("/articulos")
public class ArticuloController {
	
	@Autowired
	ArticuloService artServices;
	
	@GetMapping(path="/{id}")
	public ArticuloModel obtenerArticulo(Integer id) {
		return artServices.obtenerArticulo(id);
	}
	
	@GetMapping()
	public ArrayList<ArticuloModel> listarArticulos(ArticuloModel articulos){
		return artServices.obtenerAticulos();
	}
	
	@PostMapping()
	public ArticuloModel insertArticulo(@RequestBody ArticuloModel articulo) {
		return artServices.insetarArticulo(articulo);
	}

}
