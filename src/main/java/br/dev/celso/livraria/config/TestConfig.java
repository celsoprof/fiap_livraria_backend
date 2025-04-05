package br.dev.celso.livraria.config;

import br.dev.celso.livraria.entity.Autor;
import br.dev.celso.livraria.entity.Categoria;
import br.dev.celso.livraria.entity.Livro;
import br.dev.celso.livraria.repository.AutorRepository;
import br.dev.celso.livraria.repository.CategoriaRepository;
import br.dev.celso.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
//@Profile(value = "test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void run(String... args) throws Exception {

        Autor a1 = new Autor(null,
                "Paulo Coelho",
                "Paulo Coelho de Souza é um escritor, letrista, jornalista e compositor brasileiro. Ocupa a 21° cadeira da Academia Brasileira de Letras. O livro O Alquimista é considerado como um importante fenômeno literário do século XX, e já vendeu mais de 150 milhões de cópias, superando livros como Le Petit Prince.",
                "Rio de Janeiro",
                LocalDate.of(1999, 5, 1),
                LocalDate.of(2000, 8, 10)
        );

        Autor a2 = new Autor(null,
                "Machado de Assis",
                "Joaquim Maria Machado de Assis foi um escritor brasileiro, amplamente reconhecido por críticos, estudiosos, escritores e leitores como o maior expoente da literatura brasileira.",
                "Rio de Janeiro, Rio de Janeiro",
                LocalDate.of(1839, 6, 21),
                LocalDate.of(1908, 9, 29)
        );
        Autor a3 = new Autor(null,
                "Cora Coralina",
                "Cora Coralina, pseudônimo de Anna Lins dos Guimarães Peixoto Bretas, foi uma poetisa e contista brasileira. Considerada uma das mais importantes escritoras brasileiras, ela teve seu primeiro livro publicado em junho de 1965, quando já tinha quase 76 anos de idade, apesar de escrever seus versos desde a adolescência.",
                "Goiânia, Goiás",
                LocalDate.of(1889, 8, 20),
                LocalDate.of(1985, 4, 10)
        );
        autorRepository.saveAll(Arrays.asList(a1, a2, a3));

        Categoria c1 = new Categoria(null, "Romance");
        Categoria c2 = new Categoria(null, "Ficção científica");
        categoriaRepository.saveAll(Arrays.asList(c1, c2));

        Livro l1 = new Livro(null, "O Alquimista", a1, c1);
        Livro l2 = new Livro(null, "Dom Casmurro", a2, c1);
        Livro l3 = new Livro(null, "Amor de perdição", a2, c2);
        Livro l4 = new Livro(null, "Onze Minutos", a1, c2);
        Livro l5 = new Livro(null, "Maktub", a1, c1);
        livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));

    }
}
