package br.dev.celso.livraria.entity;

import java.io.Serializable;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_livro")
public class Livro implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;

	private String titulo;

	@ManyToOne
	@JoinColumn(name = "autor_id")
	@JsonBackReference
	private Autor autor;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	@JsonBackReference
	private Categoria categoria;

	public Livro(){}

	public Livro(Long id, String nome, Autor autor, Categoria categoria) {
		this.id = id;
		this.titulo = nome;
		this.autor = autor;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Livro livro = (Livro) o;
		return Objects.equals(id, livro.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}
