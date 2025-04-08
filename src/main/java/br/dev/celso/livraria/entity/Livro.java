package br.dev.celso.livraria.entity;

import java.io.Serializable;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_livro")
public class Livro implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;

	private String isbn;
	private String titulo;

	@Column(length = 1000)
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "autor_id")
	@JsonBackReference("autor")
	private Autor autor;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	@JsonBackReference("categoria")
	private Categoria categoria;

	private String editora;
	private double valorMedio;

	public Livro(){}

	public Livro(Long id, String nome, Autor autor, Categoria categoria, String descricao, double valorMedio) {
		this.id = id;
		this.titulo = nome;
		this.autor = autor;
		this.categoria = categoria;
		this.descricao = descricao;
		this.valorMedio = valorMedio;
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public double getValorMedio() {
		return valorMedio;
	}

	public void setValorMedio(double valorMedio) {
		this.valorMedio = valorMedio;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
