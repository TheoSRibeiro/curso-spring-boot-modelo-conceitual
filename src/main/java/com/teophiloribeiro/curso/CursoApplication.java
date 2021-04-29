package com.teophiloribeiro.curso;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.teophiloribeiro.curso.domain.Categoria;
import com.teophiloribeiro.curso.repositories.CategoriaRepository;

//INSTANCIAR O BD ASSIM QUE A APLICAÇÃO INICIAR

@SpringBootApplication
public class CursoApplication implements CommandLineRunner{
	
	@Autowired // instanciado automaticamente
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoApplication.class, args);
	}
	
	//Metodo para instanciar o BD
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
		
	}
	

}
