package com.dom.apiRest.apiRestFull.controllers;

import java.io.IOException;
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

import com.dom.apiRest.apiRestFull.models.UsuarioLoginModel;
import com.dom.apiRest.apiRestFull.models.UsuarioModels;
import com.dom.apiRest.apiRestFull.services.UsuarioServices;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControllers {
	
	@Autowired
	UsuarioServices userServices;
	
	//Metodo GET http://localhost:8081/usuarios
	@GetMapping(path = "/{id}") //Busca el usuario por ID
	public ResponseEntity<UsuarioModels> obtenerUsuario(@PathVariable("id") Integer id) throws IOException { //Devuelve un usario por eso el metodo es UsuarioModels
		return new ResponseEntity<>(userServices.getUsuario(id),HttpStatus.OK);
	}
	
	@GetMapping()
	public ArrayList<UsuarioModels> obetenerUsuarios(){ //Trae una lista de usuarios
		return userServices.getUsuarios();
	}
	
	@PostMapping()
	public UsuarioModels insertarUsuario(@RequestBody UsuarioModels usuario) { //Con el Request aviso que va a llegar un usuario de tipo UsuarioModels
		return userServices.insertarUsuario(usuario);
	}
	
	
	@PostMapping(path ="/login") //loguea un usaurio con credenciales
	public ResponseEntity<String> autenticarUsuario(@RequestBody UsuarioLoginModel usuario) throws IOException{
		return new ResponseEntity<String>(userServices.loginUsuario(usuario),HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ArrayList<UsuarioModels> eliminarUsuario(@PathVariable("id")Integer id) {
		return userServices.deleteUsuario(id);
	}
	
	
	
	
	
	
	
}
