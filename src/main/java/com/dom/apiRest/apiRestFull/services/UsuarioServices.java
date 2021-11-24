package com.dom.apiRest.apiRestFull.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.*;

import com.dom.apiRest.apiRestFull.models.UsuarioLoginModel;
import com.dom.apiRest.apiRestFull.models.UsuarioModels;

@Service
public class UsuarioServices {
	
	private ArrayList<UsuarioModels> usuariosMock = new ArrayList<>();
	private Integer idContador = 0;
	
	//Devuelve un usuario
	public UsuarioModels getUsuario(Integer id) throws IOException { //Muestra un usuario
		
		//validacion logica si el usuario y su id es distinto a 1 devolver un error con httoStatus.notfound
		UsuarioModels user = new UsuarioModels("jose", "Soto", "jose.soto@gmail.com", 1);
		if(id != 1) {
			HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
			response.sendError(HttpStatus.NOT_FOUND.value(), "Usuario Inexistente");
			return null;
		}else {
			return user;
		}
	}
	
	public ArrayList<UsuarioModels> getUsuarios(){ //Muestra una lista de usuarios
		return usuariosMock;
	}
	
	public UsuarioModels insertarUsuario(UsuarioModels usuario) { //Inserta un usuario
		idContador++;
		usuario.setId(idContador);
		usuariosMock.add(usuario);
		return usuario;		
	}
	
	public ArrayList<UsuarioModels> deleteUsuario(Integer id) { //busca un usiario por ID, lo filtra y lo elimina
		System.out.println("Estoy eliminando el usuario con el ID " + id);
		usuariosMock = (ArrayList<UsuarioModels>) usuariosMock.stream().filter(usuario->usuario.getId() != id).collect(Collectors.toList());
		return usuariosMock;
	}
	
	public String loginUsuario(UsuarioLoginModel usuario) throws IOException {
		if(usuario.getEmail().equals("jose.soto@mail.com") && usuario.getPassword().equals("123")) {
			return "Acceso confirmado";
		}else {
			HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
			response.sendError(HttpStatus.UNAUTHORIZED.value(), "Credenciales Invalidas");
			return null;
		}
	}

}
