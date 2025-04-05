package br.dev.celso.livraria.service;

import br.dev.celso.livraria.dto.AutorDTO;
import br.dev.celso.livraria.entity.Autor;
import br.dev.celso.livraria.repository.AutorRepository;
import br.dev.celso.livraria.service.exception.EntityNotFound;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository repository;

	public AutorDTO create(AutorDTO autorDTO) {
		Autor autor = new Autor();
		BeanUtils.copyProperties(autorDTO, autor);
		return new AutorDTO(repository.save(autor));
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Optional<AutorDTO> findById(Long id) {
		Optional<Autor> autor = repository.findById(id);
		System.out.println("----->"+ autor.get().getNome());
		System.out.println("----->"+ autor.get().getCidadeNatal());
		System.out.println("----->"+ autor.get().getNome());
		AutorDTO dto = new AutorDTO();
		BeanUtils.copyProperties(autor.get(), dto);
		if (autor.isEmpty()){
			throw new EntityNotFound("O autor com id " + id + " não foi encontrado!");
		}
        return Optional.of(dto);
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
