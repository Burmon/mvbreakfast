package com.desafio.projetocafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.desafio.projetocafe.models.Registro;

public interface RegistroRepository extends CrudRepository<Registro, String > {

	
	 @Query(nativeQuery = true,
	           value = "select * " +
	                   "from Registro " +
	                    "where cpf = ?1 or item = ?2 ")

	 List<Registro> cadastroselect(String cpf, String item); 
	
	
}


