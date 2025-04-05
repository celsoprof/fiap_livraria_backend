package br.dev.celso.livraria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.dev.celso.livraria.dto.AutorDTO;
import br.dev.celso.livraria.dto.LivroDTO;
import br.dev.celso.livraria.service.exception.EntityNotFound;
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
	
	public Optional<LivroDTO> findById(Long id) {
		Optional<Livro> livro = repository.findById(id);

		if (livro.isEmpty()){
			throw new EntityNotFound("O livro com id " + id + " não foi encontrado!");
		} else {
			LivroDTO livroDTO = new LivroDTO(livro.get());
			livroDTO.setAutor(new AutorDTO(livro.get().getAutor()));
			livroDTO.setCategoria(livro.get().getCategoria().getNome());
			return Optional.of(livroDTO);
		}

	}
	
	public List<LivroDTO> getAll() {
		List<Livro> livros = repository.findAll();
		List<LivroDTO> livrosDTO = new ArrayList<>();

		for (Livro livro : livros){
			LivroDTO dto = new LivroDTO();
			dto.setTitulo(livro.getTitulo());
			dto.setId(livro.getId());
			// Criar AutorDTO com base no Autor
			AutorDTO autorDTO = new AutorDTO(livro.getAutor());
			dto.setAutor(autorDTO);
			dto.setCategoria(livro.getCategoria().getNome());
			livrosDTO.add(dto);
		}
		return livrosDTO;
	}
	
	public Livro update(Livro livro) {
		Optional<Livro> newLivro = repository.findById(livro.getId());
		if (newLivro.isPresent()){
			return repository.save(livro);
		} else {
			throw new EntityNotFound("O livro com id " + livro.getId() + " não foi encontrado!");
		}
	}
}
