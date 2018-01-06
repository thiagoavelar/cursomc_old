package br.com.threeout.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.threeout.domain.Categoria;
import br.com.threeout.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Integer id) {
		Categoria categoria =  categoriaRepository.findOne(id);
		return categoria;
	}
	
}
