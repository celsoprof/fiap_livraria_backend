package br.dev.celso.livraria.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_livro")
public class Livro implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;

	private String nome;

	@ManyToOne
	@JoinColumn(name = "autor_id")
	@JsonBackReference
	private Autor autor;

}
