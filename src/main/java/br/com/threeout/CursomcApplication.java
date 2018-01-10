package br.com.threeout;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.threeout.domain.Categoria;
import br.com.threeout.domain.Cidade;
import br.com.threeout.domain.Estado;
import br.com.threeout.domain.Produto;
import br.com.threeout.repositories.CategoriaRepository;
import br.com.threeout.repositories.CidadeRepository;
import br.com.threeout.repositories.EstadoRepository;
import br.com.threeout.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
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
		
		Estado estado = new Estado(null, "Minas Gerais");
		Estado estado2 = new Estado(null, "São Paulo");
		
		Cidade c1= new Cidade(null,"Uberlândia", estado);
		Cidade c2= new Cidade(null,"São Paulo", estado2);
		
		estado.getCidades().add(c1);
		estado2.getCidades().add(c2);
		
		categoriaRepository.save(Arrays.asList(categoriaInformatica, categoriaEscritorio));
		produtoRepository.save(Arrays.asList(produto1, produto2, produto3));
		estadoRepository.save(Arrays.asList(estado, estado2));
		cidadeRepository.save(Arrays.asList(c1, c2));
		
	}
}
