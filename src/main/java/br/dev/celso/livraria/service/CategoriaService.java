package br.dev.celso.livraria.service;

import br.dev.celso.livraria.entity.Categoria;
import br.dev.celso.livraria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria create(Categoria categoria){
        return repository.save(categoria);
    }

}
