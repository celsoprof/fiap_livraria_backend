package br.dev.celso.livraria.controller;

import br.dev.celso.livraria.entity.Autor;
import br.dev.celso.livraria.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {

    @Autowired
    private AutorService service;

    @PostMapping
    public ResponseEntity<Autor> create(@RequestBody Autor Autor) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.create(Autor));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Autor> getById(@PathVariable Long id){
        Optional<Autor> Autor = service.findById(id);
        return Autor.map(value ->
                ResponseEntity.ok().body(value)).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Autor>> getAll(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @PutMapping()
    public ResponseEntity<Autor> update(@RequestBody Autor Autor){
        Optional<Autor> AutorOptional = service.findById(Autor.getId());

        if (AutorOptional.isPresent()){
            return ResponseEntity.ok().body(service.update(Autor));
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
