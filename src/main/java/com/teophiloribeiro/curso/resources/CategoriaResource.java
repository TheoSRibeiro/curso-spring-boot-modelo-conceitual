package com.teophiloribeiro.curso.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teophiloribeiro.curso.domain.Categoria;
import com.teophiloribeiro.curso.services.CategoriaService;

//CONTROLADOR REST

// Controlador Rest que vai responder pelo endpoint categorias
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired //para instanciar automaticamente
	private CategoriaService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = service.buscar(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	
}
