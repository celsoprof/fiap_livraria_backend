package br.dev.celso.livraria.dto;

import br.dev.celso.livraria.entity.Autor;
import br.dev.celso.livraria.entity.Livro;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AutorDTO {
    private Long id;
    private String nome;
    private String sobre;
    private String cidadeNatal;
    private LocalDate nascimento;
    private LocalDate falecimento;
    private List<Livro> livros = new ArrayList<>();

    public AutorDTO(Autor autor){
        BeanUtils.copyProperties(autor, this);
    }

    public AutorDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

    public String getCidadeNatal() {
        return cidadeNatal;
    }

    public void setCidadeNatal(String cidadeNatal) {
        this.cidadeNatal = cidadeNatal;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public LocalDate getFalecimento() {
        return falecimento;
    }

    public void setFalecimento(LocalDate falecimento) {
        this.falecimento = falecimento;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
