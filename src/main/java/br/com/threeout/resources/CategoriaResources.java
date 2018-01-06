package br.com.threeout.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.threeout.domain.Categoria;
import br.com.threeout.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResources {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Categoria categoriaFind = categoriaService.buscar(id);
		return ResponseEntity.ok().body(categoriaFind); 
		
		
	}
	
}
