package com.dom.apiRest.apiRestFull.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.*;

import com.dom.apiRest.apiRestFull.handlets.BadRequest;
import com.dom.apiRest.apiRestFull.handlets.ErrorEnum;
import com.dom.apiRest.apiRestFull.models.UsuarioLoginModel;
import com.dom.apiRest.apiRestFull.models.UsuarioModels;
import com.dom.apiRest.apiRestFull.repositories.UsuarioRepository;
import com.dom.apiRest.apiRestFull.security.JwtTokenUtil;

@Service
public class UsuarioServices {
	
	@Autowired
	JwtTokenUtil jwt;
	@Autowired
	private UsuarioRepository userRepository;
	
	private ArrayList<UsuarioModels> usuariosMock = new ArrayList<>();
	private Integer idContador = 0;
	
	
	/*
	//Devuelve un usuario
	public ArrayList<UsuarioModels> getUsuario(Integer id) throws Exception { //Muestra un usuario
		System.out.println("Estoy Bucando el usuario con el ID " + id);
		return null;
		/*
		for (UsuarioModels usuarios : usuariosMock) {
			if(usuarios.getId()==id) {
				System.out.println(usuarios.getNombre() + " " + usuarios.getApellido());
				return usuariosMock;
			}else {
				return null;
			}
		}
		
		return usuariosMock;
		*/
		/*
		usuariosMock = (ArrayList<UsuarioModels>) usuariosMock.stream().filter(u -> u.getId());
		System.out.println(usuariosMock);
		return usuariosMock;
		*/
		/*if(id != 1) {
			throw new NotFountException(ErrorEnum.usuarioInvalido);
		}
		UsuarioModels user = new UsuarioModels("jose", "Soto", "jose.soto@gmail.com", 1);
		return user;
		
	}
	*/
	
	
	
	public ArrayList<UsuarioModels> getUsuarios(){ //Muestra una lista de usuarios
		return usuariosMock;
	}
	
	public UsuarioModels insertarUsuario(UsuarioModels usuario) { //Inserta un usuario
		if (usuario.getId() != 0){
			throw new BadRequest(ErrorEnum.idIncorrecto);
		}
		//idContador++;
		//usuario.setId(idContador);
		//usuariosMock.add(usuario);
		userRepository.save(usuario); // Con esto creo el usuario en la base de datos
		return usuario;		
	}
	
	public ArrayList<UsuarioModels> deleteUsuario(Integer id) { //busca un usiario por ID, lo filtra y lo elimina
		System.out.println("Estoy eliminando el usuario con el ID " + id);
		usuariosMock = (ArrayList<UsuarioModels>) usuariosMock.stream().filter(usuario->usuario.getId() != id).collect(Collectors.toList());
		return usuariosMock;
	}
	
	public String loginUsuario(UsuarioLoginModel usuario) throws IOException {
		if(usuario.getEmail().equals("jose.soto@mail.com") && usuario.getPassword().equals("123")) {
			return jwt.GenerateToken(usuario);
		}else {
			HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
			response.sendError(HttpStatus.UNAUTHORIZED.value(), "Credenciales Invalidas");
			return null;
		}
	}

}
