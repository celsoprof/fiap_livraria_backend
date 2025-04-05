package br.dev.celso.livraria.dto;

import br.dev.celso.livraria.entity.Livro;
import org.springframework.beans.BeanUtils;

public class LivroDTO {

    private Long id;
    private String titulo;
    private AutorDTO autor;
    private String categoria;

    public LivroDTO(Livro livro){
        BeanUtils.copyProperties(livro, this);
    }
    public LivroDTO(){}

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

    public AutorDTO getAutor() {
        return autor;
    }

    public void setAutor(AutorDTO autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
