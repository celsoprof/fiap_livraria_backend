package br.dev.celso.livraria.service;

import br.dev.celso.livraria.entity.Autor;
import br.dev.celso.livraria.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository repository;

	public Autor create(Autor Autor) {
		return repository.save(Autor);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Optional<Autor> findById(Long id) {
        return repository.findById(id);
	}
	
	public List<Autor> getAll() {
		return repository.findAll();
	}
	
	public Autor update(Autor Autor) {
		Optional<Autor> newAutor = repository.findById(Autor.getId());
		if (newAutor.isPresent()){
			return repository.save(Autor);
		} else {
			return null;
		}
	}
}
