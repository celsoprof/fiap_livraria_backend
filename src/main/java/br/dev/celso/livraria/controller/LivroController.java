package br.dev.celso.livraria.controller;

import br.dev.celso.livraria.dto.LivroDTO;
import br.dev.celso.livraria.entity.Livro;
import br.dev.celso.livraria.service.LivroService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    @PostMapping
    public ResponseEntity<Livro> create(@RequestBody Livro livro) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.create(livro));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LivroDTO> getById(@PathVariable Long id){
        Optional<LivroDTO> livro = service.findById(id);
        return livro.map(value ->
                ResponseEntity.ok().body(value)).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> getAll(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @PutMapping()
    public ResponseEntity<LivroDTO> update(@RequestBody LivroDTO livroDTO){
        Optional<LivroDTO> livroOptional = service.findById(livroDTO.getId());
        if (livroOptional.isPresent()){
            Livro livro = new Livro();
            BeanUtils.copyProperties(livroOptional.get(), livro);
            livro = service.update(livro);
            return ResponseEntity.ok().body(new LivroDTO(livro));
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
