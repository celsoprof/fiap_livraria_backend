package br.dev.celso.livraria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.dev.celso.livraria.dto.LivroDTO;
import br.dev.celso.livraria.service.exception.EntityNotFound;
import org.springframework.beans.BeanUtils;
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
		Optional<Livro> livro = repository.findById(id);

		if (livro.isEmpty()){
			throw new EntityNotFound("O livro com id " + id + " não foi encontrado!");
		} else {
			return livro;
		}

	}

	public Optional<LivroDTO> findByIdd(Long id){
		Optional<Livro> livro = repository.findById(id);
		LivroDTO livroDTO = new LivroDTO();
		if (!livro.isEmpty()){
			livroDTO.setId(livro.get().getId());
			livroDTO.setIsbn(livro.get().getIsbn());
			livroDTO.setTitulo(livro.get().getTitulo());
			livroDTO.setAutor(livro.get().getAutor().getNome());
			livroDTO.setEditora(livro.get().getEditora());
			livroDTO.setValorMedio(livro.get().getValorMedio());
			livroDTO.setCategoria(livro.get().getCategoria().getNome());
			livroDTO.setDescricao(livro.get().getDescricao());
			livroDTO.setValorMedio(livro.get().getValorMedio());
			return Optional.of(livroDTO);
		} else {
			throw new EntityNotFound("O livro com id " + id + " não foi encontrado!");
		}
	}
	
	public List<Livro> getAll() {
		List<Livro> livros = repository.findAll();
		return livros;
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
