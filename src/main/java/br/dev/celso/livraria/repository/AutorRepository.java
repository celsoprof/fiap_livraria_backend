package br.dev.celso.livraria.repository;

import br.dev.celso.livraria.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
