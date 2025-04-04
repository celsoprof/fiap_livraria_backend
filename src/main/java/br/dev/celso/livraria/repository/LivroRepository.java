package br.dev.celso.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.celso.livraria.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
