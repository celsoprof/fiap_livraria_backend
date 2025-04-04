package br.dev.celso.livraria.service.exception;

public class EntityNotFound extends RuntimeException{

    public EntityNotFound(String message){
        super(message);
    }

}
