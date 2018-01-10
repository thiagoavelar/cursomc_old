package br.com.threeout.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.threeout.domain.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
