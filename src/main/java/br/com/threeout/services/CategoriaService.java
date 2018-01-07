package br.com.threeout.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.threeout.domain.Categoria;
import br.com.threeout.repositories.CategoriaRepository;
import br.com.threeout.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria buscar(Integer id) {
		Categoria categoria = categoriaRepository.findOne(id);
		if (categoria == null) {
			throw new ObjectNotFoundException(
					"Objeto não encotrado! Id: " + id + " Tipo: " + Categoria.class.getName());
		}
		return categoria;
	}

}
