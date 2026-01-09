package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


	public interface RepositorioCliente extends CrudRepository<Cliente, Long> {//tipo de la entidad/tipo clave primaria
	
		 List<Cliente> findByApellido(String apellido);

		    Cliente findById(long id);
	
	}
