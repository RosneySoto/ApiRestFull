package com.dom.apiRest.apiRestFull.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ArrayList<ArticuloModel> obtenerArticulo(Integer id) {
		return artServices.obtenerArticulo(id);
	}
	
	@GetMapping()
	public ResponseEntity<ArrayList<ArticuloModel>> obtenerArticulos(){
		return new ResponseEntity<>(artServices.obtenerAticulos(),HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<ArticuloModel> insertarArticulo(@RequestBody ArticuloModel articulo){
		return new ResponseEntity<ArticuloModel>(artServices.insetarArticulo(articulo), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ArrayList<ArticuloModel> deleteArticulo(@PathVariable("id")Integer id) {
		return artServices.deleteArticulo(id);
	}

}
