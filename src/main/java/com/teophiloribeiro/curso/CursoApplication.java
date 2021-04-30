package com.teophiloribeiro.curso;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.teophiloribeiro.curso.domain.Categoria;
import com.teophiloribeiro.curso.domain.Cidade;
import com.teophiloribeiro.curso.domain.Cliente;
import com.teophiloribeiro.curso.domain.Endereco;
import com.teophiloribeiro.curso.domain.Estado;
import com.teophiloribeiro.curso.domain.Produto;
import com.teophiloribeiro.curso.domain.enums.TipoCliente;
import com.teophiloribeiro.curso.repositories.CategoriaRepository;
import com.teophiloribeiro.curso.repositories.CidadeRepository;
import com.teophiloribeiro.curso.repositories.ClienteRepository;
import com.teophiloribeiro.curso.repositories.EnderecoRepository;
import com.teophiloribeiro.curso.repositories.EstadoRepository;
import com.teophiloribeiro.curso.repositories.ProdutoRepository;

//INSTANCIAR O BD ASSIM QUE A APLICAÇÃO INICIAR

@SpringBootApplication
public class CursoApplication implements CommandLineRunner{
	
	//-----REPOSITORIES------
	
	//CATEGORIA E PRODUTO
	@Autowired // instanciado automaticamente
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	//CIDADE E ESTADO
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	//CLIENTE E ENDERECO
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	//-----REPOSITORIES------
	
	public static void main(String[] args) {
		SpringApplication.run(CursoApplication.class, args);
	}
	
	//Metodo para instanciar o BD com as categorias e produtos
	@Override
	public void run(String... args) throws Exception {
		
		//CATEGORIA E PRODUTO
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		//ESTADO E CIDADE
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		//CLIENTE E ENDERECO
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		
		//Repository categoria
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
		//Criar repositorio dos produtos (produtoRepository) e salvar os produtos
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		//Repository das cidades e estados
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		//Cliente e Endereco
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		
		
		
	}
	

}
