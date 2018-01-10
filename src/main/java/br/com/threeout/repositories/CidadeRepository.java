package br.com.threeout.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.threeout.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}
