package com.teophiloribeiro.curso.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Controlador Rest que vai responder pelo endpoint categorias
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		return "REST esta funcionando!!";
	}
	
	
}
