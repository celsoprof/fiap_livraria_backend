package br.dev.celso.livraria.repository;

import br.dev.celso.livraria.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
