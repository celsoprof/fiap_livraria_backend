package br.dev.celso.livraria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.celso.livraria.entity.Livro;
import br.dev.celso.livraria.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;

	public Livro create(Livro livro) {
		return repository.save(livro);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Optional<Livro> findById(Long id) {
        return repository.findById(id);
	}
	
	public List<Livro> getAll() {
		return repository.findAll();
	}
	
	public Livro update(Livro livro) {
		Optional<Livro> newLivro = repository.findById(livro.getId());
		if (newLivro.isPresent()){
			return repository.save(livro);
		} else {
			return null;
		}
	}
}
