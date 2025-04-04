package br.dev.celso.livraria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.dev.celso.livraria.entity.Livro;

@SpringBootApplication
public class LivrariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrariaApplication.class, args);
	}

}
