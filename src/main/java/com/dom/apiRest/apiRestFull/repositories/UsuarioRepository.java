package com.dom.apiRest.apiRestFull.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dom.apiRest.apiRestFull.models.UsuarioModels;

@Repository
public interface UsuarioRepository  extends CrudRepository<UsuarioModels, Integer>{

	public UsuarioModels findByusername(String username);
	
	public ArrayList<UsuarioModels> findall();
}