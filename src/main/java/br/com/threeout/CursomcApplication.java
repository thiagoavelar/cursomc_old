package br.com.threeout;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.threeout.domain.Categoria;
import br.com.threeout.domain.Produto;
import br.com.threeout.repositories.CategoriaRepository;
import br.com.threeout.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		Categoria categoriaInformatica = new Categoria(null, "Informática");
		Categoria categoriaEscritorio = new Categoria(null, "Escritório");
		
		Produto produto1 = new Produto(null, "Computador", 2000.0);
		Produto produto2 = new Produto(null, "Impressora", 800.0);
		Produto produto3 = new Produto(null, "Mouse", 30.0);
		
		categoriaInformatica.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		categoriaInformatica.getProdutos().addAll(Arrays.asList(produto2));
		
		produto1.getCategorias().add(categoriaInformatica);
		produto2.getCategorias().addAll(Arrays.asList(categoriaInformatica, categoriaEscritorio));
		produto3.getCategorias().add(categoriaInformatica);
		
		
		categoriaRepository.save(Arrays.asList(categoriaInformatica, categoriaEscritorio));
		produtoRepository.save(Arrays.asList(produto1, produto2, produto3));
		
	}
}
