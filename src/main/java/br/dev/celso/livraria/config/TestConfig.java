package br.dev.celso.livraria.config;

import br.dev.celso.livraria.entity.Autor;
import br.dev.celso.livraria.entity.Livro;
import br.dev.celso.livraria.repository.AutorRepository;
import br.dev.celso.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
//@Profile(value = "test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public void run(String... args) throws Exception {

        Autor a1 = new Autor(null, "Paulo Coelho");
        Autor a2 = new Autor(null, "Machado de Assis");
        Autor a3 = new Autor(null, "Cora Coralina");

        autorRepository.saveAll(Arrays.asList(a1, a2, a3));

        Livro l1 = new Livro(null, "O Alquimista", a1);
        Livro l2 = new Livro(null, "Dom Casmurro", a2);
        Livro l3 = new Livro(null, "Amor de perdição", a2);
        Livro l4 = new Livro(null, "Onze Minutos", a1);
        Livro l5 = new Livro(null, "Maktub", a1);

        livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));

    }
}
