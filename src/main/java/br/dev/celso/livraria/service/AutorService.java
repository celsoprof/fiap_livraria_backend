package br.dev.celso.livraria.service;

import br.dev.celso.livraria.entity.Autor;
import br.dev.celso.livraria.repository.AutorRepository;
import br.dev.celso.livraria.service.exception.EntityNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository repository;

	public Autor create(Autor autor) {
		return repository.save(autor);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Optional<Autor> findById(Long id) {
		Optional<Autor> autor = repository.findById(id);
		if (autor.isEmpty()){
			throw new EntityNotFound("O autor com id " + id + " não foi encontrado!");
		}
        return autor;
	}
	
	public List<Autor> getAll() {
		return repository.findAll();
	}
	
	public Autor update(Autor autor) {
		Optional<Autor> newAutor = repository.findById(autor.getId());
		if (newAutor.isEmpty()){
			throw new EntityNotFound("O autor com id " + autor.getId() + " não foi encontrado!");
		}
		return repository.save(autor);
	}
}
